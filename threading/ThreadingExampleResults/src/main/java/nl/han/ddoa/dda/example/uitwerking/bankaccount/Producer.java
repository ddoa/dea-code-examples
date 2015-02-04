package nl.han.ddoa.dda.example.uitwerking.bankaccount;

/**
 * http://www.cs.sjsu.edu/~pearce/modules/lectures/j2se/multithreading/synch1.htm
 */
public class Producer extends Thread {
    private BankAccount account;
    public Producer(BankAccount acct) { account = acct; }
    public void run() {
        for(int i = 0; i < 5; i++) {
            // option 1
            synchronized(account) { account.deposit(10); }

            // option 2
//            synchronized(account) {
//                account.deposit(10);
//                account.notify();
//            }
        }
    }
}