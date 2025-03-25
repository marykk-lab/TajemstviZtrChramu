public class Help extends Command{
    @Override
    public String execute() {
        return "Commands:\npick up - pick up an item\n" +
                "inventory - look to your items\n" +
                "use item[item] - use some item\n" +
                "drop item[item] - drop some item from your inventory\n" +
                "talk - talk to a NPC\n" +
                "move - move to next or previous location\n" +
                "solve riddle - solve a riddle\n" +
                "stop - stop the game(dont be pussy, make it to the end)";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
