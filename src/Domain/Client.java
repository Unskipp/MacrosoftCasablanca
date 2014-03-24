/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author Unskipp
 */
public class Client
{

    private String id, firstName, lastName, address, country, email, travelAgency, password;
    private int phone,versionNumber;

    public Client(String id, String firsName, String lastName, String address, String country, String travelAgency, int phone,
            String email, String password,int versionNumber)
    {
        this.id = id;
        this.firstName = firsName;
        this.lastName = lastName;
        this.address = address;
        this.country = country;
        this.phone = phone;
        this.email = email;
        this.travelAgency = travelAgency;
        this.password = password;
        this.versionNumber=versionNumber;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getTravelAgency()
    {
        return travelAgency;
    }

    public void setTravelAgency(String travelAgency)
    {
        this.travelAgency = travelAgency;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public int getPhone()
    {
        return phone;
    }

    public void setPhone(int phone)
    {
        this.phone = phone;
    }

    public int getVersionNumber()
    {
        return versionNumber;
    }

    public void setVersionNumber(int versionNumber)
    {
        this.versionNumber = versionNumber;
    }

    @Override
    public String toString()
    {
        return "Clients{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }

    
    
}
