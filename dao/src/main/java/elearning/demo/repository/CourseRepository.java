package elearning.demo.repository;

import elearning.demo.entity.Course;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,String> {
    Course getOne(String courseId);
    List<Course> findAll();
    /*add pageable*/
    @Query(value = "select c from Course  c order by c.id")
    List<Course> find10Course(Pageable pageable);
}
