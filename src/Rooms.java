import java.util.HashMap;

public class Rooms extends Command{

    @Override
    public String execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }

    public String EntranceHall(boolean a){
        if (a){
            return "You see walls with some texts, exit...";
        }
        return "You see darkness.";
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
}
