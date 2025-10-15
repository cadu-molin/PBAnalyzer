package br.com.carlosmolin.pbanalyzer.analyzers;

import br.com.carlosmolin.pbanalyzer.core.CodeAnalyzer;
import br.com.carlosmolin.pbanalyzer.model.Report;
import br.com.carlosmolin.pbanalyzer.parser.PowerBuilderParserBaseListener;


public class NamingConventionAnalyzer extends PowerBuilderParserBaseListener implements CodeAnalyzer {

    private final Report report = new Report("NamingConventionAnalyzer");

//    private static final Pattern CAMEL_CASE_PATTERN = Pattern.compile("^[a-z][a-zA-Z0-9]*$");
//
//    @Override
//    public void enterVariable_decl(PowerBuilderParser.Variable_declContext ctx) {
//        if (ctx.variable_decl_sub().getChildCount() == 0) return;
//
//        for (PowerBuilderParser.Variable_nameContext varCtx : ctx.variable_decl_sub().variable_name()) {
//            String varName = varCtx.getText();
//
//            if (!CAMEL_CASE_PATTERN.matcher(varName).matches()) {
//                report.addEntry(new ReportEntry(
//                        "Violação de convenção de nomenclatura",
//                        "Variável '" + varName + "' não segue o padrão camelCase.",
//                        ctx.getStart().getLine(),
//                        Severity.WARNING
//                ));
//            }
//        }
//    }
//
//    @Override
//    public void enterFunction_declaration(PowerBuilderParser.Function_declarationContext ctx) {
//        String funcName = ctx.function_name().getText();
//
//        if (!CAMEL_CASE_PATTERN.matcher(funcName).matches()) {
//            reports.add(new Report(
//                    "Violação de convenção de nomenclatura",
//                    "Função '" + funcName + "' não segue o padrão camelCase.",
//                    ctx.start.getLine()
//            ));
//        }
//    }

    @Override
    public Report getReport() {
        return report;
    }
}