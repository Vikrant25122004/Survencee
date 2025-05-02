package com.Survencee.Suvencee.Controller;

import com.Survencee.Suvencee.Entity.Reporter;
import com.Survencee.Suvencee.Entity.Surveyor;
import com.Survencee.Suvencee.Services.ReporterService;
import com.Survencee.Suvencee.Services.SurveyorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/public")
public class Public {
    @Autowired
    private SurveyorService surveyorService;
    @Autowired
    private ReporterService reporterService;
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
            return "Signup";

        } catch (Exception e) {
            e.printStackTrace();
            return "Signup";

        }

    }
    @PostMapping("/registerrep")
    public String signuprep(@ModelAttribute("Reporter") Reporter reporter){
        try {
            reporterService.registerrep(reporter);
            return "Signup";

        } catch (Exception e) {
            e.printStackTrace();
            return "Signup";
        }

    }

}
