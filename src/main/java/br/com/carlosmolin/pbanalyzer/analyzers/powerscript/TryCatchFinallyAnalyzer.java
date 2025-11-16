package br.com.carlosmolin.pbanalyzer.analyzers.powerscript;

import br.com.carlosmolin.pbanalyzer.core.analyzer.PowerScriptAnalyzer;
import br.com.carlosmolin.pbanalyzer.core.report.Report;
import br.com.carlosmolin.pbanalyzer.core.report.ReportEntry;
import br.com.carlosmolin.pbanalyzer.enums.Severity;
import br.com.carlosmolin.pbanalyzer.parser.PowerBuilderParser;
import br.com.carlosmolin.pbanalyzer.parser.PowerBuilderParserBaseListener;

public class TryCatchFinallyAnalyzer extends PowerBuilderParserBaseListener implements PowerScriptAnalyzer {

    private final Report report = new Report("PowerScriptAnalyzer");

    @Override
    public void enterTry_catch_statement(PowerBuilderParser.Try_catch_statementContext ctx) {
        boolean hasCatch = !ctx.CATCH().isEmpty();
        boolean hasFinally = ctx.FINALLY() != null;
        StringBuilder message = new StringBuilder();
        Severity severity = null;

        if (!hasFinally && !hasCatch) {
            message.append("TRY encontrado sem o uso do CATCH e do FINALLY");
            severity = Severity.ERROR;
        } else if (hasFinally && !hasCatch) {
            message.append("TRY encontrado sem o uso do CATCH");
            severity = Severity.WARNING;
        }

        if (message.length() > 0) {
            report.addEntry(new ReportEntry(
                    "Inconsistência no Try-Catch-Finally",
                    message.toString(),
                    ctx.getStart().getLine(),
                    severity
            ));
        }
    }

    @Override
    public Report getReport() {
        return report;
    }
}