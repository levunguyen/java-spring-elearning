package elearning.demo.service;

import elearning.demo.entity.Course;
import elearning.demo.model.CourseDetail;

import java.util.List;

public interface CourseService {
    List<Course> findAllCourse();
    CourseDetail getDetailCourse(String courseId);
    Course findCourse(String courseId);
}
