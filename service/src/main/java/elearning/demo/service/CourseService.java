package elearning.demo.service;

import elearning.demo.entity.Course;
import elearning.demo.model.CourseDetailDto;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> findAllCourse();
    CourseDetailDto getDetailCourse(String courseId);
    Optional<Course> findByCourseId(String courseId);
}
