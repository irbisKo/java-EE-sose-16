package com.alpha.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = User.TABLE_NAME)
public class User implements IModel {
    private static final long serialVersionUID = 1L;

    public static final String FIELD_POLLS = "polls";
    public static final String FIELD_ROLES = "roles";
    public static final String TABLE_NAME = "users";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD_ENCRYPTED = "password_encrypted";
    public static final String COLUMN_CREATED_AT = "created_at";
    public static final String COLUMN_UPDATED_AT = "updated_at";
    public static final String COLUMN_SALT = "salt";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = User.COLUMN_ID)
    private Long id;

    @Column(name = User.COLUMN_EMAIL, unique = true, nullable = false)
    private String email;

    @Column(name = User.COLUMN_PASSWORD_ENCRYPTED, nullable = false)
    private String passwordEncrypted;

    @Column(name = User.COLUMN_SALT, nullable = false)
    private String salt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = User.COLUMN_CREATED_AT, nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = User.COLUMN_UPDATED_AT, nullable = false)
    private Date updatedAt;

    @OneToMany(mappedBy = ParticipantList.FIELD_USER, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ParticipantList> participantLists;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = UserRole.TABLE_NAME,
            joinColumns =
            @JoinColumn(name = UserRole.COLUMN_USER_ID),
            inverseJoinColumns =
            @JoinColumn(name = UserRole.COLUMN_ROLE_ID))
    private Set<Role> roles;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = UserPollListing.TABLE_NAME,
            joinColumns =
            @JoinColumn(name = UserPollListing.COLUMN_USER_ID),
            inverseJoinColumns =
            @JoinColumn(name = UserPollListing.COLUMN_POLL_ID))
    private Set<Poll> polls;

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

    public String getSalt() {
        return salt;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public ArrayList<Role> getRolesArray() {
        return new ArrayList<Role>(getRoles());
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public void setSalt(String salt) {
        this.salt = salt;
    }

    public List<ParticipantList> getParticipantLists() {
        return participantLists;
    }

    public void setParticipantLists(List<ParticipantList> participantLists) {
        this.participantLists = participantLists;
    }
}
