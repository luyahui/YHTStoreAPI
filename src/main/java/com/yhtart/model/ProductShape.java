package com.yhtart.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProductShape {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String shape;

    @OneToMany(mappedBy = "shape", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProductType> list = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public List<ProductType> getList() {
        return list;
    }

    public void setList(List<ProductType> list) {
        this.list = list;
    }
}
