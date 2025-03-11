public class Inventory extends Command{
    Items[] items = new Items[5];
    @Override
    public String execute() {
        return null;
    }

    @Override
    public boolean exit() {
        return false;
    }

    public boolean addItem(Items item){
        return true;
    }
}
