/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Interfaces.IServices;
import Technique.DataSource;
import entities.Categories;
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
public class CategoriesServices implements IServices{
    
    Connection conn;
    Statement statement;
    ResultSet rs;
    
    public CategoriesServices(){
        conn= DataSource.getInstance().getConnection();
    }

    @Override
    public void add(Categories categories) {
        String req="INSERT INTO `categorie`(`libelle`) VALUES (?)";
        try {
            PreparedStatement ste=conn.prepareStatement(req);
            ste.setString(1, categories.getLibelle());
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriesServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remove(Categories categories) {
        String req="DELETE FROM `categorie` WHERE id=?";
        try {
            PreparedStatement ste=conn.prepareStatement(req);
            ste.setInt(1, categories.getId());
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriesServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void update(Categories categories, int id) {
        String req="UPDATE `categorie` SET `libelle`=? WHERE id=?";
        try {
            PreparedStatement ste=conn.prepareStatement(req);
            ste.setString(1, categories.getLibelle());
            ste.setInt(2, id);
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriesServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Categories> getAll() {
        String req="select * from categorie";
            List<Categories> liste = new ArrayList<>();
            
        try {
            statement=conn.createStatement();
            rs=statement.executeQuery(req);
            while(rs.next()){
                Categories c=new Categories(rs.getInt(1), rs.getString(2));
                liste.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriesServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return liste;
        
    }
    
}
