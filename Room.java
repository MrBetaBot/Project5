
/**
 * Write a description of class Room here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Room
{
    private String description;
    private Item item;
    private Character character;
    private HashMap<String, Room> adjacentRooms;

    public Room (String d, Item i, Character c)
    {
        this.description = d;
        this.item = i;
        this.character = c;
        adjacentRooms = new HashMap<String, Room>();
    }

    public void addItem (Item i)
    {
        if (hasItem() == true)
        {
            removeItem();
        }
        else
        {
            i = item;
        }
    }

    public boolean hasItem()
    {
        return item != null;
    }

    public boolean hasCharacter()
    {
        return character != null;
    }

    public void addNeighbor (String direction, Room room)
    {
        adjacentRooms.put( direction, room );
    }

    public Room getNeighbor (String direction)
    {
        return adjacentRooms.get(direction != null);
    }

    public Item removeItem()
    {
        Item helper;
        helper = item;

        item = null;
        return helper;
    }

    public String getLongDescription()
    {
//         if (Room.hasItem() == true)
//         {
//             return ("You see " + item);
//         }
//         
//         if (Room.hasCharacter() == true)
//         {
//             return ("You meet " + character);
//         }
        
                String helper;

        helper = "You are " + description;
        if (item != null)
        {
            helper += "\n  You see " + item.getName();
        }
        if (character != null)
        {
            helper += "\n  You meet " + character.getCharName();
        }

        return helper;
    }
}
