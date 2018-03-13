package elearning.demo.security;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import static elearning.demo.utility.Constants.HEADER_STRING;
import static elearning.demo.utility.Constants.SECRET;
import static elearning.demo.utility.Constants.TOKEN_PREFIX;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class JWTAuthorzationFilter extends BasicAuthenticationFilter {

    public JWTAuthorzationFilter(AuthenticationManager authenticationManager){
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(HEADER_STRING);
        if (header == null || !header.startsWith(TOKEN_PREFIX)){
            chain.doFilter(request,response);
            return;
        }

        UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
        return;
    }
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request){
        String token = request.getHeader(HEADER_STRING);
        if (token != null){
            // parse the token.
            String user = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJwt(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();
            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
            return null;
        }
        return null;
    }
}
