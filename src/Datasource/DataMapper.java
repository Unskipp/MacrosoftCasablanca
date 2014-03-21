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
    public ArrayList<Employee> getEmployeesBy(Connection con, String searchCriteria, String value)
    {
        ArrayList<Employee> empList = new ArrayList<>();
        Employee emp = null;
        String SQLString1 = // get order
                "select * "
                + "from employees "
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
                emp = new Employee(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                empList.add(emp);
            }
            

        } catch (Exception e)
        {
            System.out.println("Fail in DataMapper - getEmployeeBy");
            System.out.println(e.getMessage());
        } finally														// must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in DataMapper - getEmployeeBy");
                System.out.println(e.getMessage());
            }
        }
        return empList;
    }
    public ArrayList<Employee> getAllEmployees(Connection con)
    {
        ArrayList<Employee> empList = new ArrayList<>();
        Employee emp = null;
        String SQLString1 = // get order
                "select * "
                + "from employees "
                ;
        PreparedStatement statement = null;

        try
        {            
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                emp = new Employee(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                empList.add(emp);
            }
            

        } catch (Exception e)
        {
            System.out.println("Fail in DataMapper - getEmployeeBy");
            System.out.println(e.getMessage());
        } finally														// must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in DataMapper - getAllEmployees");
                System.out.println(e.getMessage());
            }
        }
        return empList;
    }
    
    public ArrayList<Room> getRoomsBy(Connection con, String searchCriteria, String value)
    {
        ArrayList<Room> roomList = new ArrayList<>();
        Room room = null;
        String SQLString1 = // get order
                "select * "
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
                        rs.getString(2)
                        );
                roomList.add(room);

            }
            
        } catch (Exception e)
        {
            System.out.println("Fail in DataMapper - getRoomBy");
            System.out.println(e.getMessage());
        } finally														// must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in DataMapper - getRoomBy");
                System.out.println(e.getMessage());
            }
        }
        return roomList;
    }
     public ArrayList<Room> getAllRooms(Connection con)
    {
        ArrayList<Room> roomList = new ArrayList<>();
        Room room = null;
        String SQLString1 = // get order
                "select * "
                + "from rooms "
                ;
        PreparedStatement statement = null;

        try
        {
            
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                room = new Room(rs.getInt(1),
                        rs.getString(2)
                        );
                roomList.add(room);

            }
            
        } catch (Exception e)
        {
            System.out.println("Fail in DataMapper - getAllRooms");
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
        return roomList;
    }
    public ArrayList<Client> getClientsBy(Connection con, String searchCriteria, String value)
    {
        ArrayList<Client> clientList = new ArrayList<>();
        Client client = null;
        String SQLString1 = // get order
                "select * "
                + "from clients "
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
                client = new Client(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)
                        );
                clientList.add(client);

            }
            
        } catch (Exception e)
        {
            System.out.println("Fail in DataMapper - getClientBy");
            System.out.println(e.getMessage());
        } finally														// must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in DataMapper - getRoomBy");
                System.out.println(e.getMessage());
            }
        }
        return clientList;
    }
     public ArrayList<Client> getAllClients(Connection con)
    {
        ArrayList<Client> clientList = new ArrayList<>();
        Client client = null;
        String SQLString1 = // get order
                "select * "
                + "from clients "
                ;
        PreparedStatement statement = null;

        try
        {
            
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                client = new Client(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)
                        );
                clientList.add(client);

            }
            
        } catch (Exception e)
        {
            System.out.println("Fail in DataMapper - getAllClients");
            System.out.println(e.getMessage());
        } finally														// must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in DataMapper - getAllClients");
                System.out.println(e.getMessage());
            }
        }
        return clientList;
    }
    
    public ArrayList<Reservation> getReservationsBy(Connection con, String searchCriteria, String value)
    {
        ArrayList<Reservation> reservationList = new ArrayList<>();
        Reservation reservation = null;
        String SQLString1 = // get order
                "select * "
                + "from reservations "
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
                reservation = new Reservation(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                        );
                reservationList.add(reservation);

            }
            
        } catch (Exception e)
        {
            System.out.println("Fail in DataMapper - getReservationBy");
            System.out.println(e.getMessage());
        } finally														// must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in DataMapper - getRoomBy");
                System.out.println(e.getMessage());
            }
        }
        return reservationList;
    }
    public ArrayList<Reservation> getAllReservations(Connection con)
    {
        ArrayList<Reservation> reservationList = new ArrayList<>();
        Reservation reservation = null;
        String SQLString1 = // get order
                "select * "
                + "from reservations "
                ;
        PreparedStatement statement = null;

        try
        {
            
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                reservation = new Reservation(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                        );
                reservationList.add(reservation);

            }
            
        } catch (Exception e)
        {
            System.out.println("Fail in DataMapper - getAllReservations");
            System.out.println(e.getMessage());
        } finally														// must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in DataMapper - getAllReservations");
                System.out.println(e.getMessage());
            }
        }
        return reservationList;
    }
    
    public ArrayList<Facility> getFacilityBy(Connection con, String searchCriteria, String value)
    {
        ArrayList<Facility> facilityList = new ArrayList<>();
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
                        rs.getInt(3)                      
                        );
                facilityList.add(facility);

            }
            
        } catch (Exception e)
        {
            System.out.println("Fail in DataMapper - getReservationBy");
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
        return facilityList;
    }
    public ArrayList<Facility> getAllFacilities(Connection con)
    {
        ArrayList<Facility> facilityList = new ArrayList<>();
        Facility facility = null;
        String SQLString1 = // get order
                "select * "
                + "from facilities "
               ;
        PreparedStatement statement = null;

        try
        {
            
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                facility = new Facility(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3)                      
                        );
                facilityList.add(facility);

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
        return facilityList;
    }
}
