package com.exzeo.es;

import com.exzeo.settings.Settings;
import com.google.inject.Inject;
import com.google.inject.Provider;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by dhruvr on 11/9/15.
 */
public class EsClientProvider implements ClientProvider{


    private final String clusterName;
    private final String hostIp;
    private final int port;
    private Client client;
    private static final Logger LOGGER = LoggerFactory.getLogger(EsClientProvider.class);

    private Settings settings;

    @Inject
    public EsClientProvider(Settings settings) {
        this.settings = settings;
        clusterName = this.settings.getEsClusterName();
        hostIp = this.settings.getEsIp();
        port = this.settings.getEsPort();

        try {

            org.elasticsearch.common.settings.Settings esSettings = ImmutableSettings.builder()
                    .put("cluster.name", clusterName)
                    .build();

            client = new TransportClient(esSettings)
                    .addTransportAddress(new InetSocketTransportAddress(hostIp, port));


        } catch (ElasticsearchException e) {
            LOGGER.error("Problem creating the client for Elastic search setting :  ", settings.toString(), e);
            LOGGER.info("Closing system ");
            System.exit(0);
        }

        LOGGER.info("es client initialized");
    }

    @Override
    public Client get() {
        return client;
    }

    @Override
    public void closeClient() {
        LOGGER.info("closing es client");
        client.close();
    }
}
