/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datasource;

import Domain.Clients;
import Domain.Employees;
import Domain.Facilities;
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
                + "from Employeess ";
        PreparedStatement statement = null;

        try
        {
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                emp = new Employees(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(4),
                        rs.getInt(5));
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
                System.out.println("Fail in DataMapper - getAllEmployeess");
                System.out.println(e.getMessage());
            }
        }
        return empList;
    }

    public ArrayList<Rooms> getRoomssBy(Connection con, String searchCriteria, String value)
    {
        ArrayList<Rooms> RoomsList = new ArrayList<>();
        Rooms Rooms = null;
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
                Rooms = new Rooms(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5)
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
                + "from Roomss ";
        PreparedStatement statement = null;

        try
        {

            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                Rooms = new Rooms(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5)
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
                Clients = new Clients(rs.getString(1),
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

    public ArrayList<Clients> getAllClientss(Connection con)
    {
        ArrayList<Clients> ClientsList = new ArrayList<>();
        Clients Clients = null;
        String SQLString1 = // get order
                "select * "
                + "from Clientss ";
        PreparedStatement statement = null;

        try
        {

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

    public ArrayList<Reservations> getReservationssBy(Connection con, String searchCriteria, String value)
    {
        ArrayList<Reservations> ReservationsList = new ArrayList<>();
        Reservations Reservations = null;
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
                Reservations = new Reservations(rs.getInt(1),
                        rs.getBoolean(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6)
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

    public ArrayList<Reservations> getAllReservationss(Connection con)
    {
        ArrayList<Reservations> ReservationsList = new ArrayList<>();
        Reservations Reservations = null;
        String SQLString1 = // get order
                "select * "
                + "from Reservationss ";
        PreparedStatement statement = null;

        try
        {

            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                Reservations = new Reservations(rs.getInt(1),
                        rs.getBoolean(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6)
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

            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                Facilities = new Facilities(rs.getString(1),
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