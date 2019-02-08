/*
 *  
Java18-OOJ
 */
package bankomat;

import bankomat.model.Account;

import bankomat.model.Client;
import bankomat.model.HandleAccount;
import bankomat.model.Loan;
import java.util.LinkedList;
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
      List<Client> clients=repo.getAllClients();
       for(Client c:clients){
           if(usernumber==c.getPersonnumber()){
               if(pin==c.getPIN()){                                
                   return c;
               }              
           else
              JOptionPane.showMessageDialog(null,"Invalid Login.","Login Error",JOptionPane.ERROR_MESSAGE); 
           }
       }
       return null;
   } 
     
   
   public List<Account> loadAccountsforClient(Client c){
       List<Account> accountsofClient=repo.getAllAccounts().stream().
               filter(a->a.getClientID()==c.getId()&&a.getAvsluta()==false).
               collect(Collectors.toList());
       return accountsofClient;
   }
   
   public void clientWithdraw(Client c,int accountID,int amount){
       repo.callClientWithdraw(c.getId(), accountID, amount);
   }
   
   public List<Loan> loadLoansforClient(Client c){
       List<Loan> loansofClient=repo.getAllLoans().stream().filter(a->a.getClientID()==c.getId()).
               collect(Collectors.toList());
       return loansofClient;
   }
   
//   public List<HandleAccount> loadHistorysforAccount(Account a){
//       List<HandleAccount> historysofAccount= repo.getAllHandleAccounts().stream().filter(s->s.getAccountId()==a.getId()).
//               collect(Collectors.toList());
//       return historysofAccount;
//   }
   
   
   public Client checkClientNumber(String personnumber){
       List<Client> clients=repo.getAllClients();
       for(Client c:clients){
           if(personnumber.equals(c.getPersonnumber())){
               return c;
           }
           
       }
       return null;  
   
   }
   
    public List<HandleAccount> loadHistorysforAccount(Account a){
       List<HandleAccount> historysofAccount= repo.getAllHandleAccounts().stream().filter(s->s.getAccountId()==a.getId()).
               collect(Collectors.toList());
       for(HandleAccount ha:historysofAccount){
           
       }
   }
   
}
