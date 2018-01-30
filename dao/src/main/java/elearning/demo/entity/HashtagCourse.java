package elearning.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
public class HashtagCourse implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    private String id= UUID.randomUUID().toString();

    @ManyToOne(targetEntity=Course.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course courseId;

    @ManyToOne(targetEntity=Hashtag.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name = "hashtag_id")
    private Hashtag hashtagId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public HashtagCourse() {
    }

    public HashtagCourse(String id, Course courseId, Hashtag hashtagId, Date createdAt, Date updatedAt) {
        this.id = id;
        this.courseId = courseId;
        this.hashtagId = hashtagId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public Hashtag getHashtagId() {
        return hashtagId;
    }

    public void setHashtagId(Hashtag hashtagId) {
        this.hashtagId = hashtagId;
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
}
