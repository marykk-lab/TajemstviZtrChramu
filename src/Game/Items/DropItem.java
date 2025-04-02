package Game.Items;

import Game.Command.Command;

import java.util.Scanner;

/**
 * The Game.Game.Items.Items.DropItem class represents a command to drop an item from the inventory.
 */
public class DropItem extends Command {
    private Scanner sc = new Scanner(System.in);
    private Inventory inventory;
    private PickingItemUp pickingItemUp;

    /**
     * Constructs a Game.Game.Items.Items.DropItem command with the given inventory and item picker.
     *
     * @param inventory The player's inventory.
     * @param pickingItemUp The item pickup system.
     */
    public DropItem(Inventory inventory, PickingItemUp pickingItemUp) {
        this.inventory = inventory;
        this.pickingItemUp = pickingItemUp;
    }

    /**
     * Executes the drop item command, prompting the user for input.
     *
     * @return A message indicating whether the item was dropped successfully.
     */
    @Override
    public String execute() {
        System.out.print("What item do you want to drop? \n>> ");
        String command = sc.nextLine().toLowerCase();

        if (dropItem(command)) {
            return "You've dropped " + command;
        }
        return "You don't have " + command + " in the inventory.";
    }

    /**
     * Indicates whether this command should exit the game loop.
     *
     * @return false, as dropping an item does not end the game.
     */
    @Override
    public boolean exit() {
        return false;
    }

    /**
     * Attempts to drop an item from the inventory and place it back into the world.
     *
     * @param item The name of the item to drop.
     * @return true if the item was successfully dropped, false otherwise.
     */
    public boolean dropItem(String item) {
        Items temp = inventory.getItem(item);
        if (inventory.removeItem(item)) {
            pickingItemUp.addItem(temp);
            return true;
        }
        return false;
    }
}