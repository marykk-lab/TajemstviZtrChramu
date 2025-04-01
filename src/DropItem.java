import java.util.Scanner;

public class DropItem extends Command {
    Scanner sc = new Scanner(System.in);
    @Override
    public String execute() {
        System.out.print("What item do you want to drop? \n>> ");
        String command = sc.nextLine();
        command = command.toLowerCase();
        if (dropItem(command)){
            return "You've dropped "+ command;
        }
        return "You don't have " + command + " in the inventory.";
    }
    @Override
    public boolean exit() {
        return false;
    }
    private Inventory inventory;
    private PickingItemUp pickingItemUp;

    public DropItem(Inventory inventory, PickingItemUp pickingItemUp) {
        this.inventory = inventory;
        this.pickingItemUp = pickingItemUp;
    }

    public boolean dropItem(String item){
        Items temp = inventory.getItem(item);
        if (inventory.removeItem(item)){
            pickingItemUp.addItem(temp);
            return true;
        }
        return false;
    }
}
