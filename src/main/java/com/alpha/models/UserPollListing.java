package com.alpha.models;

import javax.persistence.*;
import java.util.Date;

public class UserPollListing implements IModel {

    public static final String FIELD_USER = "user";
    public static final String FIELD_POLL = "poll";
    public static final String TABLE_NAME = "user_poll_listings";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CREATED_AT = "created_at";
    public static final String COLUMN_UPDATED_AT = "updated_at";
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_POLL_ID = "poll_id";

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
    @JoinColumn(name = UserPollListing.COLUMN_USER_ID, nullable = false)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = UserPollListing.COLUMN_POLL_ID, nullable = false)
    private Poll poll;

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

}
