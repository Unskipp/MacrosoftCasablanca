/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Datasource.DBFacade;
import java.sql.Date;
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
            clientsList = dbf.getAllClientss();
            for (int i = 0; i < reservationsList.size(); i++)
            {
                for (int j = 0; j < clientsList.size(); j++)
                {
                    if (reservationsList.get(i).getClientID().equals(clientsList.get(j).getId()))
                    {
                        o = clientsList.get(j).toString() + reservationsList.get(i).toString();
                        model.addElement(o);
                    }
                }
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

    int assignedRoom;
    public int getAssignedRoom()
    {
        return assignedRoom;
    }
    public boolean isAvailable(Calendar from, Calendar until, String roomType)
    {

        boolean result = false;
        boolean found = false;
        roomsList = dbf.getAllRoomss();
        reservationsList = dbf.getAllReservationss();
        roomTypesList = dbf.getAllRoomTypes();
        int typeId = 0;
        int availableRooms = 0;

        for (int i = 0; i < roomTypesList.size(); i++)
        {
            if (roomTypesList.get(i).getType().equals(roomType))
            {
                typeId = i;
                i = roomTypesList.size();
            }
        }

        for (int i = 0; i < roomsList.size(); i++)
        {
            if (roomsList.get(i).getType() == roomTypesList.get(typeId).getId())
            {
                availableRooms++;
            }
        }

        for (int i = 0; i < roomsList.size(); i++)
        {

            if (roomsList.get(i).getType() == roomTypesList.get(typeId).getId())
            {
                for (int j = 0; j < reservationsList.size(); j++)
                {
                    if (roomsList.get(i).getId() == reservationsList.get(j).getRoomID())
                    {
                        found = true;
                        if (from.compareTo(reservationsList.get(j).getUntilDate()) == 1 || until.compareTo(reservationsList.get(j).getFromDate()) == -1)
                        {
                            assignedRoom = roomsList.get(i).getId();

                        } else
                        {
                            availableRooms--;
                            j = reservationsList.size();
                        }
                    }
                }
                if(found == false)
                {
                    assignedRoom = roomsList.get(i).getId();
                }
                found = false;
            }
        }
        // found = true if we have at least 1 reservation for the specified room type in the reservationsList
        if (availableRooms == 0)
        {
            result = false;
        } else
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

    public DefaultListModel searchBy(String valueOfSearch, Object valueOfCombobox, String frame)
    {
        Object o = new Object();
        valueOfSearch.toLowerCase();
        DefaultListModel model = new DefaultListModel();

        switch (frame)
        {
            case "Reservations":
            {
                if (valueOfCombobox.equals("Client ID"))
                {
                    for (int i = 0; i < reservationsList.size(); i++)
                    {
                        String temp = reservationsList.get(i).getClientID().toLowerCase();
                        for (int j = 0; j < clientsList.size(); j++)
                        {
                            if (temp.contains(valueOfSearch)
                                    && reservationsList.get(i).getClientID().toLowerCase().equals(clientsList.get(j).getId().toLowerCase()))
                            {
                                o = clientsList.get(j).toString() + reservationsList.get(i).toString();
                                model.addElement(o);
                            }
                        }
                    }
                } else if (valueOfCombobox.equals("Reservation ID"))
                {
                    for (int i = 0; i < reservationsList.size(); i++)
                    {
                        String temp = Integer.toString(reservationsList.get(i).getId());
                        if (temp.contains(valueOfSearch))
                        {
                            for (int j = 0; j < clientsList.size(); j++)
                            {
                                if (reservationsList.get(i).getClientID().equals(clientsList.get(j).getId()))
                                {
                                    o = clientsList.get(j).toString() + reservationsList.get(i).toString();
                                    model.addElement(o);
                                }
                            }
                        }
                    }
                } else if (valueOfCombobox.equals("Client name"))
                {
                    valueOfSearch = valueOfSearch.toLowerCase();
                    for (int i = 0; i < clientsList.size(); i++)
                    {
                        String temp = clientsList.get(i).getFirstName().toLowerCase() + " "
                                + clientsList.get(i).getLastName().toLowerCase();
                        if (temp.contains(valueOfSearch))
                        {
                            for (int j = 0; j < reservationsList.size(); j++)
                            {
                                if (clientsList.get(i).getId().equals(reservationsList.get(j).getClientID()))
                                {
                                    o = clientsList.get(i).toString() + reservationsList.get(j).toString();
                                    model.addElement(o);
                                }
                            }
                        }
                    }
                }
            }
            break;
        }
        return model;
    }

    public DefaultListModel searchByExactMatch(String valueOfSearch, Object valueOfCombobox, String frame)
    {
        Object o = new Object();
        valueOfSearch.toLowerCase();
        DefaultListModel model = new DefaultListModel();

        switch (frame)
        {
            case "Reservations":
            {
                if (valueOfCombobox.equals("Client ID"))
                {
                    for (int i = 0; i < reservationsList.size(); i++)
                    {
                        String temp = reservationsList.get(i).getClientID().toLowerCase();
                        for (int j = 0; j < clientsList.size(); j++)
                        {
                            if (temp.equals(valueOfSearch)
                                    && reservationsList.get(i).getClientID().toLowerCase().equals(clientsList.get(j).getId().toLowerCase()))
                            {
                                o = clientsList.get(j).toString() + reservationsList.get(i).toString();
                                model.addElement(o);
                            }
                        }
                    }
                } else if (valueOfCombobox.equals("Reservation ID"))
                {
                    for (int i = 0; i < reservationsList.size(); i++)
                    {
                        String temp = Integer.toString(reservationsList.get(i).getId());
                        if (temp.equals(valueOfSearch))
                        {
                            for (int j = 0; j < clientsList.size(); j++)
                            {
                                if (reservationsList.get(i).getClientID().equals(clientsList.get(j).getId()))
                                {
                                    o = clientsList.get(j).toString() + reservationsList.get(i).toString();
                                    model.addElement(o);
                                }
                            }
                        }
                    }
                } else if (valueOfCombobox.equals("Client name"))
                {
                    valueOfSearch = valueOfSearch.toLowerCase();
                    for (int i = 0; i < clientsList.size(); i++)
                    {
                        String temp = clientsList.get(i).getFirstName().toLowerCase() + " "
                                + clientsList.get(i).getLastName().toLowerCase();
                        if (temp.equals(valueOfSearch))
                        {
                            for (int j = 0; j < reservationsList.size(); j++)
                            {
                                if (clientsList.get(i).getId().equals(reservationsList.get(j).getClientID()))
                                {
                                    o = clientsList.get(i).toString() + reservationsList.get(j).toString();
                                    model.addElement(o);
                                }
                            }
                        }
                    }
                }
            }
            break;
        }

        return model;
    }

    public boolean delete(String type, String input)
    {
        if (type.equals("reservation"))
        {
            for (int i = 0; i < reservationsList.size(); i++)
            {
                if (input.contains(reservationsList.get(i).getClientID())
                        && input.contains(Integer.toString(reservationsList.get(i).getId())))
                {
                    if (dbf.delete(type, reservationsList.get(i).getId()))
                    {
                        reservationsList.remove(i);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean saveNewClient(String id, String firstName, String lastName, String address, String country, String travelAgency, int phone,
            String email, String password)
    {
        int versionNumber = 1;
        return dbf.saveNewClient(new Client(id, firstName, lastName, address, country, travelAgency, phone, email, password, versionNumber));
    }

    public boolean confirmPayment(double amount, int index)
    {
        return dbf.confirmPayment(amount, reservationsList.get(index).getId());
    }

    public String chosenClient(String input)
    {
        clientsList = dbf.getAllClientss();
        for (int i = 0; i < clientsList.size(); i++)
        {
            if (input.contains(clientsList.get(i).getId()))
            {
                return clientsList.get(i).getFirstName() + " " + clientsList.get(i).getLastName() + ", Phone Nr.: " + clientsList.get(i).getPhone();
            }
        }
        return "Could't select client.";
    }

    public boolean saveNewRoomReservation(int roomId, int roomType, int resId, String resPayed, int deposit, int amountPayed,
            Date fromDate, Date untilDate, String clientId)
    {
        Room room = new Room(roomId, roomType, 1);
        Reservation reservation = new Reservation(resId, resPayed, deposit, amountPayed, 1, clientId, fromDate, untilDate, roomId);
        return dbf.saveNewRoomReservation(reservation, room);
    }

    public String getClientId(String input)
    {
        clientsList = dbf.getAllClientss();
        for (int i = 0; i < clientsList.size(); i++)
        {
            if (input.contains(clientsList.get(i).getId()))
            {
                return clientsList.get(i).getId();
            }
        }
        return "Could't select client.";
    }

  
}
