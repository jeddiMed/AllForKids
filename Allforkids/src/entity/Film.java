/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import Services.ServiceCategorieFilm;
import Services.ServiceFilm;
import entity.CategorieFilm;
import javafx.scene.control.Button;


/**
 *
 * @author ElWess
 */
public class Film {
    private int id;
    private String titre;
    private Integer duree;
    private String description;
    private Button deleteButton;
    private ServiceFilm sv;
    private CategorieFilm categorie;

    public Film(int id, String titre, int duree, Integer idCat, String description) {
        ServiceCategorieFilm svCat = new ServiceCategorieFilm();
        CategorieFilm cat = svCat.findCatById(idCat);
        this.id = id;
        this.titre = titre;
        this.duree = duree;
        this.categorie = cat;
        this.description = description;
        this.deleteButton = new Button ("Delete");
        this.sv = new ServiceFilm();
    }    
    
    public Film(String titre, int duree, String description) {
        this.titre = titre;
        this.duree = duree;
        this.description = description;
    }
    
    public Film(String titre, int duree,Integer idCat , String description) {    
        ServiceCategorieFilm svCat = new ServiceCategorieFilm();
        CategorieFilm cat = svCat.findCatById(idCat);
        this.titre = titre;
        this.duree = duree;
        this.categorie = cat;
        this.description = description;
        
    }        
    

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(Button deleteButton) {
        this.deleteButton = deleteButton;
    }

    public CategorieFilm getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieFilm categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Film{" + "id=" + id + ", titre=" + titre + ", duree=" + duree + ", description=" + description + ", categorie=" + categorie + '}';
    }

    
    
    
}
