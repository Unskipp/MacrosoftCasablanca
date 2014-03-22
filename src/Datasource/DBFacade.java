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
import java.util.ArrayList;

/**
 *
 * @author Unskipp
 */
public class DBFacade
{

    private Connection connection;
    private static DBFacade instance;
    private DataMapper map;

    private DBFacade()
    {
        connection = new DBConnector().getConnection();
        map = new DataMapper();
    }

    public static DBFacade getInstance()
    {
        if (instance == null)
        {
            instance = new DBFacade();
        }
        return instance;
    }

    //INSERT THE METHODS HERE
    public ArrayList<Employees> getEmployeessBy(String searchCriteria, String value)
    {
        return map.getEmployeessBy(connection, searchCriteria, value);
    }

    public ArrayList<Employees> getAllEmployeess()
    {
        return map.getAllEmployeess(connection);
    }

    public ArrayList<Rooms> getRoomssBy(String searchCriteria, String value)
    {
        return map.getRoomssBy(connection, searchCriteria, value);
    }

    public ArrayList<Rooms> getAllRoomss()
    {
        return map.getAllRoomss(connection);
    }

    public ArrayList<Clients> getClientssBy(String searchCriteria, String value)
    {
        return map.getClientssBy(connection, searchCriteria, value);
    }

    public ArrayList<Clients> getAllClientss()
    {
        return map.getAllClientss(connection);
    }

    public ArrayList<Reservations> getReservationssBy(String searchCriteria, String value)
    {
        return map.getReservationssBy(connection, searchCriteria, value);
    }

    public ArrayList<Reservations> getAllReservationss()
    {
        return map.getAllReservationss(connection);
    }

    public ArrayList<Facilities> getFacilitiesBy(String searchCriteria, String value)
    {
        return map.getFacilitiesBy(connection, searchCriteria, value);
    }

    public ArrayList<Facilities> getAllFacilities()
    {
        return map.getAllFacilities(connection);
    }
}
