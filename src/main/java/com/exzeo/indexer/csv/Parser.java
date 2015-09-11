package com.exzeo.indexer.csv;

import org.apache.commons.csv.CSVParser;

import java.io.IOException;

/**
 * Created by dhruvr on 11/9/15.
 */
public interface Parser {
    public CSVParser getParser() throws IOException;
    public void closerParser() throws IOException;
}
