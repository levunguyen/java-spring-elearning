package elearning.demo.model;

import elearning.demo.entity.Course;
import elearning.demo.entity.Section;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CourseDetail {

    private Course course;

    private List<Section> sectionList;

    public CourseDetail() {}

    public CourseDetail(Course course, List<Section> sectionList) {
        this.course = course;
        this.sectionList = sectionList;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }
}
