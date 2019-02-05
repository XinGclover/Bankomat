package bankomat;


import bankomat.model.Account;
import bankomat.model.Client;
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
}
