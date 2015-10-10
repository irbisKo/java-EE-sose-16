package com.alpha.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = User.TABLE_NAME)
public class User implements IModel {
    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME = "users";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD_ENCRYPTED = "password_encrypted";
    public static final String COLUMN_CREATED_AT = "created_at";
    public static final String COLUMN_UPDATED_AT = "updated_at";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = User.COLUMN_ID)
    private Long id;

    @Column(name = User.COLUMN_EMAIL, unique = true, nullable = false)
    private String email;

    @Column(name = User.COLUMN_PASSWORD_ENCRYPTED, unique = true, nullable = false)
    private String passwordEncrypted;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = User.COLUMN_CREATED_AT, nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = User.COLUMN_UPDATED_AT, nullable = false)
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordEncrypted() {
        return passwordEncrypted;
    }

    public void setPasswordEncrypted(String passwordEncrypted) {
        this.passwordEncrypted = passwordEncrypted;
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
}
