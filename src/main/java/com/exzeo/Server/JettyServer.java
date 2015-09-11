package com.exzeo.Server;

import com.exzeo.settings.Settings;
import com.google.inject.Inject;
import com.google.inject.servlet.GuiceFilter;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumSet;

/**
 * Created by dhruvr
 */
public class JettyServer implements RegimeServer {


    private Settings settings;
    private final static Logger LOGGER = LoggerFactory.getLogger(JettyServer.class);
    private final Server server;
    final ServletContextHandler context;

    @Inject
    public JettyServer(Settings settings) {
        this.settings = settings;
        server = new Server(settings.getJettyPort());
        context = new ServletContextHandler(server, "/");
    }

    @Override
    public void start() {
        context.addFilter(GuiceFilter.class, "/*", EnumSet.of(javax.servlet.DispatcherType.REQUEST, javax.servlet.DispatcherType.ASYNC));
        context.addServlet(DefaultServlet.class, "/*");
        try {
            server.start();
        } catch (Exception e) {
            LOGGER.error("Problem while starting jetty server, existing ", e);
            System.exit(0);
        }
        try {
            LOGGER.info("Jetty server started");
            server.join();
        } catch (Exception e) {
            LOGGER.error("Problem while joining jetty server, existing ", e);
            System.exit(0);
        }
    }

    @Override
    public void stop() {

        server.setGracefulShutdown(10);
        LOGGER.info("Jetty server graceful shutdown...");
    }
}
