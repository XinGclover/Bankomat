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
     
     public List<Account> getAllAccount(){
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
     
}
