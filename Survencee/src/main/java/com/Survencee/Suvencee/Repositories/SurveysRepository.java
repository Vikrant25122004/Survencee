package com.Survencee.Suvencee.Repositories;

import com.Survencee.Suvencee.Entity.Surveys;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveysRepository extends MongoRepository<Surveys, ObjectId> {


}
