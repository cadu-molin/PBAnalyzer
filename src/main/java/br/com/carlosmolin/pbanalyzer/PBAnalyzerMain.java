package br.com.carlosmolin.pbanalyzer;

import br.com.carlosmolin.pbanalyzer.analyzers.powerscript.OleObjectAnalyzer;
import br.com.carlosmolin.pbanalyzer.core.analyzer.AnalyzerManager;
import br.com.carlosmolin.pbanalyzer.core.report.Report;
import br.com.carlosmolin.pbanalyzer.core.report.ReportEntry;
import br.com.carlosmolin.pbanalyzer.parser.PowerBuilderLexer;
import br.com.carlosmolin.pbanalyzer.parser.PowerBuilderParser;
import br.com.carlosmolin.pbanalyzer.analyzers.powerscript.GotoAnalyzer;
import br.com.carlosmolin.pbanalyzer.analyzers.powerscript.TryCatchFinallyAnalyzer;
import br.com.carlosmolin.pbanalyzer.core.report.ReportWriter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PBAnalyzerMain
{
    public static void main( String[] args ) {
        try {
            CharStream input = CharStreams.fromFileName("C:\\Projetos\\Faculdade\\TCC\\PBAnalyzer\\mock\\PowerScriptExemple.srw");
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
//                ReportWriter.printReports(reports);
                Files.writeString(Path.of("relatorio.json"), ReportWriter.toJson(reports).toString(4));

                System.exit(1);
            } else {
                System.out.println("Nenhum problema encontrado.");
                System.exit(0);
            }
        } catch (IOException e) {
            System.err.println("Erro ao executar o PBAnalyzer: " + e.getMessage());
            e.printStackTrace();
            System.exit(2);
        }

    }
}
