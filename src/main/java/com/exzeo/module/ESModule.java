package com.exzeo.module;

import com.exzeo.es.ClientProvider;
import com.exzeo.es.EsClientProvider;
import com.exzeo.settings.Settings;
import com.google.inject.AbstractModule;

/**
 * Created by dhruvr on 11/9/15.
 */
public class ESModule  extends AbstractModule{

    private final Settings settings;
    public ESModule(Settings settings){
        this.settings = settings;
    }

    @Override
    protected void configure() {
        bind(ClientProvider.class).toInstance(new EsClientProvider(settings));
    }
}
