package com.nti.testTask.clientManager.models;

import javax.persistence.*;

@Entity
@Table(name = "planet")
public class Planet {

    @Id
    @Column(name = "id_planet")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_lord")
    private Lord lord;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Lord getLord() {
        return lord;
    }

    public void setLord(Lord lord) {
        this.lord = lord;
    }

    public Planet(long id, String title, Lord lord) {
        this.id = id;
        this.title = title;
        this.lord = lord;
    }

    public Planet() {
    }
}
