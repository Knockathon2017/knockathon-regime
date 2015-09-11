package com.exzeo.bootstrap;

import com.exzeo.es.EsClientProvider;
import com.exzeo.indexer.ESIndexer;
import com.exzeo.indexer.csv.Parser;
import com.exzeo.indexer.csv.RegimeCSVParser;
import com.exzeo.settings.SettingsBuilder;
import com.google.common.base.Preconditions;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by dhruvr on 11/9/15.
 */
public class IndexerMain {

    private final static String CONF = "config";
    private final static String CSV = "csv";
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexerMain.class);

    public static void main(String[] args) throws ParseException, IOException {
        Preconditions.checkNotNull(args, "input args are null");
        Options options = new Options();
        options.addOption(CONF, true, "The path of conf file");
        options.addOption(CSV, true, "The path of csv file");

            CommandLine commandLine = new DefaultParser().parse(options, args);
        if (! commandLine.hasOption(CSV)  || !commandLine.hasOption(CONF)) {
            throw new IllegalArgumentException("Argument missing either " + CSV + "or  "+  CONF);
        }

        SettingsBuilder settingsBuilder = new SettingsBuilder(Paths.get(commandLine.getOptionValue(CONF)).toFile());
        EsClientProvider esClientProvider = new EsClientProvider(settingsBuilder.build());
        Parser parser = new RegimeCSVParser(Paths.get(commandLine.getOptionValue(CSV)).toFile());
        ESIndexer esIndexer = new ESIndexer(parser.getParser(), esClientProvider.get());

        LOGGER.info(".....Going to index ....");
        esIndexer.index();
        esClientProvider.closeClient();
    }
}
