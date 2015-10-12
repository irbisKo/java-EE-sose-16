package com.alpha.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = UserRole.TABLE_NAME)
public class UserRole implements IModel{

    private static final long serialVersionUID = 1L;

    public static final String FIELD_USER = "user";
    public static final String FIELD_ROLE = "role";
    public static final String TABLE_NAME = "user_role";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CREATED_AT = "created_at";
    public static final String COLUMN_UPDATED_AT = "updated_at";
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_ROLE_ID = "role_id";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = UserRole.COLUMN_ID)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = UserRole.COLUMN_CREATED_AT, nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = UserRole.COLUMN_UPDATED_AT, nullable = false)
    private Date updatedAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = UserRole.COLUMN_USER_ID, nullable = false)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = UserRole.COLUMN_ROLE_ID, nullable = false)
    private Role role;

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    public UserRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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
}
