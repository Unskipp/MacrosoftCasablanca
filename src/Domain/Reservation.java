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
public class Reservation
{
    private int roomId,amountPayed,deposit,versionNumber;
    private String clientID;
    private String payed;

    //DATE ???
    public Reservation(int id, String payed,int deposit, int amountPayed,  int versionNumber,String clientID)
    {
        this.roomId = id;
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
    
    public int getRoomId()
    {
        return roomId;
    }

    public void setRoomId(int id)
    {
        this.roomId = id;
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

    public String getPayed()
    {
        return payed;
    }

    public void setPayed(String payed)
    {
        this.payed = payed;
    }

    @Override
    public String toString()
    {
        return "Reservations{" + "clientID=" + clientID + '}';
    }
    
    
}
