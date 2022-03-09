package navalBattle;

import javax.swing.*;

public class Cells extends JButton
{
    private int columns, rows;

    public Cells(int rows, int columns)
    {
        this.columns = columns;
        this.rows = rows;
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
}
