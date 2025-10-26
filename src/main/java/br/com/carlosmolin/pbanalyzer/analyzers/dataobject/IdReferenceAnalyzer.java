package br.com.carlosmolin.pbanalyzer.analyzers.dataobject;

import br.com.carlosmolin.pbanalyzer.core.analyzer.DataObjectAnalyzer;
import br.com.carlosmolin.pbanalyzer.core.analyzer.ReportAnalyzer;
import br.com.carlosmolin.pbanalyzer.core.report.Report;

public class IdReferenceAnalyzer implements DataObjectAnalyzer {

    private final Report report = new Report("IdReferenceAnalyzer");

    @Override
    public void analyze() {
        //TODO analisador de dataobject
    }

    @Override
    public Report getReport() {
        return report;
    }
}
