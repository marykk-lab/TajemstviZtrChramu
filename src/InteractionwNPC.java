import java.util.HashMap;

/**
 * The InteractionwNPC class represents a command for interacting with NPCs
 * in the game world. This command allows the player to initiate a conversation with an NPC if one is present
 * in the current room.
 */
public class InteractionwNPC extends Command {

    private HashMap<String, NPC> npcs;
    private World world;

    /**
     * Constructs an InteractionwNPC command with the specified world context.
     *
     * @param world The world in which the NPCs exist and the current room is located.
     */
    public InteractionwNPC(World world) {
        this.world = world;
        this.npcs = new HashMap<>();
        npcs.put("Sal with obelisks", new NPC("Guardian Spirit", "fpqwifpi"));
    }

    /**
     * Executes the interaction with an NPC by starting a conversation if an NPC is present in the current room.
     * If no NPC is found in the current room, a message will be returned indicating that no NPCs are available
     * for interaction.
     *
     * @return A string representing the NPC's dialogue or a message indicating the absence of an NPC.
     */
    @Override
    public String execute() {
        if (startTalkingwNPC() != null) {
            return startTalkingwNPC();
        }
        return "There are no NPCs around you can talk with.";
    }

    /**
     * Determines whether this command wil exit the game. In this case, the interaction with NPCs does not exit
     * the game or the application.
     *
     * @return false, since the interaction with NPCs does not exit the application.
     */
    @Override
    public boolean exit() {
        return false;
    }

    /**
     * Starts a conversatio with an NPC in the current room, if one exists.
     *
     * @return The dialogue text of the NPC, or null if no NPC is found in the current room.
     */
    public String startTalkingwNPC() {
        NPC npc = npcs.get(world.getCurrentRoom());
        if (npc != null) {
            return npc.getText();
        }
        return null;
    }
}
