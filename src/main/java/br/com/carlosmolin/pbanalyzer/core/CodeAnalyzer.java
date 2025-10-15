package br.com.carlosmolin.pbanalyzer.core;

import br.com.carlosmolin.pbanalyzer.model.Report;
import org.antlr.v4.runtime.tree.ParseTreeListener;

public interface CodeAnalyzer extends ParseTreeListener {
    Report getReport();
}
