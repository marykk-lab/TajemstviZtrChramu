import java.util.HashMap;

public class PickingItemUp extends Command{
    @Override
    public String execute() {
        pickupItem();
        return "You've picked up the item.";
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

    public boolean pickupItem(){
        inventory.addItem(items.get(world.getCurrentRoom()));
        return true;
    }
}
