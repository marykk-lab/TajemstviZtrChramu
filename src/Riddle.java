import java.util.Scanner;

public class Riddle extends Command{
    @Override
    public String execute() {
        chooseRiddle();
        return "...";
    }
    Scanner sc = new Scanner(System.in);

    @Override
    public boolean exit() {
        return false;
    }

    private World world;
    private boolean solved = false;
    public Riddle(World world) {
        this.world = world;
    }

    public boolean isSolved(){
        if (world.getCurrentRoom().equals("Entrance hall")){
            return true;
        }
        return solved;
    }

    public void setSolved(){
        solved = false;
    }

    public void chooseRiddle(){
        String temp = world.getCurrentRoom().toLowerCase();
        switch (temp){
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

    public boolean SalwObelisksRiddle(){
        System.out.println("You see four obelisks with the symbols of the 1.Sun, 2.Moon, 3.Earth, 4.Fire.\n" +
                "You must press them in the correct order(for example: 1, 2, 3, 4)stop to end guessing.");
        String a = "";
        String correct = "1, 3, 2, 4";
        while (!a.equals(correct)&&!a.equals("stop")){
            a=sc.nextLine();
            if (!a.equals(correct) && !a.equals("stop")) {
                System.out.println("Wrong, try again(write stop to stop guessing)");
            }
        }
        if (a.equals(correct)){
            System.out.println("You made it");
            return true;
        }
        return false;
    }

    public boolean LibraryRiddle(){
        System.out.println("You solved");
        return true;
    }

    public boolean TrapRoomRiddle(){
        System.out.println("You solved");
        return true;
    }

    public boolean SonOfWaterRiddle(){
        System.out.println("You solved");
        return true;
    }

    public boolean AltarOfSacrificeRiddle(){
        System.out.println("You solved");
        return true;
    }

    public boolean ReliquaryRiddle(){
        System.out.println("You solved");
        return true;
    }

    public boolean SecretExitRiddle(){
        System.out.println("You solved");
        return true;
    }
}
