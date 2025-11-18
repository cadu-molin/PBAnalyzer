package br.com.carlosmolin.pbanalyzer;

import br.com.carlosmolin.pbanalyzer.analysis.datawindow.impl.IdReferenceAnalyzer;
import br.com.carlosmolin.pbanalyzer.analysis.window.impl.GotoAnalyzer;
import br.com.carlosmolin.pbanalyzer.analysis.window.impl.OleObjectAnalyzer;
import br.com.carlosmolin.pbanalyzer.analysis.window.impl.TryCatchFinallyAnalyzer;
import br.com.carlosmolin.pbanalyzer.antlr.window.PowerBuilderLexer;
import br.com.carlosmolin.pbanalyzer.antlr.window.PowerBuilderParser;
import br.com.carlosmolin.pbanalyzer.analysis.AnalyzerManager;
import br.com.carlosmolin.pbanalyzer.report.Report;
import br.com.carlosmolin.pbanalyzer.report.ReportWriter;
import br.com.carlosmolin.pbanalyzer.enums.FileType;
import br.com.carlosmolin.pbanalyzer.validator.FileValidator;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.nio.file.Path;
import java.util.List;

public class PBAnalyzerMain
{
    public static void main( String[] args ) {
        FileValidator validator = new FileValidator();

        try {
            FileValidator.ValidatedFile vf = validator.validateAndDetect(args);

            if (vf.getType() == FileType.UNKNOWN) {
                System.out.println("Ignorando arquivo não suportado: " + vf.getPath().getFileName());
                return;
            }

            if (vf.getType() == FileType.DATAWINDOW) {
                analyzeDataWindow(vf.getPath());
            } else {
                analyzePowerScript(vf.getPath());
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

        if (reports.isEmpty()) {
            System.out.println("Nenhum problema encontrado.");
            System.exit(0);
        } else {
            ReportWriter.appendReport(reports, filePath.getFileName().toString(), "relatorio.json");
            System.exit(1);
        }
    }

    private static void analyzeDataWindow(Path filePath) throws Exception {
        System.out.println("Analisando: " + filePath);

        IdReferenceAnalyzer dataWindowAnalyzer = new IdReferenceAnalyzer(filePath);

        dataWindowAnalyzer.analyze();

        Report reports = dataWindowAnalyzer.getReport();

        if (reports.getEntries().isEmpty()) {
            System.out.println("Nenhum problema encontrado.");
            System.exit(0);
        } else {
            ReportWriter.appendReport(List.of(reports), filePath.getFileName().toString(), "relatorio.json");
            System.exit(1);
        }
    }
}
