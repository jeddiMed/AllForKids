/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids;

import Services.CategoriesServices;
import Services.ProduitsServices;
import Technique.DataSource;
import entities.Categories;
import entities.Produits;
import java.sql.Connection;

/**
 *
 * @author mohamed
 */
public class AllForKids {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataSource ds= DataSource.getInstance();
        Connection connexion=ds.getConnection();
        
        //CATEGORIES
        /*
        Categories c1=new Categories(7);
        Categories c2= new Categories("test");
        CategoriesServices cs=new CategoriesServices();
        
        //cs.add(c2);
        //cs.remove(c1);
        //cs.update(new Categories("test3"), 9);   
        cs.getAll().forEach(System.out::println);
        */
        
        //PRODUITS
        
       
        Produits p=new Produits(12);
        Produits p1=new Produits("tttt", "60", "ihihih", "masculin", 10, 60);
        ProduitsServices ps=new ProduitsServices();
        //ps.add(p1);
        //ps.add(p2);
        //ps.remove(p);
        //ps.update(new Produits("med", "100", "mmmmm", "masculin", 10, 30), 16);
        ps.getAll().forEach(System.out::println);
        
        
    }
    
}
