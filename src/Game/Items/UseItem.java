package Game.Items;
import Game.Items.*;
import Game.World.Rooms;
import Game.Command.Command;

import java.util.Scanner;

/**
 * The Game.Items.UseItem class represents the action of using an item in the game.
 * It allows the player to interact with their inventory and use a specific item, such as the "Torch".
 */
public class UseItem extends Command {
    Scanner sc = new Scanner(System.in);

    /**
     * Executes the logic for using an item.
     * Prompts the player to choose an item from their inventory and performs the corresponding action.
     *
     * @return a message indicating the result of using the item.
     */
    @Override
    public String execute() {
        System.out.print("What item do you want to use? \n" + inventory.getPlayersitems() + " >> ");
        String command = sc.nextLine();
        command = command.toLowerCase();

        switch (command) {
            case "torch":
                torch();
                break;
            default:
                return "You don't have this item";
        }
        return "You've used " + command;
    }

    /**
     * Exits the action logic. For now, always returns false since there is no exit functionality in this method.
     *
     * @return false, as the game does not exit in this method.
     */
    @Override
    public boolean exit() {
        return false;
    }

    private Rooms rooms;
    private Inventory inventory;

    /**
     * Constructor to initialize the Game.Items.UseItem object.
     *
     * @param inventory the player's inventory.
     */
    public UseItem(Inventory inventory) {
        this.rooms = new Rooms();
        this.inventory = inventory;
    }

    /**
     * The method for using the "Torch" item.
     * If the player has the "Torch" in their inventory, it triggers an action in the Entrance Hall room.
     *
     * @return true if the torch is used successfully, false if the player doesn't have it.
     */
    public boolean torch() {
        if (inventory.ifItemExists("Torch")) {
            System.out.println(rooms.EntranceHall(true));
            return true;
        }
        return false;
    }
}
