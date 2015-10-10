package com.alpha.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by arturschens on 10.10.15.
 */

@Entity
@Table(name = UserRoles.TABLE_NAME)
public class UserRoles implements IModel {

    public static final String TABLE_NAME = "user_roles";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CREATED_AT = "created_at";
    public static final String COLUMN_UPDATED_AT = "updated_at";
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_ROLE_ID = "role_id";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = UserRoles.COLUMN_ID)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = UserRoles.COLUMN_CREATED_AT, nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = UserRoles.COLUMN_UPDATED_AT, nullable = false)
    private Date updatedAt;


    @ManyToOne
    @JoinColumn(name = UserRoles.COLUMN_USER_ID, nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = UserRoles.COLUMN_ROLE_ID, nullable = false)
    private Role role;

    public UserRoles(User user, Role role) {
        this.user = user;
        this.role = role;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
