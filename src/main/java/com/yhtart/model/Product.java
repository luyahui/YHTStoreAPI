package com.yhtart.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String num;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private ProductType type;

    @ManyToOne
    @JoinColumn(name = "engraving_id")
    private Engraving engraving;

    @ManyToOne
    @JoinColumn(name = "collection_id")
    private Collection collection;

    @Column
    private int capacity;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String imgUrl;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String detailImgUrls;

    @Column(nullable = false)
    private Date date;

    @Column
    private int clicks;

    @Column
    private boolean sold;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDetailImgUrls() {
        return detailImgUrls;
    }

    public void setDetailImgUrls(String detailImgUrls) {
        this.detailImgUrls = detailImgUrls;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public Engraving getEngraving() {
        return engraving;
    }

    public void setEngraving(Engraving engraving) {
        this.engraving = engraving;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }
}
