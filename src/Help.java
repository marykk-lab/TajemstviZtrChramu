public class Help extends Command{
    @Override
    public String execute() {
        return "Commands: ...";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
