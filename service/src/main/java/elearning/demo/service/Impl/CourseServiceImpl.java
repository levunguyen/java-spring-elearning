package elearning.demo.service.Impl;


import elearning.demo.entity.Course;
import elearning.demo.entity.Section;
import elearning.demo.model.CourseDetail;
import elearning.demo.repository.CourseRepository;
import elearning.demo.repository.SectionRepository;
import elearning.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    SectionRepository sectionRepository;

    @Autowired
    CourseDetail courseDetail;

    @Override
    public CourseDetail getDetailCourse(String courseId) {
        Optional<Course> courseOptional= Optional.ofNullable(courseRepository.getOne(courseId));
        if(!courseOptional.isPresent()){
            return null;
        }
        List<Section> listSection = sectionRepository.findAllByCourseId(courseId);
        courseDetail.setCourse(courseOptional.get());
        courseDetail.setSectionList(listSection);
        return courseDetail;
    }

    @Override
    public List<Course> findAllCourse() {
        return courseRepository.findAll();
    }

    /*add pageable*/
    @Override
    public List<Course> find10Course(PageRequest pageRequest) {
        return this.courseRepository.find10Course(pageRequest);
    }
}
