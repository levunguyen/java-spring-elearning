package elearning.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Section implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    private String id = UUID.randomUUID().toString();

    private String courseId;

    private String sectionName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("courseId")
    private Course course;

    @OneToMany(
            mappedBy = "section",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Video> listVideo = new ArrayList<>();

    public Section() {}

    public Section(String sectionId, String courseId, String sectionName, Date createdAt, Date updatedAt,
                   Course course, List<Video> listVideo) {
        this.id = sectionId;
        this.courseId = courseId;
        this.sectionName = sectionName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.course = course;
        this.listVideo = listVideo;
    }

    public String getSectionId() {
        return id;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Course getCourse() {
        return course;
    }

    public List<Video> getListVideo() {
        return listVideo;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setListVideo(List<Video> listVideo) {
        this.listVideo = listVideo;
    }

}