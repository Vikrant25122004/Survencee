/*    */ package BOOT-INF.classes.com.Survencee.Suvencee.Controller;
/*    */ 
/*    */ import com.Survencee.Suvencee.Entity.Reporter;
/*    */ import com.Survencee.Suvencee.Entity.Surveys;
/*    */ import com.Survencee.Suvencee.Services.ReporterService;
/*    */ import com.Survencee.Suvencee.Services.SurveysService;
/*    */ import java.util.ArrayList;
/*    */ import org.bson.types.ObjectId;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.security.core.Authentication;
/*    */ import org.springframework.security.core.context.SecurityContextHolder;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.Model;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"/Reporter"})
/*    */ public class ReporterController {
/*    */   @Autowired
/*    */   private SurveysService surveysService;
/*    */   
/*    */   @GetMapping({"/feeds"})
/*    */   public String feeds(Model model) {
/* 27 */     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
/* 28 */     String username = authentication.getName();
/* 29 */     Reporter reporter = this.reporterService.getrep(username);
/* 30 */     model.addAttribute("Reporter", reporter);
/* 31 */     ArrayList<Surveys> surveys = this.surveysService.getallsurv();
/* 32 */     model.addAttribute("surveys", surveys);
/* 33 */     return "feeds";
/*    */   } @Autowired
/*    */   private ReporterService reporterService; @PostMapping({"/likes"})
/*    */   public String likes(@RequestParam("id") ObjectId id, @RequestParam("username") String username) {
/* 37 */     this.surveysService.like(id, username);
/* 38 */     return "redirect:/Reporter/feeds";
/*    */   }
/*    */   
/*    */   @PostMapping({"/comment"})
/*    */   public String comment(@RequestParam("id") ObjectId id, @RequestParam("comment") String comment, @RequestParam("username") String username) {
/* 43 */     this.surveysService.comments(username, comment, id);
/* 44 */     return "redirect:/Reporter/feeds";
/*    */   }
/*    */ 
/*    */   
/*    */   @PostMapping({"/make/report"})
/*    */   public String ai(@RequestParam("survey") String payload, Model model) {
/* 50 */     String answer = this.surveysService.getans(payload);
/* 51 */     model.addAttribute("report", answer);
/* 52 */     return "Report";
/*    */   }
/*    */ }


/* Location:              C:\Users\AVITA\OneDrive\Desktop\New folder (2)\Survencee-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\Survencee\Suvencee\Controller\ReporterController.class
 * Java compiler version: 24 (68.0)
 * JD-Core Version:       1.1.3
 */