package elearning.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
public class Video implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id = UUID.randomUUID().toString();

    private String sectionId;

    private String videoName;

    private String description;

    private String videoUrl;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("sectionId")
    private Section section;

    @OneToMany(
            mappedBy = "video",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Comment comment;

    public Video() {}

    public Video(String id, String sectionId, String videoName, String description, String videoUrl, Date createdAt,
                 Date updatedAt, Section section, Comment comment) {
        this.id = id;
        this.sectionId = sectionId;
        this.videoName = videoName;
        this.description = description;
        this.videoUrl = videoUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.section = section;
        this.comment = comment;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public String getSectionId() {
        return sectionId;
    }

    public String getVideoName() {
        return videoName;
    }

    public String getDescription() {
        return description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Section getSection() {
        return section;
    }

    public Comment getComment() {
        return comment;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}