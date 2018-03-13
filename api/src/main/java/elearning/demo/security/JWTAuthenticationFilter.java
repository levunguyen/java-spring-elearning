package elearning.demo.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import elearning.demo.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static elearning.demo.utility.Constants.*;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private ObjectMapper objectMapper;
    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, ObjectMapper objectMapper){
        this.authenticationManager = authenticationManager;
        this.objectMapper = objectMapper;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            User creds = new ObjectMapper().readValue(request.getInputStream(),User.class);
            return authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(
                      creds.getUsername(),
                      creds.getPassword(),
                      new ArrayList<>()
              )
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        String username = ((org.springframework.security.core.userdetails.User) authResult.getPrincipal()).getUsername();
        String jwt = Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();

        SuccessfulAuthenticationResponse successfulAuthenticationResponse = new SuccessfulAuthenticationResponse(jwt, EXPIRATION_TIME);
        try {
            String jwtResponse = objectMapper.writeValueAsString(successfulAuthenticationResponse);
            response.setContentType("application/json");
            response.getWriter().write(jwtResponse);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // parse object to json
    private class SuccessfulAuthenticationResponse{
        private String jwt;
        private long expires;

        public SuccessfulAuthenticationResponse(String jwt, long expires){
            this.jwt =  jwt;
            this.expires = expires;
        }

        public String getJwt() {
            return jwt;
        }

        public void setJwt(String jwt) {
            this.jwt = jwt;
        }

        public long getExpires() {
            return expires;
        }

        public void setExpires(long expires) {
            this.expires = expires;
        }
    }
}
