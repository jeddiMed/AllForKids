/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;

/**
 *
 * @author mohamed
 */
public class Produits {
    
    private int id;
    private String libelle;
    private String prix;
    private String description;
    private String gender;
    private int age;
    private String path;
    private int quantite;
    private List<Categories> type;

    public Produits(int id) {
        this.id = id;
    }

    public Produits(int id, String libelle, String prix, String description, String gender, int age, String path, int quantite, List<Categories> type) {
        this.id = id;
        this.libelle = libelle;
        this.prix = prix;
        this.description = description;
        this.gender = gender;
        this.age = age;
        this.path = path;
        this.quantite = quantite;
        this.type = type;
    }

    

    public Produits(int id, String libelle, String prix, String description, String gender, int age, String path, int quantite) {
        this.id = id;
        this.libelle = libelle;
        this.prix = prix;
        this.description = description;
        this.gender = gender;
        this.age = age;
        this.path = path;
        this.quantite = quantite;
    }

 

    public Produits(String libelle, String prix, String description, String gender, int age, int quantite) {
        this.libelle = libelle;
        this.prix = prix;
        this.description = description;
        this.gender = gender;
        this.age = age;
        this.quantite = quantite;
    }

   
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Categories> getType() {
        return type;
    }

    public void setType(List<Categories> type) {
        this.type = type;
    }

   

  
    
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Produits{" + "id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", description=" + description + ", gender=" + gender + ", age=" + age + ", quantite=" + quantite + ", path=" + path + '}';
    }
    
    

   
    
    
}
