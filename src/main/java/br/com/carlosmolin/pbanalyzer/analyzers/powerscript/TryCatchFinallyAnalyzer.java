package br.com.carlosmolin.pbanalyzer.analyzers.powerscript;

import br.com.carlosmolin.pbanalyzer.core.analyzer.PowerScriptAnalyzer;
import br.com.carlosmolin.pbanalyzer.core.report.Report;
import br.com.carlosmolin.pbanalyzer.core.report.ReportEntry;
import br.com.carlosmolin.pbanalyzer.core.report.Severity;
import br.com.carlosmolin.pbanalyzer.parser.PowerBuilderParser;
import br.com.carlosmolin.pbanalyzer.parser.PowerBuilderParserBaseListener;

public class TryCatchFinallyAnalyzer extends PowerBuilderParserBaseListener implements PowerScriptAnalyzer {

    private final Report report = new Report("TryCatchFinallyAnalyzer");

    @Override
    public void enterTry_catch_statement(PowerBuilderParser.Try_catch_statementContext ctx) {
        boolean hasCatch = !ctx.CATCH().isEmpty();
        boolean hasFinally = ctx.FINALLY() != null;
        StringBuilder message = new StringBuilder();

        if (!hasFinally && !hasCatch) {
            message.append("TRY encontrado sem o uso do CATCH e do FINALLY");
        } else if (hasFinally && !hasCatch) {
            message.append("TRY encontrado sem o uso do CATCH");
        }

        if (message.length() > 0) {
            report.addEntry(new ReportEntry(
                    "Try_catch_statement",
                    message.toString(),
                    ctx.getStart().getLine(),
                    Severity.ERROR
            ));
        }
    }

    @Override
    public Report getReport() {
        return report;
    }
}