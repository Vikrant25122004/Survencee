package com.Survencee.Suvencee.Services;

import com.Survencee.Suvencee.Entity.Reporter;
import com.Survencee.Suvencee.Repositories.ReporteRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ReporterServiceimpl implements UserDetailsService {
    @Autowired
    private ReporteRepositories reporteRepositories;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Reporter reporter = reporteRepositories.findByrepoUsername(username);
        if (reporter != null){
            UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                    .username(reporter.getRepoUsername())
                    .password(reporter.getPassword())
                    .build();
            return userDetails;
        }
        throw new UsernameNotFoundException("user not found with this username");
    }
}
