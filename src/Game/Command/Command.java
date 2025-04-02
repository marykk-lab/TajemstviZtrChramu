package Game.Command;

/**
 * The Game.Command.Game.Command class serves as an abstract base class for all commands in the game.
 */
public abstract class Command {
    /**
     * Executes the command and returns a result message.
     *
     * @return A string representing the outcome of the command execution.
     */
    public abstract String execute();

    /**
     * Determines whether the command should terminate the game loop.
     *
     * @return true if the game should exit, false otherwise.
     */
    public abstract boolean exit();
}