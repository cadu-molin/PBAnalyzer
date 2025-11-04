package br.com.carlosmolin.pbanalyzer;

import br.com.carlosmolin.pbanalyzer.analyzers.dataobject.IdReferenceAnalyzer;
import br.com.carlosmolin.pbanalyzer.analyzers.powerscript.GotoAnalyzer;
import br.com.carlosmolin.pbanalyzer.analyzers.powerscript.OleObjectAnalyzer;
import br.com.carlosmolin.pbanalyzer.analyzers.powerscript.TryCatchFinallyAnalyzer;
import br.com.carlosmolin.pbanalyzer.core.analyzer.AnalyzerManager;
import br.com.carlosmolin.pbanalyzer.core.report.Report;
import br.com.carlosmolin.pbanalyzer.core.report.ReportWriter;
import br.com.carlosmolin.pbanalyzer.enums.FileType;
import br.com.carlosmolin.pbanalyzer.parser.PowerBuilderLexer;
import br.com.carlosmolin.pbanalyzer.parser.PowerBuilderParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PBAnalyzerMain
{
    public static void main( String[] args ) {
        try {
//            if (args.length == 0) {
//                System.err.println("Nenhum arquivo informado.");
//                System.exit(2);
//            }
//
//            Path filePath = Paths.get(args[0]);
//            Path filePath = Paths.get("C:\\Projetos\\Faculdade\\TCC\\PBAnalyzer\\mock\\PowerScriptExemple.srw");
            Path filePath = Paths.get("C:\\Projetos\\Faculdade\\TCC\\PBAnalyzer\\mock\\DataWindowExemple.srd");
            String fileName = filePath.getFileName().toString();
            FileType type = FileType.fromFilename(fileName);

            if (type == FileType.UNKNOWN) {
                System.out.println("Ignorando arquivo não suportado: " + fileName);
                System.exit(0);
            }

            if (type == FileType.DATAOBJECT) {
                analyzeDataObject(filePath);
            } else {
                analyzePowerScript(filePath);
            }

        } catch (Exception e) {
            System.err.println("Erro ao executar o PBAnalyzer: " + e.getMessage());
            System.exit(2);
        }
    }

    private static void analyzePowerScript(Path filePath) throws Exception {
        System.out.println("Analisando: " + filePath);
        CharStream input = CharStreams.fromPath(filePath);
        PowerBuilderLexer lexer = new PowerBuilderLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PowerBuilderParser parser = new PowerBuilderParser(tokens);
        ParseTree tree = parser.start_rule();
        ParseTreeWalker walker = new ParseTreeWalker();

        AnalyzerManager analyzers = new AnalyzerManager(parser);
        analyzers.addAnalyzer(new GotoAnalyzer());
        analyzers.addAnalyzer(new TryCatchFinallyAnalyzer());
        analyzers.addAnalyzer(new OleObjectAnalyzer());

        walker.walk(analyzers, tree);

        List<Report> reports = analyzers.collectReports();

        if (!reports.isEmpty()) {
            Files.writeString(Path.of("relatorio.json"), ReportWriter.toJson(reports).toString(4));
            System.exit(1);
        } else {
            System.out.println("Nenhum problema encontrado.");
            System.exit(0);
        }
    }

    private static void analyzeDataObject(Path filePath) throws Exception {
        System.out.println("Analisando: " + filePath);

        IdReferenceAnalyzer dataObjectAnalyzer = new IdReferenceAnalyzer(filePath);

        dataObjectAnalyzer.analyze();

        Report reports = dataObjectAnalyzer.getReport();

        if (!reports.getEntries().isEmpty()) {
            Files.writeString(Path.of("relatorio.json"), ReportWriter.toJson(reports).toString(4));
            System.exit(1);
        } else {
            System.out.println("Nenhum problema encontrado.");
            System.exit(0);
        }
    }
}
