package br.com.carlosmolin.pbanalyzer.analyzers.dataobject;

import br.com.carlosmolin.pbanalyzer.core.analyzer.DataObjectAnalyzer;
import br.com.carlosmolin.pbanalyzer.core.report.Report;
import br.com.carlosmolin.pbanalyzer.core.report.ReportEntry;
import br.com.carlosmolin.pbanalyzer.core.report.Severity;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdReferenceAnalyzer implements DataObjectAnalyzer {

    private final Report report = new Report("IdReferenceAnalyzer");
    private String content;

    public IdReferenceAnalyzer(String content) {
        this.content = content;
    }

    @Override
    public void analyze() {

        Pattern tablePattern = Pattern.compile("table\\((.*?)\\)\\s", Pattern.DOTALL);
        Matcher tableMatcher = tablePattern.matcher(content);

        List<String> tableColumnNames = new ArrayList<>();
        if (tableMatcher.find()) {
            String tableBlock = tableMatcher.group(1);

            Pattern namePattern = Pattern.compile("name=([a-zA-Z0-9_]+)");
            Matcher nameMatcher = namePattern.matcher(tableBlock);

            while (nameMatcher.find()) {
                tableColumnNames.add(nameMatcher.group(1));
            }
        }

        Pattern detailColumnPattern = Pattern.compile(
                "column\\([^)]*?id=(\\d+)[^)]*?name=([a-zA-Z0-9_]+)[^)]*?\\)", Pattern.DOTALL
        );
        Matcher detailMatcher = detailColumnPattern.matcher(content);

        while (detailMatcher.find()) {
            int id = Integer.parseInt(detailMatcher.group(1));
            String name = detailMatcher.group(2);

            if (id >= 1 && id <= tableColumnNames.size()) {
                String expectedName = tableColumnNames.get(id - 1);
                if (!expectedName.equals(name)) {
                    report.addEntry(new ReportEntry(
                            "IdReferenceAnalyzer",
                            String.format(
                                    "Coluna '%s' possui ID incorreto (%d). Esperado: '%s' (posição %d).",
                                    name, id, expectedName, id
                            ),
                            0,
                            Severity.ERROR
                    ));
                }
            }
        }
    }

    @Override
    public Report getReport() {
        return report;
    }
}
