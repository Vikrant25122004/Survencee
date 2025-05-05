package com.Survencee.Suvencee.Controller;

import com.Survencee.Suvencee.Entity.Surveys;
import com.Survencee.Suvencee.Services.SurveysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/Reporter")
public class ReporterController {
    @Autowired
    private SurveysService surveysService;
    @GetMapping("/feeds")
    public String feeds(){

        return "feeds";
    }


}
