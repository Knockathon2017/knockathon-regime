package com.exzeo.rest;

import com.exzeo.Searcher.Searcher;
import com.exzeo.settings.Settings;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by dhruvr on 10/9/15.
 */

@Path("/")
@Singleton
public class RestAPIS {
    @Inject
    private Settings settings;

    @Inject
    private Searcher searcher;

    private static final Logger LOGGER = LoggerFactory.getLogger(RestAPIS.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String echo(){
        return settings.toString();
    }


    @GET
    @Path("/data/zip/{zip}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getDetails(@PathParam("zip") String zip){
        LOGGER.info("Got zip resquet  {} ", zip);
        try {
            return searcher.searchByZip(zip);
        }catch (Exception e){
            LOGGER.error("Problem while searching ",e);
            return Response.serverError().toString();
        }
    }
}
