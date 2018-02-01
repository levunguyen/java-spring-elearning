package elearning.demo.service;


import elearning.demo.entity.Course;
import elearning.demo.entity.Section;
import elearning.demo.model.CourseDetailModel;
import elearning.demo.repository.CourseRepository;
import elearning.demo.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    SectionRepository sectionRepository;

    @Autowired
    CourseDetailModel courseDetailModel;

    public CourseDetailModel getDetailCourse(String courseId) {
        Optional<Course> courseOptional= Optional.ofNullable(courseRepository.getOne(courseId));
        if(!courseOptional.isPresent()){
            return null;
        }
        List<Section> listSection = sectionRepository.findAllByCourseId(courseId);
        courseDetailModel.setCourse(courseOptional.get());
        courseDetailModel.setSectionList(listSection);
        return courseDetailModel;
    }

    @Override
    public List<Course> findAllCourse() {
        return courseRepository.findAll();
    }
}
