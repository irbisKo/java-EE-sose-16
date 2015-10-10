package com.alpha.models;

import javax.persistence.*;

@Entity
@Table(name = ParticipantList.TABLE_NAME)
public class ParticipantList extends Model {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME = "participant_lists";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_USER_ID = "user_id";

    @Column(name = ParticipantList.COLUMN_NAME, nullable = false)
    private String name;

    @Column(name = ParticipantList.COLUMN_USER_ID, nullable = false)
    private Long user_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
