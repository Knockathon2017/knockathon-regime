package com.exzeo.module;

import com.exzeo.Server.JettyServer;
import com.exzeo.Server.RegimeServer;
import com.google.inject.AbstractModule;

/**
 * Created by dhruvr on 10/9/15.
 */
public class ServerModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(RegimeServer.class).to(JettyServer.class).asEagerSingleton();
    }
}
