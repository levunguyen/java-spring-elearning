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

//    private String courseId;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private String sectionName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    // Lỗi
//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("courseId")
//    private Course course;

    @OneToMany(
            mappedBy = "section",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Video> listVideo = new ArrayList<>();

    public Section() {}

    public Section(String id, Course course, String sectionName, Date createdAt, Date updatedAt, List<Video> listVideo) {
        this.id = id;
        this.course = course;
        this.sectionName = sectionName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.listVideo = listVideo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Video> getListVideo() {
        return listVideo;
    }

    public void setListVideo(List<Video> listVideo) {
        this.listVideo = listVideo;
    }
}