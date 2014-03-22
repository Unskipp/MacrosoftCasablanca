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
public class Reservations
{
    private int id,amountPayed,deposit,versionNumber;
    private String clientID;
    private boolean payed;

    //DATE ???
    public Reservations(int id, boolean payed,int deposit, int amountPayed,  int versionNumber, String clientID)
    {
        this.id = id;
        this.amountPayed = amountPayed;
        this.deposit = deposit;
        this.versionNumber = versionNumber;
        this.clientID = clientID;
        this.payed = payed;
    }

    public int getVersionNumber()
    {
        return versionNumber;
    }

    public void setVersionNumber(int versionNumber)
    {
        this.versionNumber = versionNumber;
    }

    public String getClientID()
    {
        return clientID;
    }

    public void setClientID(String clientID)
    {
        this.clientID = clientID;
    }
    
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getAmountPayed()
    {
        return amountPayed;
    }

    public void setAmountPayed(int amountPayed)
    {
        this.amountPayed = amountPayed;
    }

    public int getDeposit()
    {
        return deposit;
    }

    public void setDeposit(int deposit)
    {
        this.deposit = deposit;
    }

    public boolean isPayed()
    {
        return payed;
    }

    public void setPayed(boolean payed)
    {
        this.payed = payed;
    }
    
}
