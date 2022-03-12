package navalBattle;

import javax.swing.*;

public class Cells extends JButton
{
    private int columns, rows;
    private boolean chosenArea;

    public Cells(int rows, int columns, boolean chosenArea)
    {
        this.columns = columns;
        this.rows = rows;
        this.chosenArea=false;
    }

    public int getColumns()
    {
        return columns;
    }

    public int getRows()
    {
        return rows;
    }

    public void setColumns(int columns)
    {
        this.columns = columns;
    }

    public void setRows(int rows)
    {
        this.rows = rows;
    }

    public void setChosenArea()
    {
        this.chosenArea=true;
    }

    public boolean getChosenArea()
    {
        return chosenArea;
    }

}
