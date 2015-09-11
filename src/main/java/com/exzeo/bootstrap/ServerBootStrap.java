package com.exzeo.bootstrap;

import com.exzeo.Server.RegimeServer;
import com.exzeo.cleanup.ServiceStopper;
import com.exzeo.es.ClientProvider;
import com.exzeo.module.MainModule;
import com.exzeo.settings.SettingsBuilder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Paths;

/**
 * Created by dhruvr
 */
public class ServerBootStrap {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerBootStrap.class);
    private File confFile;
    private final RegimeServer server;
    private final Injector parentInjector;

    public ServerBootStrap(String confFilePath) {
        this.confFile = Paths.get(confFilePath).toFile();
        this.parentInjector = Guice.createInjector(new MainModule(new SettingsBuilder(confFile)));
        server = parentInjector.getInstance(RegimeServer.class);
    }

    public void start() {
        server.start();
    }

    public void stop() {
        server.stop();
        ServiceStopper serviceStopper =  parentInjector.getInstance(ServiceStopper.class);
        serviceStopper.stopServices();
    }
}
