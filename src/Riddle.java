import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
    private PickingItemUp pickingItemUp;
    private Inventory inventory;
    private boolean solved = false;
    public Riddle(World world, PickingItemUp pickingItemUp, Inventory inventory) {
        this.world = world;
        this.pickingItemUp = pickingItemUp;
        this.inventory = inventory;
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
        System.out.println("You see four obelisks with the symbols of the 1.Sun, 2.Moon, 3.Earth, 4.Fire.\nYou must press them in the correct order(for example: 1, 2, 3, 4)stop to end guessing.");
        String a = "";
        String correct = "1, 3, 2, 4";
        while (!a.equals(correct)&&!a.equals("stop")){
            a=sc.nextLine();
            if (!a.equals(correct) && !a.equals("stop")) {
                System.out.println("Wrong, try again(write stop to stop guessing)");
            }
        }
        if (a.equals(correct)){
            System.out.println("You made it, now you can move to the next room[move]");
            return true;
        }
        return false;
    }

    public boolean LibraryRiddle(){
        System.out.println("In the middle of the room is a large stone bookcase with dusty scrolls." +
                "Five of them are placed on special pedestals and each has a different symbol (eye, key, sun, snake, moon).\n"+
                        "In the middle is an old inscription:\n " +
                        "Only he who sees the hidden will find the truth.\n Short excerpts from the scrolls:\n"+
                        "1. Eye - Truth is hidden in darkness.\n" +
                        "2.The Key - It opens the paths to knowledge.\n"+
                        "3.Sun - Illuminates the mystery.\n"+
                        "4.Snake - Creeps in the darkness, but does not reveal the way.\n"+
                        "5.Moon - Shines in the night, but reveals no secrets.\n(Choose one of the scrolls 1-5. If you speak to some spirit, maybe he will give you a tip-write [stop], then [talk]);");
        String correct = "1";
        String a = "";
        while (!a.equals(correct)&&!a.equals("stop")){
            a=sc.nextLine();
            if (!a.equals(correct) && !a.equals("stop")) {
                System.out.println("Wrong, try again(write stop to stop guessing)");
            }
        }
        if (a.equals(correct)){
            System.out.println("You made it, now you can move to the next room[move]");
            return true;
        }
        return false;
    }

    public boolean TrapRoomRiddle(){
        System.out.println("The floor is covered with large stone pressure plates arranged in three rows. Each plate is marked with a different symbol. The air is thick with dust, and you sense danger ahead. A faded inscription on the wall reads:\n" +
                "Only those who walk the path of wisdom will escape unscathed.\nOne wrong step could trigger the deadly traps.\n(You need to write 3 numbers from 1-3, for example [1-2-3] or [3-2-1], [stop] to stop guessing)\n" +
                "Hint: look to the item you found in previous room, maybe you will find some bigger hint.");
        String correct = "1-2-3";
        String a = "";
        while (!a.equals(correct)&&!a.equals("stop")){
            a=sc.nextLine();
            if (!a.equals(correct) && !a.equals("stop")) {
                System.out.println("You stepped on a wrong plate, you are dead.");
                System.exit(0);
            }
        }
        if (a.equals(correct)){
            System.out.println("You made it, now you can move to the next room[move]");
            return true;
        }
        return false;
    }

    public boolean SonOfWaterRiddle(){
        System.out.println("The floor is submerged, and ahead of you stand three ancient stone statues: a dolphin, a turtle, and a catfish. \n" +
                "Below them, an inscription reads:\n" +
                "One swims fast, one endures, one hides in the mud\n(You need to write 3 numbers from 1-3, for example [1-2-3] or [3-2-1], but you have only 3 tries. [stop] to stop guessing)\n" +
                "Hint: you cant see clearly but you noticed some carvings on walls, maybe you have some item to see it better.");
        String correct = "3-1-2";
        String a = "";
        int guesses=3;
        while (!a.equals(correct)&&!a.equals("stop")){
            a=sc.nextLine();
            if (!a.equals(correct) && !a.equals("stop")) {
                guesses--;
                if (guesses==0){
                    System.out.println("The room's filled with water, you can't get out.");
                    System.exit(0);
                }
                System.out.println("Wrong, try again(write stop to stop guessing). Now you have " + guesses + " tries.");
            }
        }
        if (a.equals(correct)){
            System.out.println("You made it, now you can move to the next room[move]");
            return true;
        }
        return false;
    }

    public boolean AltarOfSacrificeRiddle(){
        System.out.println("Blood is the price for those who seek passage through the past.\n(You need to write the item you want sacrifice, but choose carefully, " +
                "wrong choice may be the last for your life)");
        String correct = "sacrificial dagger";
        String a = "";
        while (!a.toLowerCase().equals(correct)&&!a.equals("stop")){
            a=sc.nextLine();
            if (!a.equals(correct) && !a.equals("stop")) {
                System.out.println("You chose the wrong item, you are dead.");
                System.exit(0);
            }
        }
        if (a.equals(correct)){
            boolean dagger = false;
            for (Items x : inventory.getPlayersitems()){
                if (x.getItemName().equals("Sacrificial dagger")){
                    dagger = true;
                }
            }
            if (dagger){
                System.out.println("You made it, now you can move to the next room[move]");
                return true;
            }
            else {
                System.out.println("You dont have this item, but its correct. Come back with this item.");
                return false;
            }
        }
        return false;
    }

    public boolean ReliquaryRiddle(){
        System.out.println("At the end of the corridor, a grand reliquary stands tall, protected by three chests." +
                "\nEach chest bears a different symbol: 1)the sun, 2)serpent, and 3)mountain. A worn inscription at your feet reads:\n" +
                "Wisdom lies with the one who lifts the light above darkness.\n(You have to choose one of chests by writing its number, for instance[1].");
        String correct = "3";
        String a = "";
        while (!a.toLowerCase().equals(correct)&&!a.equals("stop")){
            a=sc.nextLine();
            if (!a.equals(correct) && !a.equals("stop")) {
                System.out.println("You chose the wrong chest, you are dead.");
                System.exit(0);
            }
        }
        if (a.equals(correct)){
            boolean key = false;
            for (Items x : inventory.getPlayersitems()){
                if (x.getItemName().equals("Emerald key")){
                    key = true;
                }
            }
            if (key){
                System.out.println("You made it, now you can move to the next room[move]");
                pickingItemUp.addItem(new Items("Golden Relic", "The key!"));
                return true;
            }
            else {
                System.out.println("You dont have this item, but its correct. Come back with this item.");
                return false;
            }
        }
        return false;
    }

    public boolean SecretExitRiddle(){
        System.out.println("You solved");
        boolean relic = false;
        for (Items x : inventory.getPlayersitems()){
            if (x.getItemName().equals("Golden Relic")){
                relic = true;
            }
        }
        if (relic){
            System.out.println("You made it, now you can move to the next room[move]");
            return true;
        }
        else {
            System.out.println("You dont have this item, but its correct. Come back with this item.");
            return false;
        }
    }
}