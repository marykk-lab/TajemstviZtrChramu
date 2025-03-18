public class NPC {
    private String NPCname;
    private String text;

    public NPC(String NPCname, String text) {
        this.NPCname = NPCname;
        this.text = text;
    }

    public String getNPCname() {
        return NPCname;
    }

    public void setNPCname(String NPCname) {
        this.NPCname = NPCname;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
