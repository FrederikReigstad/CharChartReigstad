import java.util.HashMap;
import java.util.Locale;

public class Room {
    private String description;
    private String ItemDescription;
    private HashMap<String, Room> exits;
    private HashMap<String, Item> items;



    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description)
    {

        this.description = description;
        exits = new HashMap<>();

        items = new HashMap<>();

    }

    public void addItem(Item item){
        items.put(item.getName(),item);
    }

    public void getItem(String direction){


    }

    public String getItemDescription()
    {
        for (i = 0 ; i <  ; i++)
        items.get().getItemDescription();
        return ItemDescription;
    }



    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     *   the The north exit.
     *   The east east.
     *   The south exit.
     *   The west exit.
     */
    public void setExits(String direction, Room neighbour)
    {
        exits.put(direction.toLowerCase(Locale.ROOT),neighbour);
    }

    public Room getExit(String direction){
      return exits.get(direction);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
    /**
     * Return a long description of this room, of the form:
     * You are in the kitchen. and the item in the room
     * Exits: north west
     * @return A description of the room, including exits.
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getItemDescription() + ".\n" + getExitString() ;
    }

    public String getExitString()
    {
        return exits.keySet().toString();
    }



}
