package elearning.demo.repository;

import elearning.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,String>{
    public Course getOne(String courseId);
}
