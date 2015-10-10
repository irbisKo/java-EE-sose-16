package com.alpha.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = Participant.TABLE_NAME)
public class Participant implements IModel {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "participants";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CREATED_AT = "created_at";
    public static final String COLUMN_UPDATED_AT = "updated_at";
    public static final String COLUMN_EMAIL = "email";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = Participant.COLUMN_ID)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = Participant.COLUMN_CREATED_AT, nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = Participant.COLUMN_UPDATED_AT, nullable = false)
    private Date updatedAt;
    
    @Column(name = Participant.COLUMN_EMAIL, unique = true, nullable = false)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = ParticipantListing.TABLE_NAME,
            joinColumns =
            @JoinColumn(name = ParticipantListing.COLUMN_PARTICIPANT_ID),
            inverseJoinColumns =
            @JoinColumn(name = ParticipantListing.COLUMN_PARTICIPANT_LIST_ID))
    private List<ParticipantList> participantLists;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        this.updatedAt = updatedAt;
    }

    public List<ParticipantList> getParticipantLists() {
        return participantLists;
    }

    public void setParticipantLists(List<ParticipantList> participantLists) {
        this.participantLists = participantLists;
    }
}
