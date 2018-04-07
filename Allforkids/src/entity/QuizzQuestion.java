/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import Services.ServiceCategorieQuizz;

// Referenced classes of package allforkids.entity:
//            CategorieQuizz

public class QuizzQuestion
{

    private int id;
    private String question;
    private CategorieQuizz categorie;
    private String reponseI;
    private String reponseII;
    private String reponseIII;
    private String reponseCorrect;

    public QuizzQuestion(int id, String question, Integer catID, String reponseI, String reponseII, String reponseIII, String reponseCorrect)
    {
        ServiceCategorieQuizz svQ = new ServiceCategorieQuizz();
        CategorieQuizz cat = svQ.findCatById(catID);
        this.id = id;
        this.question = question;
        categorie = cat;
        this.reponseI = reponseI;
        this.reponseII = reponseII;
        this.reponseIII = reponseIII;
        this.reponseCorrect = reponseCorrect;
    }

    public QuizzQuestion(String question, String reponseI, String reponseII, String reponseIII, String reponseCorrect, Integer catID)
    {
        ServiceCategorieQuizz svQ = new ServiceCategorieQuizz();
        CategorieQuizz cat = svQ.findCatById(catID);
        this.question = question;
        categorie = cat;
        this.reponseI = reponseI;
        this.reponseII = reponseII;
        this.reponseIII = reponseIII;
        this.reponseCorrect = reponseCorrect;
    }

    public int getId()
    {
        return id;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public CategorieQuizz getCategorie()
    {
        return categorie;
    }

    public void setCategorie(CategorieQuizz categorie)
    {
        this.categorie = categorie;
    }

    public String getReponseI()
    {
        return reponseI;
    }

    public void setReponseI(String reponseI)
    {
        this.reponseI = reponseI;
    }

    public String getReponseII()
    {
        return reponseII;
    }

    public void setReponseII(String reponseII)
    {
        this.reponseII = reponseII;
    }

    public String getReponseIII()
    {
        return reponseIII;
    }

    public void setReponseIII(String reponseIII)
    {
        this.reponseIII = reponseIII;
    }

    public String getReponseCorrect()
    {
        return reponseCorrect;
    }

    public void setReponseCorrect(String reponseCorrect)
    {
        this.reponseCorrect = reponseCorrect;
    }

    public String toString()
    {
        return (new StringBuilder()).append("QuizzQuestion{id=").append(id).append(", question=").append(question).append(", categorie=").append(categorie).append(", reponseI=").append(reponseI).append(", reponseII=").append(reponseII).append(", reponseIII=").append(reponseIII).append(", reponseCorrect=").append(reponseCorrect).append('}').toString();
    }
}
