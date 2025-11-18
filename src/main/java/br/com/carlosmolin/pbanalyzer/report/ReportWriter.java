package br.com.carlosmolin.pbanalyzer.report;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReportWriter {

    public static void appendReport(
            List<Report> reports,
            String arquivoAfetado,
            String path
    ) {

        JSONObject jsonFinal;
        Path pathRelatorio = Paths.get(path);

        // Se o arquivo existe, lê o JSON
        if (Files.exists(pathRelatorio)) {
            try {
                String conteudo = Files.readString(pathRelatorio);
                jsonFinal = new JSONObject(conteudo);
            } catch (Exception e) {
                // Se deu erro lendo, começa um novo relatório
                jsonFinal = new JSONObject();
                jsonFinal.put("arquivos", new JSONArray());
            }
        } else {
            jsonFinal = new JSONObject();
            jsonFinal.put("arquivos", new JSONArray());
        }

        JSONArray arquivosArray = jsonFinal.getJSONArray("arquivos");

        // Converte este arquivo analisado para JSON individual
        JSONObject jsonArquivo = convertSingleReport(reports, arquivoAfetado);

        // Adiciona ao array global
        arquivosArray.put(jsonArquivo);

        // Salva o arquivo novamente
        try {
            Files.writeString(pathRelatorio, jsonFinal.toString(4)); // identado e bonito
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar relatório: " + e.getMessage(), e);
        }
    }

    public static JSONObject convertSingleReport(List<Report> reports, String arquivoAfetado) {
        JSONObject json = new JSONObject();
        json.put("arquivoAfetado", arquivoAfetado);

        JSONArray problemasArray = new JSONArray();

        for (Report report : reports) {
            JSONObject reportJson = new JSONObject();

            reportJson.put("analyzer", report.getAnalyzerName());

            JSONArray entriesArray = new JSONArray();
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

    public static JSONObject toJson(List<Report> reports, String arquivoAfetado) {
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

        json.put("arquivoAfetado", arquivoAfetado);
        json.put("problemasDetectados", problemasArray);

        return json;
    }

    public static JSONObject toJson(Report report, String arquivoAfetado) {
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

        json.put("arquivoAfetado", arquivoAfetado);
        json.put("problemasDetectados", problemasArray);

        return json;
    }
}