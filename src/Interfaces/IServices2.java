/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import entities.Produits;
import java.util.List;

/**
 *
 * @author mohamed
 */
public interface IServices2 {
    public void add(Produits produits);
    public void remove(Produits produits);
    public void update(Produits produits, int id);
    public List<Produits> getAll();
    
}
