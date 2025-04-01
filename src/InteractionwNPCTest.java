import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InteractionwNPCTest {
    private World world;
    private InteractionwNPC interactionwNPC;
    private PickingItemUp pickingItemUpl;
    private Inventory inventory;

    @BeforeEach
    void setUp() {
        world = new World(new Riddle(world, pickingItemUpl, inventory));
        interactionwNPC = new InteractionwNPC(world);
    }

    @Test
    void testStartTalkingwNPC_Success() {
        world.loadMap();
        world.nextRoom(true); // Move to "Sal with obelisks"
        assertEquals("fpqwifpi", interactionwNPC.startTalkingwNPC());
    }

    @Test
    void testStartTalkingwNPC_Fail_NoNPC() {
        assertNull(interactionwNPC.startTalkingwNPC());
    }

    @Test
    void testExecute_Success() {
        world.loadMap();
        world.nextRoom(true);
        assertEquals("fpqwifpi", interactionwNPC.execute());
    }

    @Test
    void testExecute_Fail_NoNPC() {
        assertEquals("There are no NPCs around you can talk with.", interactionwNPC.execute());
    }
}