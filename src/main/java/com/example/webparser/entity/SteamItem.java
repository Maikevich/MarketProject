package com.example.webparser.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Setter
@RequiredArgsConstructor
@Table(name = "steamItem")
public class SteamItem {
    @Id
    private Long id;
    private String name;
    private String condition;
    private double price;
    private String url;

    public SteamItem(String name, String condition, String url, Double price) {
        this.name = name;
        this.condition = condition;
        this.url = url;
        this.price = price;
    }
    @Override
    public String toString() {
        return "\n" + name + " " + condition + " price = " + price + "\n" + url + "\n";
    }
}
