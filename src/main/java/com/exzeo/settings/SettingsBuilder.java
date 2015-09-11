package com.exzeo.settings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by dhruvr
 */
public class SettingsBuilder {


    private final File confFile;
    private static final Logger LOGGER = LoggerFactory.getLogger(SettingsBuilder.class);

    public SettingsBuilder(File confFile) {
        this.confFile = confFile;
    }

    public Settings build() {
        LOGGER.info("--Building settings--");
        Settings settings = null;
        try (InputStream inputStream = new FileInputStream(this.confFile)) {
            settings = new Yaml().loadAs(inputStream, Settings.class);
        } catch (IOException e) {
            LOGGER.error("Problem while reading config file input Stream, Existing ", e);
            System.exit(0);
        }
        return settings;
    }

}
