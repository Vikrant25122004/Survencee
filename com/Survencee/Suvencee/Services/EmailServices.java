/*    */ package BOOT-INF.classes.com.Survencee.Suvencee.Services;
/*    */ 
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.mail.SimpleMailMessage;
/*    */ import org.springframework.mail.javamail.JavaMailSender;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service
/*    */ public class EmailServices {
/*    */   @Autowired
/*    */   private JavaMailSender javaMailSender;
/*    */   
/*    */   public void messages(String to, String subject, String text) {
/* 14 */     SimpleMailMessage message = new SimpleMailMessage();
/* 15 */     message.setTo(to);
/* 16 */     message.setSubject(subject);
/* 17 */     message.setText(text);
/*    */     try {
/* 19 */       this.javaMailSender.send(message);
/*    */     }
/* 21 */     catch (Exception e) {
/* 22 */       e.printStackTrace();
/* 23 */       System.out.println("failed to send msg" + e.getMessage());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\AVITA\OneDrive\Desktop\New folder (2)\Survencee-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\Survencee\Suvencee\Services\EmailServices.class
 * Java compiler version: 24 (68.0)
 * JD-Core Version:       1.1.3
 */