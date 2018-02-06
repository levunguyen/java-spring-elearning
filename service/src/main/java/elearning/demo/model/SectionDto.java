package elearning.demo.model;

import elearning.demo.entity.Video;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SectionDto implements Serializable{
    private String section_id;
    private String section_name;

    private List<VideoDto> list_video = new ArrayList<>();

    public SectionDto() {
    }

    public SectionDto(String section_id, String section_name) {
        this.section_id = section_id;
        this.section_name = section_name;
    }

    public SectionDto(String section_id, String section_name, List<VideoDto> list_video) {
        this.section_id = section_id;
        this.section_name = section_name;
        this.list_video = list_video;
    }

    public List<VideoDto> getList_video() {
        return list_video;
    }

    public void setList_video(List<VideoDto> list_video) {
        this.list_video = list_video;
    }

    public String getSection_id() {
        return section_id;
    }

    public void setSection_id(String section_id) {
        this.section_id = section_id;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public void addAllVideo(List<Video> videos){
        for (Video video:videos) {
            VideoDto videoDto = new VideoDto(video.getId(),video.getVideoUrl(),
                    video.getSection().getId(),video.getDescription(),video.getVideoName());
            list_video.add(videoDto);
        }
    }
}
