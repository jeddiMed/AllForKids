/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.Film;
import connexion.DataSource;
import entity.CategorieFilm;

/**
 *
 * @author ElWess
 */
public class ServiceFilm {
    Connection con;
    Statement statement;
    ResultSet rs;

    public ServiceFilm() {
        con = (Connection) DataSource.getInstance().getConnection();
    }
    
    public void insertFilm(Film film){
        String req = "INSERT INTO `film`("
                + "`titre`, `duree`, `description`,`categorie`)"
                + " VALUES (?,?,?,?)";
        PreparedStatement ste;
        try {
            ste = con.prepareStatement(req);
            ste.setString(1, film.getTitre());
            ste.setInt(2, film.getDuree());
            ste.setString(3, film.getDescription());
            ste.setObject(4, film.getCategorie().getId());
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFilm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ArrayList<Film> showFilms(){
    String req = "select * from film";
    ArrayList<Film> liste = new ArrayList<>();
        try {
            statement = con.createStatement();
            rs = statement.executeQuery(req);
            while(rs.next()){
                Film f = new Film(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getInt(5),rs.getString(4));
                liste.add(f);
            }
    
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFilm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste;
    }
    public void updateFilm (Film filmOld, Film filmNew){
        String req = "UPDATE `film` SET "
                + "`titre`=?,`duree`=?,`categorie`=?, `description`=? WHERE `id`=?";
        try {
            PreparedStatement ste = con.prepareStatement(req);
            ste.setString(1, filmNew.getTitre());
            ste.setInt(2, filmNew.getDuree());
            ste.setObject(3, filmNew.getCategorie().getId());
            ste.setString(4, filmNew.getDescription());
            ste.setInt(5, filmOld.getId());
            ste.executeUpdate();
        }   
        catch (SQLException ex) {
            Logger.getLogger(ServiceFilm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteFilm(Film film){
        String req = "DELETE FROM `film` WHERE `id`=?";
        try {
            PreparedStatement ste = con.prepareStatement(req);
            ste.setInt(1, film.getId());
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFilm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}    
