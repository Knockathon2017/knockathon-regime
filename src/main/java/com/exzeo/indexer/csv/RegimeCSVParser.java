package com.exzeo.indexer.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.*;

/**
 * Created by dhruvr on 11/9/15.
 */
public class RegimeCSVParser implements Parser {


    private final File csvFile;
    private final CSVParser csvParser;
    private final Reader csvReader;

    public RegimeCSVParser(File csvFile) throws IOException{
        this.csvFile = csvFile;
        csvReader = new InputStreamReader(new FileInputStream(csvFile));
        csvParser = new CSVParser(csvReader, CSVFormat.EXCEL.withHeader());

    }
    @Override
    public CSVParser getParser()throws IOException{
        return csvParser;
    }

    @Override
    public void closerParser() throws IOException{
        csvReader.close();
        csvParser.close();
    }
}
