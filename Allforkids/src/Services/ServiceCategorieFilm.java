/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import connexion.DataSource;
import entity.CategorieFilm;
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
 * @author ElWess
 */
public class ServiceCategorieFilm {
    Connection con;
    Statement statement;
    ResultSet rs;
    CategorieFilm cat;

    public ServiceCategorieFilm() {
        con = (Connection) DataSource.getInstance().getConnection();
    }
    
    public void insertCategorie(CategorieFilm cat){
        String req = "INSERT INTO `categoriefilm`("
                + "`libelle`)"
                + " VALUES (?)";
        PreparedStatement ste;
        try {
            ste = con.prepareStatement(req);
            ste.setString(1, cat.getLibelle());
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Services.ServiceFilm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List<CategorieFilm> showCategorie(){
    String req = "select * from categoriefilm";
    List<CategorieFilm> liste = new ArrayList<>();
        try {
            statement = con.createStatement();
            rs = statement.executeQuery(req);
            while(rs.next()){
                CategorieFilm c = new CategorieFilm(rs.getInt(1),rs.getString(2));
                liste.add(c);
            }
    
        } catch (SQLException ex) {
            Logger.getLogger(Services.ServiceFilm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste;
    }
    
    public CategorieFilm findCatById(int id){
        String req = "select * FROM `categoriefilm` WHERE `id` ="+id;
        List<CategorieFilm> liste = new ArrayList<>();
        try {

            statement = con.createStatement();
            rs = statement.executeQuery(req);
            while(rs.next()){
                CategorieFilm c = new CategorieFilm(rs.getInt(1),rs.getString(2));
                liste.add(c);
            }
            //ste.setInt(1, id);
            cat = (CategorieFilm) liste.get(0);
        } catch (SQLException ex) {
            Logger.getLogger(Services.ServiceFilm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    public void updateCategory (CategorieFilm catOld,CategorieFilm catNew){
        String req = "UPDATE `categoriefilm` SET "
                + "`libelle`=? WHERE `id`=?";
        try {
            PreparedStatement ste = con.prepareStatement(req);
            ste.setString(1, catNew.getLibelle());
            ste.setInt(2, catOld.getId());
            ste.executeUpdate();
    }   catch (SQLException ex) {
            Logger.getLogger(ServiceCategorieFilm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteCategory(CategorieFilm cat){
        String req = "DELETE FROM `categoriefilm` WHERE `id`=?";
        try {
            PreparedStatement ste = con.prepareStatement(req);
            ste.setInt(1, cat.getId());
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategorieFilm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
}
