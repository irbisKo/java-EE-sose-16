package com.alpha.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = Role.TABLE_NAME)
public class Role implements IModel {

    private static final long serialVersionUID = 1L;

    public static final String FIELD_USERS = "users";
    public static final String TABLE_NAME = "roles";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_ROLE_NAME = "role_name";
    public static final String COLUMN_CREATED_AT = "created_at";
    public static final String COLUMN_UPDATED_AT = "updated_at";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = Role.COLUMN_ID)
    private Long id;

    @Column(name = Role.COLUMN_ROLE_NAME, unique = true, nullable = false)
    private String roleName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = Role.COLUMN_CREATED_AT, nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = Role.COLUMN_UPDATED_AT, nullable = false)
    private Date updatedAt;


    @ManyToMany(fetch = FetchType.LAZY
    )
    @JoinTable(name = UserRole.TABLE_NAME,
            joinColumns =
            @JoinColumn(name = UserRole.COLUMN_ROLE_ID),
            inverseJoinColumns =
            @JoinColumn(name = UserRole.COLUMN_USER_ID))
    private Set<User> users;

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
