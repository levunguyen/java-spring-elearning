package elearning.demo.service.Impl;

import elearning.demo.FileSupport;
import elearning.demo.entity.Video;
import elearning.demo.repository.VideoRepository;
import elearning.demo.service.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.List;

@Service
@Transactional
public class VideoServiceImpl implements VideoService {

    private static final Logger log = LoggerFactory.getLogger(VideoServiceImpl.class);

    private final VideoRepository videoRepository;

    private final FileSupport fileSupport;

    @Autowired
    public VideoServiceImpl(VideoRepository videoRepository, FileSupport fileSupport) {
        this.videoRepository = videoRepository;
        this.fileSupport = fileSupport;
    }

    @Override
    public List<Video> findAllBySectionId(String sectionId) {
        return videoRepository.getAllVideoOfSection(sectionId);
    }

    @Override
    public Video findVideoById(String id) {

        log.debug("find video by id@" + id);

        Video video = videoRepository.findVideoById(id);

        return video;

    }

    @Override
    public InputStream getVideoStream(String videoPath) {
        InputStream is = null;
        try {
            is = fileSupport.getFileStream(videoPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return is;
    }

}
