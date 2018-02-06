package elearning.demo.service;

import elearning.demo.entity.Course;
import elearning.demo.model.CourseDetail;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface CourseService {
    List<Course> findAllCourse();
    CourseDetail getDetailCourse(String courseId);
    /*add pageable*/
    List<Course> find10Course(PageRequest pageRequest);
}
