/*    */ package BOOT-INF.classes.com.Survencee.Suvencee.Filter;
/*    */ 
/*    */ import com.Survencee.Suvencee.Services.ReporterServiceimpl;
/*    */ import com.Survencee.Suvencee.Services.SurveyorServiceimpl;
/*    */ import com.Survencee.Suvencee.Utils.Jwtutils;
/*    */ import io.jsonwebtoken.io.IOException;
/*    */ import jakarta.servlet.FilterChain;
/*    */ import jakarta.servlet.ServletException;
/*    */ import jakarta.servlet.ServletRequest;
/*    */ import jakarta.servlet.ServletResponse;
/*    */ import jakarta.servlet.http.Cookie;
/*    */ import jakarta.servlet.http.HttpServletRequest;
/*    */ import jakarta.servlet.http.HttpServletResponse;
/*    */ import java.io.IOException;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
/*    */ import org.springframework.security.core.Authentication;
/*    */ import org.springframework.security.core.context.SecurityContextHolder;
/*    */ import org.springframework.security.core.userdetails.UserDetails;
/*    */ import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
/*    */ import org.springframework.stereotype.Component;
/*    */ import org.springframework.web.filter.OncePerRequestFilter;
/*    */ 
/*    */ @Component
/*    */ public class JwtFilter extends OncePerRequestFilter {
/*    */   @Autowired
/*    */   private SurveyorServiceimpl surveyorServiceimpl;
/*    */   
/*    */   protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, IOException {
/* 30 */     String username = null;
/* 31 */     String jwt = null;
/*    */     
/* 33 */     if (request.getCookies() != null) {
/* 34 */       for (Cookie cookie : request.getCookies()) {
/* 35 */         if ("jwt".equals(cookie.getName())) {
/* 36 */           jwt = cookie.getValue();
/*    */         }
/*    */       } 
/*    */     }
/* 40 */     if (jwt != null) {
/* 41 */       username = this.jwtutils.extractUsername(jwt);
/*    */     }
/* 43 */     if (username != null) {
/*    */       try {
/* 45 */         UserDetails userDetails = this.surveyorServiceimpl.loadUserByUsername(username);
/* 46 */         if (this.jwtutils.validateToken(jwt).booleanValue()) {
/* 47 */           UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
/* 48 */           auth.setDetails((new WebAuthenticationDetailsSource()).buildDetails(request));
/* 49 */           SecurityContextHolder.getContext().setAuthentication((Authentication)auth);
/*    */         }
/*    */       
/*    */       }
/* 53 */       catch (Exception e) {
/* 54 */         UserDetails userDetails = this.reporterServiceimpl.loadUserByUsername(username);
/* 55 */         if (this.jwtutils.validateToken(jwt).booleanValue()) {
/* 56 */           UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
/* 57 */           auth.setDetails((new WebAuthenticationDetailsSource()).buildDetails(request));
/* 58 */           SecurityContextHolder.getContext().setAuthentication((Authentication)auth);
/*    */         } 
/*    */       } 
/*    */     }
/*    */ 
/*    */     
/* 64 */     filterChain.doFilter((ServletRequest)request, (ServletResponse)response);
/*    */   }
/*    */   
/*    */   @Autowired
/*    */   private ReporterServiceimpl reporterServiceimpl;
/*    */   @Autowired
/*    */   private Jwtutils jwtutils;
/*    */ }


/* Location:              C:\Users\AVITA\OneDrive\Desktop\New folder (2)\Survencee-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\Survencee\Suvencee\Filter\JwtFilter.class
 * Java compiler version: 24 (68.0)
 * JD-Core Version:       1.1.3
 */