/*    */ package BOOT-INF.classes.com.Survencee.Suvencee.Controller;
/*    */ import com.Survencee.Suvencee.Entity.Surveyor;
/*    */ import com.Survencee.Suvencee.Entity.Surveys;
/*    */ import com.Survencee.Suvencee.Services.SurveyorService;
/*    */ import com.Survencee.Suvencee.Services.SurveysService;
/*    */ import jakarta.servlet.http.Cookie;
/*    */ import jakarta.servlet.http.HttpServletResponse;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Base64;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.security.core.Authentication;
/*    */ import org.springframework.security.core.context.SecurityContextHolder;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.Model;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import org.springframework.web.multipart.MultipartFile;
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"/Surveyor"})
/*    */ public class SurveyorController {
/*    */   @Autowired
/*    */   private SurveysService surveysService;
/*    */   
/*    */   @GetMapping({"/profile"})
/*    */   public String surveyor(Model model) {
/* 31 */     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
/* 32 */     String username = authentication.getName();
/* 33 */     Surveyor surveyor = this.surveyorService.getsurveyor(username);
/* 34 */     ArrayList<Surveys> surveys = this.surveysService.gets(username);
/* 35 */     model.addAttribute("Surveys", surveys);
/* 36 */     model.addAttribute("Surveyor", surveyor);
/* 37 */     return "profile";
/*    */   } @Autowired
/*    */   private SurveyorService surveyorService;
/*    */   @PostMapping({"/upload/profile"})
/*    */   public String uploadimg(@RequestParam("pic") MultipartFile file, Model model) throws IOException {
/* 42 */     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
/* 43 */     String username = authentication.getName();
/* 44 */     Surveyor surveyor = this.surveyorService.getsurveyor(username);
/*    */     try {
/* 46 */       String base64img = Base64.getEncoder().encodeToString(file.getBytes());
/* 47 */       this.surveyorService.uploadimg(surveyor, file.getOriginalFilename(), base64img);
/*    */     
/*    */     }
/* 50 */     catch (IOException e) {
/* 51 */       e.printStackTrace();
/*    */     } 
/* 53 */     model.addAttribute("Surveyor", surveyor);
/* 54 */     return "redirect:/Surveyor/profile";
/*    */   }
/*    */   @GetMapping({"/upload/surv/{username}"})
/*    */   public String uploadSurveyForm(Model model) {
/* 58 */     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
/* 59 */     model.addAttribute("username", authentication.getName());
/* 60 */     model.addAttribute("Surveys", new Surveys());
/*    */     
/* 62 */     return "Upload";
/*    */   }
/*    */   @PostMapping({"/surve/{username}"})
/*    */   public String savesurv(@PathVariable String username, @RequestParam("title") String title, @RequestParam("Surveys") String surveytext, @RequestParam("proofs") MultipartFile[] proofs) throws IOException {
/* 66 */     ArrayList<String> encoded = new ArrayList<>();
/* 67 */     for (MultipartFile file : proofs) {
/* 68 */       if (!file.isEmpty()) {
/* 69 */         String encode = Base64.getEncoder().encodeToString(file.getBytes());
/* 70 */         encoded.add(encode);
/*    */       } 
/*    */     } 
/* 73 */     Surveys surveys = new Surveys();
/* 74 */     surveys.setSurveys(surveytext);
/* 75 */     surveys.setProofs(encoded);
/* 76 */     surveys.setUsername(username);
/* 77 */     surveys.setTitle(title);
/* 78 */     this.surveysService.uploadsurveys(surveys);
/* 79 */     return "redirect:/Surveyor/profile";
/*    */   }
/*    */   
/*    */   @GetMapping({"/logout"})
/*    */   public String logout(HttpServletResponse response) {
/* 84 */     Cookie cookie = new Cookie("jwt", "");
/* 85 */     cookie.setHttpOnly(true);
/* 86 */     cookie.setSecure(true);
/* 87 */     cookie.setPath("/");
/* 88 */     cookie.setMaxAge(0);
/* 89 */     response.addCookie(cookie);
/* 90 */     return "redirect:/surv/login";
/*    */   }
/*    */ }


/* Location:              C:\Users\AVITA\OneDrive\Desktop\New folder (2)\Survencee-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\Survencee\Suvencee\Controller\SurveyorController.class
 * Java compiler version: 24 (68.0)
 * JD-Core Version:       1.1.3
 */