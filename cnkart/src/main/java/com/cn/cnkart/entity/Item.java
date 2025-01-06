package com.cn.cnkart.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    private ItemDetails itemDetails;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<ItemReview> itemReview;

    @ManyToMany(mappedBy ="items")// mapping many to many
    @JsonIgnore //used for handling JSON serialization and deserialization in entity-relationship mappings
    private List<Order> orders;

    public List<ItemReview>getItemReview(){return itemReview;}
    public void setItemReview(List<ItemReview> itemReview){this.itemReview =itemReview;}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public ItemDetails getItemDetails() {return itemDetails;}
    public void setItemDetails(ItemDetails itemDetails) {this.itemDetails = itemDetails;}
    public List<Order> getOrders() {return orders;}
    public void setOrders(List<Order> orders) {this.orders = orders;}
}
