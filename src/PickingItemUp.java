import java.util.HashMap;

/**
 * The PickingItemUp class represents the command for picking up items in the game world.
 * It allows the player to pick up items from the current room and add them to their inventory.
 */
public class PickingItemUp extends Command {

    private World world;
    private HashMap<String, Items> items;
    private Inventory inventory;

    /**
     * Constructs a PickingItemUp command with the specified world and inventory.
     * Initializes the items in various rooms of the game world.
     *
     * @param world The world wherqe the items are located.
     * @param inventory The player's inventory where the picked-up items will be stored.
     */
    public PickingItemUp(World world, Inventory inventory) {
        this.world = world;
        this.inventory = inventory;
        world.loadMap();
        this.items = new HashMap<>();
        items.put("Entrance hall", new Items("Torch", "Lights your way."));
        items.put("Library", new Items("Diary of a Lost Explorer", "Diary that contains hints for puzzles"));
        items.put("Altar of Sacrifice", new Items("Emerald Key", "Some key..."));
        items.put("Son of Water", new Items("Sacrificial dagger", "Dagger for sacrificing?"));
    }

    /**
     * Executes the action of picking up an item from the current room and adding it to the inventory.
     * If the player successfully picks up the item, a success message is returned.
     * If no item is available to pick up, a failure message is returned.
     *
     * @return A message indicating whefther the item was successfully picked up or not.
     */
    @Override
    public String execute() {
        if (pickupItem()) {
            return "You've picked up the item.";
        }
        return "You have nothing to pick up :>";
    }

    /**
     * Determines whether the inventory has space and if the item can be picked up from the current room.
     * If successful, the item is added to the player's inventory and removed from the room.
     *
     * @return true if an item was succesfully picked up; false otherwise.
     */
    public boolean pickupItem() {
        Items item = items.get(world.getCurrentRoom());
        if (inventory.getPlayersitems().size() < 5) {
            if (item != null && inventory.addItem(item)) {
                items.remove(world.getCurrentRoom());
                return true;
            }
        }
        return false;
    }

    /**
     * Adds an item to the current room's items, making it available for pickup.
     *
     * @param item The item to add to the current room.
     * @return true if the item was successfully added; false otherwise.
     */
    public boolean addItem(Items item) {
        if (item != null) {
            if (!items.containsKey(world.getCurrentRoom())) {
                items.put(world.getCurrentRoom(), item);
                return true;
            }
        }
        return false;
    }

    /**
     * Indicates that the picking up of an item does not exit the game or application.
     *
     * @return false, since the pick up commnd does not exit the application.
     */
    @Override
    public boolean exit() {
        return false;
    }
}
