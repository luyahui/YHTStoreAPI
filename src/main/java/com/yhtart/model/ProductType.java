package com.yhtart.model;

import javax.persistence.*;

@Entity
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "shape_id")
    private ProductShape shape;

    @Column(nullable = false)
    private String type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProductShape getShape() {
        return shape;
    }

    public void setShape(ProductShape shape) {
        this.shape = shape;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
