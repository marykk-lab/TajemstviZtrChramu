package Game.Command;

/**
 * The Game.Command.Exit class represents a command that terminates the game.
 */
public class Exit extends Command {
    /**
     * Executes the exit command, displaying a message indicating the game has ended.
     *
     * @return A message indicating that the application has ended.
     */
    @Override
    public String execute() {
        return "You are pussy, come back when you are ready.\nApplication was ended";
    }

    /**
     * Indicates that this command should exit the game loop.
     *
     * @return true, as this command terminates the game.
     */
    @Override
    public boolean exit() {
        return true;
    }
}
