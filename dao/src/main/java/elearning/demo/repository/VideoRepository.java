package elearning.demo.repository;

import elearning.demo.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, String> {
    Video findVideoById(String id);

    @Query("select v from Video v where v.section.id = :sectionId")
    List<Video> getAllVideoOfSection(@Param("sectionId") String sectionId);
}
