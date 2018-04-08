/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import Services.*;
import entity.*;
import javafx.scene.control.Button;


/**
 *
 * @author ElWess
 */
public class Film {
    private int id;
    private String titre;
    private Integer duree;
    private Integer minute;
    private String description;
    private String code_integ;
    private Button deleteButton;
    private ServiceFilm sv;
    private CategorieFilm categorie;
    private String path;

    public Film(int id, String titre, int duree,Integer minute, Integer idCat, String description,String url) {
        ServiceCategorieFilm svCat = new ServiceCategorieFilm();
        CategorieFilm cat = svCat.findCatById(idCat);
        this.id = id;
        this.titre = titre;
        this.duree = duree;
        this.minute = minute;
        this.categorie = cat;
        this.description = description;
        this.deleteButton = new Button ("Delete");
        this.sv = new ServiceFilm();
        this.code_integ = url;
        
    }    
    
    public Film(String titre, int duree,Integer minute, String description,String url) {
        this.titre = titre;
        this.minute = minute;
        this.duree = duree;
        this.description = description;
        this.code_integ = url;
    }
    
    public Film(String titre, int duree, Integer idCat, Integer minute , String description, String url) {    
        ServiceCategorieFilm svCat = new ServiceCategorieFilm();
        CategorieFilm cat = svCat.findCatById(idCat);
        this.titre = titre;
        this.minute = minute;
        this.duree = duree;
        this.categorie = cat;
        this.description = description;
        this.code_integ = url;
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

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
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

    public String getCode_integ() {
        return code_integ;
    }

    public void setCode_integ(String code_integ) {
        this.code_integ = code_integ;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    
 
    @Override
    public String toString() {
        return "Film{" + "id=" + id + ", titre=" + titre + ", duree=" + duree + ", description=" + description + ", categorie=" + categorie + '}';
    }

    
    
    
}
