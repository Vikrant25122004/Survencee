package com.Survencee.Suvencee.Controller;

import com.Survencee.Suvencee.Entity.Surveyor;
import com.Survencee.Suvencee.Entity.Surveys;
import com.Survencee.Suvencee.Services.SurveyorService;
import com.Survencee.Suvencee.Services.SurveysService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.mail.Multipart;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
@Controller
@RequestMapping("/Surveyor")
public class SurveyorController {
    @Autowired
    private SurveysService surveysService;
    @Autowired
    private SurveyorService surveyorService;
    @GetMapping("/profile")
    public String surveyor(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Surveyor surveyor = surveyorService.getsurveyor(username);
        ArrayList<Surveys> surveys = surveysService.gets(username);
        model.addAttribute("Surveys",surveys);
        model.addAttribute("Surveyor",surveyor );
        return "profile";
    }

    @PostMapping("/upload/profile")
    public String uploadimg(@RequestParam("pic")MultipartFile file, Model model) throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Surveyor surveyor = surveyorService.getsurveyor(username);
        try {
            String base64img = Base64.getEncoder().encodeToString(file.getBytes());
            surveyorService.uploadimg(surveyor, file.getOriginalFilename(), base64img);

        }
        catch (IOException e) {
            e.printStackTrace(); // Handle the error properly
        }
        model.addAttribute("Surveyor",surveyor);
        return "redirect:/Surveyor/profile";
    }
    @GetMapping("/upload/surv/{username}")
    public String uploadSurveyForm( Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username",authentication.getName());
        model.addAttribute("Surveys",new Surveys());

        return "Upload"; // Thymeleaf template name (e.g., uploadSurvey.html)
    }
    @PostMapping("/surve/{username}")
    public String savesurv(@PathVariable String username, @RequestParam("title") String title, @RequestParam("Surveys") String surveytext, @RequestParam("proofs") MultipartFile[] proofs) throws IOException{
        ArrayList<String> encoded = new ArrayList<>();
        for (MultipartFile file : proofs) {
            if (!file.isEmpty()) {
                String encode = Base64.getEncoder().encodeToString(file.getBytes());
                encoded.add(encode);
            }
        }
        Surveys surveys = new Surveys();
        surveys.setSurveys(surveytext);
        surveys.setProofs(encoded);
        surveys.setUsername(username);
        surveys.setTitle(title);
        surveysService.uploadsurveys(surveys);
        return "redirect:/Surveyor/profile";

    }
    @GetMapping("/logout")
    public String logout(HttpServletResponse response){
        Cookie cookie = new Cookie("jwt", "");
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(0); // <-- This removes the cookie
        response.addCookie(cookie);
        return "redirect:/surv/login";
    }



}
