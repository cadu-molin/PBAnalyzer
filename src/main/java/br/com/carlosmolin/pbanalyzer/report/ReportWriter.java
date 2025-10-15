package br.com.carlosmolin.pbanalyzer.report;

import br.com.carlosmolin.pbanalyzer.model.Report;

import java.util.List;

public class ReportWriter {
    public static void printReports(List<Report> reports) {
        for (Report report : reports) {
            System.out.println("\n=== " + report.getAnalyzerName() + " ===");
            report.getEntries().forEach(System.out::println);
        }
    }
}