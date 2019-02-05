

package bankomat.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Client {
    
    private int personnumber;
    
    private int PIN;
    
    private String name;
    
    private String address;
    
    private String telephone;
    
    private static Map<Integer, Client> clients;
    
    
    public Client (int personnumber, int PIN, String name, String address, String telephone){
        this.personnumber = personnumber;
        this.PIN = PIN;
        this.name = name;
        this.address = address;
        this.telephone = telephone;   
    }
    
    public Client(int personnumber, int PIN) {
        this.personnumber = personnumber;
        this.PIN = PIN;
    }
    
    public Client (){}
    
    
    
    

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    public int getPersonnumber() {
        return personnumber;
    }

    public void setPersonnumber(int personnumber) {
        this.personnumber = personnumber;
    }
   
    public String ClientInfo() {
        return  "personnumber=" + personnumber + ", name=" + name + ", address=" + address + ", telephone=" + telephone ;
    }

    /**
     * @return the clients
     */
    public Map<Integer, Client> getClients() {
        return clients;
    }

    /**
     * @param aClients the clients to set
     */
    public void setClients(Map<Integer, Client> aClients) {
        clients = aClients;
    }
    
    public void printClients(){
        String content = this.clients.entrySet().stream().map(e -> e.getKey() 
                + " = " + e.getValue().getName()
                + ". Tel: " + e.getValue().getTelephone()).collect(Collectors.joining(".\n"));
        System.out.println(content);
        // System.out.println(Arrays.toString(this.clients.entrySet().toArray()));
        //clients.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);       
    }
    
}
