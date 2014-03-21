/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Domain;

import Datasource.DBFacade;

/**
 *
 * @author Unskipp
 */
public class Controller
{
    private DBFacade dbf;
    
    public Controller()
    {
        dbf = DBFacade.getInstance();
    }
}
