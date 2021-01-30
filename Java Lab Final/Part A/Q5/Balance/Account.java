package Balance;

public class Account {
    double balance, principal, rate;
    int time;

    public Account(double a, int b, double c) {
        principal = a;
        time = b;
        rate = c;
    }

    public void calcBalance() {
        balance = principal * time * rate;
    }

    public void display() {
        System.out.println("Principal Amount: " + principal);
        System.out.println("Time: " + time + " Years");
        System.out.println("Rate of Interest: " + rate);
        System.out.println("Balance Amount: " + balance);
    }
}
