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
@Table(name = "csgoitem")
public class CSGOItem {

    @Id
    private Long id;
    private String name;
    private String condition;
    private double price;
    private String url;

    @Override
    public String toString() {
        return "\n" + name + " " + condition + " price = " + price + "\n" + url + "\n";
    }
}
