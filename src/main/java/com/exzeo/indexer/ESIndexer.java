package com.exzeo.indexer;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * Created by dhruvr on 11/9/15.
 */
public class ESIndexer {
    private final CSVParser csvParser;
    private final Client client;
    private static final Logger LOGGER = LoggerFactory.getLogger(ESIndexer.class);

    public ESIndexer(CSVParser csvparser, Client client) {
        this.client = client;
        this.csvParser = csvparser;
    }

    //TODO improve it
    public void index() throws IOException {

        int count = 0;
        for (final CSVRecord record : csvParser) {
            LOGGER.info("indexing record {}",count++);
            IndexResponse response = client.prepareIndex("postal-index", "zipcodes")
                    .setSource(jsonBuilder()
                                    .startObject()
                                    .field("zip", record.get("pincode"))
                                    .field("district", record.get("Districtname"))
                                    .field("state", record.get("statename"))
                                    .field("taluk", record.get("Taluk"))
                                    .field("regionName", record.get("regionname"))
                                    .field("divisionname", record.get("divisionname"))
                                    .field("officename", record.get("officename"))
                                    .endObject()
                    )
                    .execute()
                    .actionGet();
        }
        LOGGER.info("all indexing done congrats");
        LOGGER.info("Closing down stuffs..");
        this.csvParser.close();
        this.client.close();
    }
}
