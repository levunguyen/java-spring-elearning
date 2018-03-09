package elearning.demo.security;

import elearning.demo.utility.Constants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Constants.URI_SECURITY)
public class JwtAuthorizationFilter {

}
