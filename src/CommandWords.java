public class CommandWords {
    // a constant array that holds all valid command words
    // a constant array that holds all valid command words
    private static final String validCommands[] = {
            "go", "quit", "help", "look","eat","run"
    };

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    }

    /**
     * Check whether a given String is a valid command word.
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }
    /**
     * Print all valid commands to System.out.
     * @param
     */
    public String  getCommandList()
    {
        String returnString = " ";

        for (String comand : validCommands){
            returnString += comand + " ";
        }

        return returnString;
    }

    private Object validCommands() {
        return validCommands;
    }


}
