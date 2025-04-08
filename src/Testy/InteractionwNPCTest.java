package Testy;
import Game.World.*;
import Game.Items.*;
import Game.NPC.InteractionwNPC;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@link InteractionwNPC} class.
 * The tests verify that Game.Game.NPC.NPC interaction functionalities work as expected,
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
        world = new World(new Riddle(world, pickingItemUpl, inventory), new Rooms(world));
        interactionwNPC = new InteractionwNPC(world);
    }

    /**
     * Tests a successful Game.Game.NPC.NPC interaction after entering a room with an Game.Game.NPC.NPC.
     * Moves to the next room ("Sal with obelisks") and verifies that the Game.Game.NPC.NPC interaction
     * starts as expected by checking the output.
     */
    @Test
    void testStartTalkingwNPC_Success() {
        world.loadMap();
        world.nextRoom(true);
        Assertions.assertEquals("fpqwifpi", interactionwNPC.startTalkingwNPC());
    }

    /**
     * Tests the failure case when trying to interact with an Game.Game.NPC.NPC when no Game.Game.NPC.NPC is present.
     * Verifies that the method returns {@code null} when no Game.Game.NPC.NPC is available for interaction.
     */
    @Test
    void testStartTalkingwNPC_Fail_NoNPC() {
        assertNull(interactionwNPC.startTalkingwNPC());
    }

    /**
     * Tests a successful interaction with the Game.Game.NPC.NPC when the {@link InteractionwNPC#execute()} method is called.
     * Verifies that the correct response is returned when there is an Game.Game.NPC.NPC to interact with.
     */
    @Test
    void testExecute_Success() {
        world.loadMap();
        world.nextRoom(true);
        Assertions.assertEquals("fpqwifpi", interactionwNPC.execute());
    }

    /**
     * Tests the failure case when no Game.Game.NPC.NPC is available for interaction.
     * Ensures that the appropriate error message is returned when attempting to interact
     * with a non-existent Game.Game.NPC.NPC.
     */
    @Test
    void testExecute_Fail_NoNPC() {
        Assertions.assertEquals("There are no NPCs around you can talk with.", interactionwNPC.execute());
    }
}
