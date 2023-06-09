package org.example.Domain.Items;

import jakarta.persistence.*;
import org.example.Domain.BasicEntity;
import org.example.Domain.Category.Category_Item;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) //상속관계(조인 전략)
@DiscriminatorColumn
public abstract class Item extends BasicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @OneToMany(mappedBy = "item")
    private List<Category_Item> category_items = new ArrayList<Category_Item>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public List<Category_Item> getCategory_items() {
        return category_items;
    }

    public void setCategory_items(List<Category_Item> category_items) {
        this.category_items = category_items;
    }
}
