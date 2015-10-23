package com.alpha.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = ParticipantListing.TABLE_NAME)
public class ParticipantListing implements IModel{

    public static final String TABLE_NAME = "participant_listings";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CREATED_AT = "created_at";
    public static final String COLUMN_UPDATED_AT = "updated_at";
    public static final String COLUMN_PARTICIPANT_ID = "participant_id";
    public static final String COLUMN_PARTICIPANT_LIST_ID = "participant_list_id";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ParticipantListing.COLUMN_ID)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = ParticipantListing.COLUMN_CREATED_AT, nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = ParticipantListing.COLUMN_UPDATED_AT, nullable = false)
    private Date updatedAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = ParticipantListing.COLUMN_PARTICIPANT_ID, nullable = false)
    private Participant participant;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = ParticipantListing.COLUMN_PARTICIPANT_LIST_ID, nullable = false)
    private ParticipantList participantList;

    public ParticipantListing(Participant participant, ParticipantList participantList) {
        this.participant = participant;
        this.participantList = participantList;
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

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public ParticipantList getParticipantList() {
        return participantList;
    }

    public void setParticipantList(ParticipantList participantList) {
        this.participantList = participantList;
    }
}
