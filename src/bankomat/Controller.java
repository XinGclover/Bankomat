/*
 *  
Java18-OOJ
 */
package bankomat;

import bankomat.model.Account;
import bankomat.model.AccountHistory;
import bankomat.model.Client;
import bankomat.model.Loan;
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
   
   
   public Client checkLogin (String usernumber, String pin){
      List<Client> clients=repo.getAllClients();
       for(Client c:clients){
           if(usernumber.equals(c.getPersonnumber())){
               if(pin.equals(c.getPIN())){                                
                   return c;
               }
               else
                   JOptionPane.showMessageDialog(null,"Password Incorrect.","Login Error",JOptionPane.ERROR_MESSAGE);
           }
           else
              JOptionPane.showMessageDialog(null,"User not Registered.","Login Error",JOptionPane.ERROR_MESSAGE); 
       }
       return null;
   } 
   
   
   public List<Account> loadAccountsforClient(Client c){
       List<Account> accountsofClient=repo.getAllAccount().stream().filter(a->a.getClientID()==c.getId()).
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
