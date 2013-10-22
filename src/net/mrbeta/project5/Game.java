import java.util.*;
/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game
{
    private ArrayList< Room> path;
    private ArrayList<Item> heldItems;
    private Room currentLocation;
    private String currentMessage;

    public Game()
    {
        path = new ArrayList<Room>( );

        heldItems = new ArrayList<Item>( );

        createRooms( );
        setIntroMessage( );
    }

    private void createRooms()
    {
        Room caves, trainStation, town, houseUpper, lair, castle, stalliongrad, ruins, totemhoof, totemhoofClouds;
        Item[] i =
            {
                new Item("gem", "Tantalus's Crystal", 50),
                new Item("teleporter", "Incendia's Broken Teleporter", 1),
                new Item("Lfragments", "Fragments of Luna", 4),
                new Item("Cfragments", "Fragments of Celestia", 4)
            };
        Character[ ] c = 
            {
                new Character("Incendia", "We have to go collect the fragments to stop Tantalus!"),
                new Character("Tantalus", "This world is mine!")
            };

        caves = new Room( "Home", null, null);
        trainStation = new Room ( "Train Station", null, null);
        town = new Room( "Abandoned Town", i[ 1 ], null);
        houseUpper = new Room( "House in the Town", null, null);
        lair = new Room( "Tauntalus's Lair", i[ 0 ], c[1] );
        castle = new Room( "Castle of the Goddesses", null, null );
        stalliongrad = new Room( "City of Stalliongrad", i[2], c[ 0 ] );
        ruins = new Room( "Ruins of a City", null, null ); 
        totemhoof = new Room( "City of TotemHoof", null, null );
        totemhoofClouds = new Room( "Totemhoof's Cloud Layer", i[ 3 ], null );

        //Caves.addNeighbor( "north", c1);
        caves.addNeighbor( "up", trainStation);
        trainStation.addNeighbor( "north", ruins);
        town.addNeighbor( "west", stalliongrad);
        town.addNeighbor( "north", lair);
        lair.addNeighbor( "south", town);
        lair.addNeighbor( "up", castle);
        stalliongrad.addNeighbor( "east", town);
        stalliongrad.addNeighbor( "up", ruins);
        stalliongrad.addNeighbor( "north", totemhoof);
        totemhoof.addNeighbor( "south", stalliongrad);
        houseUpper.addNeighbor( "west", ruins);
        houseUpper.addNeighbor( "north", castle);
        castle.addNeighbor( "south", houseUpper);
        castle.addNeighbor( "down", lair);
        castle.addNeighbor( "west", totemhoofClouds);
        ruins.addNeighbor( "east", houseUpper);
        ruins.addNeighbor( "down", stalliongrad);
        ruins.addNeighbor( "north", totemhoofClouds);
        totemhoofClouds.addNeighbor( "south", ruins);
        totemhoofClouds.addNeighbor( "east", castle);

        currentLocation = caves;
    }

    private void setIntroMessage( ) 
    {
        currentMessage = ("The sun and moon both hang high in the sky, unable to set, unable to rise. " +
                        "You must find the fragments of Celestia and Luna and use them to defeat " + 
                        "Tantalus before he can take over the world.");
    }

    public String getMessage()
    {
        return currentMessage;
    }

    public void help()
    {
    }

    public void look()
    {
        currentMessage = currentLocation.getLongDescription(); 
    }

    public void go(String direction)
    {
        if (direction.equals("retreat"))
        {
            retreat();
        }
        else 
        {
            Room location = currentLocation.getNeightbor (direction);
            if (location == null)
            {
                currentMessage = "There is no way to procced in that direction.";
            }
            else 
            {
                path.add(currentLocation);
                currentMessage = Room.getName();
                location = currentLocation;
            }
        }
    }

    public void pouch()
    {
        if (heldItems != null)
        {
            currentMessage = heldItems[1] + ", " + heldItems[2] + ", " + heldItems[3];
        }
        else 
        {
            currentMessage = "You are not holding anything.";
        }
    }

    public void speak()
    {
        if (Room.hasCharacter() == true)
        {
            currentMessage = Character.getPhrase();
        }
        else
        {
            currentMessage = "You're talking to yourself. There's obviously no one here.";
        }
    }

    public boolean gameOver()
    {
        return true;
    }

    public void take()
    {
        if (Room.hasItem() == true)
        {
            Room.removeItem();
            currentMessage = "You have picked up " + Item.getName();
        }
        else if (Item.getWeight > 30)
        {
            currentMessage = "You failed your strength roll. You cannot pick up this item.";
        }
        else if (Room.hasItem() == false)
        {
            currentMessage = "There is no item in this room.";
        }
    }

    public Item searchPouch(String name)
    {
        for (Item e: heldItems)
        {
            if (e.getName().equals(name))
            {
                return e;
            }
        }
        return null;
    }

    public void drop (String item)
    {
        Item search = searchPouch (item);
        if (currentroom.getItem() != null)
        {
            currentMessage = "There's already an item here.";
            getMessage();
        }
        
        for (Item i: heldItems)
        {
            if (search = item)
            {
                currentRoom.addItem();
            }
        }
    }

    public void retreat()
    {
    }

//     public static void main(String args[])
//     {
//     }
}