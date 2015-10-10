package com.alpha.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = Role.TABLE_NAME)
public class Role implements IModel {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME = "polls";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CREATED_AT = "created_at";
    public static final String COLUMN_UPDATED_AT = "updated_at";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = Role.COLUMN_ID)
    private Long id;

    @Column(name = Role.COLUMN_NAME, unique = true, nullable = false)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = Role.COLUMN_CREATED_AT, nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = Role.COLUMN_UPDATED_AT, nullable = false)
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
