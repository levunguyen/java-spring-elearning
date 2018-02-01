package elearning.demo.controller;

import elearning.demo.utility.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hieu {

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public ResponseEntity<String> ping() {
        return new ResponseEntity<>("Hieu", HttpStatus.OK);
    }
}
