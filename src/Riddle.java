public class Riddle extends Command{
    @Override
    public String execute() {
        chooseRiddle();
        return "...";
    }

    @Override
    public boolean exit() {
        return false;
    }

    private World world;
    public Riddle(World world) {
        this.world = world;
    }

    public void chooseRiddle(){
        String temp = world.getCurrentRoom().toLowerCase();
        switch (temp){
            case "sal with obelisks":
                SalwObelisksRiddle();
                break;
            case "trap room":
                TrapRoomRiddle();
                break;
            default:
                System.out.println("There is no riddle in that room!");
        }
    }

    public boolean SalwObelisksRiddle(){
        System.out.println("riddle...");
        return true;
    }

    public boolean TrapRoomRiddle(){
        System.out.println("riddle...");
        return true;
    }
}
