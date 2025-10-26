package br.com.carlosmolin.pbanalyzer.core.analyzer;

import br.com.carlosmolin.pbanalyzer.core.report.Report;
import br.com.carlosmolin.pbanalyzer.parser.PowerBuilderParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.lang.reflect.Method;
import java.util.List;
import java.util.ArrayList;

public class AnalyzerManager implements ParseTreeListener {

    private final List<PowerScriptAnalyzer> analyzers = new ArrayList<>();
    private final PowerBuilderParser parser; // necessário para obter rule names

    public AnalyzerManager(PowerBuilderParser parser) {
        this.parser = parser;
    }

    public void addAnalyzer(PowerScriptAnalyzer a) { analyzers.add(a); }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        // também encaminha enterEveryRule normalmente
        analyzers.forEach(a -> a.enterEveryRule(ctx));
        // tenta encaminhar enter<RuleName>(ctx)
        invokeSpecific(ctx, "enter");
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        analyzers.forEach(a -> a.exitEveryRule(ctx));
        invokeSpecific(ctx, "exit");
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        analyzers.forEach(a -> a.visitTerminal(node));
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        analyzers.forEach(a -> a.visitErrorNode(node));
    }

    private void invokeSpecific(ParserRuleContext ctx, String prefix) {
        String[] ruleNames = parser.getRuleNames();
        int idx = ctx.getRuleIndex();
        if (idx < 0 || idx >= ruleNames.length) return;
        String ruleName = ruleNames[idx];               // ex: "goto_statement"
        String methodName = prefix + capitalize(ruleName); // ex: "enterGoto_statement"

        for (PowerScriptAnalyzer a : analyzers) {
            // procura um método com o nome e que aceite o tipo do ctx (ou supertipo)
            Method m = findCompatibleMethod(a.getClass(), methodName, ctx.getClass());
            if (m != null) {
                try {
                    m.invoke(a, ctx);
                } catch (Exception e) {
                    // logue ou ignore - não pare a travessia por causa de um analyzer
                    e.printStackTrace();
                }
            }
        }
    }

    private static Method findCompatibleMethod(Class<?> cls, String name, Class<?> paramType) {
        for (Method m : cls.getMethods()) {
            if (!m.getName().equals(name)) continue;
            Class<?>[] params = m.getParameterTypes();
            if (params.length != 1) continue;
            if (params[0].isAssignableFrom(paramType)) {
                return m;
            }
        }
        return null;
    }

    private static String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }

    public List<Report> collectReports() {
        List<Report> reports = new ArrayList<>();
        for (PowerScriptAnalyzer analyzer : analyzers) {
            reports.add(analyzer.getReport());
        }
        return reports;
    }
}