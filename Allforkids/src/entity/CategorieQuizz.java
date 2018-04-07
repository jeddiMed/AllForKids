/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ElWess
 */

public class CategorieQuizz
{

    private int id;
    private String libelle;

    public CategorieQuizz(int id, String libelle)
    {
        this.id = id;
        this.libelle = libelle;
    }

    public CategorieQuizz(String libelle)
    {
        this.libelle = libelle;
    }

    public int getId()
    {
        return id;
    }

    public String getLibelle()
    {
        return libelle;
    }

    public void setLibelle(String libelle)
    {
        this.libelle = libelle;
    }

    public String toString()
    {
        return libelle;
    }
}
