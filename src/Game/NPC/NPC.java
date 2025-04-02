package Game.NPC;

/**
 * The Game.Game.NPC.NPC class represents a (Game.Game.NPC.NPC) in the game world.
 * Each Game.Game.NPC.NPC has a name and a text that represents what the Game.Game.NPC.NPC says.
 */
public class NPC {

    private String NPCname;
    private String text;

    /**
     * Constructs a new Game.Game.NPC.NPC with the specified name and dialogue text.
     *
     * @param NPCname The name of the Game.Game.NPC.NPC.
     * @param text The dialogue or text associated with the Game.Game.NPC.NPC.
     */
    public NPC(String NPCname, String text) {
        this.NPCname = NPCname;
        this.text = text;
    }

    /**
     * Gets the name of the Game.Game.NPC.NPC.
     *
     * @return The name of the Game.Game.NPC.NPC.
     */
    public String getNPCname() {
        return NPCname;
    }

    /**
     * Sets the name of the Game.Game.NPC.NPC.
     *
     * @param NPCname The name to set for the Game.Game.NPC.NPC.
     */
    public void setNPCname(String NPCname) {
        this.NPCname = NPCname;
    }

    /**
     * Gets the text or dialogue associated with the Game.Game.NPC.NPC.
     *
     * @return The dialogue text of the Game.Game.NPC.NPC.
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text or dialogue associated with the Game.Game.NPC.NPC.
     *
     * @param text The text to set for the Game.Game.NPC.NPC.
     */
    public void setText(String text) {
        this.text = text;
    }
}
