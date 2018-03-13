/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Interfaces.IServices2;
import Technique.DataSource;
import entities.Produits;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mohamed
 */
public class ProduitsServices implements IServices2{
    
    Connection conn;
    Statement statement;
    ResultSet rs;
    
    public ProduitsServices(){
        conn= DataSource.getInstance().getConnection();
    }

    @Override
    public void add(Produits produits) {
       String req="INSERT INTO `produit`(`libelle`, `prix`, `description`"
               + ", `gender`, `Age`, `path`, `quantite`) "
               + "VALUES (?,?,?"
               +",?,?,?,?)";
        try {
            PreparedStatement ste=conn.prepareStatement(req);
            ste.setString(1, produits.getLibelle());
            ste.setString(2, produits.getPrix());
            ste.setString(3, produits.getDescription());
            ste.setString(4, produits.getGender());
            ste.setInt(5, produits.getAge());
            ste.setString(6, produits.getPath());
            ste.setInt(7, produits.getQuantite());
            ste.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProduitsServices.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @Override
    public void remove(Produits produits) {
        String req="DELETE FROM `produit` WHERE id=?";
        try {
            PreparedStatement ste=conn.prepareStatement(req);
            ste.setInt(1, produits.getId());
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitsServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Produits produits, int id) {
        String req="UPDATE `produit` SET `libelle`=?,`prix`=?,"
                + "`description`=?,`gender`=?,`Age`=?,"
                + "`path`=?,`quantite`=? WHERE id=?";
        try {
            PreparedStatement ste=conn.prepareStatement(req);
            ste.setString(1, produits.getLibelle());
            ste.setString(2, produits.getPrix());
            ste.setString(3, produits.getDescription());
            ste.setString(4, produits.getGender());
            ste.setInt(5, produits.getAge());
            ste.setString(6, produits.getPath());
            ste.setInt(7, produits.getQuantite());
            ste.setInt(8, id);
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitsServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<Produits> getAll() {
        String req="SELECT * FROM `produit`";
        List<Produits> liste=new ArrayList<>();
        
        try {
            statement=conn.createStatement();
            rs=statement.executeQuery(req);
            while(rs.next()){
                Produits p= new Produits(rs.getInt("id"), rs.getString("libelle"), rs.getString("prix"),
                        rs.getString("description"), rs.getString("gender"), rs.getInt("age"), rs.getString("path"),
                        rs.getInt("quantite"));
                liste.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitsServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return liste;
        
        
    }
    
}
