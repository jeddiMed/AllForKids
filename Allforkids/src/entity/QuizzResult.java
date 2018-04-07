package entity;
import java.util.ArrayList;

// Referenced classes of package allforkids.entity:
//            CategorieQuizz

public class QuizzResult
{

    private int id;
    private int userId;
    private int score;
    private ArrayList questionsList;
    private CategorieQuizz categorie;

    public QuizzResult(int userId, int score, ArrayList questionsList, CategorieQuizz categorie)
    {
        this.userId = userId;
        this.score = score;
        this.questionsList = questionsList;
        this.categorie = categorie;
    }

    public int getId()
    {
        return id;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public ArrayList getQuestionsList()
    {
        return questionsList;
    }

    public void setQuestionsList(ArrayList questionsList)
    {
        this.questionsList = questionsList;
    }

    public CategorieQuizz getCategorie()
    {
        return categorie;
    }

    public void setCategorie(CategorieQuizz categorie)
    {
        this.categorie = categorie;
    }
}
