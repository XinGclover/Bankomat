/*
 *  
Java18-OOJ
 */

package bankomat;

import bankomat.model.Account;
import bankomat.model.Client;
import bankomat.model.HandleAccount;
import bankomat.model.Loan;
import java.util.ArrayList;
import java.util.List;


public class Bankomat {

  
    public static void main(String[] args) {
       
//       List<Client> clients=new ArrayList<>();
//       Client c1=new Client(10003,123);
//       Client c2=new Client(20004,124);
//       clients.add(c2);
//       clients.add(c1);
//       
//        ClientLogInGui cgui=new ClientLogInGui();
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ClientLogInGui().setVisible(true);
//            }
//        });
       
        Repository rep = new Repository();
        Client client = new Client();
        Account account = new Account();
        Loan loan = new Loan();
        HandleAccount handleAccount = new HandleAccount();
        
        rep.getAllClients();
        System.out.println("Clients:");
        client.printClients();
        
        rep.getAllAccounts();
        System.out.println("\nAccounts:");
        account.printAccounts();
        
        rep.getAllLoans();
        System.out.println("\nLoans:");
        loan.printLoans();
        
        rep.getAllLoans();
        System.out.println("\nLoans:");
        loan.printLoans();
        
        rep.getAllHandleAccounts();
        System.out.println("\nHandleAccounts:");
        handleAccount.printHandleAccount();
        
        


    }

}
