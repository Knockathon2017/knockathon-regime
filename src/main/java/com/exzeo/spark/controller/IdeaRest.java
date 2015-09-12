package com.exzeo.spark.controller;

import com.exzeo.spark.common.ResponseUtil;
import com.exzeo.spark.model.Idea;
import com.exzeo.spark.service.IdeaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by dhruvr on 12/9/15.
 */


@RequestMapping(value = "/idea")
public class IdeaRest {

    private final static Logger LOGGER = Logger.getLogger(IdeaRest.class);

    @Autowired
    private IdeaService ideaService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE,)
    public String createIdea(Idea idea, HttpServletResponse response) {
        try {
            ideaService.saveIdea(idea);
            return ResponseUtil.SUCCESS;
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return ResponseUtil.FAILURE;
        }
    }

}
