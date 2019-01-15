package com.yhtart.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String designation;

    @Column
    private String name;

    @Column
    private String gender;

    @Column
    private Date birthday;

    @Column
    private String email;

    @Column
    private String qq;

    @Column
    private String wangwang;

    @Column
    private String idCard;

    @Column
    private String storeLevel;

    @Column
    private String receiptor;

    @Column
    private String cellphone;

    @Column
    private String telephone;

    @Column
    private String city;

    @Column
    private String address;

    @Column
    private String zipCode;

    @Column
    private String productUrl;

    @Column
    private Timestamp timestamp;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWangwang() {
        return wangwang;
    }

    public void setWangwang(String wangwang) {
        this.wangwang = wangwang;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getStoreLevel() {
        return storeLevel;
    }

    public void setStoreLevel(String storeLevel) {
        this.storeLevel = storeLevel;
    }

    public String getReceiptor() {
        return receiptor;
    }

    public void setReceiptor(String receiptor) {
        this.receiptor = receiptor;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
