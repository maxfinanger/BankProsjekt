import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Terminal
{
    //Felter
    private ArrayList<String> options;
    static Scanner reader = new Scanner(System.in);

    //Hashmap for brukernavn
    HashMap<String, String> users = new HashMap<String, String>();

    // Her er det kode tilknyttet valgene i startmenyen
    public Terminal() {
        this.options = new ArrayList<>();

        users.put("maxfin", "1234");
        users.put("heltve", "4321");

    }
    public void addOption(String value) {
        this.options.add(value);
    }
    public void displayMainMenu() {
        for (int i = 0; i < this.options.size(); i ++) {
            System.out.println((i + 1) + ". " + this.options.get(i));
        }
    }

    public void info(String tag, String line) {
        System.out.println("[" + tag + "]: " + line);
    }

    public static void mainMenu() {
        Terminal terminal = new Terminal();

        terminal.info("Terminal", "Vi oppretter 2 meny-valg");

        terminal.options.add("Logg inn");
        terminal.options.add("Avslutt");

        terminal.displayMainMenu();
        reader.nextLine();


    }
}
