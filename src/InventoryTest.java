import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * Unit tests for the {@link Inventory} class.
 * This class verifies the functionality of the inventory system, including
 * adding, removing, and retrieving items, as well as checking item existence.
 */
class InventoryTest {
    private Inventory inventory;

    /**
     * Initializes the inventory object before each test case.
     */
    @BeforeEach
    void setUp() {
        inventory = new Inventory();
    }

    /**
     * Tests the successful addition of an item to the inventory.
     * Verifies that the item is added, and the inventory size increases by one.
     */
    @Test
    void testAddItem_Success() {
        Items item = new Items("sword", "A sharp blade");
        assertTrue(inventory.addItem(item));
        assertEquals(1, inventory.getPlayersitems().size());
        assertEquals(item, inventory.getPlayersitems().get(0));
    }

    /**
     * Tests the failure case when attempting to add an item that exceeds the inventory limit.
     * Verifies that the item is not added when the limit is reached, and the inventory size remains unchanged.
     */
    @Test
    void testAddItem_Fail_ExceedsLimit() {
        for (int i = 0; i < 5; i++) {
            inventory.addItem(new Items("item" + i, "Description"));
        }
        assertFalse(inventory.addItem(new Items("extraItem", "Extra item description")));
        assertEquals(5, inventory.getPlayersitems().size());
    }

    /**
     * Tests the successful removal of an item from the inventory.
     * Verifies that the item is removed, and it no longer exists in the inventory.
     */
    @Test
    void testRemoveItem_Success() {
        Items item = new Items("shield", "A sturdy shield");
        inventory.addItem(item);
        assertTrue(inventory.removeItem("shield"));
        assertNull(inventory.getItem("shield"));
    }

    /**
     * Tests the failure case when attempting to remove an item that doesn't exist in the inventory.
     * Verifies that the removal fails when the item is not present.
     */
    @Test
    void testRemoveItem_Failure() {
        assertFalse(inventory.removeItem("nonexistent"));
    }

    /**
     * Tests the successful retrieval of an item from the inventory.
     * Verifies that the correct item is retrieved by name.
     */
    @Test
    void testGetItem_Success() {
        Items item = new Items("potion", "A healing potion");
        inventory.addItem(item);
        assertEquals(item, inventory.getItem("potion"));
    }

    /**
     * Tests the failure case when attempting to retrieve an item that doesn't exist in the inventory.
     * Verifies that the method returns {@code null} when the item is not found.
     */
    @Test
    void testGetItem_Failure() {
        assertNull(inventory.getItem("nonexistent"));
    }

    /**
     * Tests the successful existence check for an item in the inventory.
     * Verifies that the method returns {@code true} when the item exists.
     */
    @Test
    void testIfItemExists_True() {
        Items item = new Items("bow", "A long-range weapon");
        inventory.addItem(item);
        assertTrue(inventory.ifItemExists("bow"));
    }

    /**
     * Tests the failure case when checking for the existence of an item that is not in the inventory.
     * Verifies that the method returns {@code false} when the item is not found.
     */
    @Test
    void testIfItemExists_False() {
        assertFalse(inventory.ifItemExists("dagger"));
    }
}
