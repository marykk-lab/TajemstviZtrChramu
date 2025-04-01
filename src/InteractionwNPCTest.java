import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@link InteractionwNPC} class.
 * The tests verify that NPC interaction functionalities work as expected,
 * including both successful interactions and failure cases.
 */
class InteractionwNPCTest {
    private World world;
    private InteractionwNPC interactionwNPC;
    private PickingItemUp pickingItemUpl;
    private Inventory inventory;

    /**
     * Initializes the objects needed for the tests before each test case.
     * Creates instances of {@link World}, {@link InteractionwNPC}, and other dependencies.
     */
    @BeforeEach
    void setUp() {
        world = new World(new Riddle(world, pickingItemUpl, inventory));
        interactionwNPC = new InteractionwNPC(world);
    }

    /**
     * Tests a successful NPC interaction after entering a room with an NPC.
     * Moves to the next room ("Sal with obelisks") and verifies that the NPC interaction
     * starts as expected by checking the output.
     */
    @Test
    void testStartTalkingwNPC_Success() {
        world.loadMap();
        world.nextRoom(true);
        assertEquals("fpqwifpi", interactionwNPC.startTalkingwNPC());
    }

    /**
     * Tests the failure case when trying to interact with an NPC when no NPC is present.
     * Verifies that the method returns {@code null} when no NPC is available for interaction.
     */
    @Test
    void testStartTalkingwNPC_Fail_NoNPC() {
        assertNull(interactionwNPC.startTalkingwNPC());
    }

    /**
     * Tests a successful interaction with the NPC when the {@link InteractionwNPC#execute()} method is called.
     * Verifies that the correct response is returned when there is an NPC to interact with.
     */
    @Test
    void testExecute_Success() {
        world.loadMap();
        world.nextRoom(true);
        assertEquals("fpqwifpi", interactionwNPC.execute());
    }

    /**
     * Tests the failure case when no NPC is available for interaction.
     * Ensures that the appropriate error message is returned when attempting to interact
     * with a non-existent NPC.
     */
    @Test
    void testExecute_Fail_NoNPC() {
        assertEquals("There are no NPCs around you can talk with.", interactionwNPC.execute());
    }
}
