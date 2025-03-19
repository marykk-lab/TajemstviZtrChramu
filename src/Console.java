import java.util.HashMap;
import java.util.Scanner;

public class Console {
    Scanner sc = new Scanner(System.in);
    private boolean exit = false;
    private HashMap<String, Command> commands;
    private World world;
    private Inventory inventory;
    private PickingItemUp pickingItemUp;


    public Console() {
        this.commands = new HashMap<>();
        this.world = new World();
        this.inventory = new Inventory();
        this.pickingItemUp = new PickingItemUp(world, inventory);
    }


    private void initialization(){
        commands.put("help", new Help());
        commands.put("stop", new Exit());
        commands.put("talk", new InteractionwNPC(world));
        commands.put("move", world);
        commands.put("pick up", pickingItemUp);
        commands.put("inventory", inventory);
        commands.put("use item", new UseItem(inventory));
        commands.put("drop item", new DropItem(inventory, pickingItemUp));
        commands.put("solve riddle", new Riddle(world));
        commands.put("start", new Rooms());
    };

    private boolean makeAction(){
        System.out.print("Write your command: \n>> ");
        String command = sc.nextLine();
        command = command.toLowerCase();
        if (commands.containsKey(command)){
            System.out.println(">> "+commands.get(command).execute());
            exit = commands.get(command).exit();
        }else{
            System.out.println("Wrong command.");
        }
        return true;
    };

    public void start(){
        initialization();
        try{
            do {
                makeAction();
            }while (!exit);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    };
}
