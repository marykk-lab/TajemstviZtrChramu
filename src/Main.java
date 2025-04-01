/**
 * The entry point of the application.
 * This class contains the main method that starts the game by initializing a {@link Console} object and calling its {@link Console#start()} method.
 */
public class Main {

    /**
     * The main method that starts the game.
     * It creates an instance of {@link Console} and invokes its {@link Console#start()} method to begin the game interaction.
     *
     * @param args Command-line arguments (not used in this case).
     */
    public static void main(String[] args) {
        Console c = new Console();
        c.start();
    }
}
