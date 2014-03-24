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
    private String clientID,facilityName,startingDate,endingDate;
    private int versionNumber;

    public FacilityReservation(String clientID, String facilityName, String startingDate,String endingDate,int versionNumber)
    {
        this.clientID = clientID;
        this.facilityName = facilityName;
        this.versionNumber = versionNumber;
        this.startingDate=startingDate;
        this.endingDate=endingDate;
    }

    public String getStartingDate()
    {
        return startingDate;
    }

    public void setStartingDate(String startingDate)
    {
        this.startingDate = startingDate;
    }

    public String getEndingDate()
    {
        return endingDate;
    }

    public void setEndingDate(String endingDate)
    {
        this.endingDate = endingDate;
    }
    
    public String getClientID()
    {
        return clientID;
    }

    public void setClientID(String clientID)
    {
        this.clientID = clientID;
    }

    public String getFacilityName()
    {
        return facilityName;
    }

    public void setFacilityName(String facilityName)
    {
        this.facilityName = facilityName;
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
        return "FacilityReservation{" + "clientID=" + clientID + ", facilityName=" + facilityName + '}';
    }
    
    
}