package nl.han.ddoa.dda.example.base.bankaccount;

/**
 * http://www.cs.sjsu.edu/~pearce/modules/lectures/j2se/multithreading/synch1.htm
 */
public class Producer extends Thread {
    private BankAccount account;
    public Producer(BankAccount acct) { account = acct; }
    public void run() {
        for(int i = 0; i < 5; i++) {
            account.deposit(10);
        }
    }
}