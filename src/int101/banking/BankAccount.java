package int101.banking;

import int101.base.Person;
import java.math.BigDecimal;

public class BankAccount {
    private static int nextAccountNo;
    private final int accountNo;
    private final String accountName;
    private final Person accountOwner;
    private BigDecimal balance;
    private AccountHistory history;

    public BankAccount(String accountName, Person accountOwner) {
        this.accountNo = nextAccountNo++;
        this.accountName = accountName;
        this.accountOwner = accountOwner;
        this.balance = new BigDecimal(0);
    }

    /* ToDo: 
       - call the above constructor to the the job.
       - use "firstname lastname" of accountOwner as the accountName;
    */
    public BankAccount(Person accountOwner) {
        this.accountNo = nextAccountNo++;
        this.accountOwner = accountOwner;
        this.accountName = accountOwner.getFirstname() + " " + accountOwner.getLastname();
        this.balance = new BigDecimal(0);
    }
    
    public BankAccount deposit(double amount) {
        if (amount<=0) return null;
        balance = balance.add(new BigDecimal(amount));
        return this;
    }
    
    public BankAccount withdraw(double amount) {
        if (amount<=0) return null;
        if (balance.doubleValue()<amount) return null;
        balance = balance.subtract(new BigDecimal(amount));
        /*ToDo :
        accountHistory ...
        */
        return this;
    }
    
    /* ToDo:
       - try withdraw from this account first (call withdraw()); if fails, return null.
       - deposit to the other account (call deposit()); if fails, return null.
       - if everything is ok, return this (for method chaining).
    */
    public BankAccount transferTo(BankAccount to, double amount) {
        // ToDo: add your code here
        if(amount <=0) return null;
        if(balance.doubleValue()<amount) return null;
        //if(withdraw(amount)==null) return null;
        balance = balance.subtract(new BigDecimal(amount));
        to.balance = to.balance.add(new BigDecimal(amount));
        /*ToDo :
        accountHistory ...
        */
        
        return this;
    }

    public Person getAccountOwner() { return accountOwner; }

    @Override
    public String toString() {
        return "BankAccount[" + accountNo + ":" + accountName + "=" + balance + ']';
    }
    
}
