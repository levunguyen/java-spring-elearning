package elearning.demo.repository;

import elearning.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course,String> {

    List<Course> findAll();

    Optional<Course> findById(String courseId);
}
