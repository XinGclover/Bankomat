/*
 *  
Java18-OOJ
 */
package bankomat;

import bankomat.model.Account;
import bankomat.model.Client;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;



/**
 *
 * @author xingao
 */
public class Controller {
   Repository repo= new Repository(); 
   
   
   public Client checkLogin (int usernumber, int pin){
       int clientId=repo.getClientIdByPersonnummerAndPIN(usernumber, pin);
       Map<Integer,Client> clients=repo.getAllClients();
       return clients.get(clientId);
   } 
   
   
   public List<Account> loadAccountsforClient(Client c){
       List<Account> accountsofClient=repo.getAllAccounts().stream().filter(a->a.getClientID()==c.getId()).
               collect(Collectors.toList());
       return accountsofClient;
   }
   
   public void clientWithdraw(Client c,int accountID,int amount){
       repo.callClientWithdraw(c.getId(), accountID, amount);
   }
   
   public List<Loan> loadLoansforClient(Client c){
       List<Loan> loansofClient=repo.getAllLoan().stream().filter(a->a.getClientID()==c.getId()).
               collect(Collectors.toList());
       return loansofClient;
   }
   
   public List<AccountHistory> loadHistorysforAccount(Account a){
       List<AccountHistory> historysofAccount= repo.getAllHistory().stream().filter(s->s.getAccountID()==a.getId()).
               collect(Collectors.toList());
       return historysofAccount;
   }
   
   
   
}
