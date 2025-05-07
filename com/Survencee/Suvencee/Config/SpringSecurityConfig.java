/*    */ package BOOT-INF.classes.com.Survencee.Suvencee.Config;
/*    */ import com.Survencee.Suvencee.Filter.JwtFilter;
/*    */ import com.Survencee.Suvencee.Services.ReporterServiceimpl;
/*    */ import com.Survencee.Suvencee.Services.SurveyorServiceimpl;
/*    */ import jakarta.servlet.Filter;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.security.authentication.AuthenticationManager;
/*    */ import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
/*    */ import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
/*    */ import org.springframework.security.config.annotation.web.builders.HttpSecurity;
/*    */ import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
/*    */ import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
/*    */ import org.springframework.security.core.userdetails.UserDetailsService;
/*    */ import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/*    */ import org.springframework.security.crypto.password.PasswordEncoder;
/*    */ import org.springframework.security.web.SecurityFilterChain;
/*    */ import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
/*    */ 
/*    */ @Configuration
/*    */ public class SpringSecurityConfig {
/*    */   @Autowired
/*    */   private SurveyorServiceimpl surveyorDetailsServiceimpl;
/*    */   
/*    */   @Bean
/*    */   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
/* 28 */     return (SecurityFilterChain)http.csrf(AbstractHttpConfigurer::disable)
/* 29 */       .authorizeHttpRequests(auth -> ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)auth.requestMatchers(new String[] { "/Surveyor/**"
/*    */           })).authenticated().requestMatchers(new String[] {
/*    */             "/Reporter/**"
/*    */           
/* 33 */           })).authenticated().anyRequest()).permitAll()).addFilterBefore((Filter)this.jwtFilter, UsernamePasswordAuthenticationFilter.class)
/* 34 */       .build();
/*    */   } @Autowired
/*    */   private ReporterServiceimpl reporterDetailServiceimpl; @Autowired
/*    */   private JwtFilter jwtFilter;
/*    */   @Bean
/*    */   public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
/* 40 */     return config.getAuthenticationManager();
/*    */   }
/*    */   
/*    */   @Bean
/*    */   public PasswordEncoder passwordEncoder() {
/* 45 */     return (PasswordEncoder)new BCryptPasswordEncoder();
/*    */   }
/*    */   
/*    */   @Bean
/*    */   public DaoAuthenticationProvider SurveyorAuthenticationProvider() {
/* 50 */     DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
/* 51 */     provider.setUserDetailsService((UserDetailsService)this.surveyorDetailsServiceimpl);
/* 52 */     provider.setPasswordEncoder(passwordEncoder());
/* 53 */     return provider;
/*    */   }
/*    */   @Bean
/*    */   public DaoAuthenticationProvider ReporterAuthenticationProvider() {
/* 57 */     DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
/* 58 */     provider.setUserDetailsService((UserDetailsService)this.reporterDetailServiceimpl);
/* 59 */     provider.setPasswordEncoder(passwordEncoder());
/* 60 */     return provider;
/*    */   }
/*    */ }


/* Location:              C:\Users\AVITA\OneDrive\Desktop\New folder (2)\Survencee-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\Survencee\Suvencee\Config\SpringSecurityConfig.class
 * Java compiler version: 24 (68.0)
 * JD-Core Version:       1.1.3
 */