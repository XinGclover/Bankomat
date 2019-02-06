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
        Controller con=new Controller();
        
        repositoryTest rt=new repositoryTest();
//        System.out.println(rt.getAllCustomers().size());
//        System.out.println(rt.getAllClients().size());
//        System.out.println(rep.getAllAccounts().size());
//        System.out.println(rep.getAllHandleAccounts().size());
//        System.out.println(rep.getAllLoans().size());
//        rep.callClientWithdraw(1, 3, 300);

//        System.out.println(rep.getAllClients().get(0).getPersonnumber());
//        System.out.println(rep.getAllAccounts().size());
//        System.out.println(rep.getAllAccounts().get(0).getClientID());
        
         System.out.println(con.loadAccountsforClient(new Client(3)).size()); 
//         System.out.println(con.loadLoansforClient(new Client(1)).get(0).loanInfo());
//          System.out.println(rep.getAllClients().get(0).ClientInfo());
//          System.out.println(rep.getAllLoans().size());
         
//        rep.getAllAccounts();
//        System.out.println("\nAccounts:");
//        account.printAccounts();
//        
//        rep.getAllLoans();
//        System.out.println("\nLoans:");
//        loan.printLoans();
//        
//        rep.getAllLoans();
//        System.out.println("\nLoans:");
//        loan.printLoans();
//        
//        rep.getAllHandleAccounts();
//        System.out.println("\nHandleAccounts:");
//        handleAccount.printHandleAccount();
//        
//        System.out.println("\nprintAccountTest:");
//       Account aTest;
//       aTest = handleAccount.getAccountByAccountID(0);
//       System.out.println(aTest.getId() + ", " + aTest.getBalance());
//
//        System.out.println("\nprintClientTest:");
//       Client cTest;
//       cTest = handleAccount.getClientByClientID(0);
//       System.out.println(cTest.getId() + ", " + cTest.getName());
//       
    }

}
