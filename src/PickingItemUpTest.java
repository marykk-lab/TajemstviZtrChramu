import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PickingItemUpTest {
    private World world;
    private Inventory inventory;
    private PickingItemUp pickingItemUp;

    @BeforeEach
    void setUp() {
        world = new World(new Riddle(world, pickingItemUp, inventory));
        inventory = new Inventory();
        pickingItemUp = new PickingItemUp(world, inventory);
        world.loadMap();
    }

    @Test
    void testPickupItem_Success() {
        world.nextRoom(true);
        assertTrue(pickingItemUp.pickupItem());
        assertEquals(1, inventory.getPlayersitems().size());
        assertEquals("Diary of a Lost Explorer", inventory.getPlayersitems().get(0).getItemName());
    }

    @Test
    void testPickupItem_Fail_NoItem() {
        assertFalse(pickingItemUp.pickupItem());
        assertEquals(0, inventory.getPlayersitems().size());
    }

    @Test
    void testPickupItem_Fail_InventoryFull() {
        for (int i = 0; i < 5; i++) {
            inventory.addItem(new Items("item" + i, "Description"));
        }

        world.nextRoom(true);
        assertFalse(pickingItemUp.pickupItem());
        assertEquals(5, inventory.getPlayersitems().size());
    }

    @Test
    void testAddItem_Success() {
        Items item = new Items("Golden Chalice", "A rare treasure");
        assertTrue(pickingItemUp.addItem(item));
    }

    @Test
    void testAddItem_Fail_AlreadyExists() {
        Items item = new Items("Duplicate Item", "Should not be added");
        assertFalse(pickingItemUp.addItem(item));
    }
}