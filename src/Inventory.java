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

    public boolean removeItem(String item){
        if (item!=null){
            for (Items i : playersitems){
                if (i.getItemName().toLowerCase().equals(item)){
                    playersitems.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public Items getItem(String item){
        if (item!=null){
            for (Items i : playersitems){
                if (i.getItemName().toLowerCase().equals(item)){
                    return i;
                }
            }
        }
        return null;
    }

    public boolean ifItemExists(String item){
        for (Items i : playersitems){
            if (i.getItemName().equals(item)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Items> getPlayersitems() {
        return playersitems;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "playersitems=" + playersitems +
                '}';
    }
}
