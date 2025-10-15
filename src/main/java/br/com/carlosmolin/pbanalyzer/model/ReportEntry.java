package br.com.carlosmolin.pbanalyzer.model;

public class ReportEntry {
    private final String ruleName;
    private final String message;
    private final int line;
    private final Severity severity;

    public ReportEntry(String ruleName, String message, int line, Severity severity) {
        this.ruleName = ruleName;
        this.message = message;
        this.line = line;
        this.severity = severity;
    }

    // getters
    public String getRuleName() { return ruleName; }
    public String getMessage() { return message; }
    public int getLine() { return line; }
    public Severity getSeverity() { return severity; }

    @Override
    public String toString() {
        return String.format("[%s] (%s:%d) %s", severity, ruleName, line, message);
    }
}