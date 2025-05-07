/*     */ package BOOT-INF.classes.com.Survencee.Suvencee.Controller;
/*     */ 
/*     */ import com.Survencee.Suvencee.Entity.Reporter;
/*     */ import com.Survencee.Suvencee.Entity.Surveyor;
/*     */ import com.Survencee.Suvencee.Services.ReporterService;
/*     */ import com.Survencee.Suvencee.Services.ReporterServiceimpl;
/*     */ import com.Survencee.Suvencee.Services.SurveyorService;
/*     */ import com.Survencee.Suvencee.Services.SurveyorServiceimpl;
/*     */ import com.Survencee.Suvencee.Utils.Jwtutils;
/*     */ import jakarta.servlet.http.Cookie;
/*     */ import jakarta.servlet.http.HttpServletResponse;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.security.core.userdetails.UserDetails;
/*     */ import org.springframework.security.core.userdetails.UsernameNotFoundException;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping
/*     */ public class Public
/*     */ {
/*     */   @Autowired
/*     */   private SurveyorServiceimpl surveyorServiceimpl;
/*     */   @Autowired
/*     */   private SurveyorService surveyorService;
/*     */   
/*     */   @GetMapping
/*     */   public String signuppage(@RequestParam(value = "formType", required = false) String formType, Model model) {
/*  36 */     if ("surveyor".equals(formType)) {
/*  37 */       model.addAttribute("Surveyor", new Surveyor());
/*  38 */     } else if ("reporter".equals(formType)) {
/*  39 */       model.addAttribute("Reporter", new Reporter());
/*     */     } else {
/*     */       
/*  42 */       model.addAttribute("Surveyor", new Surveyor());
/*     */     } 
/*  44 */     return "Signup"; } @Autowired
/*     */   private ReporterService reporterService; @Autowired
/*     */   private ReporterServiceimpl reporterServiceimpl; @Autowired
/*     */   private Jwtutils jwtutils; @PostMapping({"/registersurv"})
/*     */   public String signupsurv(@ModelAttribute("Surveyor") Surveyor surveyor) {
/*     */     try {
/*  50 */       this.surveyorService.registersurveyor(surveyor);
/*  51 */       return "redirect:/surv/login";
/*     */     }
/*  53 */     catch (Exception e) {
/*  54 */       e.printStackTrace();
/*  55 */       return "Signup";
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/surv/login"})
/*     */   public String loginsurv(Model model) {
/*  62 */     model.addAttribute("Surveyor", new Surveyor());
/*  63 */     return "SurveyorLogin";
/*     */   }
/*     */   @PostMapping({"/login-Surveyor"})
/*     */   public String LoginSurveyor(@ModelAttribute("Surveyor") Surveyor surveyor, HttpServletResponse response) {
/*     */     try {
/*  68 */       UserDetails userDetails = this.surveyorServiceimpl.loadUserByUsername(surveyor.getUsername());
/*  69 */       String jwt = this.jwtutils.generateToken(userDetails.getUsername());
/*  70 */       Cookie cookie = new Cookie("jwt", jwt);
/*  71 */       cookie.setHttpOnly(true);
/*  72 */       cookie.setSecure(true);
/*  73 */       cookie.setPath("/");
/*  74 */       cookie.setMaxAge(604800);
/*  75 */       response.addCookie(cookie);
/*     */       
/*  77 */       return "redirect:/Surveyor/profile";
/*  78 */     } catch (Exception e) {
/*  79 */       throw new RuntimeException("something went wrong please try again");
/*     */     } 
/*     */   }
/*     */   @PostMapping({"/registerrep"})
/*     */   public String signuprep(@ModelAttribute("Reporter") Reporter reporter) {
/*     */     try {
/*  85 */       this.reporterService.registerrep(reporter);
/*  86 */       return "redirect:/report/login";
/*     */     }
/*  88 */     catch (Exception e) {
/*  89 */       return "Signup";
/*     */     } 
/*     */   }
/*     */   
/*     */   @GetMapping({"/report/login"})
/*     */   public String loginrep(Model model) {
/*  95 */     model.addAttribute("Reporter", new Reporter());
/*  96 */     return "ReporterLogin";
/*     */   }
/*     */   
/*     */   @PostMapping({"/login-Reporter"})
/*     */   public String Loginrep(@ModelAttribute("Reporter") Reporter reporter, HttpServletResponse response) {
/*     */     try {
/* 102 */       UserDetails userDetails = this.reporterServiceimpl.loadUserByUsername(reporter.getRepoUsername());
/* 103 */       String jwt = this.jwtutils.generateToken(userDetails.getUsername());
/* 104 */       Cookie cookie = new Cookie("jwt", jwt);
/* 105 */       cookie.setHttpOnly(true);
/* 106 */       cookie.setSecure(true);
/* 107 */       cookie.setPath("/");
/* 108 */       cookie.setMaxAge(604800);
/* 109 */       response.addCookie(cookie);
/* 110 */       return "redirect:/Reporter/feeds";
/* 111 */     } catch (UsernameNotFoundException e) {
/* 112 */       throw new RuntimeException(e);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\AVITA\OneDrive\Desktop\New folder (2)\Survencee-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\Survencee\Suvencee\Controller\Public.class
 * Java compiler version: 24 (68.0)
 * JD-Core Version:       1.1.3
 */