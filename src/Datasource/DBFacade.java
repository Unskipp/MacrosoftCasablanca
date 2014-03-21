/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datasource;

import java.sql.Connection;

/**
 *
 * @author Unskipp
 */
public class DBFacade
{

    private Connection connection;
    private static DBFacade instance;
    private DBFacade()
    {
        connection = new DBConnector().getConnection();
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
}
