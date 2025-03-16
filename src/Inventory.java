import java.util.ArrayList;
import java.util.Arrays;

public class Inventory extends Command{
    private ArrayList<Items> playersitems = new ArrayList<>();


    @Override
    public String execute() {
        return toString();
    }

    @Override
    public boolean exit() {
        return false;
    }

    public boolean addItem(Items item){
        if (item!=null && playersitems.size()<5){
            playersitems.add(item);
        }
        return true;
    }


    @Override
    public String toString() {
        return "Inventory{" +
                "playersitems=" + playersitems +
                '}';
    }
}
