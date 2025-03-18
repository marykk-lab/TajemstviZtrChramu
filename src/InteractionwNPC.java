import java.util.HashMap;

public class InteractionwNPC extends Command{
    @Override
    public String execute() {
        if (startTalkingwNPC()!=null){
            return startTalkingwNPC();
        }
        return "There are no NPCs around you can talk with.";
    }

    @Override
    public boolean exit() {
        return false;
    }


    private HashMap <String, NPC> npcs;
    private World world;

    public InteractionwNPC(World world) {
        this.world = world;
        this.npcs = new HashMap<>();
        npcs.put("Sal with obelisks", new NPC("Guardian Spirit", "fpqwifpi"));
    }

    public String startTalkingwNPC(){
        NPC npc = npcs.get(world.getCurrentRoom());
        if (npc!=null){
            return npc.getText();
        }
        return null;
    }
}
