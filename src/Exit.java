public class Exit extends Command{
    @Override
    public String execute() {
        return "You are pussy, come back when you are ready.\nApplication was ended";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
