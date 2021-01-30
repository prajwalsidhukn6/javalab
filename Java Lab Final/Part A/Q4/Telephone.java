// Consider the trunk calls of a telephone exchange.
// A trunk call can be ordinary,
// urgent or lightning. The charges depend on the
// duration and the type of the call.
// Write a program using the concept of
// polymorphism in Java to calculate the
// charges.

class TrunkCall {
    int duration;
    double charge;

    TrunkCall() {
        duration = 0;
    }

    TrunkCall(int a) {
        duration = a;
    }

    void calcCharge() {
        System.out.println("No Policy");
    }
}

class OrdinaryCall extends TrunkCall {
    double callRate;

    OrdinaryCall() {
        super();
        callRate = 0.60;
    }

    OrdinaryCall(int a) {
        super(a);
        callRate = 0.60;
    }

    OrdinaryCall(int a, double b) {
        super(a);
        callRate = b;
    }

    void calcCharge() {
        charge = duration * callRate;
        System.out.println("For Ordinary Calls: " + charge);
    }
}

class UrgentCall extends TrunkCall {
    double callRate;

    UrgentCall() {
        super();
        callRate = 1.0;
    }

    UrgentCall(int a) {
        super(a);
        callRate = 1.0;
    }

    UrgentCall(int a, double b) {
        super(a);
        callRate = b;
    }

    void calcCharge() {
        charge = duration * callRate;
        System.out.println("For Urgent Calls: " + charge);
    }
}

class LightningCall extends TrunkCall {
    double callRate;

    LightningCall() {
        super();
        callRate = 1.2;
    }

    LightningCall(int a) {
        super(a);
        callRate = 1.2;
    }

    LightningCall(int a, double b) {
        super(a);
        callRate = b;
    }

    void calcCharge() {
        charge = duration * callRate;
        System.out.println("For Lightning Calls: " + charge);
    }
}

public class Telephone {
    public static void main(String[] args) {
        TrunkCall tc;
        OrdinaryCall oc = new OrdinaryCall(5);
        UrgentCall uc = new UrgentCall(4, 2.3);
        LightningCall lc = new LightningCall(7, 6.0);

        tc = oc;
        tc.calcCharge();

        tc = uc;
        tc.calcCharge();

        tc = lc;
        tc.calcCharge();
    }
}
