import Balance.Account;

public class PackageDemo {
    public static void main(String[] args) {
        Account ac = new Account(20000.0, 3, 14.0);
        ac.calcBalance();
        ac.display();
    }
}
