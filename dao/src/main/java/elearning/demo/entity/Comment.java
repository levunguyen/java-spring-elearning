package elearning.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id = UUID.randomUUID().toString();

//    private String videoId;
//
//    private String userId;

    // Fix lại như thế này
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "video_id")
    private Video video;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name="content")
    private String content;

    @Column(name="root_comment")
    private String rootComment;

    @Temporal(TemporalType.DATE)
    @Column(name="created_at")
    private Date createdAt;

    @Temporal(TemporalType.DATE)
    @Column(name="updated_at")
    private Date updatedAt;

    // Chổ này map sai
//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("videoId")
//    private Video video;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("userId")
//    private User user;

    public Comment() {}

    public Comment(String id, Video video, User user, String content, String rootComment, Date createdAt, Date updatedAt) {
        this.id = id;
        this.video = video;
        this.user = user;
        this.content = content;
        this.rootComment = rootComment;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRootComment() {
        return rootComment;
    }

    public void setRootComment(String rootComment) {
        this.rootComment = rootComment;
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