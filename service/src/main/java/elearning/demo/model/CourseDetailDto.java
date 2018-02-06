package elearning.demo.model;

import elearning.demo.entity.Section;
import elearning.demo.entity.Video;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CourseDetailDto implements Serializable {

    private String course_id;
    private String course_name;
    private String description;
    private String image_url;

    private List<SectionDto> sectionList;

    private List<VideoDto> videoList;

    public CourseDetailDto() {
        sectionList = new ArrayList<>();
        videoList = new ArrayList<>();
    }

    public CourseDetailDto(String course_id, String description, String image_url, String course_name, List<SectionDto> sectionList, List<VideoDto> videoList) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.description = description;
        this.image_url = image_url;
        this.sectionList = sectionList;
        this.videoList = videoList;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
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


}
