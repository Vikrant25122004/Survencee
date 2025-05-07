/*    */ package BOOT-INF.classes.com.Survencee.Suvencee.Config;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.web.reactive.function.client.WebClient;
/*    */ 
/*    */ @Configuration
/*    */ public class webclient {
/*    */   @Bean
/*    */   public WebClient webClient(WebClient.Builder builder) {
/* 10 */     return builder
/* 11 */       .build();
/*    */   }
/*    */ }


/* Location:              C:\Users\AVITA\OneDrive\Desktop\New folder (2)\Survencee-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\Survencee\Suvencee\Config\webclient.class
 * Java compiler version: 24 (68.0)
 * JD-Core Version:       1.1.3
 */