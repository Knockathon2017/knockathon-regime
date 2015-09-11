package com.exzeo.module;

import com.exzeo.settings.Settings;
import com.exzeo.settings.SettingsBuilder;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * Created by dhruvr
 */
public class MainModule extends ServletModule {

    private final static Logger LOGGER = LoggerFactory.getLogger(MainModule.class);
    private final Settings settings;

    public MainModule(SettingsBuilder settingsBuilder) {
        this.settings = settingsBuilder.build();
    }

    @Override
    protected void configureServlets() {
        HashMap<String, String> options = new HashMap<>();
        options.put("com.sun.jersey.api.json.POJOMappingFeature", "true");
        serve("/*").with(GuiceContainer.class, options);

        install(new SettingsModule(settings));
        LOGGER.info("Setting module installed");

        install(new ServerModule());
        LOGGER.info("Server Module installed");

        install(new RestModule());
        LOGGER.info("Rest Module installed");

        install(new ESModule(settings));
        LOGGER.info("ES Module installed");

        install(new SearcherModule());
        LOGGER.info("Searcher module installed");
    }

}
