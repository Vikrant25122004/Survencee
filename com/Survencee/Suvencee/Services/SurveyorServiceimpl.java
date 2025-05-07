/*    */ package BOOT-INF.classes.com.Survencee.Suvencee.Services;
/*    */ 
/*    */ import com.Survencee.Suvencee.Entity.Surveyor;
/*    */ import com.Survencee.Suvencee.Repositories.SurveyorRepositories;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.security.core.userdetails.User;
/*    */ import org.springframework.security.core.userdetails.UserDetails;
/*    */ import org.springframework.security.core.userdetails.UserDetailsService;
/*    */ import org.springframework.security.core.userdetails.UsernameNotFoundException;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service
/*    */ public class SurveyorServiceimpl implements UserDetailsService {
/*    */   @Autowired
/*    */   private SurveyorRepositories surveyorRepositories;
/*    */   
/*    */   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
/* 18 */     Surveyor surveyor = this.surveyorRepositories.findByusername(username);
/* 19 */     if (surveyor != null) {
/*    */ 
/*    */ 
/*    */       
/* 23 */       UserDetails userDetails = User.builder().username(surveyor.getUsername()).password(surveyor.getPassword()).build();
/* 24 */       return userDetails;
/*    */     } 
/* 26 */     throw new UsernameNotFoundException("user not found with this username");
/*    */   }
/*    */ }


/* Location:              C:\Users\AVITA\OneDrive\Desktop\New folder (2)\Survencee-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\Survencee\Suvencee\Services\SurveyorServiceimpl.class
 * Java compiler version: 24 (68.0)
 * JD-Core Version:       1.1.3
 */