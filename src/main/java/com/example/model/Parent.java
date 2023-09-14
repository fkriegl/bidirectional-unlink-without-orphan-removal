package com.example.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Parent {

    @Id
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Child> children = new ArrayList<>();

    public int unlinkOddChildren() {
        var oddChildren = getOddChildren();
        oddChildren.forEach(Child::unlink); // unlink all odd children
        return oddChildren.size();
    }

    public void notifyOnUnlink(Child child) {
        this.getChildren().remove(child);
    }

    public Collection<Child> getOddChildren() {
        final Collection<Child> oddChildren = new ArrayList<>(this.getChildren());
        oddChildren.removeAll(this.getChildren().stream()
                .filter(child -> child.getId() % 2 == 0)
                .toList());
        return oddChildren;
    }

    public Integer getId() {
        return id;
    }

    public Parent setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Parent setName(String name) {
        this.name = name;
        return this;
    }

    public List<Child> getChildren() {
        return children;
    }

    public Parent setChildren(List<Child> children) {
        this.children = children;
        return this;
    }
}
