import java.util.Scanner;

/**
 * The Riddle class represents a command for solving riddles in the game.
 * The player must solve different types of riddles in various rooms to proceed.
 */
public class Riddle extends Command {

    private World world;
    private PickingItemUp pickingItemUp;
    private Inventory inventory;
    private boolean solved = false;
    private Scanner sc = new Scanner(System.in);

    /**
     * Constructs a Riddle command with the specified world, picking item up, and inventory.
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
        System.out.println("You see four obelisks with the symbols of the 1.Sun, 2.Moon, 3.Earth, 4.Fire.\nYou must press them in the correct order(for example: 1, 2, 3, 4)stop to end guessing.");
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
        System.out.println("In the middle of the room is a large stone bookcase with dusty scrolls...\nChoose the correct scroll based on the clues.");
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
        System.out.println("The floor is covered with large stone pressure plates... You must step on the correct ones.");
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
        System.out.println("The floor is submerged... You must arrange the statues in the correct order.");
        String correct = "3-1-2";
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
        System.out.println("Blood is the price for those who seek passage through the past.");
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
            boolean dagger = false;
            for (Items x : inventory.getPlayersitems()) {
                if (x.getItemName().equals("Sacrificial dagger")) {
                    dagger = true;
                }
            }
            if (dagger) {
                System.out.println("You made it, now you can move to the next room[move]");
                return true;
            } else {
                System.out.println("You don't have this item, but it's correct. Come back with this item.");
                return false;
            }
        }
        return false;
    }

    /**
     * Solves the "Reliquary" riddle where the player must choose the correct chest.
     *
     * @return true if the riddle is solved correctly, false otherwise.
     */
    public boolean ReliquaryRiddle() {
        System.out.println("A grand reliquary stands tall, protected by three chests...");
        String correct = "3";
        String answer = "";
        while (!answer.toLowerCase().equals(correct) && !answer.equals("stop")) {
            answer = sc.nextLine();
            if (!answer.equals(correct) && !answer.equals("stop")) {
                System.out.println("You chose the wrong chest, you are dead.");
                System.exit(0);
            }
        }
        if (answer.equals(correct)) {
            boolean key = false;
            for (Items x : inventory.getPlayersitems()) {
                if (x.getItemName().equals("Emerald key")) {
                    key = true;
                }
            }
            if (key) {
                System.out.println("You made it, now you can move to the next room[move]");
                pickingItemUp.addItem(new Items("Golden Relic", "The key!"));
                return true;
            } else {
                System.out.println("You don't have this item, but it's correct. Come back with this item.");
                return false;
            }
        }
        return false;
    }

    /**
     * Solves the "Secret Exit" riddle where the player must have the Golden Relic.
     *
     * @return true if the riddle is solved correctly, false otherwise.
     */
    public boolean SecretExitRiddle() {
        System.out.println("You solved it!");
        boolean relic = false;
        for (Items x : inventory.getPlayersitems()) {
            if (x.getItemName().equals("Golden Relic")) {
                relic = true;
            }
        }
        if (relic) {
            System.out.println("You made it, now you can move to the next room[move]");
            return true;
        } else {
            System.out.println("You don't have this item, but it's correct. Come back with this item.");
            return false;
        }
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
}
