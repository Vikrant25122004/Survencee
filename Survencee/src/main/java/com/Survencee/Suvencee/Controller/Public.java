package com.Survencee.Suvencee.Controller;

import com.Survencee.Suvencee.Entity.Reporter;
import com.Survencee.Suvencee.Entity.Surveyor;
import com.Survencee.Suvencee.Services.ReporterService;
import com.Survencee.Suvencee.Services.ReporterServiceimpl;
import com.Survencee.Suvencee.Services.SurveyorService;
import com.Survencee.Suvencee.Services.SurveyorServiceimpl;
import com.Survencee.Suvencee.Utils.Jwtutils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping()
public class Public {
    @Autowired
    private SurveyorServiceimpl surveyorServiceimpl;
    @Autowired
    private SurveyorService surveyorService;
    @Autowired
    private ReporterService reporterService;
    @Autowired
    private ReporterServiceimpl reporterServiceimpl;
    @Autowired
    private Jwtutils jwtutils;
    @GetMapping
    public String signuppage(@RequestParam(value = "formType", required = false) String formType, Model model) {
        if ("surveyor".equals(formType)) {
            model.addAttribute("Surveyor", new Surveyor());
        } else if ("reporter".equals(formType)) {
            model.addAttribute("Reporter", new Reporter());
        } else {
            // Default form (Surveyor form)
            model.addAttribute("Surveyor", new Surveyor());
        }
        return "Signup";
    }

    @PostMapping("/registersurv")
    public String signupsurv(@ModelAttribute("Surveyor") Surveyor surveyor){
        try {
            surveyorService.registersurveyor(surveyor);
            return "redirect:/surv/login";

        } catch (Exception e) {
            e.printStackTrace();
            return "Signup";

        }

    }
    @GetMapping("/surv/login")
    public String loginsurv(Model model){
        model.addAttribute("Surveyor", new Surveyor());
        return "SurveyorLogin";
    }
    @PostMapping("/login-Surveyor")
    public String LoginSurveyor(@ModelAttribute("Surveyor") Surveyor surveyor, HttpServletResponse response){
        try{
            UserDetails userDetails = surveyorServiceimpl.loadUserByUsername(surveyor.getUsername());
            String jwt = jwtutils.generateToken(userDetails.getUsername());
            Cookie cookie = new Cookie("jwt",jwt);
            cookie.setHttpOnly(true);
            cookie.setSecure(true);
            cookie.setPath("/");
            cookie.setMaxAge(7 * 24 * 60 * 60);
            response.addCookie(cookie);

            return "redirect:/Surveyor/profile";
        } catch (Exception e) {
            throw new RuntimeException("something went wrong please try again");
        }
    }
    @PostMapping("/registerrep")
    public String signuprep(@ModelAttribute("Reporter") Reporter reporter){
        try {
            reporterService.registerrep(reporter);
            return "redirect:/report/login";

        } catch (Exception e) {
            return "Signup";
        }

    }
    @GetMapping("/report/login")
    public String loginrep(Model model){
        model.addAttribute("Reporter", new Reporter());
        return "ReporterLogin";
    }

    @PostMapping("/login-Reporter")
    public String Loginrep(@ModelAttribute("Reporter") Reporter reporter,HttpServletResponse response){
        try{
            UserDetails userDetails = reporterServiceimpl.loadUserByUsername(reporter.getRepoUsername());
            String jwt = jwtutils.generateToken(userDetails.getUsername());
            Cookie cookie = new Cookie("jwt",jwt);
            cookie.setHttpOnly(true);
            cookie.setSecure(true);
            cookie.setPath("/");
            cookie.setMaxAge(7 * 24 * 60 * 60);
            response.addCookie(cookie);
            return "redirect:/Reporter/feeds";
        } catch (UsernameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
