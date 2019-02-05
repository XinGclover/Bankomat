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
       List<Account> accountsofClient=(List<Account>) repo.getAllAccounts().values();
            
       return accountsofClient;
   }
   
   
}
