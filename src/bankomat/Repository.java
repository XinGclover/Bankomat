package bankomat;


import bankomat.model.Account;
import bankomat.model.Client;
import bankomat.model.Loan;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;


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
    
    
    
    // Kunden ska kunna logga in med personnummer och PIN
    public int getClientIdByPersonnummerAndPIN(int personnummer, int pin){

        String query = "select id from Kund where personnummer = ? and pin = ?";
        ResultSet rs;
        int id = -1;
        
        try(Connection con = DriverManager.getConnection(p.getProperty("connectionString"), 
            p.getProperty("name"), p.getProperty("password"));
            PreparedStatement stmt = con.prepareStatement(query);
                ){
            stmt.setInt(1, personnummer);
            stmt.setInt(2, pin);
            rs = stmt.executeQuery();
            
            while (rs.next()){
                id = rs.getInt("id");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }  
        return id;
    }
    

    public Map<Integer, Client> getAllClients(){
        Client client = new Client();
        Map<Integer, Client> clients = new HashMap<Integer, Client>();
        try(Connection con = DriverManager.getConnection(p.getProperty("connectionString"), 
            p.getProperty("name"), p.getProperty("password"));
            Statement stmt = con.createStatement();){
            
            ResultSet rs = stmt.executeQuery("select idKund, personnummer, "
                    + "pin, namn, address, telefon from Kund");
            
            while(rs.next()){
                int id = rs.getInt("idKund");
                client = new Client(rs.getInt("personnummer"), rs.getInt("pin"),
                        rs.getString("namn"), rs.getString("address"), rs.getString("telefon"));
                clients.put(id,client);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        client.setClients(clients);
        return clients;
    }
    
    
    public Map<Integer, Account> getAllAccounts(){
        Account account = new Account();
        Map<Integer, Account> accounts = new HashMap<Integer, Account>();
        boolean avsluta;
        
        try(Connection con = DriverManager.getConnection(p.getProperty("connectionString"), 
            p.getProperty("name"), p.getProperty("password"));
            Statement stmt = con.createStatement();){
            
            ResultSet rs = stmt.executeQuery("select idKonto, number, "
                    + "kundId, saldo, sparaRantesats, avsluta from Konto");
            
            while(rs.next()){
                int id = rs.getInt("idKonto");
                if (rs.getInt("avsluta") == 1){
                    avsluta = true;
                } else
                    avsluta = false;
                
                account = new Account(rs.getInt("number"),
                        rs.getInt("kundId"), rs.getInt("saldo"), 
                        rs.getDouble("sparaRantesats"), avsluta);
                accounts.put(id,account);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        account.setAccounts(accounts);
        return accounts;
    }
    
    
    public Map<Integer, Loan> getAllLoans(){
        Loan loan = new Loan();
        Map<Integer, Loan> loans = new HashMap<Integer, Loan>();
        boolean bevilja;
        
        try(Connection con = DriverManager.getConnection(p.getProperty("connectionString"), 
            p.getProperty("name"), p.getProperty("password"));
            Statement stmt = con.createStatement();){
            
            ResultSet rs = stmt.executeQuery("select idLan, LanNumber, "
                    + "kundId, lanAntal, lanRantesats, betalplan, bevilja from Lan");
            
            while(rs.next()){
                int id = rs.getInt("idLan");
                if (rs.getInt("bevilja") == 1){
                    bevilja = true;
                } else
                    bevilja = false;
                
                loan = new Loan(rs.getInt("LanNumber"),
                        rs.getInt("kundId"), rs.getInt("lanAntal"), 
                        rs.getDouble("lanRantesats"), rs.getDate("betalplan"), bevilja);
                loans.put(id,loan);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        loan.setLoans(loans);
        return loans;
    }
}
