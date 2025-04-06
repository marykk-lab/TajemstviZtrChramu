package Game.World;

import Game.Command.Command;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Rooms extends Command {
    private int a=0;
    private World world;

    public Rooms(World world) {
        this.world = world;
    }

    @Override
    public String execute() {
        return startGame();
    }

    @Override
    public boolean exit() {
        return false;
    }

    public String EntranceHall(boolean a){
        if (a){
            return readRoomsTextTorch();
        }
        return readRoomsTextNoTorch();
    }

    public String SalwObelisks(boolean a){
        if (a){
            return readRoomsTextTorch();
        }
        return readRoomsTextNoTorch();
    }

    public String Library(boolean a){
        if (a){
            return readRoomsTextTorch();
        }
        return readRoomsTextNoTorch();
    }

    public String TrapRoom(boolean a){
        if (a){
            return readRoomsTextTorch();
        }
        return readRoomsTextNoTorch();
    }

    public void SonOfWater(){
    }

    public void AltarOfSacrifice(){
    }

    public void Reliquary(){
    }

    public void SecretExit(){
    }

    public String startGame(){
        if (a==0){
            readStartText();
            a++;
            return EntranceHall(false);
        }
        return "You've already started the game.";
    }

    public boolean roomChoose(String room){
        switch (room){
            case "Sal with obelisks":
                SalwObelisks(false);
                break;
            case "Library":
                Library(false);
                break;
            case "Trap Room":
                TrapRoom(false);
                break;
            case "Son of Water":
                SonOfWater();
                break;
            case "Altar of Sacrifice":
                AltarOfSacrifice();
                break;
            case "Reliquary":
                Reliquary();
                break;
            case "Secret exit":
                SecretExit();
                break;
            default:
                System.out.println("Wrong room!");
                return false;
        }
        return true;
    }

    public boolean readStartText(){
        try (BufferedReader br = new BufferedReader(new FileReader("startingText.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.print("\n");
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String readRoomsTextNoTorch(){
        try (BufferedReader br = new BufferedReader(new FileReader("roomsDescriptions.txt"))){
            ArrayList<String> array = new ArrayList<>();
            String line;
            while((line=br.readLine())!=null){
                array.add(line);
            }
            for (String x : array){
                if (x.startsWith("#"+world.getCurrentRoom())){
                    return array.get(array.indexOf(x)+1);
                }
            }
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String readRoomsTextTorch(){
        try(BufferedReader br = new BufferedReader(new FileReader("roomsDescriptionsWithTorch.txt"))) {
            ArrayList<String> array = new ArrayList<>();
            String line;
            while((line=br.readLine())!=null){
                array.add(line);
            }
            for (String x : array){
                if (x.startsWith("#"+world.getCurrentRoom())){
                    return array.get(array.indexOf(x)+1);
                }
            }
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
