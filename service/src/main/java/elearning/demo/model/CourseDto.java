package elearning.demo.model;

import java.io.Serializable;

public class CourseDto implements Serializable{
    private String course_id;
    private String description;
    private String image_url;
    private String course_name;

    public CourseDto() {
    }

    public CourseDto(String course_id, String description, String image_url, String course_name) {
        this.course_id = course_id;
        this.description = description;
        this.image_url = image_url;
        this.course_name = course_name;
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
}
