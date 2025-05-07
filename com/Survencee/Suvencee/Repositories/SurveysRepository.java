package BOOT-INF.classes.com.Survencee.Suvencee.Repositories;

import com.Survencee.Suvencee.Entity.Surveys;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveysRepository extends MongoRepository<Surveys, ObjectId> {
  Surveys findByid(ObjectId paramObjectId);
}


/* Location:              C:\Users\AVITA\OneDrive\Desktop\New folder (2)\Survencee-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\Survencee\Suvencee\Repositories\SurveysRepository.class
 * Java compiler version: 24 (68.0)
 * JD-Core Version:       1.1.3
 */