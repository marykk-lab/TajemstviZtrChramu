package Game.Items;

/**
 * The Items class represents an item in the game's inventory.
 * Each item has a name and a description.
 */
public class Items {

    private String itemName;
    private String description;

    /**
     * Constructs a new item with the specified name and description.
     *
     * @param itemName The name of the item.
     * @param description A description of the item.
     */
    public Items(String itemName, String description) {
        this.itemName = itemName;
        this.description = description;
    }

    /**
     * Gets the name of the item.
     *
     * @return The name of the item.
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Sets the name of the item.
     *
     * @param itemName The name to set for the item.
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Gets the description of the item.
     *
     * @return The description of the item.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the item.
     *
     * @param description The description to set for the item.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns a string representation of the item, including its name and description.
     *
     * @return A string representing the item.
     */
    @Override
    public String toString() {
        return "Item='" + itemName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
