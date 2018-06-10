package com.webapp.states.data.entity;

import javax.persistence.Id;

import javax.persistence.*;

@Entity
@Table(name="STATES")
public class State {
    @Id
    @Column(name="STATE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="STATE_CODE")
    private String code;

    @Column(name="STATE_NAME")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

