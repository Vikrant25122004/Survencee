/*    */ package BOOT-INF.classes.com.Survencee.Suvencee.Services;
/*    */ 
/*    */ import com.Survencee.Suvencee.Entity.Surveyor;
/*    */ import com.Survencee.Suvencee.Repositories.SurveyorRepositories;
/*    */ import com.Survencee.Suvencee.Services.EmailServices;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.security.crypto.password.PasswordEncoder;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class SurveyorService
/*    */ {
/*    */   @Autowired
/*    */   private SurveyorRepositories surveyorRepositories;
/*    */   
/*    */   public void registersurveyor(Surveyor surveyor) {
/*    */     try {
/* 20 */       surveyor.setPassword(this.passwordEncoder.encode(surveyor.getPassword()));
/* 21 */       this.surveyorRepositories.save(surveyor);
/* 22 */       this.emailServices.messages(surveyor.getEmail(), "Registration", "you have successfully registered on survencee");
/* 23 */     } catch (RuntimeException e) {
/* 24 */       throw new RuntimeException(e);
/*    */     }  } @Autowired
/*    */   private EmailServices emailServices; @Autowired
/*    */   private PasswordEncoder passwordEncoder; public Surveyor getsurveyor(String username) {
/*    */     try {
/* 29 */       return this.surveyorRepositories.findByusername(username);
/* 30 */     } catch (Exception e) {
/* 31 */       throw new RuntimeException(e);
/*    */     } 
/*    */   }
/*    */   public void uploadimg(Surveyor surveyor, String profile, String imgurl) {
/*    */     try {
/* 36 */       surveyor.setPicturename(profile);
/* 37 */       surveyor.setImgurl(imgurl);
/* 38 */       this.surveyorRepositories.save(surveyor);
/*    */     }
/* 40 */     catch (Exception e) {
/* 41 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\AVITA\OneDrive\Desktop\New folder (2)\Survencee-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\Survencee\Suvencee\Services\SurveyorService.class
 * Java compiler version: 24 (68.0)
 * JD-Core Version:       1.1.3
 */