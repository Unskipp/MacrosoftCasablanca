/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datasource;

import Domain.Clients;
import Domain.Employees;
import Domain.Facilities;
import Domain.FacilityReservation;
import Domain.Reservations;
import Domain.Rooms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Marek FURAK
 */
public class DataMapper
{

    public ArrayList<Employees> getEmployeessBy(Connection con, String searchCriteria, String value)
    {
        ArrayList<Employees> empList = new ArrayList<>();
        Employees emp = null;
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
                emp = new Employees(rs.getString(1),
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

    public ArrayList<Employees> getAllEmployeess(Connection con)
    {
        ArrayList<Employees> empList = new ArrayList<>();
        Employees emp = null;
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
                emp = new Employees(rs.getString(1),
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
        System.out.println(empList.toString());
        return empList;
    }

    public ArrayList<Rooms> getRoomssBy(Connection con, String searchCriteria, String value)
    {
        ArrayList<Rooms> RoomsList = new ArrayList<>();
        Rooms Rooms = null;
        String SQLString1 = // get order
                "select * "
                + "from Rooms "
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
                Rooms = new Rooms(rs.getInt(1),
                        rs.getString(2) //                        rs.getInt(3),
                        //                      rs.getInt(4),
                        //                        rs.getInt(5)
                        );
                RoomsList.add(Rooms);

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
        return RoomsList;
    }

    public ArrayList<Rooms> getAllRoomss(Connection con)
    {
        ArrayList<Rooms> RoomsList = new ArrayList<>();
        Rooms Rooms = null;
        String SQLString1 = // get order
                "select * "
                + "from Rooms ";
        PreparedStatement statement = null;

        try
        {
            statement = con.prepareStatement(SQLString1);
            ResultSet rs = statement.executeQuery(SQLString1);
            while (rs.next())
            {
                Rooms = new Rooms(rs.getInt(1),
                        rs.getString(2) //                        rs.getInt(3),
                        //                        rs.getInt(4),
                        //                        rs.getInt(5)
                        );
                RoomsList.add(Rooms);

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
        return RoomsList;
    }

    public ArrayList<Clients> getClientssBy(Connection con, String searchCriteria, String value)
    {
        ArrayList<Clients> ClientsList = new ArrayList<>();
        Clients Clients = null;
        String SQLString1 = // get order
                "select * "
                + "from Clientss "
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
                Clients = new Clients(rs.getString(1),
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

    public ArrayList<Clients> getAllClientss(Connection con)
    {
        ArrayList<Clients> ClientsList = new ArrayList<>();
        Clients Clients = null;
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
                Clients = new Clients(rs.getString(1),
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
        return ClientsList;
    }

    public ArrayList<Reservations> getReservationssBy(Connection con, String searchCriteria, String value)
    {
        ArrayList<Reservations> ReservationsList = new ArrayList<>();
        
        Reservations Reservations = null;
        String SQLString1 = // get order
                "select c.id, c.first_name, c.last_name, r.id, r.payed, r.deposit, r.amount_payed, rr.starting_date, rr.ending_date, room.id, room.type, rt.capacity"
                + "from  clients c join clients_reservations cr on c.id = cr.client_id"
                + "join reservations r on cr.res_id = r.id"
                + "join room_reservations rr on r.id = rr.res_id"
                + "join rooms room on rr.room_id = room.id"
                + "join room_types rt on room.type = rt.type"
                + "where c.first_name = "+ searchCriteria+ "=?";
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
                
                Reservations = new Reservations(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getInt(10)
                        );
                ReservationsList.add(Reservations);

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
        return ReservationsList;
    }

    public ArrayList<Reservations> getAllReservationss(Connection con)
    {
        ArrayList<Reservations> ReservationsList = new ArrayList<>();
        Reservations Reservations = null;
        String SQLString1 = // get order
                "select c.id, c.first_name, c.last_name, r.id, r.payed, r.deposit, r.amount_payed, rr.starting_date, rr.ending_date, room.id, room.type, rt.capacity"
                + "from  clients c join clients_reservations cr on c.id = cr.client_id"
                + "join reservations r on cr.res_id = r.id"
                + "join room_reservations rr on r.id = rr.res_id"
                + "join rooms room on rr.room_id = room.id"
                + "join room_types rt on room.type = rt.type";
        PreparedStatement statement = null;

        try
        {
            statement = con.prepareStatement(SQLString1);
            ResultSet rs = statement.executeQuery(SQLString1);
            while (rs.next())
            {
                Reservations = new Reservations(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getInt(10)
                        );
                ReservationsList.add(Reservations);

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
        return ReservationsList;
    }

    public ArrayList<Facilities> getFacilitiesBy(Connection con, String searchCriteria, String value)
    {
        ArrayList<Facilities> FacilitiesList = new ArrayList<>();
        Facilities Facilities = null;
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
                Facilities = new Facilities(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4));
                FacilitiesList.add(Facilities);

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
                System.out.println("Fail in DataMapper - getFacilitiesBy");
                System.out.println(e.getMessage());
            }
        }
        return FacilitiesList;
    }

    public ArrayList<Facilities> getAllFacilities(Connection con)
    {
        ArrayList<Facilities> FacilitiesList = new ArrayList<>();
        Facilities Facilities = null;
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
                Facilities = new Facilities(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4));
                FacilitiesList.add(Facilities);

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
        return FacilitiesList;
    }

    public boolean saveNewReservation(Reservations reservation, Rooms room, Clients client, Connection con)
    {
        int rowsInsertedInReservations = 0;
        int rowsInsertedInRoomReservations = 0;

        String SQLString1 =
                "insert into reservations "
                + "values (?,?,?,?,?)";
        String SQLString2 =
                "insert into room_reservations"
                + "values(?,?,?,?,?)";
        String SQLString3 =
                "insert into rooms"
                + "values(?,?,?)";
        String SQLString4 =
                "insert into clients_reservations"
                + "values(?,?)";
        String SQLString5 =
                "insert into clients"
                + "values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = null;

        try
        {


            //== insert tuple
            statement = con.prepareStatement(SQLString1);
            statement.setInt(1, reservation.getId());
            statement.setString(2, reservation.isPayed());
            statement.setInt(3, reservation.getDeposit());
            statement.setInt(4, reservation.getAmountPayed());
            statement.setInt(5, reservation.getVersionNumber());
            rowsInsertedInReservations = statement.executeUpdate();

            statement = con.prepareStatement(SQLString2);
            statement.setInt(1, reservation.getId());
            statement.setInt(2, reservation.getRoomID());
            statement.setInt(3, reservation.getStartingDate());
            statement.setString(4, reservation.getEndingDate());
            statement.setInt(5, reservation.getVersionNumber());
            rowsInsertedInRoomReservations = statement.executeUpdate();

            statement = con.prepareStatement(SQLString3);
            statement.setInt(1, room.getId());
            statement.setString(2, room.getType());

            statement = con.prepareStatement(SQLString4);
            statement.setInt(1, reservation.getId());
            statement.setString(2, client.getId());

            statement = con.prepareStatement(SQLString5);
            statement.setString(1, client.getId());
            statement.setString(2, client.getFirstName());
            statement.setString(3, client.getLastName());
            statement.setString(4, client.getAddress());
            statement.setString(5, client.getCountry());
            statement.setString(6, client.getTravelAgency());
            statement.setInt(7, client.getPhone());
            statement.setString(8, client.getEmail());
            statement.setString(9, client.getPassword());
        } catch (Exception e)
        {
            System.out.println("Fail in dataMapper - saveNewReservation");
            System.out.println(e.getMessage());
        } finally														// must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in OrderMapper - saveNewOrder");
                System.out.println(e.getMessage());
            }
        }
        return rowsInsertedInReservations == 1 && rowsInsertedInRoomReservations == 1;
    }

    public ArrayList<FacilityReservation> getFacilitiyReservationsBy(Connection con, String searchCriteria, String value)
    {
        ArrayList<FacilityReservation> FacilityResList = new ArrayList<>();
        FacilityReservation FacilityRes = null;
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
                FacilityRes = new FacilityRes(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5));
                FacilityResList.add(FacilityRes);

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
                System.out.println("Fail in DataMapper - getFacilitiesBy");
                System.out.println(e.getMessage());
            }
        }
        return FacilityResList;
    }
}