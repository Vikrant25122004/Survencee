package com.Survencee.Suvencee.Filter;

import com.Survencee.Suvencee.Services.ReporterServiceimpl;
import com.Survencee.Suvencee.Services.SurveyorServiceimpl;
import com.Survencee.Suvencee.Utils.Jwtutils;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private SurveyorServiceimpl surveyorServiceimpl;
    @Autowired
    private ReporterServiceimpl reporterServiceimpl;
    @Autowired
    private Jwtutils jwtutils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, java.io.IOException {
        String authorisationheader = request.getHeader("Authorization");
        String username = null;
        String jwt = null;
        if (authorisationheader != null && authorisationheader.startsWith("Bearer ")) {
            jwt = authorisationheader.substring(7);
            username = jwtutils.extractUsername(jwt);
        }
        if (username!=null){
            try {
                UserDetails userDetails = surveyorServiceimpl.loadUserByUsername(username);
                if (jwtutils.validateToken(jwt)) {
                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(auth);


                }
            } catch (Exception e) {
                UserDetails userDetails = reporterServiceimpl.loadUserByUsername(username);
                if (jwtutils.validateToken(jwt)) {
                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(auth);


                }
            }
        }
        filterChain.doFilter(request,response);
    }

}
