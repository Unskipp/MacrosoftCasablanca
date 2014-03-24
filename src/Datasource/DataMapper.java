/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datasource;

import Domain.Client;
import Domain.Employee;
import Domain.Facility;
import Domain.Reservation;
import Domain.Room;

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
            statement=con.prepareStatement(SQLString1);
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
        System.out.println( empList.toString());
        return empList;
    }

    public ArrayList<Room> getRoomssBy(Connection con, String searchCriteria, String value)
    {
        ArrayList<Room> RoomsList = new ArrayList<>();
        Room Rooms = null;
        String SQLString1 = // get order
                "select * "
                + "from Roomss "
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
                Rooms = new Room(rs.getInt(1),
                        rs.getString(2)
//                        rs.getInt(3),
//                        rs.getInt(4),
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

    public ArrayList<Room> getAllRoomss(Connection con)
    {
        ArrayList<Room> RoomsList = new ArrayList<>();
        Room Rooms = null;
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
                Rooms = new Room(rs.getInt(1),
                        rs.getString(2)
//                        rs.getInt(3),
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

    public ArrayList<Client> getClientssBy(Connection con, String searchCriteria, String value)
    {
        ArrayList<Client> ClientsList = new ArrayList<>();
        Client Clients = null;
        String SQLString1 = // get order
                "select * "
                + "from Clientss "
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
                Clients = new Client(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10)
                );
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
        ArrayList<Client> ClientsList = new ArrayList<>();
        Client Clients = null;
        String SQLString1 = // get order
                "select * "
                + "from Clients ";
        PreparedStatement statement = null;

        try
        {
            statement= con.prepareStatement(SQLString1);
            ResultSet rs = statement.executeQuery(SQLString1);
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
                        rs.getInt(10)
                );
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

    public ArrayList<Reservation> getReservationssBy(Connection con, String searchCriteria, String value)
    {
        ArrayList<Reservation> ReservationsList = new ArrayList<>();
        Reservation Reservations = null;
        String SQLString1 = // get order
                "select * "
                + "from Reservationss "
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
                Reservations = new Reservation(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5)
                       // rs.getString(6)
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
                System.out.println("Fail in DataMapper - getRoomsBy");
                System.out.println(e.getMessage());
            }
        }
        return ReservationsList;
    }

    public ArrayList<Reservation> getAllReservationss(Connection con)
    {
        ArrayList<Reservation> ReservationsList = new ArrayList<>();
        Reservation Reservations = null;
        String SQLString1 = // get order
                "select * "
                + "from Reservations ";
        PreparedStatement statement = null;

        try
        {
            statement = con.prepareStatement(SQLString1);
            ResultSet rs = statement.executeQuery(SQLString1);
            while (rs.next())
            {
                Reservations = new Reservation(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5)
                       // rs.getString(6)
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

    public ArrayList<Facility> getFacilitiesBy(Connection con, String searchCriteria, String value)
    {
        ArrayList<Facility> FacilitiesList = new ArrayList<>();
        Facility Facilities = null;
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
                Facilities = new Facility(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4)
                );
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

    public ArrayList<Facility> getAllFacilities(Connection con)
    {
        ArrayList<Facility> FacilitiesList = new ArrayList<>();
        Facility Facilities = null;
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
                Facilities = new Facility(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4)
                );
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
}