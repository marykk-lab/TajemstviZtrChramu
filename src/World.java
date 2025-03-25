import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class World extends Command{
    Scanner sc = new Scanner(System.in);
    @Override
    public String execute() {
        System.out.print("Where do you want to move? \n 1) next room\n 2) previous room\n >> ");
        String command = sc.nextLine();
        command = command.toLowerCase();
        switch (command){
            case "1":
                if (riddle.isSolved()) {
                    nextRoom(true);
                    riddle.setSolved();
                }else {
                    nextRoom(false);
                }
                break;
            case "2":
                previousRoom();
                break;
            default:
                return "Wrong choice!";
        }
        return "You`ve entered " + getCurrentRoom();
    }

    @Override
    public boolean exit() {
        return false;
    }

    private LinkedList<String> rooms = new LinkedList<>();
    private int position=0;
    private Riddle riddle;

    public World(Riddle riddle) {
        this.riddle = riddle;
    }

    public boolean loadMap(){
        try(BufferedReader br = new BufferedReader(new FileReader("rooms.txt"))){
            String line;
            while((line = br.readLine()) != null){
                rooms.add(line);
            }
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean nextRoom(boolean a){
        if (position<7&&a){
            position++;
            return true;
        } else if (position==7&&a) {
            System.out.println("You won!");
            System.exit(0);
        } else {
            System.out.println("You cant go to the next location!");
        }
        return false;
    }
    public boolean previousRoom(){
        if (position>0){
            position--;
            return true;
        }
        return false;
    }

    public String getCurrentRoom(){
        if (rooms.isEmpty()) {
            return "No rooms available!";
        }
        return rooms.get(position);
    }

    public World() {
    }

    public void setRiddle(Riddle riddle) {
        this.riddle = riddle;
    }
}
