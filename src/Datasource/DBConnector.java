/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datasource;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Unskipp
 */
public class DBConnector
{
    //INSERT THE USERNAME AND PASSWORD FOR THE DATABASE
    private static String id = "";
    private static String pw = "";

    public Connection getConnection()
    {
        Connection con = null;
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@datdb.cphbusiness.dk:1521:dat", DBConnector.id, DBConnector.pw);
        } catch (Exception e)
        {
            System.out.println("\n*** Remember to insert your Oracle ID and PW in the DBConnector class! ***\n");
            System.out.println("error in DBConnector.getConnection()");
            System.out.println(e);
        }

        return con;
    }
}
