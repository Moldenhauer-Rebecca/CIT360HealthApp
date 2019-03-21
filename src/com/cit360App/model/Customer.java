package com.cit360App.model;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="cust_age")
    private int cust_age;

    @Column(name="cust_gender")
    private String cust_gender;

    @Column(name="cust_weight")
    private int cust_weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getCust_age() {
        return cust_age;
    }

    public void setCust_age(int cust_age) {
        this.cust_age = cust_age;
    }

    public String getCust_gender() {
        return cust_gender;
    }

    public void setCust_gender(String cust_gender) {
        this.cust_gender = cust_gender;
    }

    public int getCust_weight() {
        return cust_weight;
    }

    public void setCust_weight(int cust_weight) {
        this.cust_weight = cust_weight;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", cust_age=" + cust_age +
                ", cust_gender='" + cust_gender + '\'' +
                ", cust_weight=" + cust_weight +
                '}';
    }
}
