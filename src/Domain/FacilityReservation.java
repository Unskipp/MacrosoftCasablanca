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
public class FacilityReservation
{
    private int facID,clientID,duration;
    
    public FacilityReservation()
    {
        facID=0;
        clientID=0;
        duration=0;
    }

    public int getFacID()
    {
        return facID;
    }

    public void setFacID(int facID)
    {
        this.facID = facID;
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
    
}
