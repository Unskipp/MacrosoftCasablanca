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
import javax.swing.table.DefaultTableModel;

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
    private String[] vect;
    private int assignedRoom;

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
        vect = null;

    }

    public DefaultTableModel display(String frame)
    {
        Object o = new Object();
        DefaultTableModel model = new DefaultTableModel();

        if (frame.equals("Employees"))
        {
            employeesList = dbf.getAllEmployeess();

            model = setHeader("Employees");
            vect = new String[4];

            for (int i = 0; i < employeesList.size(); i++)
            {
                vect[0] = employeesList.get(i).getId();
                vect[1] = employeesList.get(i).getFirstName();
                vect[2] = employeesList.get(i).getLastName();
                vect[3] = employeesList.get(i).getPosition();

                model.addRow(vect);
            }
        } else if (frame.equals("Clients"))
        {
            clientsList = dbf.getAllClientss();

            model = setHeader("Clients");
            vect = new String[3];

            for (int i = 0; i < clientsList.size(); i++)
            {
                vect[0] = clientsList.get(i).getId();
                vect[1] = clientsList.get(i).getFirstName();
                vect[2] = clientsList.get(i).getLastName();

                model.addRow(vect);
            }
        } else if (frame.equals("Facilities"))
        {
            facilitiesList = dbf.getAllFacilities();

            model = setHeader("Facilities");
            vect = new String[2];

            for (int i = 0; i < facilitiesList.size(); i++)
            {
                vect[0] = facilitiesList.get(i).getName();
                vect[1] = Integer.toString(facilitiesList.get(i).getPrice());

                model.addRow(vect);
            }
        } else if (frame.equals("Reservations"))
        {
            reservationsList = dbf.getAllReservationss();
            clientsList = dbf.getAllClientss();

            model = setHeader("Reservations");
            vect = new String[4];

            for (int i = 0; i < reservationsList.size(); i++)
            {
                for (int j = 0; j < clientsList.size(); j++)
                {
                    if (reservationsList.get(i).getClientID().equals(clientsList.get(j).getId()))
                    {
                        vect[0] = Integer.toString(reservationsList.get(i).getId());
                        vect[1] = clientsList.get(j).getId();
                        vect[2] = clientsList.get(j).getFirstName();
                        vect[3] = clientsList.get(j).getLastName();

                        model.addRow(vect);
                    }
                }
            }
        } else
        {
            roomsList = dbf.getAllRoomss();
            roomTypesList = dbf.getAllRoomTypes();

            model = setHeader("Rooms");
            vect = new String[4];

            for (int i = 0; i < roomsList.size(); i++)
            {
                for (int j = 0; j < roomTypesList.size(); j++)
                {
                    if (roomsList.get(i).getType() == roomTypesList.get(j).getId())
                    {
                        vect[0] = Integer.toString(roomsList.get(i).getId());
                        vect[1] = roomTypesList.get(j).getType();
                        vect[2] = Integer.toString(roomTypesList.get(j).getCapacity());
                        vect[3] = Integer.toString(roomTypesList.get(j).getPrice());

                        model.addRow(vect);
                    }
                }
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

        for (Room roomsList1 : roomsList)
        {
            if (roomsList1.getType() == roomTypesList.get(typeId).getId())
            {
                for (int j = 0; j < reservationsList.size(); j++)
                {
                    if (roomsList1.getId() == reservationsList.get(j).getRoomID())
                    {
                        found = true;
                        if (from.compareTo(reservationsList.get(j).getUntilDate()) == 1 || until.compareTo(reservationsList.get(j).getFromDate()) == -1)
                        {
                            assignedRoom = roomsList1.getId();
                        } else
                        {
                            availableRooms--;
                            j = reservationsList.size();
                        }
                    }
                }
                if (found == false)
                {
                    assignedRoom = roomsList1.getId();
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

    public DefaultTableModel setHeader(String criteria)
    {
        DefaultTableModel model = new DefaultTableModel();

        switch (criteria)
        {

            case "Reservations":
            {
                String[] title =
                {
                    "Reservation ID", "Client id", "First name", "Last name"
                };
                model.addColumn(title[0]);
                model.addColumn(title[1]);
                model.addColumn(title[2]);
                model.addColumn(title[3]);
            }
            break;
            case "Rooms":
            {
                String[] title =
                {
                    "ID", "Type", "Capacity", "Price"
                };

                model.addColumn(title[0]);
                model.addColumn(title[1]);
                model.addColumn(title[2]);
                model.addColumn(title[3]);
            }
            break;
            case "Facilities":
            {
                String[] title =
                {
                    "Name of facility", "Price"
                };
                model.addColumn(title[0]);
                model.addColumn(title[1]);
            }
            break;
            case "Clients":
            {
                String[] title =
                {
                    "Client id", "First name", "Last name"
                };

                model.addColumn(title[0]);
                model.addColumn(title[1]);
                model.addColumn(title[2]);
            }
            break;
            case "Employees":
            {
                String[] title =
                {
                    "ID", "First name", "Last name", "Position"
                };
                model.addColumn(title[0]);
                model.addColumn(title[1]);
                model.addColumn(title[2]);
                model.addColumn(title[3]);
            }
            break;
        }

        return model;
    }

    public DefaultTableModel searchBy(String valueOfSearch, Object valueOfCombobox, String frame)
    {
        Object o = new Object();
        valueOfSearch.toLowerCase();
        DefaultTableModel model = new DefaultTableModel();

        switch (frame)
        {
            case "Reservations":
            {
                if (valueOfCombobox.equals("ID"))
                {

                    model = setHeader("Reservations");
                    vect = new String[4];

                    for (int i = 0; i < reservationsList.size(); i++)
                    {
                        String temp = reservationsList.get(i).getClientID().toLowerCase();
                        for (int j = 0; j < clientsList.size(); j++)
                        {
                            if (temp.contains(valueOfSearch)
                                    && reservationsList.get(i).getClientID().toLowerCase().equals(clientsList.get(j).getId().toLowerCase()))
                            {
                                vect[0] = Integer.toString(reservationsList.get(i).getId());
                                vect[1] = clientsList.get(j).getId();
                                vect[2] = clientsList.get(j).getFirstName();
                                vect[3] = clientsList.get(j).getLastName();

                                model.addRow(vect);
                            }
                        }
                    }
                } else if (valueOfCombobox.equals("Reservation ID"))
                {
                    model = setHeader("Reservations");
                    vect = new String[4];

                    for (int i = 0; i < reservationsList.size(); i++)
                    {
                        String temp = Integer.toString(reservationsList.get(i).getId());
                        if (temp.contains(valueOfSearch))
                        {
                            for (int j = 0; j < clientsList.size(); j++)
                            {
                                if (reservationsList.get(i).getClientID().equals(clientsList.get(j).getId()))
                                {
                                    vect[0] = Integer.toString(reservationsList.get(i).getId());
                                    vect[1] = clientsList.get(j).getId();
                                    vect[2] = clientsList.get(j).getFirstName();
                                    vect[3] = clientsList.get(j).getLastName();

                                    model.addRow(vect);
                                }
                            }
                        }
                    }
                } else if (valueOfCombobox.equals("Name"))
                {
                    model = setHeader("Reservations");
                    vect = new String[4];

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
                                    vect[0] = Integer.toString(reservationsList.get(j).getId());
                                    vect[1] = clientsList.get(i).getId();
                                    vect[2] = clientsList.get(i).getFirstName();
                                    vect[3] = clientsList.get(i).getLastName();

                                    model.addRow(vect);
                                }
                            }
                        }
                    }
                }
            }
            break;
            case "Rooms":
            {
                if (valueOfCombobox.equals("ID"))
                {
                    model = setHeader("Rooms");
                    vect = new String[4];
                    valueOfSearch = valueOfSearch.toLowerCase();

                    for (int i = 0; i < roomsList.size(); i++)
                    {
                        if (Integer.parseInt(valueOfSearch) == roomsList.get(i).getId())
                        {
                            for (int j = 0; j < roomTypesList.size(); j++)
                            {
                                if (roomsList.get(i).getType() == roomTypesList.get(j).getId())
                                {
                                    vect[0] = Integer.toString(roomsList.get(i).getId());
                                    vect[1] = roomTypesList.get(j).getType();
                                    vect[2] = Integer.toString(roomTypesList.get(j).getCapacity());
                                    vect[3] = Integer.toString(roomTypesList.get(j).getPrice());

                                    model.addRow(vect);
                                }
                            }
                        }
                    }
                } else if (valueOfCombobox.equals("Price"))
                {
                    model = setHeader("Rooms");
                    vect = new String[4];

                    for (int i = 0; i < roomsList.size(); i++)
                    {
                        for (int j = 0; j < roomTypesList.size(); j++)
                        {
                            if (roomsList.get(i).getType() == roomTypesList.get(j).getId() && roomTypesList.get(j).getPrice() <= Integer.parseInt(valueOfSearch))
                            {
                                vect[0] = Integer.toString(roomsList.get(i).getId());
                                vect[1] = roomTypesList.get(j).getType();
                                vect[2] = Integer.toString(roomTypesList.get(j).getCapacity());
                                vect[3] = Integer.toString(roomTypesList.get(j).getPrice());

                                model.addRow(vect);
                            }
                        }
                    }
                } else if (valueOfCombobox.equals("Capacity"))
                {
                    model = setHeader("Rooms");
                    vect = new String[4];

                    for (int i = 0; i < roomsList.size(); i++)
                    {
                        for (int j = 0; j < roomTypesList.size(); j++)
                        {
                            if (roomsList.get(i).getType() == roomTypesList.get(j).getId() && roomTypesList.get(j).getCapacity() <= Integer.parseInt(valueOfSearch))
                            {
                                vect[0] = Integer.toString(roomsList.get(i).getId());
                                vect[1] = roomTypesList.get(j).getType();
                                vect[2] = Integer.toString(roomTypesList.get(j).getCapacity());
                                vect[3] = Integer.toString(roomTypesList.get(j).getPrice());

                                model.addRow(vect);
                            }
                        }
                    }
                }
            }
            break;
            case "Clients":
            {
                if (valueOfCombobox == "ID")
                {
                    model = setHeader("Clients");
                    vect = new String[3];

                    for (int i = 0; i < clientsList.size(); i++)
                    {
                        if (clientsList.get(i).getId().contains(valueOfSearch))
                        {
                            vect[0] = clientsList.get(i).getId();
                            vect[1] = clientsList.get(i).getFirstName();
                            vect[2] = clientsList.get(i).getLastName();

                            model.addRow(vect);
                        }
                    }
                } else if (valueOfCombobox == "Name")
                {
                    model = setHeader("Clients");
                    vect = new String[3];

                    valueOfSearch = valueOfSearch.toLowerCase();
                    for (int i = 0; i < clientsList.size(); i++)
                    {
                        String temp = clientsList.get(i).getFirstName().toLowerCase() + " "
                                + clientsList.get(i).getLastName().toLowerCase();
                        if (temp.contains(valueOfSearch))
                        {
                            vect[0] = clientsList.get(i).getId();
                            vect[1] = clientsList.get(i).getFirstName();
                            vect[2] = clientsList.get(i).getLastName();

                            model.addRow(vect);
                        }
                    }
                }
            }
            break;
            case "Facilities":
            {
                if (valueOfCombobox == "Type")
                {
                    model = setHeader("Facilities");
                    vect = new String[2];

                    valueOfSearch = valueOfSearch.toLowerCase();
                    for (int i = 0; i < facilitiesList.size(); i++)
                    {
                        if (facilitiesList.get(i).getName().toLowerCase().contains(valueOfSearch))
                        {
                            vect[0] = facilitiesList.get(i).getName();
                            vect[1] = Integer.toString(facilitiesList.get(i).getPrice());

                            model.addRow(vect);
                        }
                    }
                } else if (valueOfCombobox == "Price")
                {
                    model = setHeader("Facilities");
                    vect = new String[2];

                    for (int i = 0; i < facilitiesList.size(); i++)
                    {
                        if (facilitiesList.get(i).getPrice() <= Integer.parseInt(valueOfSearch))
                        {
                            vect[0] = facilitiesList.get(i).getName();
                            vect[1] = Integer.toString(facilitiesList.get(i).getPrice());

                            model.addRow(vect);
                        }
                    }
                }
            }
            break;
            case "Employees":
            {
                if (valueOfCombobox == "ID")
                {
                    model = setHeader("Employees");
                    vect = new String[4];

                    valueOfSearch = valueOfSearch.toLowerCase();

                    for (int i = 0; i < employeesList.size(); i++)
                    {
                        if (employeesList.get(i).getId().contains(valueOfSearch))
                        {
                            vect[0] = employeesList.get(i).getId();
                            vect[1] = employeesList.get(i).getFirstName();
                            vect[2] = employeesList.get(i).getLastName();
                            vect[3] = employeesList.get(i).getPosition();

                            model.addRow(vect);
                        }
                    }
                } else if (valueOfCombobox == "Name")
                {
                    model = setHeader("Employees");
                    vect = new String[4];

                    valueOfSearch = valueOfSearch.toLowerCase();

                    for (int i = 0; i < employeesList.size(); i++)
                    {
                        String temp = employeesList.get(i).getFirstName().toLowerCase() + " "
                                + employeesList.get(i).getLastName().toLowerCase();
                        if (temp.contains(valueOfSearch))
                        {
                            vect[0] = employeesList.get(i).getId();
                            vect[1] = employeesList.get(i).getFirstName();
                            vect[2] = employeesList.get(i).getLastName();
                            vect[3] = employeesList.get(i).getPosition();

                            model.addRow(vect);
                        }
                    }

                } else if (valueOfCombobox == "Position")
                {
                    model = setHeader("Employees");
                    vect = new String[4];

                    for (int i = 0; i < employeesList.size(); i++)
                    {
                        if (employeesList.get(i).getPosition().toLowerCase().contains(valueOfSearch))
                        {
                            vect[0] = employeesList.get(i).getId();
                            vect[1] = employeesList.get(i).getFirstName();
                            vect[2] = employeesList.get(i).getLastName();
                            vect[3] = employeesList.get(i).getPosition();

                            model.addRow(vect);
                        }
                    }
                }
            }
            break;
        }
        return model;
    }

    public DefaultTableModel searchByExactMatch(String valueOfSearch, Object valueOfCombobox, String frame)
    {
        Object o = new Object();
        valueOfSearch.toLowerCase();
        DefaultTableModel model = new DefaultTableModel();

        switch (frame)
        {
            case "Reservations":
            {
                if (valueOfCombobox.equals("ID"))
                {

                    model = setHeader("Reservations");
                    vect = new String[4];

                    for (int i = 0; i < reservationsList.size(); i++)
                    {
                        String temp = reservationsList.get(i).getClientID().toLowerCase();
                        for (int j = 0; j < clientsList.size(); j++)
                        {
                            if (temp.equals(valueOfSearch)
                                    && reservationsList.get(i).getClientID().toLowerCase().equals(clientsList.get(j).getId().toLowerCase()))
                            {
                                vect[0] = Integer.toString(reservationsList.get(i).getId());
                                vect[1] = clientsList.get(j).getId();
                                vect[2] = clientsList.get(j).getFirstName();
                                vect[3] = clientsList.get(j).getLastName();

                                model.addRow(vect);
                            }
                        }
                    }
                } else if (valueOfCombobox.equals("Reservation ID"))
                {
                    model = setHeader("Reservations");
                    vect = new String[4];

                    for (int i = 0; i < reservationsList.size(); i++)
                    {
                        String temp = Integer.toString(reservationsList.get(i).getId());
                        if (temp.equals(valueOfSearch))
                        {
                            for (int j = 0; j < clientsList.size(); j++)
                            {
                                if (reservationsList.get(i).getClientID().equals(clientsList.get(j).getId()))
                                {
                                    vect[0] = Integer.toString(reservationsList.get(i).getId());
                                    vect[1] = clientsList.get(j).getId();
                                    vect[2] = clientsList.get(j).getFirstName();
                                    vect[3] = clientsList.get(j).getLastName();

                                    model.addRow(vect);
                                }
                            }
                        }
                    }
                } else if (valueOfCombobox.equals("Name"))
                {
                    model = setHeader("Reservations");
                    vect = new String[4];

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
                                    vect[0] = Integer.toString(reservationsList.get(j).getId());
                                    vect[1] = clientsList.get(i).getId();
                                    vect[2] = clientsList.get(i).getFirstName();
                                    vect[3] = clientsList.get(i).getLastName();

                                    model.addRow(vect);
                                }
                            }
                        }
                    }
                }
            }
            break;
            case "Rooms":
            {
                if (valueOfCombobox.equals("ID"))
                {
                    model = setHeader("Rooms");
                    vect = new String[4];
                    valueOfSearch = valueOfSearch.toLowerCase();

                    for (int i = 0; i < roomsList.size(); i++)
                    {
                        if (Integer.parseInt(valueOfSearch) == roomsList.get(i).getId())
                        {
                            for (int j = 0; j < roomTypesList.size(); j++)
                            {
                                if (roomsList.get(i).getType() == roomTypesList.get(j).getId())
                                {
                                    vect[0] = Integer.toString(roomsList.get(i).getId());
                                    vect[1] = roomTypesList.get(j).getType();
                                    vect[2] = Integer.toString(roomTypesList.get(j).getCapacity());
                                    vect[3] = Integer.toString(roomTypesList.get(j).getPrice());

                                    model.addRow(vect);
                                }
                            }
                        }
                    }
                } else if (valueOfCombobox.equals("Price"))
                {
                    model = setHeader("Rooms");
                    vect = new String[4];

                    for (int i = 0; i < roomsList.size(); i++)
                    {
                        for (int j = 0; j < roomTypesList.size(); j++)
                        {
                            if (roomsList.get(i).getType() == roomTypesList.get(j).getId() && roomTypesList.get(j).getPrice() == Integer.parseInt(valueOfSearch))
                            {
                                vect[0] = Integer.toString(roomsList.get(i).getId());
                                vect[1] = roomTypesList.get(j).getType();
                                vect[2] = Integer.toString(roomTypesList.get(j).getCapacity());
                                vect[3] = Integer.toString(roomTypesList.get(j).getPrice());

                                model.addRow(vect);
                            }
                        }
                    }
                } else if (valueOfCombobox.equals("Capacity"))
                {
                    model = setHeader("Rooms");
                    vect = new String[4];

                    for (int i = 0; i < roomsList.size(); i++)
                    {
                        for (int j = 0; j < roomTypesList.size(); j++)
                        {
                          if (roomsList.get(i).getType() == roomTypesList.get(j).getId() && roomTypesList.get(j).getCapacity()== Integer.parseInt(valueOfSearch))
                            {
                                vect[0] = Integer.toString(roomsList.get(i).getId());
                                vect[1] = roomTypesList.get(j).getType();
                                vect[2] = Integer.toString(roomTypesList.get(j).getCapacity());
                                vect[3] = Integer.toString(roomTypesList.get(j).getPrice());

                                model.addRow(vect);
                            }
                        }
                    }
                }
            }
            break;
            case "Clients":
            {
                if (valueOfCombobox == "ID")
                {
                    model = setHeader("Clients");
                    vect = new String[3];

                    for (int i = 0; i < clientsList.size(); i++)
                    {
                        if (clientsList.get(i).getId().equals(valueOfSearch))
                        {
                            vect[0] = clientsList.get(i).getId();
                            vect[1] = clientsList.get(i).getFirstName();
                            vect[2] = clientsList.get(i).getLastName();

                            model.addRow(vect);
                        }
                    }
                } else if (valueOfCombobox == "Name")
                {
                    model = setHeader("Clients");
                    vect = new String[3];

                    valueOfSearch = valueOfSearch.toLowerCase();
                    for (int i = 0; i < clientsList.size(); i++)
                    {
                        String temp = clientsList.get(i).getFirstName().toLowerCase() + " "
                                + clientsList.get(i).getLastName().toLowerCase();
                        if (temp.equals(valueOfSearch))
                        {
                            vect[0] = clientsList.get(i).getId();
                            vect[1] = clientsList.get(i).getFirstName();
                            vect[2] = clientsList.get(i).getLastName();

                            model.addRow(vect);
                        }
                    }
                }
            }
            break;
            case "Facilities":
            {
                if (valueOfCombobox == "Type")
                {
                    model = setHeader("Facilities");
                    vect = new String[2];

                    valueOfSearch = valueOfSearch.toLowerCase();
                    for (int i = 0; i < facilitiesList.size(); i++)
                    {
                        if (facilitiesList.get(i).getName().toLowerCase().equals(valueOfSearch))
                        {
                            vect[0] = facilitiesList.get(i).getName();
                            vect[1] = Integer.toString(facilitiesList.get(i).getPrice());

                            model.addRow(vect);
                        }
                    }
                } else if (valueOfCombobox == "Price")
                {
                    model = setHeader("Facilities");
                    vect = new String[2];

                    for (int i = 0; i < facilitiesList.size(); i++)
                    {
                        if (facilitiesList.get(i).getPrice() == Integer.parseInt(valueOfSearch))
                        {
                            vect[0] = facilitiesList.get(i).getName();
                            vect[1] = Integer.toString(facilitiesList.get(i).getPrice());

                            model.addRow(vect);
                        }
                    }
                }
            }
            break;
            case "Employees":
            {
                if (valueOfCombobox == "ID")
                {
                    model = setHeader("Employees");
                    vect = new String[4];

                    valueOfSearch = valueOfSearch.toLowerCase();

                    for (int i = 0; i < employeesList.size(); i++)
                    {
                        if (employeesList.get(i).getId().equals(valueOfSearch))
                        {
                            vect[0] = employeesList.get(i).getId();
                            vect[1] = employeesList.get(i).getFirstName();
                            vect[2] = employeesList.get(i).getLastName();
                            vect[3] = employeesList.get(i).getPosition();

                            model.addRow(vect);
                        }
                    }
                } else if (valueOfCombobox == "Name")
                {
                    model = setHeader("Employees");
                    vect = new String[4];

                    valueOfSearch = valueOfSearch.toLowerCase();

                    for (int i = 0; i < employeesList.size(); i++)
                    {
                        String temp = employeesList.get(i).getFirstName().toLowerCase() + " "
                                + employeesList.get(i).getLastName().toLowerCase();
                        if (temp.equals(valueOfSearch))
                        {
                            vect[0] = employeesList.get(i).getId();
                            vect[1] = employeesList.get(i).getFirstName();
                            vect[2] = employeesList.get(i).getLastName();
                            vect[3] = employeesList.get(i).getPosition();

                            model.addRow(vect);
                        }
                    }

                } else if (valueOfCombobox == "Position")
                {
                    model = setHeader("Employees");
                    vect = new String[4];

                    for (int i = 0; i < employeesList.size(); i++)
                    {
                        if (employeesList.get(i).getPosition().toLowerCase().equals(valueOfSearch))
                        {
                            vect[0] = employeesList.get(i).getId();
                            vect[1] = employeesList.get(i).getFirstName();
                            vect[2] = employeesList.get(i).getLastName();
                            vect[3] = employeesList.get(i).getPosition();

                            model.addRow(vect);
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
                System.out.println(reservationsList.get(i).getId());
                if (Integer.parseInt(input) == reservationsList.get(i).getId())
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
            if (input.equals(clientsList.get(i).getId()))
            {
                return clientsList.get(i).getFirstName() + " " + clientsList.get(i).getLastName() + ", Phone Nr.: " + clientsList.get(i).getPhone();
            }
        }
        return "Could't select client.";
    }

    public boolean saveNewRoomReservation(int roomId, String roomType, int resId, String resPayed, int deposit, int amountPayed,
            Date fromDate, Date untilDate, String clientId)
    {

        Calendar d1 = Calendar.getInstance();
        d1.setTime(fromDate);
        Calendar d2 = Calendar.getInstance();
        d1.setTime(untilDate);
        String roomTypeString = null;
        for (int i = 0; i < roomTypesList.size(); i++)
        {
            if (roomTypesList.get(i).getId() == getRoomTypeAsInt(roomType))
            {
                roomTypeString = roomTypesList.get(i).getType();
                i = roomTypesList.size();
            }
        }
        if (isAvailable(d1, d2, roomTypeString))
        {
            Room room = new Room(roomId, getRoomTypeAsInt(roomType), 1);
            Reservation reservation = new Reservation(resId, resPayed, deposit, amountPayed, 1, clientId, fromDate, untilDate, roomId);
            return dbf.saveNewRoomReservation(reservation, room);
        }
        return false;
    }

    private int getRoomTypeAsInt(String roomType)
    {
        if (roomType.equals("Family room"))
        {
            return 1;
        } else if (roomType.equals("Single room"))
        {
            return 2;
        } else
        {
            return 3;
        }
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

    public boolean roomIsAvailable(int assignedRoom, Calendar from, Calendar until)
    {
        getAllReservations();
        for (int j = 0; j < reservationsList.size(); j++)
        {
            if (assignedRoom == reservationsList.get(j).getRoomID())
            {
                if (!(from.compareTo(reservationsList.get(j).getUntilDate()) == 1 || until.compareTo(reservationsList.get(j).getFromDate()) == -1))
                {
                    return false;
                }
            }

        }
        return true;
    }
}
