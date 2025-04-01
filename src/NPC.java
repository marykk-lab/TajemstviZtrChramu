/**
 * The NPC class represents a (NPC) in the game world.
 * Each NPC has a name and a text that represents what the NPC says.
 */
public class NPC {

    private String NPCname;
    private String text;

    /**
     * Constructs a new NPC with the specified name and dialogue text.
     *
     * @param NPCname The name of the NPC.
     * @param text The dialogue or text associated with the NPC.
     */
    public NPC(String NPCname, String text) {
        this.NPCname = NPCname;
        this.text = text;
    }

    /**
     * Gets the name of the NPC.
     *
     * @return The name of the NPC.
     */
    public String getNPCname() {
        return NPCname;
    }

    /**
     * Sets the name of the NPC.
     *
     * @param NPCname The name to set for the NPC.
     */
    public void setNPCname(String NPCname) {
        this.NPCname = NPCname;
    }

    /**
     * Gets the text or dialogue associated with the NPC.
     *
     * @return The dialogue text of the NPC.
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text or dialogue associated with the NPC.
     *
     * @param text The text to set for the NPC.
     */
    public void setText(String text) {
        this.text = text;
    }
}
