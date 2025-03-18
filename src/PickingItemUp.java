import java.util.HashMap;

public class PickingItemUp extends Command{
    @Override
    public String execute() {
        if (pickupItem())
            return "You've picked up the item.";
        return "You have nothing to pick up:>";
    }

    @Override
    public boolean exit() {
        return false;
    }

    private World world;
    private HashMap<String, Items> items;
    private Inventory inventory;

    public PickingItemUp(World world, Inventory inventory) {
        this.world = world;
        this.inventory = inventory;
        world.loadMap();
        this.items = new HashMap<>();
        items.put("Entrance hall", new Items("Torch", "Lights your way."));
    }

    public boolean pickupItem() {
        Items item = items.get(world.getCurrentRoom());
        if (items.size()<5) {
            if (item != null && inventory.addItem(item)) {
                items.remove(world.getCurrentRoom());
                return true;
            }
        }
        return false;
    }

    public boolean addItem(Items item) {
        if (item!= null){
        if (!items.containsKey(world.getCurrentRoom())) {
            items.put(world.getCurrentRoom(), item);
            return true;
        }}
        return false;
    }
}
