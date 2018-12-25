package com.yhtart.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MaterialType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Material> list = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Material> getList() {
        return list;
    }

    public void setList(List<Material> list) {
        this.list = list;
    }
}
