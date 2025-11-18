package br.com.carlosmolin.pbanalyzer.analysis.window.impl;

import br.com.carlosmolin.pbanalyzer.analysis.window.WindowAnalyzer;
import br.com.carlosmolin.pbanalyzer.report.Report;
import br.com.carlosmolin.pbanalyzer.report.ReportEntry;
import br.com.carlosmolin.pbanalyzer.enums.Severity;
import br.com.carlosmolin.pbanalyzer.antlr.window.PowerBuilderParser;
import br.com.carlosmolin.pbanalyzer.antlr.window.PowerBuilderParserBaseListener;

public class OleObjectAnalyzer extends PowerBuilderParserBaseListener implements WindowAnalyzer {

    private final Report report = new Report("WindowAnalyzer");

    @Override
    public void enterVariable_decl(PowerBuilderParser.Variable_declContext ctx) {
        String text = ctx.getText().toLowerCase();

        if (text.contains("oleobject")) {
            report.addEntry(new ReportEntry(
                    "Uso de OleObject",
                    "Encontrada declaração de OleObject",
                    ctx.getStart().getLine(),
                    Severity.WARNING
            ));
        }
    }

    @Override
    public Report getReport() {
        return report;
    }
}