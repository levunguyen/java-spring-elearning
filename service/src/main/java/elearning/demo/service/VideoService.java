package elearning.demo.service;

import elearning.demo.entity.Video;

import java.io.InputStream;

public interface VideoService {
    Video findVideoById(String id);
    InputStream getVideoStream(String videoPath);
}
