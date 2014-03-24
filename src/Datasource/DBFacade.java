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
    public ArrayList<Employee> getEmployeessBy(String searchCriteria, String value)
    {
        return map.getEmployeessBy(connection, searchCriteria, value);
    }

    public ArrayList<Employee> getAllEmployeess()
    {
        return map.getAllEmployeess(connection);
    }

    public ArrayList<Room> getRoomssBy(String searchCriteria, String value)
    {
        return map.getRoomssBy(connection, searchCriteria, value);
    }

    public ArrayList<Room> getAllRoomss()
    {
        return map.getAllRoomss(connection);
    }

    public ArrayList<Client> getClientssBy(String searchCriteria, String value)
    {
        return map.getClientssBy(connection, searchCriteria, value);
    }

    public ArrayList<Client> getAllClientss()
    {
        return map.getAllClientss(connection);
    }

    public ArrayList<Reservation> getReservationssBy(String searchCriteria, String value)
    {
        return map.getReservationssBy(connection, searchCriteria, value);
    }

    public ArrayList<Reservation> getAllReservationss()
    {
        return map.getAllReservationss(connection);
    }

    public ArrayList<Facility> getFacilitiesBy(String searchCriteria, String value)
    {
        return map.getFacilitiesBy(connection, searchCriteria, value);
    }

    public ArrayList<Facility> getAllFacilities()
    {
        return map.getAllFacilities(connection);
    }
}
