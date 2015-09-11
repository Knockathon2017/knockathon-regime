package com.exzeo.module;

import com.exzeo.settings.Settings;
import com.exzeo.settings.SettingsBuilder;
import com.google.inject.AbstractModule;

/**
 * Created by dhruvr
 */
public class SettingsModule extends AbstractModule {

    private Settings settings;
    public SettingsModule(Settings settings){
        this.settings = settings;
    }
    @Override
    protected void configure() {
        bind(Settings.class).toInstance(settings);
    }
}
