package Game.Command;

/**
 * The Game.Command.Help class is a command that displays a list of available commands
 * to the user.
 */
public class Help extends Command {

    /**
     * Executes the help command, which displays a list of available commands.
     *
     * @return A string containing the list of commands.
     */
    @Override
    public String execute() {
        return "Commands:\npick up - pick up an item\n" +
                "inventory - look to your items\n" +
                "use item[item] - use some item\n" +
                "drop item[item] - drop some item from your inventory\n" +
                "talk - talk to a Game.Game.NPC.NPC\n" +
                "move - move to next or previous location\n" +
                "solve riddle - solve a riddle\n" +
                "stop - stop the game(dont be pussy, make it to the end)";
    }

    /**
     * Indicates that the help command does not exit the game or application.
     *
     * @return false, since the help command does not exit the application.
     */
    @Override
    public boolean exit() {
        return false;
    }
}
