package elearning.demo.controller;

import elearning.demo.entity.Course;
import elearning.demo.model.CourseDetailDto;
import elearning.demo.service.CourseService;
import elearning.demo.utility.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = Constants.URI_API)
public class CourseController {

    private static final Logger log = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    CourseService courseService;

    @GetMapping(value = Constants.URI_COURSES)
    @ResponseBody
    public ResponseEntity<Object> getAllCourse() {

        log.debug("Get all course");

        List<Course> courses = courseService.findAllCourse();

        if (courses == null) {
            return new ResponseEntity<>("No course found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping(value = Constants.URI_COURSE)
    @ResponseBody
    public ResponseEntity<Object> getDetailCourse(@RequestParam("id") String id){

        log.debug("Get detail course");

        Optional<CourseDetailDto> courseDetailOptional = Optional.ofNullable(courseService.getDetailCourse(id));

        if(courseDetailOptional.isPresent()){
            return new ResponseEntity<>(courseDetailOptional.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>("No course detail", HttpStatus.OK);

    }

}
