package com.alpha.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Participant.TABLE_NAME)
public class Participant extends Model {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "participants";

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
