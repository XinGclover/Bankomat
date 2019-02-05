/*
 *  
Java18-OOJ
 */
package bankomat.model;

/**
 *
 * @author xingao
 */
public class Loan {
   
    private int number;
    private int amount;
    private double rate;   
    private int id;
    
    private int clientID;

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
   

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
   

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    private String payoffdate;

    public String getPayoffdate() {
        return payoffdate;
    }

    public void setPayoffdate(String payoffdate) {
        this.payoffdate = payoffdate;
    }

   
    public String loanInfo() {
        return "number=" + number + ", amount=" + amount + ", rate=" + rate + ", payoffdate=" + payoffdate;
    }
 
    
}
