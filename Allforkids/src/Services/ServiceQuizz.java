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
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package allforkids.Services:
//            ServiceFilm

public class ServiceQuizz
{

    Connection con;
    Statement statement;
    ResultSet rs;

    public ServiceQuizz()
    {
        con = DataSource.getInstance().getConnection();
    }

    public void insertQuestion(QuizzQuestion question)
    {
        String req = "INSERT INTO `question`(`question`, `reponseI`, `reponseII`,`reponseIII`,`reponse" +
"Correct`,`categorie`) VALUES (?,?,?,?,?,?)"
;
        
        try {
            PreparedStatement ste = con.prepareStatement(req);
            ste.setString(1, question.getQuestion());
            ste.setString(2, question.getReponseI());
            ste.setString(3, question.getReponseII());
            ste.setString(4, question.getReponseIII());
            ste.setString(5, question.getReponseCorrect());
            ste.setObject(6, Integer.valueOf(question.getCategorie().getId()));
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceQuizz.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public ArrayList showQuestions()
    {
        String req = "select * from question";
        ArrayList liste = new ArrayList();
        
        try {
            statement = con.createStatement();
            rs = statement.executeQuery(req);
            while(rs.next()){
                QuizzQuestion q = new QuizzQuestion (rs.getInt("id"), rs.getString("question"),rs.getInt("categorie"), rs.getString("reponseI"),rs.getString("reponseII"),rs.getString("reponseIII"),rs.getString("reponseCorrect"));
                liste.add(q);
            }
           

        } catch (SQLException ex) {
            Logger.getLogger(ServiceQuizz.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return liste;
    }
    public void updateQuestion (QuizzQuestion questionOld, QuizzQuestion questionNew){
        String req = "UPDATE `question` SET "
                + "`question`=?,`reponseI`=?,`reponseII`=?, `reponseIII`=?,`reponseCorrect`=?,categorie=? WHERE `id`=?";
        
        try {
            PreparedStatement ste = con.prepareStatement(req);
            ste.setString(1, questionNew.getQuestion());
            ste.setString(2, questionNew.getReponseI());
            ste.setString(3, questionNew.getReponseII());
            ste.setString(4, questionNew.getReponseIII());
            ste.setString(5, questionNew.getReponseCorrect());
            ste.setInt(6, questionNew.getCategorie().getId());
            ste.setInt(7, questionOld.getId());
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceQuizz.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    } 
    
    public void deleteFilm(QuizzQuestion question){
        String req = "DELETE FROM `question` WHERE `id`=?";
        try {
            PreparedStatement ste = con.prepareStatement(req);
            ste.setInt(1, question.getId());
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFilm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
