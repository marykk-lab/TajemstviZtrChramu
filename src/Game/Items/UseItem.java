package Game.Items;
import Game.Items.*;
import Game.World.*;
import Game.Command.Command;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
                if (torch()){
                    return "You've used " + command;
                }
            case "diary of a lost explorer":
                boolean diary = Diary();
                if (diary){
                    return "You've used " + command;
                }
            case "sacrificial dagger":
                boolean dagger = SacrificialDagger();
                if (dagger){
                    return "You've used " + command;
                }
            case "emerald key":
                boolean key = EmeraldKey();
                if (key){
                    return "You've used " + command;
                }
            case "golden relic":
                boolean relic = GoldenRelic();
                if (relic){
                    return "You've used " + command;
                }
            default:
                return "You don't have this item";
        }
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
    private World world;

    /**
     * Constructor to initialize the Game.Items.UseItem object.
     *
     * @param inventory the player's inventory.
     */
    public UseItem(Inventory inventory, Rooms room, World world) {
        this.rooms = room;
        this.inventory = inventory;
        this.world = world;
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

    public boolean SacrificialDagger(){
        if (inventory.ifItemExists("Sacrificial dagger")){
            System.out.println("Keep it!You will need it for something else...");
            return true;
        }
        return false;
    }

    public boolean EmeraldKey(){
        if (inventory.ifItemExists("Emerald Key")){
            System.out.println("Keep it!You will need if for something else...");
            return true;
        }
        return false;
    }

    public boolean GoldenRelic(){
        if (inventory.ifItemExists("Golden Relic")){
            System.out.println("Keep it!You will need if for something else...");
            return true;
        }
        return false;
    }

    public boolean Diary(){
        if (inventory.ifItemExists("Diary of a Lost Explorer")){
            try(BufferedReader br = new BufferedReader(new FileReader("DiaryTexts.txt"))){
                String line;
                ArrayList<String> array = new ArrayList<>();
                String text="";
                while((line=br.readLine())!=null){
                    array.add(line);
                }
                for (String x : array){
                    if (x.startsWith("#"+world.getCurrentRoom())){
                        text = array.get(array.indexOf(x)+1);
                    }
                }
                String[] splitted_text = text.split("\\\\n");
                for (String x : splitted_text) {
                    System.out.println(x);
                }
                return true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }
}
