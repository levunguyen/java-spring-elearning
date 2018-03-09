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
import org.springframework.data.domain.PageRequest;
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
        courseDetailDto.setCourseDtoFromCourse(courseOptional.get());

        List<Section> sections = sectionService.findAllSectionByCourseId(courseId);
        courseDetailDto.addAllSection(sections);

        List<Video> videos = new ArrayList<>();
        for(int i=0;i<sections.size() ;i++) {
             courseDetailDto.getSectionList().get(i).
                     addAllVideo(videoService.findAllBySectionId(sections.get(i).getId()));
        }

        return courseDetailDto;
    }
    /*add pageable*/
    @Override
    public List<Course> find10Course(PageRequest pageRequest) {
        return this.courseRepository.find10Course(pageRequest);
    }
}
