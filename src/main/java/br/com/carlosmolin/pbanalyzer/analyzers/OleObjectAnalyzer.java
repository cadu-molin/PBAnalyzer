package br.com.carlosmolin.pbanalyzer.analyzers;

import br.com.carlosmolin.pbanalyzer.core.CodeAnalyzer;
import br.com.carlosmolin.pbanalyzer.model.Report;
import br.com.carlosmolin.pbanalyzer.model.ReportEntry;
import br.com.carlosmolin.pbanalyzer.model.Severity;
import br.com.carlosmolin.pbanalyzer.parser.PowerBuilderParser;
import br.com.carlosmolin.pbanalyzer.parser.PowerBuilderParserBaseListener;

public class OleObjectAnalyzer extends PowerBuilderParserBaseListener implements CodeAnalyzer {

    private final Report report = new Report("OleObjectAnalyzer");

    @Override
    public void enterVariable_decl(PowerBuilderParser.Variable_declContext ctx) {
        String text = ctx.getText().toLowerCase();

        if (text.contains("oleobject")) {
            report.addEntry(new ReportEntry(
                    "Uso de OleObject detectado",
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