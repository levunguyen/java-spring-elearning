package elearning.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity(name = "UserRole")
@Table
public class UserRole implements Serializable {
    private static final long serialVersionUID = 1L;
    /*@EmbeddedId
    private UserRoleId id;*/
    @Id
    private String id = UUID.randomUUID().toString();
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("roleId")
    private Role role;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    public UserRole() {
    }

    public UserRole(String id, Role role, User user, Date createdAt, Date updateAt) {
        this.id = id;
        this.role = role;
        this.user = user;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public String getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}