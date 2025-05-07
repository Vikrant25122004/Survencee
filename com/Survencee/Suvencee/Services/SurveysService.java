/*    */ package BOOT-INF.classes.com.Survencee.Suvencee.Services;
/*    */ 
/*    */ import com.Survencee.Suvencee.Entity.Surveys;
/*    */ import com.Survencee.Suvencee.Repositories.SurveysRepository;
/*    */ import com.fasterxml.jackson.core.JsonProcessingException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.bson.types.ObjectId;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.beans.factory.annotation.Value;
/*    */ import org.springframework.data.mongodb.core.MongoTemplate;
/*    */ import org.springframework.data.mongodb.core.query.Criteria;
/*    */ import org.springframework.data.mongodb.core.query.CriteriaDefinition;
/*    */ import org.springframework.data.mongodb.core.query.Query;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.web.reactive.function.client.WebClient;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class SurveysService
/*    */ {
/*    */   @Autowired
/*    */   private MongoTemplate mongoTemplate;
/*    */   @Autowired
/*    */   private WebClient webClient;
/*    */   
/*    */   public ArrayList<Surveys> getallsurveys() {
/* 32 */     ArrayList<Surveys> all = (ArrayList<Surveys>)this.surveysRepository.findAll();
/* 33 */     return all; } @Value("${gemini.api.url}")
/*    */   private String geminiapiurl; @Value("${gemini.api.key}")
/*    */   private String geminiapikey; @Autowired
/*    */   private SurveysRepository surveysRepository; public void uploadsurveys(Surveys surveys) throws JsonProcessingException { try {
/* 37 */       this.surveysRepository.save(surveys);
/* 38 */     } catch (RuntimeException e) {
/* 39 */       throw new RuntimeException(e);
/*    */     }  }
/*    */   
/*    */   public ArrayList<Surveys> gets(String username) {
/* 43 */     Query query = new Query();
/* 44 */     query.addCriteria((CriteriaDefinition)Criteria.where("username").is(username));
/* 45 */     ArrayList<Surveys> surveys = (ArrayList<Surveys>)this.mongoTemplate.find(query, Surveys.class);
/* 46 */     return surveys;
/*    */   }
/*    */   
/*    */   public ArrayList<Surveys> getallsurv() {
/* 50 */     ArrayList<Surveys> surveys = (ArrayList<Surveys>)this.surveysRepository.findAll();
/* 51 */     return surveys;
/*    */   }
/*    */   
/*    */   public void like(ObjectId id, String username) {
/* 55 */     Surveys surveys = this.surveysRepository.findByid(id);
/*    */     
/* 57 */     ArrayList<String> likes = surveys.getLike();
/* 58 */     if (likes.contains(username)) {
/* 59 */       surveys.setLikes(surveys.getLikes() - 1);
/* 60 */       likes.remove(username);
/* 61 */       surveys.setLike(likes);
/* 62 */       this.surveysRepository.save(surveys);
/*    */     } else {
/*    */       
/* 65 */       surveys.setLikes(surveys.getLikes() + 1);
/* 66 */       likes.add(username);
/* 67 */       surveys.setLike(likes);
/* 68 */       this.surveysRepository.save(surveys);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void comments(String username, String comment, ObjectId id) {
/* 73 */     Surveys surveys = this.surveysRepository.findByid(id);
/* 74 */     HashMap<String, String> commentss = surveys.getComments();
/* 75 */     commentss.put(username, comment);
/* 76 */     surveys.setComment(surveys.getComment() + 1);
/* 77 */     surveys.setComments(commentss);
/* 78 */     this.surveysRepository.save(surveys);
/*    */   }
/*    */   public String getans(String question) {
/* 81 */     Map<String, Object> requestbody = Map.of("contents", new Object[] {
/*    */           
/* 83 */           Map.of("parts", new Object[] {
/* 84 */               Map.of("text", question)
/*    */             })
/*    */         });
/*    */
/* 96 */     String response = (String)((WebClient.RequestBodySpec)((WebClient.RequestBodySpec)this.webClient.post().uri(this.geminiapiurl + this.geminiapiurl, new Object[0])).header("Content-Type", new String[] { "application/json" })).bodyValue(requestbody).retrieve().bodyToMono(String.class).block();
/* 97 */     return response;
/*    */   }
/*    */ }


/* Location:              C:\Users\AVITA\OneDrive\Desktop\New folder (2)\Survencee-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\Survencee\Suvencee\Services\SurveysService.class
 * Java compiler version: 24 (68.0)
 * JD-Core Version:       1.1.3
 */