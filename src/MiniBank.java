public class MiniBank extends Terminal {

    public void accountHolders() {
        users.put("maxfin", "1234");
        users.put("heltve", "4321");
        users.put("frehyl", "6969");
        users.put("kateng", "1234");
    }

    public void accounts() {
        balances.put("maxfin", 1000000);
        balances.put("heltve", 1000);
        balances.put("frehyl", 1000000);
        balances.put("kateng", 0);
    }

    public static void main(String[] args) {
        mainMenu();

    }
}
