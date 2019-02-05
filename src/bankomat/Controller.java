/*
 *  
Java18-OOJ
 */
package bankomat;

import bankomat.model.Account;
import bankomat.model.Client;
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
   
   
   public Map<Integer,Account> loadAccountsforClient(Client c){
       Map<Integer,Account> accountsMap=repo.getAllAccount().stream().filter(a->a.getId()=c.getId()).
               collect(Collectors.toMap(Account::getId, Account->Account));
   }
   
}
