package com.nti.testTask.clientManager.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lord")
public class Lord {

    @Id
    @Column(name = "id_lord")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "")
    private List<Planet> planets;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }

    public Lord(String name, int age, List<Planet> planets) {
        this.name = name;
        this.age = age;
        this.planets = planets;
    }

    public Lord() {
    }
}
