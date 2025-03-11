public class Game extends Command{
    @Override
    public String execute() {
        return null;
    }

    @Override
    public boolean exit() {
        return false;
    }

    Rooms rooms = new Rooms();
    Inventory inventory = new Inventory();
    Items items = new Items();
    World world = new World();

    public boolean takeItem(){
        return true;
    }

    public boolean talkToNPC(){
        return true;
    }

    public boolean solveRiddle(){
        return false;
    }

    public boolean useItem(){
        return true;
    }
}
