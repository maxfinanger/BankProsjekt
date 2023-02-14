import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Terminal {
    private ArrayList<String> options;
    private static Scanner input;
    public static HashMap<String, String> users;
    public static HashMap<String, Integer> balances;

    public Terminal() {
        this.options = new ArrayList<>();
        this.input = new Scanner(System.in);
        this.users = new HashMap<>();
        this.balances = new HashMap<String, Integer>();

        this.users.put("maxfin", "1234");
        this.users.put("heltve", "4321");
        this.balances.put("maxfin", 1000000);
        this.balances.put("heltve", 1000);
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

    public static void bankTransactions(String username) {
        Terminal transactions = new Terminal();

        transactions.addOption("Vis saldo");
        transactions.addOption("Sett inn penger");
        transactions.addOption("Ta ut penger");
        transactions.addOption("Send penger til en annen");
        transactions.addOption("Logg ut");

        transactions.displayMainMenu();
            int bankChoice = input.nextInt();
            int balance = balances.get(username);

            switch (bankChoice) {
                case 1:
                    System.out.println("Din saldo er " + balance + " kr.");
                    bankTransactions(username);
                    break;

                case 2:
                    System.out.println("Din saldo er " + balance);
                    System.out.println("Hvor mye ønsker du å sette inn?");
                    int deposit = input.nextInt();
                    balance += deposit;
                    balances.put(username, balance);
                    System.out.println("Din saldo er nå " + balance + " kr.");
                    bankTransactions(username);
                    break;

                case 3:
                    System.out.println("Din saldo er " + balance);
                    System.out.println("Hvor mye ønsker du å ta ut?");
                    int withdrawl = input.nextInt();
                    if (withdrawl <= balance){
                        balance -= withdrawl;
                        balances.put(username, balance);
                        System.out.println("Din saldo er nå " + balance + " kr.");
                        bankTransactions(username);
                    }
                    else {
                        System.out.println("Du har ikke nok penger på kontoen din");
                        bankTransactions(username);
                    }
                    break;

                case 4:
                    System.out.println("Din saldo er " + balance);
                    System.out.println("Hvor mye ønsker du å overføre?");
                    int transferAmount = input.nextInt();
                    System.out.println("Skriv inn mottakerens brukernavn:");
                    String recipient = input.next();
                    if (transferAmount <= balance) {
                        int recipientBalance = balances.get(recipient);
                        balance -= transferAmount;
                        recipientBalance += transferAmount;
                        balances.put(username, balance);
                        balances.put(recipient, recipientBalance);
                        System.out.println("Du har overført " + transferAmount + " kr til " + recipient);
                        System.out.println("Ny balanse for sender er " + balance + " kr");
                        System.out.println("Ny balanse for motaker er " + recipientBalance + " kr");
                        bankTransactions(username);
                    } else {
                        System.out.println("Du har ikke nok penger på kontoen din");
                        bankTransactions(username);
                    }
                    break;

                case 5:
                    System.out.println("Du har logget ut!");
                    mainMenu();
                    break;
            }
        }

    public static void mainMenu() {
        Terminal terminal = new Terminal();

        terminal.info("Terminal", "Vi oppretter 2 meny-valg");

        terminal.addOption("Logg inn");
        terminal.addOption("Avslutt");

        terminal.displayMainMenu();
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Vennligst skriv inn brukernavnet:");
                String username = input.next();
                if (users.containsKey(username)) {
                    System.out.println("Vennligst skriv inn pinkoden:");
                    String pinCode = input.next();
                    if (users.get(username).equals(pinCode)) {
                        System.out.println("Velkommen!");
                        bankTransactions(username);

                    } else {
                        System.out.println("Feil pinkode");
                        mainMenu();
                    }
                } else {
                    System.out.println("Feil brukernavn");
                    mainMenu();
                }
                break;
            case 2:
                System.out.println("Takk for ditt besøk, ha en fin dag!");
                break;
            default:
                System.out.println("Vær så snill, velg et av valgene");
                break;
        }
    }
}
