package com.exzeo.spark.service;

import com.exzeo.spark.model.Idea;

import java.util.List;

/**
 * Created by dhruvr on 12/9/15.
 */
public interface IdeaService {

    public void saveIdea(Idea idea);

    public void getIdea(long ideaId);

    public List<Idea> getAllIdeas();

}
