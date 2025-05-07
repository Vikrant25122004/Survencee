package com.Survencee.Suvencee.Services;

import com.Survencee.Suvencee.Entity.Reporter;
import com.Survencee.Suvencee.Repositories.ReporteRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ReporterService {
    @Autowired
    private ReporteRepositories reporteRepositories;
    @Autowired
    private EmailServices emailServices;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public void registerrep(Reporter reporter){
        try {
            reporter.setPassword(passwordEncoder.encode(reporter.getPassword()));
            reporteRepositories.save(reporter);
            emailServices.messages(reporter.getEmail(),"Registration", "you have successfully registered on survencee");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
