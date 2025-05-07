package BOOT-INF.classes.com.Survencee.Suvencee.Repositories;

import com.Survencee.Suvencee.Entity.Reporter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReporteRepositories extends MongoRepository<Reporter, ObjectId> {
  Reporter findByrepoUsername(String paramString);
  
  void deleteByrepoUsername(String paramString);
}


/* Location:              C:\Users\AVITA\OneDrive\Desktop\New folder (2)\Survencee-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\Survencee\Suvencee\Repositories\ReporteRepositories.class
 * Java compiler version: 24 (68.0)
 * JD-Core Version:       1.1.3
 */