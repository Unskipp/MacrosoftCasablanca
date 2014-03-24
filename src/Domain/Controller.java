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
    private ArrayList<RoomType> roomsList;

    public Controller()
    {
        dbf = DBFacade.getInstance();
        employeesList = new ArrayList<Employee>();
        clientsList = new ArrayList<Client>();
        facilitiesList = new ArrayList<Facility>();
        facilityReservationsList = new ArrayList<FacilityReservation>();
        reservationsList = new ArrayList<Reservation>();
        roomsList = new ArrayList<RoomType>();
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
        } else
        {
            roomsList = dbf.getAllRoomTypes();
            for (int i = 0; i < roomsList.size(); i++)
            {
                o = roomsList.get(i).toString();
                model.addElement(o);
            }
        }
        return model;
    }

    public DefaultComboBoxModel getAllroomsType()
    {
        roomsList = dbf.getAllRoomTypes();

        Object o = new Object();
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        for (int i = 0; i < roomsList.size(); i++)
        {
            o = roomsList.get(i).getType().toString();
            model.addElement(o);
        }

        return model;
    }

    public String returnDataAboutSelectedRoom(String typeOfRoom)
    {
        String result = null;

        for (int i = 0; i < roomsList.size(); i++)
        {
            if (roomsList.get(i).getType().equals(typeOfRoom))
            {
                result = "Room type: " + roomsList.get(i).getType() + "\nPrice per night: " + Integer.toString(roomsList.get(i).getPrice())
                        + "\nCapacity: " + Integer.toString(roomsList.get(i).getCapacity());
            }
        }

        return result;
    }

    public boolean isAvailable(Calendar from, Calendar until, String roomType)
    {

        boolean result = false;
        boolean found = false;
        for (int i = 0; i < roomsList.size(); i++)
        {
            if (roomsList.get(i).getType().equals(roomType))
            {
                for (int j = 0; j < reservationsList.size(); j++)
                {
                    if (roomsList.get(i).getId() == reservationsList.get(j).getRoomID())
                    {
                        found=true;
                        if (from.compareTo(reservationsList.get(j).getUntilDate()) == 1 || until.compareTo(reservationsList.get(j).getFromDate()) == -1)
                        {
                            result = true;
                        }
                    }
                }
            }
        }
        if (found==false) result = true;
        return result;
    }

    public void getAllReservations()
    {
        reservationsList = dbf.getAllReservationss();
    }

    public void getAllRoomTypes()
    {
        roomsList = dbf.getAllRoomTypes();
    }
}
