package elearning.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Hashtag implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    private String id= UUID.randomUUID().toString();

    @Column(name="hashtag_name")
    private String hashtagName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    private Date createAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at")
    private Date updatedAt;

    @OneToMany(mappedBy="hashtag",cascade= CascadeType.ALL,orphanRemoval=true)
    private List<HashtagCourse> listCourses;

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
