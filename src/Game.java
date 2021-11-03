import java.util.Scanner;

public class Game {

    private Parser parser;
    private Room currentRoom;

    /**
     * Create the game and initialise its internal map.
     */
    public Game()
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */

    private void createRooms()
    {
        Room outside, kitchen, hallWay, backYard, pantry;

        // create the rooms
        outside = new Room("outside the Safety of you're home watch out for cat's and traps");
        kitchen = new Room("in a big kitchen white muse traps there is no food other then in the traps");
        hallWay = new Room("in the hall way in the house there is a cat's scratch wood in the middle of it");
        backYard = new Room("in a big back yard whit a dor whit a cat dor in it");
        pantry = new Room("in the pantry you found the food now you just need to get it home to you're family ");

        // initialise room exits
        outside.setExits("East", kitchen);
        outside.setExits("South", backYard);
        kitchen.setExits("North", hallWay);
        kitchen.setExits("West", outside);
        hallWay.setExits("South", kitchen);
        hallWay.setExits("West", hallWay);
        backYard.setExits("North", outside);
        backYard.setExits("East", kitchen);

        pantry.setExits( "East",  hallWay);

        currentRoom = outside;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play()
    {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }


    private void printLocationInfo()
    {
        System.out.println("You are " + currentRoom.getDescription());
        System.out.print("Exits: ");

        System.out.println(currentRoom.getExitString());
        System.out.println();
    }






    /**
     * Print out the opening message for the player.
     */


    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to a Muse's World!");
        System.out.println("a Muse's World is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("You are " + currentRoom.getDescription());
        System.out.print("Exits: ");
        printLocationInfo();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command)
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the
     * command words.
     */
    private void printHelp()
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }

    /**
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command)
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

         if (nextRoom == null){
             System.out.println();
         }
        else {
            currentRoom = nextRoom;
            printLocationInfo();
        }
    }

    /**
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command)
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
