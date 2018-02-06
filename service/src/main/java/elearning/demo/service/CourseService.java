package elearning.demo.service;

import elearning.demo.entity.Course;
import elearning.demo.model.CourseDetailDto;

import java.util.List;

public interface CourseService {

    List<Course> findAllCourse();
    CourseDetailDto getDetailCourse(String courseId);

}
