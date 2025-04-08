package Game.World;

import Game.Command.Command;
import Game.Items.Inventory;
import Game.Items.Items;
import Game.Items.PickingItemUp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * The Game.World.Riddle class represents a command for solving riddles in the game.
 * The player must solve different types of riddles in various rooms to proceed.
 */
public class Riddle extends Command {

    private World world;
    private PickingItemUp pickingItemUp;
    private Inventory inventory;
    private boolean solved = false;
    private Scanner sc = new Scanner(System.in);

    /**
     * Constructs a Game.World.Riddle command with the specified world, picking item up, and inventory.
     *
     * @param world The world in which the riddles are located.
     * @param pickingItemUp The command to pick up items, which might be needed to solve riddles.
     * @param inventory The player's inventory, which might be required to solve riddles.
     */
    public Riddle(World world, PickingItemUp pickingItemUp, Inventory inventory) {
        this.world = world;
        this.pickingItemUp = pickingItemUp;
        this.inventory = inventory;
    }

    /**
     * Executes the riddle-solving process by choosing the appropriate riddle based on the current room.
     *
     * @return A message indicating the result of the riddle-solving attempt.
     */
    @Override
    public String execute() {
        chooseRiddle();
        return "...";
    }
    /**
     * Indicates that the riddle command does not exit the game or application.
     *
     * @return false, since solving a riddle does not terminate the game.
     */
    @Override
    public boolean exit() {
        return false;
    }

    /**
     * Returns whether the riddle in the current room is solved.
     *
     * @return true if the riddle is solved, false otherwise.
     */
    public boolean isSolved() {
        if (world.getCurrentRoom().equals("Entrance hall")) {
            return true;
        }
        return solved;
    }

    /**
     * Sets the riddle status to unsolved.
     */
    public void setSolved() {
        solved = false;
    }

    /**
     * Chooses and starts a riddle depending on the current room.
     */
    public void chooseRiddle() {
        String room = world.getCurrentRoom().toLowerCase();
        switch (room) {
            case "sal with obelisks":
                solved = SalwObelisksRiddle();
                break;
            case "trap room":
                solved = TrapRoomRiddle();
                break;
            case "library":
                solved = LibraryRiddle();
                break;
            case "son of water":
                solved = SonOfWaterRiddle();
                break;
            case "altar of sacrifice":
                solved = AltarOfSacrificeRiddle();
                break;
            case "reliquary":
                solved = ReliquaryRiddle();
                break;
            case "secret exit":
                solved = SecretExitRiddle();
                break;
            default:
                System.out.println("There is no riddle in that room!");
        }
    }

    /**
     * Solves the "Sal with obelisks" riddle where the player must press the obelisks in the correct order.
     *
     * @return true if the riddle is solved correctly, false otherwise.
     */
    public boolean SalwObelisksRiddle() {
        readRiddlesTexts();
        String answer = "";
        String correct = "1, 3, 2, 4";
        while (!answer.equals(correct) && !answer.equals("stop")) {
            answer = sc.nextLine();
            if (!answer.equals(correct) && !answer.equals("stop")) {
                System.out.println("Wrong, try again(write stop to stop guessing)");
            }
        }
        if (answer.equals(correct)) {
            System.out.println("You made it, now you can move to the next room[move]");
            return true;
        }
        return false;
    }

    /**
     * Solves the "Library" riddle where the player must choose the correct scroll.
     *
     * @return true if the riddle is solved correctly, false otherwise.
     */
    public boolean LibraryRiddle() {
        readRiddlesTexts();
        String correct = "1";
        String answer = "";
        while (!answer.equals(correct) && !answer.equals("stop")) {
            answer = sc.nextLine();
            if (!answer.equals(correct) && !answer.equals("stop")) {
                System.out.println("Wrong, try again(write stop to stop guessing)");
            }
        }
        if (answer.equals(correct)) {
            System.out.println("You made it, now you can move to the next room[move]");
            pickingItemUp.addItem(new Items("Diary of a Lost Explorer", "Diary that contains hints for puzzles"));
            System.out.println("Something fell out from bookshelves...[pick up]");
            return true;
        }
        return false;
    }

