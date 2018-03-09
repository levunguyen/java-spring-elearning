package elearning.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name="role_name")
    private String roleName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at")
    private Date updateAt;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserRole> userRoles = new ArrayList<>();

    public Role() {
    }

    public Role(String id, String roleName, Date createdAt, Date updateAt, List<UserRole> userRoles) {
        this.id = id;
        this.roleName = roleName;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.userRoles = userRoles;
    }

    public String getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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


    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
