package elearning.demo.repository;

import elearning.demo.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SectionRepository extends JpaRepository<Section, String> {

    @Query(value = "select s from Section s where s.course.id = :courseId order by s.sectionName")
    List<Section> findAllByCourseId(@Param("courseId") String courseId);

}
