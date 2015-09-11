package com.exzeo.es;

import org.elasticsearch.client.Client;

/**
 * Created by dhruvr on 11/9/15.
 */
public interface ClientProvider {
    public Client get();
    public void closeClient();
}
