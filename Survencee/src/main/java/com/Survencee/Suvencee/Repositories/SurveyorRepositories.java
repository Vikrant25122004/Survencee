package com.Survencee.Suvencee.Repositories;

import com.Survencee.Suvencee.Entity.Surveyor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyorRepositories extends MongoRepository<Surveyor, ObjectId> {
    Surveyor findByusername(String username);
    void deleteByusername(String username);

}
