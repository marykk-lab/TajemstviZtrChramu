package Game.World;

import Game.Command.Command;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * The World class represents the game world, allowing the player to move between rooms and interact with riddles.
 * It provides functionality for loading the room map from a file, navigating through rooms, and checking the current room.
 */
public class World extends Command {
    Scanner sc = new Scanner(System.in);

    /**
     * Executes the logic for moving between rooms based on user input.
     * Prompts the user to either move to the next room or the previous room.
     *
     * @return a message indicating the result of the movement.
     */
    @Override
    public String execute() {
        System.out.print("Where do you want to move? \n 1) next room\n 2) previous room\n >> ");
        String command = sc.nextLine();
        command = command.toLowerCase();


        switch (command) {
            case "1":
                if (riddle.isSolved()) {
                    nextRoom(true);
                    riddle.setSolved();
                } else {
                    nextRoom(false);
                }
                break;
            case "2":
                previousRoom();
                break;
            default:
                return "Wrong choice!";
        }
        return "You've entered " + getCurrentRoom()+"\n"+roooms.roomChoose(getCurrentRoom());
    }

    /**
     * Exits the action logic. For now, always returns false since there is no exit functionality in this method.
     *
     * @return false, as the game does not exit in this method.
     */
    @Override
    public boolean exit() {
        return false;
    }

    private LinkedList<String> rooms = new LinkedList<>();
    private int position = 0;
    private Riddle riddle;
    private Rooms roooms;

    /**
     * Constructor to initialize the World class with the given Riddle.
     *
     * @param riddle
     * @param roooms
     */
    public World(Riddle riddle, Rooms roooms) {
        this.riddle = riddle;
        this.roooms = roooms;
    }

    /**
     * Loads the map of rooms from a file named "rooms.txt".
     * Each room is added to the list of rooms.
     *
     * @return true if the rooms are successfully loaded from the file, false otherwise.
     */
    public boolean loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("rooms.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                rooms.add(line);
            }
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Moves the player to the next room.
     * If the player is at the last room, they win the game.
     *
     * @param a a flag to indicate if the riddle is solved.
     * @return true if the player successfully moves to the next room, false otherwise.
     */
    public boolean nextRoom(boolean a) {
        if (position < 7 && a) {
            position++;
            return true;
        } else if (position == 7 && a) {
            System.out.println("You won!");
            System.exit(0);
        } else {
            System.out.println("You can't go to the next location!");
        }
        return false;
    }

    /**
     * Moves the player to the previous room.
     *
     * @return true if the player successfully moves to the previous room, false otherwise.
     */
    public boolean previousRoom() {
        if (position > 0) {
            position--;
            return true;
        }
        return false;
    }

    /**
     * Gets the name of the current room.
     *
     * @return the name of the current room, or a message indicating that no rooms are available.
     */
    public String getCurrentRoom() {
        if (rooms.isEmpty()) {
            return "No rooms available!";
        }
        return rooms.get(position);
    }

    /**
     * Default constructor for the World class.
     */
    public World() {
    }

    /**
     * Sets the riddle associated with the world.
     *
     * @param riddle the Riddle object to set.
     */
    public void setRiddle(Riddle riddle) {
        this.riddle = riddle;
    }

    /**
     * Sets the rooms assouciated with the world.
     *
     * @param roooms the Rooms object to set.
     */
    public void setRoooms(Rooms roooms) {
        this.roooms = roooms;
    }
}
