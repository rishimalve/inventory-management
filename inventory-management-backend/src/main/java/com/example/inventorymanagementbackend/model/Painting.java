package com.example.inventorymanagementbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "paintings")
public class Painting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Name;
    private Double Price;
    private String Type;
    private String Medium;
    private String Dimensions;
    private String ImgPath;

    public String toString() {
        return "painting(name=" + this.Name + ", Price=" + this.Price + ", Type=" + this.Type + ", Medium="
                + this.Medium + ", Dimensions=" + this.Dimensions + ", ImgPath=" + this.ImgPath + ")";
    }
}
