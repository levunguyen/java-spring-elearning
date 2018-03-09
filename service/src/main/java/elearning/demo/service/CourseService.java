package elearning.demo.service;

import elearning.demo.entity.Course;
import org.springframework.data.domain.PageRequest;
import elearning.demo.model.CourseDetailDto;

import java.util.List;

public interface CourseService {
    List<Course> findAllCourse();
    /*add pageable*/
    List<Course> find10Course(PageRequest pageRequest);
    CourseDetailDto getDetailCourse(String courseId);
}
