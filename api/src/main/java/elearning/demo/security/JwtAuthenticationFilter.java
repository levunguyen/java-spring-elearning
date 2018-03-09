package elearning.demo.security;

import elearning.demo.utility.Constants;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping(value = Constants.URI_SECURITY)
public class JwtAuthenticationFilter {

}
