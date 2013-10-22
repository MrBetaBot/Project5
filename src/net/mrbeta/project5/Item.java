
/**
 * This class is for items
 * 
 * @author Killian Riley
 * @version 11/14/2012
 */
public class Item
{
    private String name;
    private String description;
    private int weight;

    //constructor
    public Item ()
    {
        this.name = name;
        this.description = description;
        this.weight = weight;
    }

    //returns and sets the name of the item
    public String getName()
    {
        return name;
    }
    public void setName()
    {
        this.name = name; 
    }

    //returns and sets the description of the item
    public String getDescription()
    {
        return description;
    }
    public void setDescription()
    {
        this.description = description;
    }

    //returns and sets the weight of the item
    public int getWeight()
    {
        return weight;   
    }
    public void setWeight()
    {
        this.weight = weight;
    }
    
    public String toString( ) 
    {
        String description = getName() + " " + getDescription() + " " + getWeight() ;

        return description;
    }
}
