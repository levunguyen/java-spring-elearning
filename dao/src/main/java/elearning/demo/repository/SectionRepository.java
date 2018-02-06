package elearning.demo.repository;

import elearning.demo.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SectionRepository extends JpaRepository<Section, String> {

    @Query(value = "select s from Section s where s.course.id = :courseId")
    List<Section> findAllByCourseId(@Param("courseId") String courseId);

    @Override
    List<Section> findAll();
}
