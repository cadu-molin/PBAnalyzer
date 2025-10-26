package br.com.carlosmolin.pbanalyzer.analyzers.powerscript;

import br.com.carlosmolin.pbanalyzer.core.analyzer.PowerScriptAnalyzer;
import br.com.carlosmolin.pbanalyzer.core.report.Report;
import br.com.carlosmolin.pbanalyzer.core.report.ReportEntry;
import br.com.carlosmolin.pbanalyzer.core.report.Severity;
import br.com.carlosmolin.pbanalyzer.parser.PowerBuilderParser;
import br.com.carlosmolin.pbanalyzer.parser.PowerBuilderParserBaseListener;

public class GotoAnalyzer extends PowerBuilderParserBaseListener implements PowerScriptAnalyzer {

    private final Report report = new Report("GotoAnalyzer");

    @Override
    public void enterGoto_statement(PowerBuilderParser.Goto_statementContext ctx) {
        int qtd = ctx.variable_name().size();

        // Caso tenha pelo menos um variable_name → é o destino do GOTO
        if (qtd >= 1) {
            String targetLabel = ctx.variable_name(0).getText();
            report.addEntry(new ReportEntry(
                    "goto_statement",
                    "Declaração de comando GOTO detectado: " + targetLabel,
                    ctx.getStart().getLine(),
                    Severity.WARNING
            ));
        }

        // Caso tenha dois variable_name → o segundo é o label definido
        if (qtd >= 2) {
            String definedLabel = ctx.variable_name(1).getText();
            report.addEntry(new ReportEntry(
                    "goto_statement",
                    "Definição do label \"" + definedLabel + "\" associada ao GOTO",
                    ctx.getStart().getLine(),
                    Severity.WARNING
            ));
        }

        // Caso não haja nenhum nome (GOTO malformado)
        if (qtd == 0) {
            report.addEntry(new ReportEntry(
                    "goto_statement",
                    "Uso de comando GOTO sem label",
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