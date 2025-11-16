package br.com.carlosmolin.pbanalyzer.analyzers.powerscript;

import br.com.carlosmolin.pbanalyzer.core.analyzer.PowerScriptAnalyzer;
import br.com.carlosmolin.pbanalyzer.core.report.Report;
import br.com.carlosmolin.pbanalyzer.core.report.ReportEntry;
import br.com.carlosmolin.pbanalyzer.enums.Severity;
import br.com.carlosmolin.pbanalyzer.parser.PowerBuilderParser;
import br.com.carlosmolin.pbanalyzer.parser.PowerBuilderParserBaseListener;

public class OleObjectAnalyzer extends PowerBuilderParserBaseListener implements PowerScriptAnalyzer {

    private final Report report = new Report("PowerScriptAnalyzer");

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