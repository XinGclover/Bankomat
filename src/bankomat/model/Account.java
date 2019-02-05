

package bankomat.model;

import java.util.Map;
import java.util.stream.Collectors;


public class Account {
   
    private int clientID;
    
    private int number;
    
    private int balance;
    
    private double rate;
    
    private boolean avsluta;  // true = avslutat konto
    
    private static Map<Integer, Account> accounts;
            
    
    public Account (int clientID, int number, int balance, double rate, boolean avsluta){
        this.clientID = clientID;
        this.number = number;
        this.balance = balance;
        this.rate = rate;
        this.avsluta = avsluta;
    }
    
    public Account (){}
    
    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String AccountInfo() {
        return  "number=" + number + ", balance=" + balance + ", rate=" + rate ;
    }

    /**
     * @return the avsluta
     */
    public boolean getAvsluta() {
        return avsluta;
    }

    /**
     * @param avsluta the avsluta to set
     */
    public void setAvsluta(boolean avsluta) {
        this.avsluta = avsluta;
    }

    /**
     * @return the accounts
     */
    public Map<Integer, Account> getAccounts() {
        return accounts;
    }

    /**
     * @param accounts the accounts to set
     */
    public void setAccounts(Map<Integer, Account> accounts) {
        this.accounts = accounts;
    }
 
    public void printAccounts(){
        String content = this.accounts.entrySet().stream().map(e -> e.getKey() 
                + " = " + e.getValue().getBalance()
                + "kr, ränta: " + e.getValue().getRate()).collect(Collectors.joining(".\n"));
        System.out.println(content);     
    }
    
    
}
