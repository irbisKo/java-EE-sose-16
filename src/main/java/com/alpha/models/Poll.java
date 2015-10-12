package com.alpha.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = Poll.TABLE_NAME)
public class Poll implements IModel {
    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME = "polls";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CREATED_AT = "created_at";
    public static final String COLUMN_UPDATED_AT = "updated_at";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_END_AT = "end_at";
    public static final String COLUMN_START_AT = "start_at";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = Poll.COLUMN_ID)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = Poll.COLUMN_CREATED_AT, nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = Poll.COLUMN_UPDATED_AT, nullable = false)
    private Date updatedAt;

    @Column(name = Poll.COLUMN_TITLE, unique = true, nullable = false)
    private String title;

    @Column(name = Poll.COLUMN_DESCRIPTION, unique = true, nullable = false)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = Poll.COLUMN_START_AT, nullable = false)
    private Date startAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = Poll.COLUMN_END_AT, nullable = false)
    private Date endAt;

    @OneToMany(mappedBy = Item.FIELD_POLL, fetch = FetchType.LAZY)
    private List<Item> items;

    @OneToMany(mappedBy = Token.FIELD_NAME, fetch = FetchType.LAZY)
    private List<Token> tokens;

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {

    }
}
