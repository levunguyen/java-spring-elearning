package elearning.demo.controller;

import elearning.demo.entity.Course;
import elearning.demo.model.CourseDetailModel;
import elearning.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.Optional;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping(value = "course/{courseId}")
    public ResponseEntity<Object> showDetailCourse(@PathVariable String courseId){
        Optional<CourseDetailModel> courseOptional = Optional.ofNullable(courseService.getDetailCourse(courseId));
        if(courseOptional.isPresent()){
            return new ResponseEntity<>(courseOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Course not found ", HttpStatus.NOT_FOUND);
    }
}
