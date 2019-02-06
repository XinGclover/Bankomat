/*
 *  
Java18-OOJ
 */
package bankomat;

import bankomat.model.Client;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author xingao
 */
public class repositoryTest {
    private Properties p= new Properties();
    
    public repositoryTest(){
        try {
            p.load(new FileInputStream("src/bankomat/Settings.properties"));
//            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public List<Client> getAllClients(){
        Client client = new Client();
        List<Client> clients = new ArrayList();
        try(Connection con = DriverManager.getConnection(p.getProperty("connectionString"), 
            p.getProperty("name"), p.getProperty("password"));
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery("select idKund, personnummer,pin, namn, address, telefon from Kund");){
            
            while(rs.next()){
                client = new Client(rs.getInt("idKund"), rs.getInt("personnummer"), rs.getInt("pin"),
                        rs.getString("namn"), rs.getString("address"), rs.getString("telefon"));
                clients.add(client);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        client.setClients(clients);
        return clients;
    }
 
    
    
    public List<Client> getAllCustomers(){
        Client client = new Client();
        List<Client> clients = new ArrayList<>();
        String query="select idKund, personnummer,pin, namn, address, telefon from Kund";
        
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("username"),
                             p.getProperty("password"));
            Statement stmt = con.createStatement();
            ResultSet rs =stmt.executeQuery(query);){
            while (rs.next()) {
               client = new Client(rs.getInt("idKund"), rs.getInt("personnummer"), rs.getInt("pin"),
                        rs.getString("namn"), rs.getString("address"), rs.getString("telefon"));
                clients.add(client);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return clients;
    }
}
