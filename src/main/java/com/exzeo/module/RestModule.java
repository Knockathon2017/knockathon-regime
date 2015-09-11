package com.exzeo.module;

import com.exzeo.rest.RestAPIS;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import org.eclipse.jetty.servlet.DefaultServlet;

/**
 * Created by dhruvr on 10/9/15.
 */
public class RestModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(DefaultServlet.class).in(Singleton.class);
        bind(RestAPIS.class).in(Singleton.class);
    }
}
