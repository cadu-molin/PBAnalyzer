package br.com.carlosmolin.pbanalyzer.core.report;

import java.util.ArrayList;
import java.util.List;

public class Report {
    private final String analyzerName;
    private final List<ReportEntry> entries = new ArrayList<>();

    public Report(String analyzerName) {
        this.analyzerName = analyzerName;
    }

    public void addEntry(ReportEntry entry) {
        entries.add(entry);
    }

    public List<ReportEntry> getEntries() {
        return entries;
    }

    public String getAnalyzerName() {
        return analyzerName;
    }

    @Override
    public String toString() {
        return "(" + entries.stream().map(ReportEntry::toString) + ")";
    }
}