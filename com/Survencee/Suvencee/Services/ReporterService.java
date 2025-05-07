/*    */ package BOOT-INF.classes.com.Survencee.Suvencee.Services;
/*    */ 
/*    */ import com.Survencee.Suvencee.Entity.Reporter;
/*    */ import com.Survencee.Suvencee.Repositories.ReporteRepositories;
/*    */ import com.Survencee.Suvencee.Services.EmailServices;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.security.crypto.password.PasswordEncoder;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class ReporterService
/*    */ {
/*    */   @Autowired
/*    */   private ReporteRepositories reporteRepositories;
/*    */   
/*    */   public void registerrep(Reporter reporter) {
/*    */     try {
/* 19 */       reporter.setPassword(this.passwordEncoder.encode(reporter.getPassword()));
/* 20 */       this.reporteRepositories.save(reporter);
/* 21 */       this.emailServices.messages(reporter.getEmail(), "Registration", "you have successfully registered on survencee");
/* 22 */     } catch (Exception e) {
/* 23 */       throw new RuntimeException(e);
/*    */     }  } @Autowired
/*    */   private EmailServices emailServices; @Autowired
/*    */   private PasswordEncoder passwordEncoder; public Reporter getrep(String username) {
/*    */     try {
/* 28 */       Reporter reporter = this.reporteRepositories.findByrepoUsername(username);
/* 29 */       return reporter;
/* 30 */     } catch (Exception e) {
/* 31 */       throw new RuntimeException(e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\AVITA\OneDrive\Desktop\New folder (2)\Survencee-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\Survencee\Suvencee\Services\ReporterService.class
 * Java compiler version: 24 (68.0)
 * JD-Core Version:       1.1.3
 */