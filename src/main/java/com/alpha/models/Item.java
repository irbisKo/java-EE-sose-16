package com.alpha.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = Item.TABLE_NAME)
public class Item implements  IModel{

    private static final long serialVersionUID = 1L;
    public static final String FIELD_POLL = "poll";
    public static final String TABLE_NAME = "items";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CREATED_AT = "created_at";
    public static final String COLUMN_UPDATED_AT = "updated_at";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_POLL_ID = "poll_id";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = Item.COLUMN_ID)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = Item.COLUMN_CREATED_AT, nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = Item.COLUMN_UPDATED_AT, nullable = false)
    private Date updatedAt;

    @Column(name = Item.COLUMN_NAME)
    private String name;

    @Column(name = Item.COLUMN_DESCRIPTION)
    private String description;

    @Column(name = Item.COLUMN_TYPE)
    private String type;

    @OneToMany(mappedBy = Option.FIELD_ITEM, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Option> options;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = Item.COLUMN_POLL_ID)
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

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }
}
