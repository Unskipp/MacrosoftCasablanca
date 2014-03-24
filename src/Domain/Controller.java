/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Datasource.DBFacade;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

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
    private ArrayList<Room> roomsList;

    public Controller()
    {
        dbf = DBFacade.getInstance();
        employeesList = new ArrayList<Employee>();
        clientsList = new ArrayList<Client>();
        facilitiesList = new ArrayList<Facility>();
        facilityReservationsList = new ArrayList<FacilityReservation>();
        reservationsList = new ArrayList<Reservation>();
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
        } else
        {
            roomsList = dbf.getAllRoomss();
            for (int i = 0; i < roomsList.size(); i++)
            {
                o = roomsList.get(i).toString();
                model.addElement(o);
            }
        }
        return model;
    }

}
