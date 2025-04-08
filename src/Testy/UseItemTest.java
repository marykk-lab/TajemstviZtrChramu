package Testy;
import Game.Items.*;
import Game.World.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@link UseItem} class.
 * This class verifies the functionality of using items in the inventory, particularly the use of a torch.
 * The tests check if items are used successfully, as well as failure scenarios when the item does not exist
 * in the inventory or cannot be used.
 */
class UseItemTest {
    private Inventory inventory;
    private UseItem useItem;
    private World world;
    private Rooms rooms = new Rooms(world);

    /**
     * Initializes the inventory and Game.Items.UseItem objects before each test case.
     */
    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        useItem = new UseItem(inventory, rooms, world);
    }

    /**
     * Tests the successful use of the torch item.
     * Verifies that the torch can be used when it is present in the inventory.
     */
    @Test
    void testUseItem_Torch_Success() {
        Items torch = new Items("Torch", "Lights your way.");
        inventory.addItem(torch);
        Assertions.assertTrue(useItem.torch());
    }

    /**
     * Tests the failure case where the torch is no in the inventory.
     * Verifies that the use of the torch fails when it is not present.
     */
    @Test
    void testUseItem_Torch_Fail_NotInInventory() {
        Assertions.assertFalse(useItem.torch());
    }

    /**
     * Tests the successful execution of using the torch through the execute method.
     * Verifies that when the torch is present in the inventory, the correct success message is returned.
     */
    @Test
    void testExecute_UseTorch() {
        Items torch = new Items("Torch", "Lights your way.");
        inventory.addItem(torch);
        Assertions.assertEquals("You've used torch", useItem.execute());
    }

    /**
     * Tests the failure case when trying to execute the useItem command but the item is not in the inventory.
     * Verifies that the failure message is returned when the item is absent.
     */
    @Test
    void testExecute_Fail_ItemNotExists() {
        Assertions.assertEquals("You dont have this item", useItem.execute());
    }
}
