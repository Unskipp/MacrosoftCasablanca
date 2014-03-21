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
    private int id,amountPayed,deposit,clientID,duration;
    private boolean payed;
    //DATE ??? 
    public Reservations()
    {
        id=0;
        amountPayed=0;
        deposit=0;
        clientID=0;
        duration=0;
        payed=false;
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

    public int getClientID()
    {
        return clientID;
    }

    public void setClientID(int clientID)
    {
        this.clientID = clientID;
    }

    public int getDuration()
    {
        return duration;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
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
