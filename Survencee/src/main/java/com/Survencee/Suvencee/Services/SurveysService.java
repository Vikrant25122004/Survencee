package com.Survencee.Suvencee.Services;

import com.Survencee.Suvencee.Entity.Surveys;
import com.Survencee.Suvencee.Repositories.SurveysRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SurveysService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private SurveysRepository surveysRepository;
    public ArrayList<Surveys> getallsurveys(){
        ArrayList<Surveys> all = (ArrayList<Surveys>) surveysRepository.findAll();
        return all;
    }
    public void uploadsurveys(Surveys surveys) throws JsonProcessingException {
       try {
           surveysRepository.save(surveys);
       } catch (RuntimeException e) {
           throw new RuntimeException(e);
       }
    }
    public ArrayList<Surveys> gets(String username){
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        ArrayList<Surveys> surveys = (ArrayList<Surveys>) mongoTemplate.find(query,Surveys.class);
        return surveys;

    }

}
