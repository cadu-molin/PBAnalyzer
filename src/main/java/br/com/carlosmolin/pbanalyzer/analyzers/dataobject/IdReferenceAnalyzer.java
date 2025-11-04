package br.com.carlosmolin.pbanalyzer.analyzers.dataobject;

import br.com.carlosmolin.pbanalyzer.core.analyzer.DataObjectAnalyzer;
import br.com.carlosmolin.pbanalyzer.core.report.Report;
import br.com.carlosmolin.pbanalyzer.core.report.ReportEntry;
import br.com.carlosmolin.pbanalyzer.core.report.Severity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdReferenceAnalyzer implements DataObjectAnalyzer {

    private final Report report = new Report("IdReferenceAnalyzer");
    private Path filePath;

    public IdReferenceAnalyzer(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public void analyze() {

        try {
            Pattern detailColumnPattern = Pattern.compile("column\\([^)]*?id=(\\d+)[^)]*?name=([a-zA-Z0-9_]+)[^)]*?\\)", Pattern.DOTALL);
            Pattern namePattern = Pattern.compile("name=([a-zA-Z0-9_]+)");
            AtomicBoolean readingTable = new AtomicBoolean(false);
            List<String> tableColumnNames = new ArrayList<>();

            Files.lines(filePath).forEach(linha -> {
                if(linha.trim().startsWith("table(")) {
                    readingTable.set(true);

                    Matcher nameMatcher = namePattern.matcher(linha);

                    if (nameMatcher.find()) {
                        tableColumnNames.add(nameMatcher.group(1));
                    }

                    return;
                }

                if(readingTable.get() && linha.trim().startsWith("column=(")) {
                    Matcher nameMatcher = namePattern.matcher(linha);

                    if (nameMatcher.find()) {
                        tableColumnNames.add(nameMatcher.group(1));
                    }

                    return;
                } else {
                    readingTable.set(false);
                }

                Matcher detailMatcher = detailColumnPattern.matcher(linha);

                if (detailMatcher.find()) {
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
            });
        } catch (IOException e) {
            System.err.println("Erro ao executar a análise da classe IdReferenceAnalyzer do PBAnalyzer: " + e.getMessage());
            System.exit(2);
        }
    }

    @Override
    public Report getReport() {
        return report;
    }
}
