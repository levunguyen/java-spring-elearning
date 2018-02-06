package elearning.demo.service.Impl;


import com.fasterxml.jackson.annotation.JsonIgnore;
import elearning.demo.entity.Course;
import elearning.demo.entity.Section;
import elearning.demo.entity.Video;
import elearning.demo.model.CourseDetail;
import elearning.demo.model.CourseDto;
import elearning.demo.model.SectionDto;
import elearning.demo.model.VideoDto;
import elearning.demo.repository.CourseRepository;
import elearning.demo.repository.SectionRepository;
import elearning.demo.repository.VideoRepository;
import elearning.demo.service.CourseService;
import elearning.demo.service.SectionService;
import elearning.demo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    SectionService sectionService;

    @Autowired
    VideoService videoService;

    @Autowired
    CourseDetail courseDetail;

    @Override
    public List<Course> findAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public CourseDetail getDetailCourse(String courseId) {
        Optional<Course> courseOptional= courseRepository.findById(courseId);
        if(!courseOptional.isPresent()){
            return null;
        }

        courseDetail.setCourseDtoFromCourse(courseOptional.get());

        List<Section> sections = sectionService.findAllSectionByCourseId(courseId);
        courseDetail.addAllSection(sections);

        List<Video> videos = new ArrayList<>();
        for(Section section : sections) {
            videos.addAll(videoService.findAllBySectionId(section.getId()));
        }
        courseDetail.addAllVideo(videos);
        return courseDetail;
    }

    public Course findCourse(String courseId){
        return courseRepository.findById(courseId).get();
    }


}
