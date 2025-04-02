package Game.World;

import Game.Command.Command;

public class Rooms extends Command {
    private int a=0;

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
            return "You see walls with some texts, exit...";
        }
        return "You see darkness, but you feel something near your leg. It's torch!\n(pick up to grab it)";
    }

    public void SalwObelisks(){
    }

    public void Library(){
    }

    public void TrapRoom(){
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
            System.out.println("Vojta Malinek finally founds The Lost Temple. He enters and... gates are closed?? He cant open it.\n " +
                    "Game.Command.Help Vojtech to escape from this mysterious place.\n(write help to see availble commands)");
            a++;
            return EntranceHall(false);
        }
        return "You've already started the game.";
    }

    public boolean roomChoose(String room){
        switch (room){
            case "Sal with obelisks":
                SalwObelisks();
                break;
            case "Library":
                Library();
                break;
            case "Trap Room":
                TrapRoom();
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
}
