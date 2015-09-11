package com.exzeo.Searcher;

import com.exzeo.es.EsClientProvider;
import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHitField;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by dhruvr on 11/9/15.
 */
public class RegimeSearcher implements Searcher {


    private final Client client;
    private static final Logger LOGGER = LoggerFactory.getLogger(RegimeSearcher.class);


    @Inject
    public RegimeSearcher(EsClientProvider esClientProvider) {
        client = esClientProvider.get();
    }


    //TODO Improve the method
    @Override
    public String searchByZip(String zip) {
        Preconditions.checkNotNull(zip, "zip is null");

        SearchResponse response = client.prepareSearch("postal-index")
                .setTypes("zipcodes")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.matchQuery("zip", zip))
                .execute()
                .actionGet();

        LOGGER.info("search response {} ",  response);

        SearchHit[] searchHit = response.getHits().getHits();

        if (searchHit.length == 0) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("result", "sorry no data found");
            return jsonObject.toString();
        }

        JSONArray jsonArray = new JSONArray();
        for (SearchHit hit : searchHit) {
            Map<String, Object> searchHitFieldMap = hit.getSource();
            JSONObject internalHit = new JSONObject();
            internalHit.put("zip", searchHitFieldMap.get("zip"));
            internalHit.put("district", searchHitFieldMap.get("district"));
            internalHit.put("state", searchHitFieldMap.get("state"));
            internalHit.put("taluk", searchHitFieldMap.get("taluk"));
            internalHit.put("regionName", searchHitFieldMap.get("regionName"));
            internalHit.put("divisionname", searchHitFieldMap.get("divisionname"));
            internalHit.put("officename", searchHitFieldMap.get("officename"));
            jsonArray.put(internalHit);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", jsonArray);

        LOGGER.info("{} ",jsonObject.toString());

        return jsonObject.toString();
    }
}
