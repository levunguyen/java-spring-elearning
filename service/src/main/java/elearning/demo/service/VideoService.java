package elearning.demo.service;

import elearning.demo.entity.Video;

import java.io.InputStream;
import java.util.List;

public interface VideoService {
    List<Video> findAllBySectionId(String sectionId);//Hà Thêm để show list video
    Video findVideoById(String id);
    InputStream getVideoStream(String videoPath);
}
