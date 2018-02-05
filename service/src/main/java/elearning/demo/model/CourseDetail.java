package elearning.demo.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import elearning.demo.entity.Course;
import elearning.demo.entity.Section;
import elearning.demo.entity.Video;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CourseDetail implements Serializable {

    private CourseDto courseDto;

    private List<SectionDto> sectionList;

    private List<VideoDto> videoList;

    public CourseDetail() {
        sectionList = new ArrayList<>();
        videoList = new ArrayList<>();
        courseDto = new CourseDto();
    }

    public CourseDetail(CourseDto course, List<SectionDto> sectionList,List<VideoDto> videoList) {
        this.courseDto = course;
        this.sectionList = sectionList;
        this.videoList = videoList;
    }

    public CourseDto getCourse() {
        return courseDto;
    }

    public void setCourse(CourseDto course) {
        this.courseDto = course;
    }

    public List<SectionDto> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<SectionDto> sectionList) {
        this.sectionList = sectionList;
    }

    public List<VideoDto> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<VideoDto> videoList) {
        this.videoList = videoList;
    }

    public void addAllSection(List<Section> sections){
        for (Section section:sections) {
            SectionDto sectionDto = new SectionDto(section.getId(),section.getSectionName());
            sectionList.add(sectionDto);
        }
    }

    public void addAllVideo(List<Video> videos){
        for (Video video:videos) {
            VideoDto videoDto = new VideoDto(video.getId(),video.getVideoUrl(),
                    video.getSection().getId(),video.getDescription(),video.getVideoName());
            videoList.add(videoDto);
        }
    }

    public void setCourseDtoFromCourse(Course course){
        courseDto.setCourse_id(course.getId());
        courseDto.setCourse_name(course.getCourseName());
        courseDto.setDescription(course.getDescription());
        courseDto.setImage_url(course.getImageUrl());
    }

}
