package elearning.demo.repository;

import elearning.demo.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, String> {
    Video findVideoById(String id);
}
