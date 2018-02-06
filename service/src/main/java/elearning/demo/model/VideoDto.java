package elearning.demo.model;

import java.io.Serializable;

public class VideoDto implements Serializable{
    private String id;
    private String video_url;
    private String section_id;
    private String video_name;
    private String description;

    public VideoDto() {
    }

    public VideoDto(String id, String video_url, String section_id, String description,
                    String video_name ) {
        this.id = id;
        this.video_url = video_url;
        this.section_id = section_id;
        this.description = description;
        this.video_name=video_name;

    }

    public String getVideo_name() {
        return video_name;
    }

    public void setVideo_name(String video_name) {
        this.video_name = video_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getSection_id() {
        return section_id;
    }

    public void setSection_id(String section_id) {
        this.section_id = section_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
