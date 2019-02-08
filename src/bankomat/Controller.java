/*
 *  
Java18-OOJ
 */
package bankomat;

import bankomat.model.Account;
import bankomat.model.Client;
import bankomat.model.HandleAccount;
import bankomat.model.Loan;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
          
           }
       }
       
       JOptionPane.showMessageDialog(null,"Invalid Login.","Login Error",JOptionPane.ERROR_MESSAGE); 
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
   
   
   // Ska visa 30 dagar bakåt
   public List<HandleAccount> loadHistorysforAccount(Account a){
       
       repo.getAllHandleAccounts();
       LocalDate startDate = LocalDate.now().minusDays(30);
       LocalDate endDate = LocalDate.now();
       System.out.println("startDate:" + startDate);
       System.out.println("endDate:" + endDate);
       
       
       int accountId = a.getId();
       HandleAccount ha = new HandleAccount();
       List<HandleAccount> selectedDatesOfHandleAccount = new ArrayList();
       
       for (int i = 0; i < ha.getHistoryOfAccounts().size(); i++) {
           // om kontoID stämmer
           if (ha.getHistoryOfAccounts().get(i).getAccountId() == accountId){
                // Om datumet är mellan startDate och endDate, eller är lika med startDate eller endDate.
                if(((ha.getHistoryOfAccounts().get(i).getCreationDate()).toLocalDate().isAfter(startDate)) && 
                        ((ha.getHistoryOfAccounts().get(i).getCreationDate()).toLocalDate().isBefore(endDate)) ||
                        ((ha.getHistoryOfAccounts().get(i).getCreationDate()).toLocalDate().equals(startDate)) ||
                        ((ha.getHistoryOfAccounts().get(i).getCreationDate()).toLocalDate().equals(endDate))
                        ){
                    selectedDatesOfHandleAccount.add(ha.getHistoryOfAccounts().get(i));
                }
           }
       }
       return selectedDatesOfHandleAccount;
   }
   
   public Client checkClientNumber(String personnumber){
       List<Client> clients=repo.getAllClients();
       for(Client c:clients){
           if(personnumber.equals(c.getPersonnumber())){
               return c;
           }
       }
       return null;  
   }
   
    
   
}
