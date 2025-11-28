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
    public void enterData_type_name(PowerBuilderParser.Data_type_nameContext ctx) {
        String text = ctx.getText().toLowerCase();

        if ("oleobject".equalsIgnoreCase(text)) {
            report.addEntry(new ReportEntry(
                    "Uso de OleObject",
                    "Identificado uso de OleObject",
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