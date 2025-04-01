import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;

class ConsoleTest {
    private Console console;

    @BeforeEach
    void setUp() {
        console = new Console();
    }

    @Test
    void testGetStartingText() {
        assertEquals("Write [start] to start the game.", console.getStartingText());
    }

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

    @Test
    void testInvalidCommand() throws NoSuchFieldException, IllegalAccessException {
        console.start();

        var field = Console.class.getDeclaredField("commands");
        field.setAccessible(true);
        HashMap<String, Command> commands = (HashMap<String, Command>) field.get(console);

        assertFalse(commands.containsKey("invalidCommand"));
    }
}
