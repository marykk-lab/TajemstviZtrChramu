import java.util.ArrayList;

/**
 * The Inventory class represents the player's inventory in the game.
 * It allows adding, removing, and checking items within the inventory.
 */
public class Inventory extends Command {

    private ArrayList<Items> playersitems = new ArrayList<>();

    /**
     * Executes the inventory command by displaying the player's current inventory.
     *
     * @return A string representing the player's inventory.
     */
    @Override
    public String execute() {
        return toString();
    }

    /**
     * Indicates that the inventory command does not exit the game or application.
     *
     * @return false, since the inventory command does not exit the application.
     */
    @Override
    public boolean exit() {
        return false;
    }

    /**
     * Adds an item to the player's inventory if it is not null and the inventory has space.
     * The inventory can hold a maximum of 5 items.
     *
     * @param item The item to add to the inventory.
     * @return true if the item was successfully added.
     */
    public boolean addItem(Items item) {
        if (item != null && playersitems.size() < 5) {
            playersitems.add(item);
        }
        return true;
    }

    /**
     * Removes an item from the inventory by its name.
     *
     * @param item The name of the item to remove.
     * @return true if the item was found and removed from the inventory, false otherwise.
     */
    public boolean removeItem(String item) {
        if (item != null) {
            for (Items i : playersitems) {
                if (i.getItemName().toLowerCase().equals(item)) {
                    playersitems.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Retrieves an item from the inventory by its name.
     *
     * @param item The name of the item to retrieve.
     * @return The item if it exists in the inventory, or null if it is not found.
     */
    public Items getItem(String item) {
        if (item != null) {
            for (Items i : playersitems) {
                if (i.getItemName().toLowerCase().equals(item)) {
                    return i;
                }
            }
        }
        return null;
    }

    /**
     * Checks whether an item exists in the inventory.
     *
     * @param item The name of the item to check.
     * @return true if the item exists in the inventory, false otherwise.
     */
    public boolean ifItemExists(String item) {
        for (Items i : playersitems) {
            if (i.getItemName().equals(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the list of items currently in the player's inventory.
     *
     * @return An ArrayList of items in the inventory.
     */
    public ArrayList<Items> getPlayersitems() {
        return playersitems;
    }

    /**
     * Returns a string representation of the player's inventory.
     *
     * @return A string representing the player's inventory and its items.
     */
    @Override
    public String toString() {
        return "Inventory:" + playersitems;
    }
}
