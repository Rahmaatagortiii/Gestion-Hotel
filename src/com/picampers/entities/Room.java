/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.picampers.entities;

/**
 *
 * @author Arij
 */
public class Room {
    private int id;
    private int Number;
    private int Etage;
    private int NbLit;
    private String Price;
    private String Emplacement;
    private String Description;
    private String type;
    private Boolean disponibilite;
    private String image;

    public Room(int id, int Number,int Etage,int NbLit, String Price, String Emplacement, String Description, String type, Boolean disponibilite,String image) {
        this.id = id;
        this.Number = Number;
        this.Etage = Etage;
        this.NbLit = NbLit;
        this.Price = Price;
        this.Emplacement = Emplacement;
        this.Description = Description;
        this.type = type;
        this.disponibilite = disponibilite;
        this.image = image;
    }

    public Room() {
 }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public int getEtage() {
        return Number;
    }

    public void setEtage(int Etage) {
        this.Etage = Etage;
    }

    public int getNbLit() {
        return NbLit;
    }

    public void setNbLit(int NbLit) {
        this.NbLit = NbLit;
    }
    
    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getEmplacement() {
        return Emplacement;
    }

    public void setEmplacement(String Emplacement) {
        this.Emplacement= Emplacement;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description= Description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(Boolean disponibilite) {
        this.disponibilite = disponibilite;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
