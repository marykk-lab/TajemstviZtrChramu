import Game.Command.Console;

 /**
 * The entry point of the application.
 * This class contains the main method that starts the game by initializing a {@link Console} object and calling its {@link Console#start()} method.
  * @author Maksym Osetsimskyi
 */
public class Main {

     /**
     * The main method that starts the game.
     * It creates an instance of {@link Console} and invokes its {@link Console#start()} method to begin the game interaction.
     *
     * @param args = arguments.
     */
    public static void main(String[] args) {
        Console c = new Console();
        c.start();
    }
}
