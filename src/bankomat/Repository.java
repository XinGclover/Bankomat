package bankomat;


import bankomat.model.Account;
import bankomat.model.AccountHistory;
import bankomat.model.Client;
import bankomat.model.Employee;
import bankomat.model.Loan;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/*
 *  
Java18-OOJ
 */

/**
 *
 * @author xingao
 */
public class Repository {
    
    private Properties p= new Properties();
    public Repository(){
        try {
            p.load(new FileInputStream("src/bankomat/Settings.properties"));
//            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
     public List<Client> getAllClients(){
         List<Client> clients = new ArrayList<>();
         return clients;
     }
     
     public List<Account> getAllAccounts(){
         List<Account> accounts = new ArrayList<>();
         return accounts;
     }
     
     public void callClientWithdraw(int clientID, int accountID, int amount){
         
     }
     
     public List<Loan> getAllLoan(){
         List<Loan> loans = new ArrayList<>();
         return loans;
     }
     
     public List<AccountHistory> getAllHistory(){
         List<AccountHistory> historys= new ArrayList<>();
         return historys;
     }
     
     public List<Employee> getAllEmployees(){
         List<Employee> employees= new ArrayList<>();
         return employees;
     }
     
     public void callCreateClient(int employeeID, int clientID){
         
     }
     
     public void callUpdateInfo(int clientID,int PIN,String name,String address,String telephont){
         
     }
     
     public void callDeleteClient(int employeeID, int clientID){
         
     }
     
     public void callAssignAccount(int employeeID, int clientID, int AccountNumber){
         
     }
     
     public void callEndAccount(int employeeID, int clientID, int accountID){
         
     }
     
     public void callDeposit(int employeeID, int clientID,int accountID, int amount){
         
     }
     
     public void callWithdraw(int employeeID, int clientID,int accountID, int amount){
         
     }
     
     public void callSetAccountRate(int employeeID, int clientID,int accountID, double rate){
         
     }
     
     public void callGrantLoan(int employeeID, int clientID,int loanID){
         
     }
     
     public void callSetLoanRate(int employeeID, int clientID,int loanID, double rate){
         
     }
     
     public double callPayOffMonth(int loanID){
         
     }
     
     public double callVinstOfLoan(int loanID){
         
     }
}
