import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;

/**
 * Unit tests for the {@link Console} class to verify initialization,
 * command handling, and invalid command checks.
 */
class ConsoleTest {
    private Console console;

    /**
     * Initializes the console instance before each test.
     */
    @BeforeEach
    void setUp() {
        console = new Console();
    }

    /**
     * Tests that the starting text returned by the console is correct.
     * It ensures that the message prompting the player to start the game is as expected.
     */
    @Test
    void testGetStartingText() {
        assertEquals("Write [start] to start the game.", console.getStartingText());
    }

    /**
     * Tests the initialization of commands in the {@link Console} class.
     * It checks that the commands map is populated with the expected commands
     * like "help", "stop", and "talk" after the game starts.
     *
     * @throws NoSuchFieldException   if the field cannot be found.
     * @throws IllegalAccessException if there is an issue accessing the field.
     */
    @Test
    void testInitialization() throws NoSuchFieldException, IllegalAccessException {
        console.start();

        var field = Console.class.getDeclaredField("commands");
        field.setAccessible(true);
        HashMap<String, Command> commands = (HashMap<String, Command>) field.get(console);

        assertNotNull(commands);
        assertTrue(commands.containsKey("help"));
        assertTrue(commands.containsKey("stop"));
        assertTrue(commands.containsKey("talk"));
    }

    /**
     * Tests that invalid commands are not present in the commands map.
     * It checks that any command not registered, like "invalidCommand",
     * is not part of the available commands in the {@link Console}.
     *
     * @throws NoSuchFieldException   if the field cannot be found.
     * @throws IllegalAccessException if there is an issue accessing the field.
     */
    @Test
    void testInvalidCommand() throws NoSuchFieldException, IllegalAccessException {
        console.start();

        var field = Console.class.getDeclaredField("commands");
        field.setAccessible(true);
        HashMap<String, Command> commands = (HashMap<String, Command>) field.get(console);

        assertFalse(commands.containsKey("invalidCommand"));
    }
}
