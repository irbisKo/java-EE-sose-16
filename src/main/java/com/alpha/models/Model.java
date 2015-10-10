package com.alpha.models;

import javax.persistence.*;
import java.util.Date;

public abstract class Model implements IModel {

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CREATED_AT = "created_at";
    public static final String COLUMN_UPDATED_AT = "updated_at";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = Model.COLUMN_ID)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = Model.COLUMN_CREATED_AT, nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = Model.COLUMN_UPDATED_AT, nullable = false)
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
