/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Domain;

/**
 *
 * @author Unskipp
 */
public class RoomType
{
    String type;
    int capacity, price;

    public RoomType(String type, int capacity, int price)
    {
        this.type = type;
        this.capacity = capacity;
        this.price = price;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }
    
    
}
