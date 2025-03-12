import java.util.HashMap;
import java.util.Scanner;

public class Console {
    Scanner sc = new Scanner(System.in);
    private boolean exit = false;
    private HashMap<String, Command> commands;
    Game game = new Game();

    public Console() {
        this.commands = new HashMap<>();
    }

    private void initialization(){
        commands.put("help", new Help());
        commands.put("stop", new Exit());
        commands.put("mluvit", new InteractionwNPC());
        commands.put("jit", new World());
    };

    private boolean makeAction(){
        System.out.println(">> ");
        String command = sc.next();
        command.toLowerCase();
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
