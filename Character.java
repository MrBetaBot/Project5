
/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character
{
    private String name;
    private String phrase;

    //constructor
    public Character (String name, String phrase)
    {
        this.name = name;
        this.phrase = phrase;
    }

    //returns and sets the Character's name
    public String getCharName()
    {
        return name;
    }
    public void setCharName(String n)
    {
        this.name = name;
    }

    //returns and sets the phrase the character says
    public String getPhrase()
    {
        return phrase;
    }
    public void setPhrase()
    {
        this.phrase = phrase;
    }
}
