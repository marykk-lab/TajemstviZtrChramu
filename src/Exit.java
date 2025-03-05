public class Exit extends Command{
    @Override
    public String execute() {
        return "Application was ended";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
