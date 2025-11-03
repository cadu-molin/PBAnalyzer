package br.com.carlosmolin.pbanalyzer.core.report;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class ReportWriter {
    public static void printReports(List<Report> reports) {
        for (Report report : reports) {
            System.out.println("\n=== " + report.getAnalyzerName() + " ===");
            report.getEntries().forEach(System.out::println);
        }
    }

    public static Boolean hasReport() {
        return true;
    }

    public static JSONObject toJson(List<Report> reports) {
        JSONObject json = new JSONObject();
        JSONArray problemasArray = new JSONArray();

        for (Report report : reports) {
            JSONObject reportJson = new JSONObject();
            JSONArray entriesArray = new JSONArray();

            reportJson.put("analyzer", report.getAnalyzerName());

            for (ReportEntry entry : report.getEntries()) {
                JSONObject entryJson = new JSONObject();
                entryJson.put("regra", entry.getRuleName());
                entryJson.put("mensagem", entry.getMessage());
                entryJson.put("linha", entry.getLine());
                entryJson.put("gravidade", entry.getSeverity().toString());
                entriesArray.put(entryJson);
            }

            reportJson.put("ocorrencias", entriesArray);

            problemasArray.put(reportJson);
        }

        json.put("problemasDetectados", problemasArray);

        return json;
    }

    public static JSONObject toJson(Report report) {
        JSONObject json = new JSONObject();
        JSONArray problemasArray = new JSONArray();

        JSONObject reportJson = new JSONObject();
        JSONArray entriesArray = new JSONArray();

        reportJson.put("analyzer", report.getAnalyzerName());

        for (ReportEntry entry : report.getEntries()) {
            JSONObject entryJson = new JSONObject();
            entryJson.put("regra", entry.getRuleName());
            entryJson.put("mensagem", entry.getMessage());
            entryJson.put("linha", entry.getLine());
            entryJson.put("gravidade", entry.getSeverity().toString());
            entriesArray.put(entryJson);
        }

        reportJson.put("ocorrencias", entriesArray);

        problemasArray.put(reportJson);

        json.put("problemasDetectados", problemasArray);

        return json;
    }
}