    /**
     * Solves the "Trap Room" riddle where the player must step on the correct pressure plates.
     *
     * @return true if the riddle is solved correctly, false otherwise.
     */
    public boolean TrapRoomRiddle() {
        readRiddlesTexts();
        String correct = "1-2-3";
        String answer = "";
        while (!answer.equals(correct) && !answer.equals("stop")) {
            answer = sc.nextLine();
            if (!answer.equals(correct) && !answer.equals("stop")) {
                System.out.println("You stepped on a wrong plate, you are dead.");
                System.exit(0);
            }
        }
        if (answer.equals(correct)) {
            System.out.println("You made it, now you can move to the next room[move]");
            return true;
        }
        return false;
    }

    /**
     * Solves the "Son of Water" riddle where the player must arrange the statues in the correct order.
     *
     * @return true if the riddle is solved correctly, false otherwise.
     */
    public boolean SonOfWaterRiddle() {
        readRiddlesTexts();
        String correct = "3-1-2-4";
        String answer = "";
        int guesses = 3;
        while (!answer.equals(correct) && !answer.equals("stop")) {
            answer = sc.nextLine();
            if (!answer.equals(correct) && !answer.equals("stop")) {
                guesses--;
                if (guesses == 0) {
                    System.out.println("The room's filled with water, you can't get out.");
                    System.exit(0);
                }
                System.out.println("Wrong, try again(write stop to stop guessing). Now you have " + guesses + " tries.");
            }
        }
        if (answer.equals(correct)) {
            System.out.println("You made it, now you can move to the next room[move]");
            return true;
        }
        return false;
    }

    /**
     * Solves the "Altar of Sacrifice" riddle where the player must sacrifice the correct item.
     *
     * @return true if the riddle is solved correctly, false otherwise.
     */
    public boolean AltarOfSacrificeRiddle() {
        readRiddlesTexts();
        String correct = "sacrificial dagger";
        String answer = "";
        while (!answer.toLowerCase().equals(correct) && !answer.equals("stop")) {
            answer = sc.nextLine();
            if (!answer.equals(correct) && !answer.equals("stop")) {
                System.out.println("You chose the wrong item, you are dead.");
                System.exit(0);
            }
        }
        if (answer.equals(correct)) {
            if (inventory.ifItemExists("Sacrificial dagger")){
                System.out.println("You made it, now you can move to the next room[move]");
                return true;
            }
            System.out.println("You don't have this item, but it's correct. Come back with this item.");
            return false;
        }
        return false;
    }

    /**
     * Solves the "Reliquary" riddle where the player must choose the correct chest.
     *
     * @return true if the riddle is solved correctly, false otherwise.
     */
    public boolean ReliquaryRiddle() {
        readRiddlesTexts();
        String correct = "gold";
        String answer = "";
        while (!answer.toLowerCase().equals(correct) && !answer.equals("stop")) {
            answer = sc.nextLine();
            if (!answer.equals(correct) && !answer.equals("stop")) {
                System.out.println("You chose the wrong chest, you are dead.");
                System.exit(0);
            }
        }
        if (answer.equals(correct)) {
            if (inventory.ifItemExists("Emerald Key")) {
                System.out.println("You made it, now you can move to the next room[move]");
                pickingItemUp.addItem(new Items("Golden Relic", "The key!"));
                System.out.println("Something is in chest, it shines...[pick up].");
                return true;
            }
            System.out.println("You don't have this item, but it's correct. Come back with this item.");
            return false;
        }
        return false;
    }


    /**
     * Solves the "Secret Game.Command.Exit" riddle where the player must have the Golden Relic.
     *
     * @return true if the riddle is solved correctly, false otherwise.
     */
    public boolean SecretExitRiddle() {
        System.out.println("You solved it!");
        if (inventory.ifItemExists("Golden Relic")){
            System.out.println("You made it, now you can move to the next room[move]");
            return true;
        }
        System.out.println("You dont have the needed item!");
        return false;
    }

    public boolean readRiddlesTexts(){
        String text = null;
        ArrayList<String> array = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("RiddlesTexts.txt"))){
            String line;
            while((line=br.readLine())!=null){
                array.add(line);
            }
            for (String x : array){
                if (x.startsWith("#"+world.getCurrentRoom())){
                    text = array.get(array.indexOf(x)+1);
                }
            }
            String[] splitted_text = text.split("\\\\n");
            for (String x : splitted_text){
                System.out.println(x);
            }
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}