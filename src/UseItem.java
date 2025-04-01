import java.util.Scanner;

public class UseItem extends Command {
    Scanner sc = new Scanner(System.in);
    @Override
    public String execute() {
        System.out.print("What item do you want to use? \n"+inventory.getPlayersitems() +">> ");
        String command = sc.nextLine();
        command = command.toLowerCase();
        switch (command){
            case "torch":
                torch();
                break;
            default:
                return "You dont have this item";
        }
        return "You've used "+ command;
    }

    @Override
    public boolean exit() {
        return false;
    }

    private Rooms rooms;
    private Inventory inventory;

    public UseItem(Inventory inventory) {
        this.rooms = new Rooms();
        this.inventory = inventory;
    }

    public boolean torch(){
        if (inventory.ifItemExists("Torch")){
            System.out.println(rooms.EntranceHall(true));
            return true;
        }
        return false;
    }
}
