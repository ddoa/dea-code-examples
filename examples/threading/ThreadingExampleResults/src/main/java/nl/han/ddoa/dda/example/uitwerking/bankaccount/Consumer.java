package nl.han.ddoa.dda.example.uitwerking.bankaccount;

/**
 * http://www.cs.sjsu.edu/~pearce/modules/lectures/j2se/multithreading/synch1.htm
 */
public class Consumer extends Thread {
    private BankAccount account;
    public Consumer(BankAccount acct) { account = acct; }
    public void run() {
        for(int i = 0; i < 5; i++) {
            // option 1
            synchronized(account) { account.withdraw(10); }

            // option 2
//            synchronized(account) {
//                while(account.getBalance() < 10) {
//                    try {
//                        account.wait();
//                    } catch (InterruptedException ie) {
//                        System.err.println(ie.getMessage());
//                    }
//                }
//                account.withdraw(10);
//            }
        }
    }
}