package elearning.demo.service.Impl;

import elearning.demo.entity.Course;
import elearning.demo.entity.Section;
import elearning.demo.entity.Video;
import elearning.demo.model.CourseDetailDto;
import elearning.demo.repository.CourseRepository;

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

    private final CourseRepository courseRepository;

    private final SectionService sectionService;

    private final VideoService videoService;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository, SectionService sectionService, VideoService videoService) {
        this.courseRepository = courseRepository;
        this.sectionService = sectionService;
        this.videoService = videoService;
    }

    @Override
    public List<Course> findAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public CourseDetailDto getDetailCourse(String courseId) {

        Optional<Course> courseOptional= courseRepository.findById(courseId);
        if(!courseOptional.isPresent()){
            return null;
        }

        CourseDetailDto courseDetailDto = new CourseDetailDto();

        courseDetailDto.setCourse_id(courseOptional.get().getId());
        courseDetailDto.setCourse_name(courseOptional.get().getCourseName());
        courseDetailDto.setDescription(courseOptional.get().getDescription());
        courseDetailDto.setImage_url(courseOptional.get().getImageUrl());

        List<Section> sections = sectionService.findAllSectionByCourseId(courseId);
        courseDetailDto.addAllSection(sections);

        List<Video> videos = new ArrayList<>();
        for(Section section : sections) {
            videos.addAll(videoService.findAllBySectionId(section.getId()));
        }

        courseDetailDto.addAllVideo(videos);

        return courseDetailDto;
    }

}
