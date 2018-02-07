package elearning.demo.service;

import elearning.demo.entity.Section;

import java.util.List;

public interface SectionService {

    List<Section> findAllSectionByCourseId(String courseId);

}
