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
   
   
   // Ska visa 30 dagar bakåt
   public List<HandleAccount> loadHistorysforAccount(Account a){
       
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
   
//   public void createClient(Employee e,Client c){
//       repo.callCreateClient(e.getId(), c.getPersonnumber());
//   }
//   
//   public void deleteClient(Employee e,Client c){
//       repo.callDeleteClient(e.getId(), c.getId());
//   }
//   
//   public void updateInfo(Client c,int PIN,String name,String address,String telephont){
//       repo.callUpdateInfo(c.getId(), PIN, name, address, telephont);
//   }
//   
//   public void assignAccount(Employee e,Client c,int accountNumber){
//       repo.callAssignAccount(e.getId(), c.getId(), accountNumber);
//   }
//   
//   public void endAccount(Employee e,Client c,Account a){
//       
//   }
//   
//   public void depositAmount(Employee e,Client c,Account a,int amount){
//       repo.callDeposit(e.getId(), c.getId(), a.getId(), amount);
//   }
//   
//   public void withdrawAmount(Employee e,Client c,Account a,int amount){
//       repo.callWithdraw(e.getId(), c.getId(), a.getId(), amount);
//   }
//   
//   public void setAccountRate(Employee e,Client c,Account a,double rate){
//       repo.callSetAccountRate(e.getId(), c.getId(), a.getId(), rate);
//   }
//   
//   public void grantLoan(Employee e,Client c,Loan l){
//       repo.callGrantLoan(e.getId(), c.getId(), l.getId());
//       
//   }
//   
//   public void setLoanRate(Employee e,Client c,Loan l,double rate){
//       repo.callSetLoanRate(e.getId(), c.getId(), l.getId(), rate);
//   }
//   
//   public double showVinstOfLoan(Loan l){
//       return repo.callVinstOfLoan(l.getId());
//   }
//   
//   public double showPayOffMonth(Loan l){
//       return repo.callPayOffMonth(l.getId());
//   }
//   
//   public int caculatePeriod(String datefram,String dateto){
//       
//   }
   
   
}
