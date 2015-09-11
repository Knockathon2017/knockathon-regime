package com.exzeo.bootstrap;

import com.google.common.base.Preconditions;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by dhruvr
 */
public class SearcherMain {

    private final static String CONF = "config";
    private static final Logger LOGGER = LoggerFactory.getLogger(SearcherMain.class);

    public static void main(String[] args) throws ParseException {
        Preconditions.checkNotNull(args, "input args are null");
        Options options = new Options();
        options.addOption(CONF, true, "The path of conf file");

        CommandLine commandLine = new DefaultParser().parse(options, args);
        if (!commandLine.hasOption(CONF)){
            throw new IllegalArgumentException("Argument missing either " + CONF);
        }

        final ServerBootStrap serverBootStrap = new ServerBootStrap(commandLine.getOptionValue(CONF));

        Runtime.getRuntime().addShutdownHook(new Thread("Regime-Shutdown-Hook") {
            @Override
            public void run() {
                LOGGER.info("Closing down stuffs...");
                serverBootStrap.stop();
            }
        });
        serverBootStrap.start();
    }

}

