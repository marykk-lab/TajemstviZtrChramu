public class Items {
    private String itemName;
    private String description;

    public Items(String itemName, String description) {
        this.itemName = itemName;
        this.description = description;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item='" + itemName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
