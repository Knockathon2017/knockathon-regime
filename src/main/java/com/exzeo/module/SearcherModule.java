package com.exzeo.module;

import com.exzeo.Searcher.RegimeSearcher;
import com.exzeo.Searcher.Searcher;
import com.google.inject.AbstractModule;

/**
 * Created by dhruvr on 12/9/15.
 */
public class SearcherModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Searcher.class).to(RegimeSearcher.class).asEagerSingleton();
    }
}
