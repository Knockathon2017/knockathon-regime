package com.exzeo.spark.serviceImpl;

import com.exzeo.spark.dao.IdeaDao;
import com.exzeo.spark.model.Idea;
import com.exzeo.spark.service.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dhruvr on 12/9/15.
 */

@Service("ideaService")
@Transactional(readOnly=true)
public class IdeaServiceImpl implements IdeaService {

    @Autowired
    private IdeaDao ideaDao;

        public void saveIdea(Idea idea) {
        ideaDao.saveOrUpdate(idea);
    }


    @Override
    public void getIdea(long ideaId) {

    }

    @Override
    public List<Idea> getAllIdeas() {
        return null;
    }
}
