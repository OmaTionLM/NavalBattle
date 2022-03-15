package navalBattle;

import javax.swing.*;
import java.util.ArrayList;

/**
 * This class is used for ...
 * Alan Valderrama - 2042836 - alan.valderrama@correounivalle.edu.co
 * Jeison Perea - 2077250 - jeison.perea@correounivalle.edu.co
 * @version v.1.0.0 date:15/03/2022
 */
public class Cells extends JButton
{
    /*
    Attributes
    */
    private int columns, rows;
    private boolean chosenArea;
    private String boatName;

    /*
    Constructor of the class
    */
    public Cells(int rows, int columns, boolean chosenArea)
    {
        this.columns = columns;
        this.rows = rows;
        this.chosenArea=false;
        boatName="";
    }

    /*
    Get columns
    */
    public int getColumns()
    {
        return columns;
    }

    /*
    Get rows
    */
    public int getRows()
    {
        return rows;
    }

    /*
    Set chosen area
    */
    public void setChosenArea()
    {
        this.chosenArea=true;
    }

    /*
    Get chosen area
    */
    public boolean getChosenArea()
    {
        return chosenArea;
    }

    /*
    Set the boat name
    */
    public void setBoatName(String name)
    {
        this.boatName=name;
    }

    /*
    Get boat name
    */
    public String getBoatName()
    {
        return boatName;
    }
}
