package elearning.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Hashtag implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    private String id= UUID.randomUUID().toString();

    private String hashtagName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @OneToMany(
            mappedBy = "hashtag",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            targetEntity = HashtagCourse.class,
            fetch = FetchType.EAGER
    )
    private List<HashtagCourse> listCourses = new ArrayList<>();

    public Hashtag() {
    }

    public Hashtag(String id, String hashtagName, Date createAt, Date updatedAt) {
        this.id = id;
        this.hashtagName = hashtagName;
        this.createAt = createAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public String getHashtagName() {
        return hashtagName;
    }

    public void setHashtagName(String hashtagName) {
        this.hashtagName = hashtagName;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
