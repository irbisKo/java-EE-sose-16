package com.alpha.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by arturschens on 10.10.15.
 */
@Entity
@Table(name = Token.TABLE_NAME)
public class Token implements IModel {

    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "tokens";
    public static final String FIELD_NAME = "token";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TOKEN = "token";
    public static final String COLUMN_CREATED_AT = "created_at";
    public static final String COLUMN_UPDATED_AT = "updated_at";
    public static final String COLUMN_POLL_ID = "poll_id";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = Token.COLUMN_ID)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = Token.COLUMN_CREATED_AT, nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = Token.COLUMN_UPDATED_AT, nullable = false)
    private Date updatedAt;

    @Column(name = Token.COLUMN_TOKEN, unique = true, nullable = false)
    private String token;

    @ManyToOne
    @JoinColumn(name = Token.COLUMN_POLL_ID)
    private Poll poll;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
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
