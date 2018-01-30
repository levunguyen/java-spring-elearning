package elearning.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id= UUID.randomUUID().toString();

    @ManyToOne(targetEntity = Course.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course courseId;

    @ManyToOne(targetEntity = User.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    private String feedbackContent;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Feedback() {
    }

    public Feedback(String id, Course courseId, User userId, String feedbackContent, Date createdAt, Date updatedAt) {
        this.id = id;
        this.courseId = courseId;
        this.userId = userId;
        this.feedbackContent = feedbackContent;
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
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
