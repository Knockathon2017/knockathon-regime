package com.exzeo.spark.daoImpl;

import com.exzeo.spark.dao.BaseDAO;
import com.exzeo.spark.dao.IdeaDao;
import com.exzeo.spark.model.Idea;
import org.springframework.stereotype.Repository;

/**
 * Created by dhruvr on 12/9/15.
 */
@Repository("ideaDAO")
public class IdeaDaoImpl extends BaseDAOImpl<Idea, Long> implements IdeaDao{

}
