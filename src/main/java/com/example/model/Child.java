package com.example.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Child {

    @Id
    private Integer id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id", nullable = false)
    private Parent parent;

    public void unlink() {
        final var formerParent = getParent(); // Keep a backup reference to parent
        setParent(null);
        formerParent.notifyOnUnlink(this);
    }

    public Integer getId() {
        return id;
    }

    public Child setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Child setName(String name) {
        this.name = name;
        return this;
    }

    @JsonIgnore
    public Parent getParent() {
        return parent;
    }

    @JsonIgnore
    public Child setParent(Parent parent) {
        this.parent = parent;
        return this;
    }
}
