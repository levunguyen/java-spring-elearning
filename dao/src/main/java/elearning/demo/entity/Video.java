package elearning.demo.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Video implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id = UUID.randomUUID().toString();

//    private String sectionId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "section_id")
    @JsonIgnore //bỏ qua lỗi parse json(gọi qua gọi lại) mà tham chiếu 2 chiều của entity(video và section)
    private Section section;

    private String videoName;

    private String description;

    private String videoUrl;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    // Sai như bên Comment entity
//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("sectionId")
//    private Section section;

    // One to many phải map tới 1 list
//    @OneToMany(
//            mappedBy = "video",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    private Comment comment;

    @OneToMany(mappedBy = "video", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    public Video() {}

    public Video(String id, Section section, String videoName, String description, String videoUrl, Date createdAt, Date updatedAt, List<Comment> comments) {
        this.id = id;
        this.section = section;
        this.videoName = videoName;
        this.description = description;
        this.videoUrl = videoUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.comments = comments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}