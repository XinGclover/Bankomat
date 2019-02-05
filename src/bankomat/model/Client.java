/*
 *  
Java18-OOJ
 */
package bankomat.model;

/**
 *
 * @author xingao
 */
public class Client {
    
    private int personnumber;
    
    private int PIN;
    
    private int Id;
    
    private String name;
    
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String telephone;

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


    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }


    public Client(int personnumber, int PIN) {
        this.personnumber = personnumber;
        this.PIN = PIN;
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

    
}
