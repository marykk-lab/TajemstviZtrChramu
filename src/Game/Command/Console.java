package Game.Command;
import java.util.HashMap;
import java.util.Scanner;
import Game.Items.PickingItemUp;
import Game.Items.Inventory;
import Game.World.World;
import Game.World.Riddle;
import Game.NPC.InteractionwNPC;
import Game.Items.DropItem;
import Game.Items.UseItem;
import Game.World.Rooms;

/**
 * The Console class handles user input and command execution for the game.
 */
public class Console {
    private Scanner sc = new Scanner(System.in);
    private boolean exit = false;
    private HashMap<String, Command> commands;
    private World world;
    private Inventory inventory;
    private PickingItemUp pickingItemUp;
    private Riddle riddle;
    private Rooms rooms;

    /**
     * Constructs a new Console instance, initializing game components.
     */
    public Console() {
        this.commands = new HashMap<>();
        this.inventory = new Inventory();
        this.world = new World();
        this.pickingItemUp = new PickingItemUp(world, inventory);
        this.riddle = new Riddle(world, pickingItemUp, inventory);
        this.world.setRiddle(riddle);
        this.rooms = new Rooms(world);
        this.world.setRoooms(rooms);
    }

    /**
     * Initializes the command map with available commands.
     */
    private void initialization() {
        commands.put("help", new Help());
        commands.put("stop", new Exit());
        commands.put("talk", new InteractionwNPC(world));
        commands.put("move", world);
        commands.put("pick up", pickingItemUp);
        commands.put("inventory", inventory);
        commands.put("drop item", new DropItem(inventory, pickingItemUp));
        commands.put("solve riddle", riddle);
        commands.put("start", new Rooms(world));
        commands.put("use item", new UseItem(inventory, rooms, world));
    }

    /**
     * Handles user input and executes corresponding commands.
     *
     * @return true to continue execution, false to terminate.
     */
    private boolean makeAction() {
        System.out.print("Write your command: \n>> ");
        String command = sc.nextLine().toLowerCase();

        if (commands.containsKey(command)) {
            System.out.println(">> " + commands.get(command).execute());
            exit = commands.get(command).exit();
        } else {
            System.out.println("Wrong command.");
        }
        return true;
    }

    /**
     * Provides the starting text for the game.
     *
     * @return A string prompting the player to start the game.
     */
    public String getStartingText() {
        return "Write [start] to start the game.";
    }

    /**
     * Starts the game loop, allowing the player to input commands.
     */
    public void start() {
        initialization();
        world.loadMap();
        System.out.println(getStartingText());

        try {
            do {
                makeAction();
            } while (!exit);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
