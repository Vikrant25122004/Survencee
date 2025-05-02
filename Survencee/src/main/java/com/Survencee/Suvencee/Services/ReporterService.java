package com.Survencee.Suvencee.Services;

import com.Survencee.Suvencee.Entity.Reporter;
import com.Survencee.Suvencee.Repositories.ReporteRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReporterService {
    @Autowired
    private ReporteRepositories reporteRepositories;
    public void registerrep(Reporter reporter){
        try {
            reporteRepositories.save(reporter);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
