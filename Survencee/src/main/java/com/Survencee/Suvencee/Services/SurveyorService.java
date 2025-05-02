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
    private PasswordEncoder passwordEncoder;
    public void registersurveyor(Surveyor surveyor){
        try {
            surveyor.setPassword(passwordEncoder.encode(surveyor.getPassword()));
            surveyorRepositories.save(surveyor);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
