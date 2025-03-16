import java.util.Scanner;

public class DropItem extends Command{
    Scanner sc = new Scanner(System.in);
    @Override
    public String execute() {
        System.out.println("What item do you want to drop? \n>> ");
        String command = sc.nextLine();
        command.toLowerCase();
        return null;
    }
    @Override
    public boolean exit() {
        return false;
    }

    public boolean dropItem(String item){
        return true;
    }
}
