package elearning.demo.model;

import elearning.demo.entity.Course;
import elearning.demo.entity.Section;
import elearning.demo.entity.Video;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CourseDetailDto implements Serializable {

    private String course_id;
    private String description;
    private String image_url;
    private String course_name;

    private List<SectionDto> sectionList;

    public CourseDetailDto() {
        sectionList = new ArrayList<>();
    }

    public CourseDetailDto(String course_id, String description, String image_url, String course_name, List<SectionDto> sectionList, List<VideoDto> videoList) {
        this.sectionList = sectionList;
    }


    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public List<SectionDto> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<SectionDto> sectionList) {
        this.sectionList = sectionList;
    }

    public void setCourseDtoFromCourse(Course course){
        setCourse_id(course.getId());
        setCourse_name(course.getCourseName());
        setDescription(course.getDescription());
        setImage_url(course.getImageUrl());
    }

    public void addAllSection(List<Section> sections){
        for (Section section:sections) {
            SectionDto sectionDto = new SectionDto(section.getId(),section.getSectionName());
            sectionList.add(sectionDto);
        }
    }

//    public void addAllVideo(List<Video> videos){
//        for (Video video:videos) {
//            VideoDto videoDto = new VideoDto(video.getId(),video.getVideoUrl(),
//                    video.getSection().getId(),video.getDescription(),video.getVideoName());
//            videoList.add(videoDto);
//        }
//    }



}
