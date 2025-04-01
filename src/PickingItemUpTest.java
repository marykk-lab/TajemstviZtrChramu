import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@link PickingItemUp} class.
 * This class verifies the functionality of the itwfem pickup system, including the addition of items
 * to the inventory, the inventory size, and handling scenarios when the inventory is full or there
 * are no items to pick up.
 */
class PickingItemUpTest {
    private World world;
    private Inventory inventory;
    private PickingItemUp pickingItemUp;

    /**
     * Initializes the world, inventory, axnd pickingItemUp objects before each test case.
     */
    @BeforeEach
    void setUp() {
        world = new World(new Riddle(world, pickingItemUp, inventory));
        inventory = new Inventory();
        pickingItemUp = new PickingItemUp(world, inventory);
        world.loadMap();
    }

    /**
     * Tests the successful pickup of an item from the current room.
     * Verifies that the item is picked up, added to the inventory, and the inventory size increases.
     */
    @Test
    void testPickupItem_Success() {
        world.nextRoom(true);
        assertTrue(pickingItemUp.pickupItem());
        assertEquals(1, inventory.getPlayersitems().size());
        assertEquals("Diary of a Lost Explorer", inventory.getPlayersitems().get(0).getItemName());
    }

    /**
     * Tests the failure case when attempting to pick up an item when there is no item to pick up.
     * Verifies that the method returns false and the inventory size remains zero.
     */
    @Test
    void testPickupItem_Fail_NoItem() {
        assertFalse(pickingItemUp.pickupItem());
        assertEquals(0, inventory.getPlayersitems().size());
    }

    /**
     * Tests the failure case when attempting to pick up an item while the inventory is full.
     * Verifies that the item cannot be picked up and the inventory size stays at its limit.
     */
    @Test
    void testPickupItem_Fail_InventoryFull() {
        for (int i = 0; i < 5; i++) {
            inventory.addItem(new Items("item" + i, "Description"));
        }

        world.nextRoom(true);
        assertFalse(pickingItemUp.pickupItem());
        assertEquals(5, inventory.getPlayersitems().size());
    }

    /**
     * Tests the successful addition of an item to the inventory.
     * Verifies that the item is successfully added to the inventory.
     */
    @Test
    void testAddItem_Success() {
        Items item = new Items("Golden Chalice", "A rare treasure");
        assertTrue(pickingItemUp.addItem(item));
    }

    /**
     * Tests the failure case when attempting to add an item that already exists in the inventory.
     * Verifies that the item is not added if it is already present.
     */
    @Test
    void testAddItem_Fail_AlreadyExists() {
        Items item = new Items("Duplicate Item", "Should not be added");
        assertFalse(pickingItemUp.addItem(item));
    }
}
