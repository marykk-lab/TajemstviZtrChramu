package Game.World;
import Game.Command.Command;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Handles the logic for room transitions and text display in the game world.
 * Provides methods for displaying room descriptions based on whether the player has a torch,
 * as well as reading initial game text and processing room navigation.
 */
public class Rooms extends Command {
    private int a = 0;
    private World world;

    /**
     * Constructor that initializes the Rooms object with a reference to the World.
     *
     * @param world the game world context.
     */
    public Rooms(World world) {
        this.world = world;
    }

    /**
     * Starts the game by reading the initial start text and returning the Entrance Hall description.
     *
     * @return a string containing the room description or a message if the game has already started.
     */
    @Override
    public String execute() {
        return startGame();
    }

    /**
     * Indicates whether the game should exit from this command.
     *
     * @return false, as Rooms does not handle exiting the game.
     */
    @Override
    public boolean exit() {
        return false;
    }

    /**
     * Returns the description for the Entrance Hall based on torch status.
     *
     * @param a true if the player has a torch, false otherwise.
     * @return the appropriate room description.
     */
    public String EntranceHall(boolean a) {
        if (a) {
            return readRoomsTextTorch();
        }
        return readRoomsTextNoTorch();
    }

    /**
     * Returns the description for the Sal with Obelisks based on torch status.
     *
     * @param a true if the player has a torch, false otherwise.
     * @return the appropriate room description.
     */
    public String SalwObelisks(boolean a) {
        if (a) {
            return readRoomsTextTorch();
        }
        return readRoomsTextNoTorch();
    }

    /**
     * Returns the description for the Library based on torch status.
     *
     * @param a true if the player has a torch, false otherwise.
     * @return the appropriate room description.
     */
    public String Library(boolean a) {
        if (a) {
            return readRoomsTextTorch();
        }
        return readRoomsTextNoTorch();
    }

    /**
     * Returns the description for the Trap Room based on torch status.
     *
     * @param a true if the player has a torch, false otherwise.
     * @return the appropriate room description.
     */
    public String TrapRoom(boolean a) {
        if (a) {
            return readRoomsTextTorch();
        }
        return readRoomsTextNoTorch();
    }

    /**
     * Returns the description for the Son of Water room based on torch status.
     *
     * @param a true if the player has a torch, false otherwise.
     * @return the appropriate room description.
     */
    public String SonOfWater(boolean a) {
        if (a) {
            return readRoomsTextTorch();
        }
        return readRoomsTextNoTorch();
    }

    /**
     * Returns the description for the Altar of Sacrifice room based on torch status.
     *
     * @param a true if the player has a torch, false otherwise.
     * @return the appropriate room description.
     */
    public String AltarOfSacrifice(boolean a) {
        if (a) {
            return readRoomsTextTorch();
        }
        return readRoomsTextNoTorch();
    }

    /**
     * Returns the description for the Reliquary based on torch status.
     *
     * @param a true if the player has a torch, false otherwise.
     * @return the appropriate room description.
     */
    public String Reliquary(boolean a) {
        if (a) {
            return readRoomsTextTorch();
        }
        return readRoomsTextNoTorch();
    }

    /**
     * Returns the description for the Secret Exit room based on torch status.
     *
     * @param a true if the player has a torch, false otherwise.
     * @return the appropriate room description.
     */
    public String SecretExit(boolean a) {
        if (a) {
            return readRoomsTextTorch();
        }
        return readRoomsTextNoTorch();
    }

    /**
     * Begins the game by printing the start text and returning the Entrance Hall description.
     * This method only runs once and prevents repeated game starts.
     *
     * @return the initial room description or a message if the game was already started.
     */
    public String startGame() {
        if (a == 0) {
            readStartText();
            a++;
            return EntranceHall(false);
        }
        return "You've already started the game.";
    }

    /**
     * Returns the description for a given room by name.
     * Torch status is assumed to be false by default.
     *
     * @param room the name of the room to enter.
     * @return the corresponding room description or a default error message.
     */
    public String roomChoose(String room) {
        switch (room) {
            case "Sal with obelisks":
                return SalwObelisks(false);
            case "Library":
                return Library(false);
            case "Trap Room":
                return TrapRoom(false);
            case "Son of Water":
                return SonOfWater(false);
            case "Altar of Sacrifice":
                return AltarOfSacrifice(false);
            case "Reliquary":
                return Reliquary(false);
            case "Secret exit":
                return SecretExit(false);
            default:
                return "Wrong room!";
        }
    }

    /**
     * Reads and prints the start text from "startingText.txt".
     *
     * @return true if the file is read successfully, otherwise throws an exception.
     * @throws RuntimeException if an I/O error occurs while reading the file.
     */
    public boolean readStartText() {
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

    /**
     * Reads the room description from "roomsDescriptions.txt" when the player does not have a torch.
     *
     * @return the room description text, or null if the room is not found.
     * @throws RuntimeException if an I/O error occurs while reading the file.
     */
    public String readRoomsTextNoTorch() {
        try (BufferedReader br = new BufferedReader(new FileReader("roomsDescriptions.txt"))) {
            ArrayList<String> array = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                array.add(line);
            }
            for (String x : array) {
                if (x.startsWith("#" + world.getCurrentRoom())) {
                    return array.get(array.indexOf(x) + 1);
                }
            }
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Reads the room description from "roomsDescriptionsWithTorch.txt" when the player has a torch.
     *
     * @return the room description text, or null if the room is not found.
     * @throws RuntimeException if an I/O error occurs while reading the file.
     */
    public String readRoomsTextTorch() {
        try (BufferedReader br = new BufferedReader(new FileReader("roomsDescriptionsWithTorch.txt"))) {
            ArrayList<String> array = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                array.add(line);
            }
            for (String x : array) {
                if (x.startsWith("#" + world.getCurrentRoom())) {
                    return array.get(array.indexOf(x) + 1);
                }
            }
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
