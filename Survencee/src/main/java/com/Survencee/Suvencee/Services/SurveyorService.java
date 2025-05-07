package com.Survencee.Suvencee.Services;

import com.Survencee.Suvencee.Entity.Surveyor;
import com.Survencee.Suvencee.Repositories.SurveyorRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class SurveyorService {
    @Autowired
    private SurveyorRepositories surveyorRepositories;
    @Autowired
    private EmailServices emailServices;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public void registersurveyor(Surveyor surveyor){
        try {
            surveyor.setPassword(passwordEncoder.encode(surveyor.getPassword()));
            surveyorRepositories.save(surveyor);
            emailServices.messages(surveyor.getEmail(),"Registration", "you have successfully registered on survencee");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public Surveyor getsurveyor(String username){
        try {
            return surveyorRepositories.findByusername(username);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void uploadimg(Surveyor surveyor, String profile, String imgurl){
        try{
            surveyor.setPicturename(profile);
            surveyor.setImgurl(imgurl);
            surveyorRepositories.save(surveyor);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
