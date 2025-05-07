/*    */ package BOOT-INF.classes.com.Survencee.Suvencee.Services;
/*    */ 
/*    */ import com.Survencee.Suvencee.Entity.Reporter;
/*    */ import com.Survencee.Suvencee.Repositories.ReporteRepositories;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.security.core.userdetails.User;
/*    */ import org.springframework.security.core.userdetails.UserDetails;
/*    */ import org.springframework.security.core.userdetails.UserDetailsService;
/*    */ import org.springframework.security.core.userdetails.UsernameNotFoundException;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service
/*    */ public class ReporterServiceimpl
/*    */   implements UserDetailsService {
/*    */   @Autowired
/*    */   private ReporteRepositories reporteRepositories;
/*    */   
/*    */   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
/* 19 */     Reporter reporter = this.reporteRepositories.findByrepoUsername(username);
/* 20 */     if (reporter != null) {
/*    */ 
/*    */ 
/*    */       
/* 24 */       UserDetails userDetails = User.builder().username(reporter.getRepoUsername()).password(reporter.getPassword()).build();
/* 25 */       return userDetails;
/*    */     } 
/* 27 */     throw new UsernameNotFoundException("user not found with this username");
/*    */   }
/*    */ }


/* Location:              C:\Users\AVITA\OneDrive\Desktop\New folder (2)\Survencee-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\Survencee\Suvencee\Services\ReporterServiceimpl.class
 * Java compiler version: 24 (68.0)
 * JD-Core Version:       1.1.3
 */