package elearning.demo.service.Impl;

import elearning.demo.entity.Section;
import elearning.demo.repository.SectionRepository;
import elearning.demo.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    SectionRepository sectionRepository;

    @Override
    public List<Section> findAllSectionByCourseId(String courseId) {
        return sectionRepository.findAllByCourseId(courseId);
    }

}
