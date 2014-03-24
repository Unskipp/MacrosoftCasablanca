/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Domain;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author Unskipp
 */
public class Reservation
{
    private int amountPayed,deposit,versionNumber, id,roomID;
    private String clientID;
    private String payed;
    private Calendar fromDate,untilDate;

    //DATE ???
    public Reservation(int id, String payed,int deposit, int amountPayed,  int versionNumber,String clientID,Date fromDate,Date untilDate,int roomID)
    {
        this.id = id;
        this.amountPayed = amountPayed;
        this.deposit = deposit;
        this.versionNumber = versionNumber;
        this.clientID = clientID;
        this.payed = payed;
        this.fromDate=Calendar.getInstance();
        this.fromDate.setTime(fromDate);
        this.untilDate=Calendar.getInstance();
        this.untilDate.setTime(untilDate);
        this.roomID=roomID;
    }

    public int getRoomID()
    {
        return roomID;
    }

    public void setRoomID(int roomID)
    {
        this.roomID = roomID;
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

    public Calendar getFromDate()
    {
        return fromDate;
    }

    public void setFromDate(Calendar fromDate)
    {
        this.fromDate = fromDate;
    }

    public Calendar getUntilDate()
    {
        return untilDate;
    }

    public void setUntilDate(Calendar untilDate)
    {
        this.untilDate = untilDate;
    }
}
