package br.com.carlosmolin.pbanalyzer.core;

import br.com.carlosmolin.pbanalyzer.analyzers.OleObjectAnalyzer;
import br.com.carlosmolin.pbanalyzer.parser.PowerBuilderLexer;
import br.com.carlosmolin.pbanalyzer.parser.PowerBuilderParser;
import br.com.carlosmolin.pbanalyzer.analyzers.GotoAnalyzer;
import br.com.carlosmolin.pbanalyzer.analyzers.TryCatchFinallyAnalyzer;
import br.com.carlosmolin.pbanalyzer.report.ReportWriter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class PBAnalyzerMain
{
    public static void main( String[] args ) throws IOException {
        CharStream input = CharStreams.fromFileName("C:\\Projetos\\Faculdade\\TCC\\PBAnalyzer\\mock\\PowerScriptExemple.txt");
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

        ReportWriter.printReports(analyzers.collectReports());
    }
}
