import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UseItemTest {
    private Inventory inventory;
    private UseItem useItem;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        useItem = new UseItem(inventory);
    }

    @Test
    void testUseItem_Torch_Success() {
        Items torch = new Items("Torch", "Lights your way.");
        inventory.addItem(torch);
        assertTrue(useItem.torch());
    }

    @Test
    void testUseItem_Torch_Fail_NotInInventory() {
        assertFalse(useItem.torch());
    }

    @Test
    void testExecute_UseTorch() {
        Items torch = new Items("Torch", "Lights your way.");
        inventory.addItem(torch);
        assertEquals("You've used torch", useItem.execute());
    }

    @Test
    void testExecute_Fail_ItemNotExists() {
        assertEquals("You dont have this item", useItem.execute());
    }
}