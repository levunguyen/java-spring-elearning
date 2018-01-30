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
    @MapsId("courseId")
    private String courseId;

    @ManyToOne(targetEntity=Hashtag.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @MapsId("hashtagId")
    private String hashtagId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public HashtagCourse() {
    }

    public HashtagCourse(String id, String courseId, String hashtagId, Date createdAt, Date updatedAt) {
        this.id = id;
        this.courseId = courseId;
        this.hashtagId = hashtagId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getHashtagId() {
        return hashtagId;
    }

    public void setHashtagId(String hashtagId) {
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
