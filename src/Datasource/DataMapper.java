/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datasource;

import Domain.Client;
import Domain.Employee;
import Domain.Facility;
import Domain.FacilityReservation;
import Domain.Reservation;
import Domain.Room;
import Domain.RoomType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Marek FURAK
 */
public class DataMapper
{

    public ArrayList<Employee> getEmployeessBy(Connection con, String searchCriteria, String value)
    {
        ArrayList<Employee> empList = new ArrayList<>();
        Employee emp = null;
        String SQLString1 = // get order
                "select * "
                + "from Employeess "
                + "where" + searchCriteria + "= ?";
        PreparedStatement statement = null;

        try
        {

            statement.setString(1, value);     // primary key value

            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                emp = new Employee(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6));
                empList.add(emp);
            }

        } catch (Exception e)
        {
            System.out.println("Fail in DataMapper - getEmployeesBy");
            System.out.println(e.getMessage());
        } finally														// must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in DataMapper - getEmployeesBy");
                System.out.println(e.getMessage());
            }
        }

        return empList;
    }

    public ArrayList<Employee> getAllEmployeess(Connection con)
    {
        ArrayList<Employee> empList = new ArrayList<>();
        Employee emp = null;
        String SQLString1 = // get order
                "select * "
                + "from Employees ";
        PreparedStatement statement = null;

        try
        {
            statement = con.prepareStatement(SQLString1);
            ResultSet rs = statement.executeQuery(SQLString1);
            while (rs.next())
            {
                emp = new Employee(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6));
                empList.add(emp);
            }

        } catch (Exception e)
        {
            System.out.println("Fail in DataMapper - getAllEmployeess");
            System.out.println(e.getMessage());
        } finally														// must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in DataMapper - getAllEmployeess");
                System.out.println(e.getMessage());
            }
        }
        return empList;
    }

    public ArrayList<Room> getRoomssBy(Connection con, String searchCriteria, String value)
    {
        ArrayList<Room> roomsList = new ArrayList<>();
        Room room = null;
        String SQLString1 = // get order
                "select *  "
                + "from rooms "
                + "where" + searchCriteria + "= ?";
        PreparedStatement statement = null;

        try
        {
            if (searchCriteria.equals("id"))
            {
                statement.setInt(1, Integer.parseInt(value));
            } else
            {
                statement.setString(1, value);     // primary key value
            }
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                room = new Room(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3)
                );
                roomsList.add(room);

            }

        } catch (Exception e)
        {
            System.out.println("Fail in DataMapper - getRoomsBy");
            System.out.println(e.getMessage());
        } finally														// must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in DataMapper - getRoomsBy");
                System.out.println(e.getMessage());
            }
        }
        return roomsList;
    }

    public ArrayList<Room> getAllRoomss(Connection con)
    {
        ArrayList<Room> roomsList = new ArrayList<>();
        Room room = null;
        String SQLString1 = // get order
                "select *  "
                + "from rooms ";
        PreparedStatement statement = null;

        try
        {
            statement = con.prepareStatement(SQLString1);
            ResultSet rs = statement.executeQuery(SQLString1);
            while (rs.next())
            {
                room = new Room(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3)
                );
                roomsList.add(room);

            }

        } catch (Exception e)
        {
            System.out.println("Fail in DataMapper - getAllRoomss");
            System.out.println(e.getMessage());
        } finally														// must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in DataMapper - getAllRoms");
                System.out.println(e.getMessage());
            }
        }
        return roomsList;
    }

    public ArrayList<Client> getClientssBy(Connection con, String searchCriteria, String value, String clientID)
    {
        ArrayList<Client> ClientsList = new ArrayList<>();
        Client Clients = null;
        String SQLString1 = // get order
                "select * "
                + "from Clients "
                + "where" + searchCriteria + "= ?";
        PreparedStatement statement = null;

        try
        {
            if (searchCriteria.equals("phone"))
            {
                statement.setInt(1, Integer.parseInt(value));
            } else
            {
                statement.setString(1, value);     // primary key value
            }
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                Clients = new Client(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10));
                ClientsList.add(Clients);

            }

        } catch (Exception e)
        {
            System.out.println("Fail in DataMapper - getClientsBy");
            System.out.println(e.getMessage());
        } finally														// must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in DataMapper - getRoomsBy");
                System.out.println(e.getMessage());
            }
        }
        return ClientsList;
    }

    public ArrayList<Client> getAllClientss(Connection con)
    {
        ArrayList<Client> clientsList = new ArrayList<>();
        Client client = null;
        String SQLString1 = // get order
                "select * "
                + "from Clients ";
        PreparedStatement statement = null;

        try
        {
            statement = con.prepareStatement(SQLString1);
            ResultSet rs = statement.executeQuery(SQLString1);
            while (rs.next())
            {
                client = new Client(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10));
                clientsList.add(client);

            }

        } catch (Exception e)
        {
            System.out.println("Fail in DataMapper - getAllClientss");
            System.out.println(e.getMessage());
        } finally														// must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in DataMapper - getAllClientss");
                System.out.println(e.getMessage());
            }
        }
        return clientsList;
    }

    public ArrayList<Reservation> getReservationssBy(Connection con, String searchCriteria, String value)
    {
        ArrayList<Reservation> reservationsList = new ArrayList<>();
        Reservation reservation = null;
        String SQLString1 = // get order
                "select   r.*, c.id, rr.starting_date, rr.ending_date,rr.room_id "
                + "from  clients c join clients_reservations cr on c.id = cr.client_id "
                + "join reservations r on cr.res_id = r.id "
                + "join room_reservations rr on rr.res_id = r.id "
                + "where" + searchCriteria + "=?";
        PreparedStatement statement = null;

        try
        {
            if (searchCriteria.equals("room.id") || searchCriteria.equals("r.id") || searchCriteria.equals("c.id"))
            {
                statement.setInt(1, Integer.parseInt(value));
            } else
            {
                statement.setString(1, value);     // primary key value
            }
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {

                reservation = new Reservation(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getDate(7),
                        rs.getDate(8),
                        rs.getInt(9)
                );
                reservationsList.add(reservation);

            }

        } catch (Exception e)
        {
            System.out.println("Fail in DataMapper - getReservationsBy");
            System.out.println(e.getMessage());
        } finally														// must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in DataMapper - getReservationsBy");
                System.out.println(e.getMessage());
            }
        }
        return reservationsList;
    }

    public ArrayList<Reservation> getAllReservationss(Connection con)
    {
        ArrayList<Reservation> reservationsList = new ArrayList<>();
        Reservation reservation = null;
        String SQLString1 = // get order
                "select   r.*, c.id, rr.starting_date, rr.ending_date,rr.room_id "
                + "from  clients c join clients_reservations cr on c.id = cr.client_id "
                + "join reservations r on cr.res_id = r.id "
                + "join room_reservations rr on rr.res_id = r.id";
        PreparedStatement statement = null;

        try
        {
            statement = con.prepareStatement(SQLString1);
            ResultSet rs = statement.executeQuery(SQLString1);
            while (rs.next())
            {
                reservation = new Reservation(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getDate(7),
                        rs.getDate(8),
                        rs.getInt(9)
                );
                reservationsList.add(reservation);

            }

        } catch (Exception e)
        {
            System.out.println("Fail in DataMapper - getAllReservationss");
            System.out.println(e.getMessage());
        } finally														// must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in DataMapper - getAllReservationss");
                System.out.println(e.getMessage());
            }
        }
        return reservationsList;
    }

    public ArrayList<Facility> getFacilitiesBy(Connection con, String searchCriteria, String value)
    {
        ArrayList<Facility> facilitiesList = new ArrayList<>();
        Facility facility = null;
        String SQLString1 = // get order
                "select * "
                + "from facilities "
                + "where" + searchCriteria + "= ?";
        PreparedStatement statement = null;

        try
        {
            if (searchCriteria.equals("price"))
            {
                statement.setInt(1, Integer.parseInt(value));
            } else
            {
                statement.setString(1, value);     // primary key value
            }
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                facility = new Facility(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4));
                facilitiesList.add(facility);

            }

        } catch (Exception e)
        {
            System.out.println("Fail in DataMapper - getFacilitiesBy");
            System.out.println(e.getMessage());
        } finally														// must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in DataMapper - getFacilitiesBy");
                System.out.println(e.getMessage());
            }
        }
        return facilitiesList;
    }

    public ArrayList<Facility> getAllFacilities(Connection con)
    {
        ArrayList<Facility> facilitiesList = new ArrayList<>();
        Facility facility = null;
        String SQLString1 = // get order
                "select * "
                + "from facilities ";
        PreparedStatement statement = null;

        try
        {
            statement = con.prepareStatement(SQLString1);
            ResultSet rs = statement.executeQuery(SQLString1);
            while (rs.next())
            {
                facility = new Facility(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4));
                facilitiesList.add(facility);

            }

        } catch (Exception e)
        {
            System.out.println("Fail in DataMapper - getAllFacilities");
            System.out.println(e.getMessage());
        } finally														// must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in DataMapper - getAllFacilities");
                System.out.println(e.getMessage());
            }
        }
        return facilitiesList;
    }

    public boolean saveNewClient(Client client, Connection con)
    {
        int rowsInserted = 0;
        String SQLString1
                = "insert into clients "
                + "values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = null;

        try
        {

            //== insert tuple
            statement = con.prepareStatement(SQLString1);
            statement.setString(1, client.getId());
            statement.setString(2, client.getFirstName());
            statement.setString(3, client.getLastName());
            statement.setString(4, client.getAddress());
            statement.setString(5, client.getCountry());
            statement.setString(6, client.getTravelAgency());
            statement.setInt(7, client.getPhone());
            statement.setString(8, client.getEmail());
            statement.setString(9, client.getPassword());
            statement.setInt(10, client.getVersionNumber());
            rowsInserted = statement.executeUpdate();

        } catch (Exception e)
        {
            System.out.println("Fail in dataMapper - saveNewClient");
            System.out.println(e.getMessage());
        } finally														// must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in DataMapper - saveNewClient");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;

    }

    public boolean saveNewRoomReservation(Reservation reservation, Room room, Connection con)
    {
        int rowsInsertedInReservations = 0;
        int rowsInsertedInRoomReservations = 0;
        int rowsInsertedInClientsReservations = 0;

        String SQLString1
                = "insert into reservations "
                + "values (?,?,?,?,?)";
        String SQLString2
                = "insert into room_reservations  "
                + "values(?,?,?,?,?)";
        String SQLString4
                = "insert into clients_reservations "
                + "values(?,?,?)";
        String SQLString5
                = "select reservations_seq.nextval  "
                + "from dual";

        PreparedStatement statement = null;

        
        try
        {
            statement = con.prepareStatement(SQLString5);
            ResultSet rs = statement.executeQuery();
            if (rs.next())
            {
                reservation.setId(rs.getInt(1));
            }

            statement = con.prepareStatement(SQLString1);
            statement.setInt(1, reservation.getId());
            statement.setString(2, reservation.getPayed());
            statement.setInt(3, reservation.getDeposit());
            statement.setInt(4, reservation.getAmountPayed());
            statement.setInt(5, reservation.getVersionNumber());
            rowsInsertedInReservations = statement.executeUpdate();

            java.sql.Date sqlFromDate =  new java.sql.Date(reservation.getFromDate().getTime().getTime() );
            java.sql.Date sqlUntilDate =  new java.sql.Date(reservation.getUntilDate().getTime().getTime() );

            statement = con.prepareStatement(SQLString2);
            statement.setInt(1, reservation.getId());
            statement.setInt(2, room.getId());
            statement.setDate(3, sqlFromDate);
            statement.setDate(4, sqlUntilDate);
            statement.setInt(5, reservation.getVersionNumber());
            rowsInsertedInRoomReservations = statement.executeUpdate();

            statement = con.prepareStatement(SQLString4);
            statement.setInt(1, reservation.getId());
            statement.setString(2, reservation.getClientID());
            statement.setInt(3, 1);
            rowsInsertedInClientsReservations = statement.executeUpdate();

        } catch (Exception e)
        {
            System.out.println("Fail in dataMapper - saveNewRoomReservation");
            System.out.println(e.getMessage());
        } finally														// must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in DataMapper - saveNewRoomReservation");
                System.out.println(e.getMessage());
            }
        }
        return rowsInsertedInReservations == 1 && rowsInsertedInRoomReservations == 1 &&  rowsInsertedInClientsReservations == 1;
    }

    public ArrayList<FacilityReservation> getFacilityReservationsBy(Connection con, String searchCriteria, String value)
    {
        ArrayList<FacilityReservation> facilityResList = new ArrayList<>();
        FacilityReservation facilityRes = null;
        String SQLString1 = // get order
                "select * "
                + "from facilities_reservations "
                + "where" + searchCriteria + "= ?";
        PreparedStatement statement = null;

        try
        {
            statement.setString(1, value);

            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                facilityRes = new FacilityReservation(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5));
                facilityResList.add(facilityRes);

            }

        } catch (Exception e)
        {
            System.out.println("Fail in DataMapper - getFacilityReservationsBy");
            System.out.println(e.getMessage());
        } finally														// must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in DataMapper - getFacilityReservationsBy");
                System.out.println(e.getMessage());
            }
        }
        return facilityResList;
    }

    public ArrayList<RoomType> getAllRoomTypes(Connection con)
    {
        ArrayList<RoomType> roomTypesList = new ArrayList<>();
        RoomType roomType = null;
        String SQLString1 = // get order
                "select * "
                + "from room_types ";
        PreparedStatement statement = null;

        try
        {
            statement = con.prepareStatement(SQLString1);
            ResultSet rs = statement.executeQuery(SQLString1);
            while (rs.next())
            {
                roomType = new RoomType(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4));
                roomTypesList.add(roomType);

            }

        } catch (Exception e)
        {
            System.out.println("Fail in DataMapper - getAllFacilities");
            System.out.println(e.getMessage());
        } finally														// must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in DataMapper - getAllFacilities");
                System.out.println(e.getMessage());
            }
        }
        return roomTypesList;
    }

    public boolean delete(String type, int id, Connection con)
    {
        String sqlString1 = null, sqlString2 = null, sqlString3 = null;
        int tuplesDeleted;
        boolean result = true;
        if (type.equals("reservation"))
        {
            sqlString1 = "DELETE FROM CLIENTS_RESERVATIONS "
                    + "WHERE RES_ID = ?";
            sqlString2 = "DELETE FROM ROOM_RESERVATIONS "
                    + "WHERE RES_ID = ?";
            sqlString3 = "DELETE FROM RESERVATIONS "
                    + "WHERE ID = ?";
        }
        PreparedStatement statement = null;

        try
        {
            statement = con.prepareStatement(sqlString1);
            statement.setInt(1, id);
            tuplesDeleted = statement.executeUpdate();
            if (tuplesDeleted == 0)
            {
                result = false;
            }
            statement = con.prepareStatement(sqlString2);
            statement.setInt(1, id);
            tuplesDeleted = statement.executeUpdate();
            if (tuplesDeleted == 0)
            {
                result = false;
            }
            statement = con.prepareStatement(sqlString3);
            statement.setInt(1, id);
            tuplesDeleted = statement.executeUpdate();
            if (tuplesDeleted == 0)
            {
                result = false;
            }
        } catch (SQLException e)
        {
            System.out.println("Fail in DataMapper - delete");
            System.out.println(e.getMessage());
            result = false;
        } finally														// must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in DataMapper - delete");
                System.out.println(e.getMessage());
                result = false;
            }
        }

        return result;
    }

    public boolean confirmPayment(double amount, int id, Connection con)
    {
        String sqlString
                = "UPDATE RESERVATIONS "
                + "SET AMOUNT_PAYED = ?, PAYED = 'Y' "
                + "WHERE ID = ?";
        PreparedStatement statement = null;

        try
        {
            statement = con.prepareStatement(sqlString);
            statement.setDouble(1, amount);
            statement.setInt(2, id);
            return statement.executeUpdate() == 1;
        } catch (SQLException e)
        {
            System.out.println("Fail in DataMapper - confirmPayment");
            System.out.println(e.getMessage());
        } finally														// must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in DataMapper - confirmPayment");
                System.out.println(e.getMessage());
            }
        }

        return true;
    }

    public boolean saveNewFacilityReservation(FacilityReservation facilityReservation, Connection con)
    {
        int rowsInserted = 0;

        String SQLString1
                = "insert into facilities_reservations "
                + "values (?,?,?,?)";

        PreparedStatement statement = null;

        try
        {

            //== insert tuple
            statement = con.prepareStatement(SQLString1);
            statement.setString(1, facilityReservation.getClientID());
            statement.setString(2, facilityReservation.getFacilityName());
            statement.setString(3, facilityReservation.getStartingDate());
            statement.setString(4, facilityReservation.getEndingDate());
            rowsInserted = statement.executeUpdate();

        } catch (Exception e)
        {
            System.out.println("Fail in dataMapper - saveNewFacilityReservation");
            System.out.println(e.getMessage());
        } finally														// must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in DataMapper - saveNewFacilityReservation");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }
}
