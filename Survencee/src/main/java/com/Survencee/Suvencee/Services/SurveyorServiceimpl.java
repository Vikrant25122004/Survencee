package com.Survencee.Suvencee.Services;

import com.Survencee.Suvencee.Entity.Surveyor;
import com.Survencee.Suvencee.Repositories.SurveyorRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SurveyorServiceimpl implements UserDetailsService {
    @Autowired
    private SurveyorRepositories surveyorRepositories;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Surveyor surveyor = surveyorRepositories.findByusername(username);
            if (surveyor != null){
                UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                        .username(surveyor.getUsername())
                        .password(surveyor.getPassword())
                        .build();
                return userDetails;
            }
            throw new UsernameNotFoundException("user not found with this username");
        }
}
