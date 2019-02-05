/*
 *  
Java18-OOJ
 */
package bankomat.model;


public class Account {
   
    private int clientID;
    
    private int id;
    
    private int number;
    
    private int balance;
    
    private double rate;

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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
 
    
}
