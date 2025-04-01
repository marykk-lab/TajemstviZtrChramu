import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class InventoryTest {
    private Inventory inventory;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
    }

    @Test
    void testAddItem_Success() {
        Items item = new Items("sword", "A sharp blade");
        assertTrue(inventory.addItem(item));
        assertEquals(1, inventory.getPlayersitems().size());
        assertEquals(item, inventory.getPlayersitems().get(0));
    }

    @Test
    void testAddItem_Fail_ExceedsLimit() {
        for (int i = 0; i < 5; i++) {
            inventory.addItem(new Items("item" + i, "Description"));
        }
        assertFalse(inventory.addItem(new Items("extraItem", "Extra item description")));
        assertEquals(5, inventory.getPlayersitems().size());
    }

    @Test
    void testRemoveItem_Success() {
        Items item = new Items("shield", "A sturdy shield");
        inventory.addItem(item);
        assertTrue(inventory.removeItem("shield"));
        assertNull(inventory.getItem("shield"));
    }

    @Test
    void testRemoveItem_Failure() {
        assertFalse(inventory.removeItem("nonexistent"));
    }

    @Test
    void testGetItem_Success() {
        Items item = new Items("potion", "A healing potion");
        inventory.addItem(item);
        assertEquals(item, inventory.getItem("potion"));
    }

    @Test
    void testGetItem_Failure() {
        assertNull(inventory.getItem("nonexistent"));
    }

    @Test
    void testIfItemExists_True() {
        Items item = new Items("bow", "A long-range weapon");
        inventory.addItem(item);
        assertTrue(inventory.ifItemExists("bow"));
    }

    @Test
    void testIfItemExists_False() {
        assertFalse(inventory.ifItemExists("dagger"));
    }
}