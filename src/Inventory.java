public class Inventory extends Command{
    String[] items = new String[5];
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
