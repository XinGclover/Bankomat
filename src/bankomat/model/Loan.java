

package bankomat.model;

import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

public class Loan {
   
    private int number;
    private int amount;
    private double rate;
    private int clientID;
    private Date paymentPlan;
    private boolean granted;
    private static Map<Integer, Loan> loans;
    
    public Loan (int number, int clientID, int amount, double rate , Date paymentPlan, boolean granted){
        this.number = number;
        this.clientID = clientID;
        this.amount = amount;
        this.rate = rate;
        this.paymentPlan = paymentPlan;
        this.granted = granted;
    }
    
    public Loan(){}
    
    
    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
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

    /**
     * @return the paymentPlan
     */
    public Date getPaymentPlan() {
        return paymentPlan;
    }

    /**
     * @param paymentPlan the paymentPlan to set
     */
    public void setPaymentPlan(Date paymentPlan) {
        this.paymentPlan = paymentPlan;
    }

    /**
     * @return the granted
     */
    public boolean isGranted() {
        return granted;
    }

    /**
     * @param granted the granted to set
     */
    public void setGranted(boolean granted) {
        this.granted = granted;
    }

    /**
     * @return the loans
     */
    public Map<Integer, Loan> getLoans() {
        return loans;
    }

    /**
     * @param aLoans the loans to set
     */
    public void setLoans(Map<Integer, Loan> aLoans) {
        loans = aLoans;
    }
 
    public void printLoans(){
        String content = this.loans.entrySet().stream().map(e -> e.getKey() 
                + " = " + e.getValue().getAmount()
                + "kr, ränta: " + e.getValue().getRate()).collect(Collectors.joining(".\n"));
        System.out.println(content);     
    }
    
    
}
