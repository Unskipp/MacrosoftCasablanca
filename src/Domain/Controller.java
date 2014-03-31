/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Datasource.DBFacade;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author Unskipp
 */
public class Controller
{

    private DBFacade dbf;
    private ArrayList<Employee> employeesList;
    private ArrayList<Client> clientsList;
    private ArrayList<Facility> facilitiesList;
    private ArrayList<FacilityReservation> facilityReservationsList;
    private ArrayList<Reservation> reservationsList;
    private ArrayList<RoomType> roomTypesList;
    private ArrayList<Room> roomsList;

    public Controller()
    {
        dbf = DBFacade.getInstance();
        employeesList = new ArrayList<Employee>();
        clientsList = new ArrayList<Client>();
        facilitiesList = new ArrayList<Facility>();
        facilityReservationsList = new ArrayList<FacilityReservation>();
        reservationsList = new ArrayList<Reservation>();
        roomTypesList = new ArrayList<RoomType>();
        roomsList = new ArrayList<Room>();
    }

    public DefaultListModel display(String frame)
    {
        Object o = new Object();
        DefaultListModel model = new DefaultListModel();

        if (frame.equals("Employees"))
        {
            employeesList = dbf.getAllEmployeess();
            for (int i = 0; i < employeesList.size(); i++)
            {
                o = employeesList.get(i).toString();
                model.addElement(o);
            }
        } else if (frame.equals("Clients"))
        {
            clientsList = dbf.getAllClientss();
            for (int i = 0; i < clientsList.size(); i++)
            {
                o = clientsList.get(i).toString();
                model.addElement(o);
            }
        } else if (frame.equals("Facilities"))
        {
            facilitiesList = dbf.getAllFacilities();
            for (int i = 0; i < facilitiesList.size(); i++)
            {
                o = facilitiesList.get(i).toString();
                model.addElement(o);
            }
        } else if (frame.equals("Reservations"))
        {
            reservationsList = dbf.getAllReservationss();
            for (int i = 0; i < reservationsList.size(); i++)
            {
                o = reservationsList.get(i).toString();
                model.addElement(o);
            }
        }else if (frame.equals("Rooms"))
        {
            roomsList = dbf.getAllRoomss();
            for (int i = 0; i < roomsList.size(); i++)
            {
                o = roomsList.get(i).toString();
                model.addElement(o);
            }
        }
        
        else
        {
            roomTypesList = dbf.getAllRoomTypes();
            for (int i = 0; i < roomTypesList.size(); i++)
            {
                o = roomTypesList.get(i).toString();
                model.addElement(o);
            }
        }
        return model;
    }

    public DefaultComboBoxModel getAllroomsType()
    {
        roomTypesList = dbf.getAllRoomTypes();

        Object o = new Object();
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        for (int i = 0; i < roomTypesList.size(); i++)
        {
            o = roomTypesList.get(i).getType().toString();
            model.addElement(o);
        }

        return model;
    }

    public String returnDataAboutSelectedRoom(String typeOfRoom)
    {
        String result = null;

        for (int i = 0; i < roomTypesList.size(); i++)
        {
            if (roomTypesList.get(i).getType().equals(typeOfRoom))
            {
                result = "Room type: " + roomTypesList.get(i).getType() + "\nPrice per night: " + Integer.toString(roomTypesList.get(i).getPrice())
                        + "\nCapacity: " + Integer.toString(roomTypesList.get(i).getCapacity());
            }
        }

        return result;
    }
    
    public int returnPriceAboutSelectedRoom(String typeOfRoom)
    {
        int result = 0;

        for (int i = 0; i < roomTypesList.size(); i++)
        {
            if (roomTypesList.get(i).getType().equals(typeOfRoom))
            {
                result = (roomTypesList.get(i).getPrice());
            }
        }

        return result;
    }

    public boolean isAvailable(Calendar from, Calendar until, String roomType)
    {

        boolean result = false;
        boolean found = false;
        roomsList = dbf.getAllRoomss();
        reservationsList = dbf.getAllReservationss();
        roomTypesList = dbf.getAllRoomTypes();
        int typeId=0;
        
        for (int i = 0; i < roomTypesList.size(); i++)
        {
           if(roomTypesList.get(i).getType().equals(roomType))
           {
               typeId=i;
               i=roomTypesList.size();
           };
        }
        
        for (int i = 0; i < roomsList.size(); i++)
        {
           
            if (roomsList.get(i).getType()== roomTypesList.get(typeId).getId())
            {
                for (int j = 0; j < reservationsList.size(); j++)
                {
                    if (roomsList.get(i).getId() == reservationsList.get(j).getRoomID())
                    {
                        found = true;
                        if (from.compareTo(reservationsList.get(j).getUntilDate()) == 1 || until.compareTo(reservationsList.get(j).getFromDate()) == -1)
                        {
                            result = true;
                            j = reservationsList.size();
                        }
                    }
                }
            }
        }
        // found = true if we have at least 1 reservation for the specified room type in the reservationsList
        if (found == false)
        {
            result = true;
        }
        return result;
    }

    public void getAllReservations()
    {
        reservationsList = dbf.getAllReservationss();
    }

    public void getAllRoomTypes()
    {
        roomTypesList = dbf.getAllRoomTypes();
    }

    public boolean delete(String type, int index)
    {
        if (type.equals("reservation"))
        {
            if (dbf.delete(type, reservationsList.get(index).getId()))
            {
                reservationsList.remove(index);
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }
    
    public boolean confirmPayment(double amount, int index)
    {
        return dbf.confirmPayment(amount, reservationsList.get(index).getId());
    }
}
