package nl.han.ddoa.dda.example.uitwerking.bankaccount;

/**
 * http://www.cs.sjsu.edu/~pearce/modules/lectures/j2se/multithreading/synch1.htm
 */
public class BankAccount {
    private double balance;

    public BankAccount(double bal) {
        balance = bal;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt) {
        double temp = balance;
        temp = temp + amt;
        try {
            Thread.sleep(300); // simulate production time
        } catch (InterruptedException ie) {
            System.err.println(ie.getMessage());
        }
        System.out.println("after deposit balance = $" + temp);
        balance = temp;
    }

    public void withdraw(double amt) {
        if (balance < amt) {
            System.out.println("Insufficient funds!");
            return;
        }
        double temp = balance;
        temp = temp - amt;
        try {
            Thread.sleep(200); // simulate consumption time
        } catch (InterruptedException ie) {
            System.err.println(ie.getMessage());
        }
        System.out.println("after withdrawl balance = $" + temp);
        balance = temp;
    }

    // option 3
//    class BankAccount {
//        private double balance;
//        public BankAccount(double bal) { balance = bal; }
//        public BankAccount() { this(0); }
//        public synchronized double getBalance() { return balance; }
//        public synchronized void deposit(double amt) {
//            double temp = balance;
//            temp = temp + amt;
//            try {
//                Thread.sleep(300); // simulate production time
//            } catch (InterruptedException ie) {
//                System.err.println(ie.getMessage());
//            }
//            System.out.println("after deposit balance = $" + temp);
//            balance = temp;
//            notify();
//        }
//        public synchronized void withdraw(double amt) {
//            while (balance < amt) {
//                try {
//                    wait(); // wait for funds
//                } catch (InterruptedException ie) {
//                    System.err.println(ie.getMessage());
//                }
//            }
//            double temp = balance;
//            temp = temp - amt;
//            try {
//                Thread.sleep(200); // simulate consumption time
//            } catch (InterruptedException ie) {
//                System.err.println(ie.getMessage());
//            }
//            System.out.println("after withdrawl balance = $" + temp);
//            balance = temp;
//        }
//    }
}
