package elearning.demo.service;

import elearning.demo.entity.Course;
import elearning.demo.model.CourseDetailModel;

import java.util.List;

public interface CourseService {
    CourseDetailModel getDetailCourse(String courseId);
    List<Course> findAllCourse();
}
