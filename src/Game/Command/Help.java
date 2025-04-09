package Game.Command;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The Game.Command.Help class is a command that displays a list of available commands
 * to the user.
 */
public class Help extends Command {

    /**
     * Executes the help command, which displays a list of available commands.
     *
     * @return A string containing the list of commands.
     */
    @Override
    public String execute() {
        readHelpText();
        return "You ve called Help";
    }

    /**
     * Reads and displays help text from the file "HelpText.txt".
     *
     * @return true if the help text is found and displayed successfully, false otherwise.
     * @throws RuntimeException if an I/O error occurs while reading the file.
     */
    public boolean readHelpText() {
        String text = null;
        ArrayList<String> array = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("HelpText.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                array.add(line);
            }
            for (String x : array) {
                text +=x;
            }
            String[] splitted_text = text.split("\\\\n");
            for (String x : splitted_text) {
                System.out.println(x);
            }
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Indicates that the help command does not exit the game or application.
     *
     * @return false, since the help command does not exit the application.
     */
    @Override
    public boolean exit() {
        return false;
    }
}
