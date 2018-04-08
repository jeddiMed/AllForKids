/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import connexion.DataSource;
import entity.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package allforkids.Services:
//            ServiceQuizz

public class ServiceCategorieQuizz
{

    Connection con;
    Statement statement;
    ResultSet rs;
    CategorieQuizz cat;

    public ServiceCategorieQuizz()
    {
        con = DataSource.getInstance().getConnection();
    }

    public void insertCategorie(CategorieQuizz cat)
    {
        String req = "INSERT INTO `categoriequizz`(`libelle`) VALUES (?)";
        
        try {
            PreparedStatement ste = con.prepareStatement(req);
            ste.setString(1, cat.getLibelle());
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategorieQuizz.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public CategorieQuizz findCatById(int id)
    {
        String req = (new StringBuilder()).append("select * FROM `categoriequizz` WHERE `id` =").append(id).toString();
        List liste = new ArrayList();
        
        try {
            statement = con.createStatement();
            CategorieQuizz c;
            for(rs = statement.executeQuery(req); rs.next(); liste.add(c))
            {
                c = new CategorieQuizz(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategorieQuizz.class.getName()).log(Level.SEVERE, null, ex);
        }

        cat = (CategorieQuizz)liste.get(0);
        return cat;
    }

    public ArrayList showCategorieQuizz()
    {
        String req = "select * from categoriequizz";
        ArrayList liste = new ArrayList();
        
        try {
            statement = con.createStatement();
            CategorieQuizz c;
            for(rs = statement.executeQuery(req); rs.next(); liste.add(c))
            {
                c = new CategorieQuizz(rs.getInt(1), rs.getString(2));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategorieQuizz.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste;
    }
    public void updateCategory (CategorieQuizz catOld,CategorieQuizz catNew){
        String req = "UPDATE `categoriequizz` SET "
                + "`libelle`=? WHERE `id`=?";
        try {
            PreparedStatement ste = con.prepareStatement(req);
            ste.setString(1, catNew.getLibelle());
            ste.setInt(2, catOld.getId());
            ste.executeUpdate();
    }   catch (SQLException ex) {
            Logger.getLogger(ServiceCategorieQuizz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteCategory(CategorieQuizz cat){
        String req = "DELETE FROM `categoriequizz` WHERE `id`=?";
        try {
            PreparedStatement ste = con.prepareStatement(req);
            ste.setInt(1, cat.getId());
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategorieQuizz.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
