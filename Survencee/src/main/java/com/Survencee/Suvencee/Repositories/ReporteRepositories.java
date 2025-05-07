package com.Survencee.Suvencee.Repositories;

import com.Survencee.Suvencee.Entity.Reporter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReporteRepositories extends MongoRepository<Reporter, ObjectId> {
    Reporter findByrepoUsername(String repoUsername);
    void deleteByrepoUsername(String repoUsername);

}
