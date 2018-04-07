/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ElWess
 */
public class CategorieFilm {
    private int id;
    private String libelle;
    private ArrayList<Film> listFilms;

    public CategorieFilm(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    
    
    
    public CategorieFilm(String libelle) {
        this.libelle = libelle;
        this.listFilms = new ArrayList<Film>();
    }
        

    public int getId() {
        return id;
    }
    
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return libelle;
    }
    
    
}
