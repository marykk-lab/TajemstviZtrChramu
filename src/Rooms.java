/**
 * The Rooms class represents different rooms in a text-based adventure game.
 * Each room has a description and potential interactions that the player can experience
 * as they progress through the game.
 * The class provides methods to handle room-specific actions and to start the game.
 */
public class Rooms extends Command {
    private int a = 0;

    /**
     * Executes the room logic. If the game has not started yet, it will start the game.
     *
     * @return a string representing the result of the execution.
     */
    @Override
    public String execute() {
        return startGame();
    }

    /**
     * Exits the room logic. For now, always returns false since the game does not exit here.
     *
     * @return false as the game doesn't exit from this method.
     */
    @Override
    public boolean exit() {
        return false;
    }

    /**
     * Represents the Entrance Hall room where the game starts. If the player has picked up the torch,
     * a different description is shown. Otherwise, the player is prompted to pick up the torch.
     *
     * @param a boolean indicating whether the player has picked up the torch.
     * @return a string describing the room.
     */
    public String EntranceHall(boolean a) {
        if (a) {
            return "You see walls with some texts, exit...";
        }
        return "You see darkness, but you feel something near your leg. It's a torch!\n(pick up to grab it)";
    }

    /**
     * Represents the "Sal with Obelisks" room. Currently, this method does nothing.
     * Add room-specific interactions here.
     */
    public void SalwObelisks() {
    }

    /**
     * Represents the "Library" room. Currently, this method does nothing.
     * Add room-specific interactions here.
     */
    public void Library() {
    }

    /**
     * Represents the "Trap Room" room. Currently, this method does nothing.
     * Add room-specific interactions here.
     */
    public void TrapRoom() {
    }

    /**
     * Represents the "Son of Water" room. Currently, this method does nothing.
     * Add room-specific interactions here.
     */
    public void SonOfWater() {
    }

    /**
     * Represents the "Altar of Sacrifice" room. Currently, this method does nothing.
     * Add room-specific interactions here.
     */
    public void AltarOfSacrifice() {
    }

    /**
     * Represents the "Reliquary" room. Currently, this method does nothing.
     * Add room-specific interactions here.
     */
    public void Reliquary() {
    }

    /**
     * Represents the "Secret Exit" room. Currently, this method does nothing.
     * Add room-specific interactions here.
     */
    public void SecretExit() {
    }

    /**
     * Starts the game and initializes the first room (Entrance Hall). If the game has already started,
     * it returns a message saying the game is already running.
     *
     * @return a string describing the current status of the game.
     */
    public String startGame() {
        if (a == 0) {
            System.out.println("Vojta Malinek finally finds The Lost Temple. He enters and... gates are closed?? He can't open them.\n" +
                    "Help Vojta escape from this mysterious place.\n(write 'help' to see available commands)");
            a++;
            return EntranceHall(false);
        }
        return "You've already started the game.";
    }

    /**
     * Allows the player to choose a room by providing the room's name.
     * Depending on the room chosen, the corresponding room method is executed.
     *
     * @param room the name of the room the player wants to enter.
     * @return true if a valid room was chosen, false if the room is invalid.
     */
    public boolean roomChoose(String room) {
        switch (room) {
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
                System.out.println("Unknown room! Please choose a valid room.");
                return false;
        }
        return true;
    }
}
