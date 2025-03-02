import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class World {
    private LinkedList<String> rooms = new LinkedList<>();
    private int position=0;

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
        if (position<rooms.size()&&a){
            position++;
            System.out.println("You have entered " + getCurrentRoom());
            return true;
        }else {
            System.out.println("You cant go to the next location!");
        }
        return false;
    }

    public String getCurrentRoom(){
        return rooms.get(position);
    }
}
