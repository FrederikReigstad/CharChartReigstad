import java.util.HashMap;

public class Room {
    private String description;
    private HashMap<String, Room> exits;

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
        exits.put(direction,neighbour);
    }

    public Room getExit(String direction){
      return  exits.get(direction);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    public String getExitString()
    {
        return exits.keySet().toString();
    }



}
