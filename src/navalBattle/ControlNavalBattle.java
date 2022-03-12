package navalBattle;

import javax.swing.*;
import java.util.Random;

public class ControlNavalBattle
{
    private int numberOfHits, step=1, armament=0;

    public void setEnemyPanel(JPanel panel, Cells[][] cells, ImageIcon image)
    {
        Random randoNum=new Random();
        if(step==1)
        {
            int number1=randoNum.nextInt(10)+1;
            int number2=randoNum.nextInt(10)+1;
            int horizontallyOrVertically=randoNum.nextInt(2)+1;
            if(horizontallyOrVertically==1)
            {
                if(cells[number1][number2].getRows() >= 1 && cells[number1][number2].getRows() <= 3 && !cells[number1][number2].getChosenArea())
                {
                    cells[number1][number2].setIcon(image); cells[number1][number2].setChosenArea();
                    cells[number1 + 1][number2].setIcon(image); cells[number1 + 1][number2].setChosenArea();
                    cells[number1 + 2][number2].setIcon(image); cells[number1 + 2][number2].setChosenArea();
                    cells[number1 + 3][number2].setIcon(image); cells[number1 + 3][number2].setChosenArea();
                    panel.updateUI();
                    step++;
                }
                if(cells[number1][number2].getRows() > 3 && cells[number1][number2].getRows() < 9 && !cells[number1][number2].getChosenArea())
                {
                    cells[number1][number2].setIcon(image); cells[number1][number2].setChosenArea();
                    cells[number1 - 1][number2].setIcon(image); cells[number1 - 1][number2].setChosenArea();
                    cells[number1 - 2][number2].setIcon(image); cells[number1 - 2][number2].setChosenArea();
                    cells[number1 - 3][number2].setIcon(image); cells[number1 - 3][number2].setChosenArea();
                    panel.updateUI();
                    step++;
                }
            }
            if(horizontallyOrVertically==2)
            {
                if(cells[number1][number2].getColumns() >= 8 && cells[number1][number2].getColumns() <= 10 && !cells[number1][number2].getChosenArea())
                {
                    cells[number1][number2].setIcon(image); cells[number1][number2].setChosenArea();
                    cells[number1][number2 - 1].setIcon(image); cells[number1][number2 - 1].setChosenArea();
                    cells[number1][number2 - 2].setIcon(image); cells[number1][number2 - 2].setChosenArea();
                    cells[number1][number2 - 3].setIcon(image); cells[number1][number2 - 3].setChosenArea();
                    panel.updateUI();
                    step++;
                }
                if(cells[number1][number2].getColumns() >= 1 && cells[number1][number2].getColumns() < 8 && !cells[number1][number2].getChosenArea())
                {
                    cells[number1][number2].setIcon(image); cells[number1][number2].setChosenArea();
                    cells[number1][number2 + 1].setIcon(image); cells[number1][number2 + 1].setChosenArea();
                    cells[number1][number2 + 2].setIcon(image); cells[number1][number2 + 2].setChosenArea();
                    cells[number1][number2 + 3].setIcon(image); cells[number1][number2 + 3].setChosenArea();
                    panel.updateUI();
                    step++;
                }
            }
        }

        if(step==2)
        {
            while(armament < 2)
            {
                int number1 = randoNum.nextInt(10) + 1;
                int number2 = randoNum.nextInt(10) + 1;
                /*
                while (cells[number1][number2].getChosenArea())
                {
                    number1 = randoNum.nextInt(10) + 1;
                    number2 = randoNum.nextInt(10) + 1;
                }*/
                int horizontallyOrVertically = randoNum.nextInt(2) + 1;
                if (horizontallyOrVertically == 1)
                {
                    if (cells[number1][number2].getRows() == 10 && !cells[number1][number2].getChosenArea()
                        && !cells[number1 - 1][number2].getChosenArea() && !cells[number1 - 2][number2].getChosenArea())
                    {
                        cells[number1][number2].setIcon(image); cells[number1][number2].setChosenArea();
                        cells[number1 - 1][number2].setIcon(image); cells[number1 - 1][number2].setChosenArea();
                        cells[number1 - 2][number2].setIcon(image); cells[number1 - 2][number2].setChosenArea();
                        panel.updateUI();
                        armament++;
                    }
                    if(cells[number1][number2].getRows() >= 1 && cells[number1][number2].getRows() < 10 && !cells[number1][number2].getChosenArea()
                        && !cells[number1 + 1][number2].getChosenArea() && !cells[number1 + 2][number2].getChosenArea())
                    {
                        cells[number1][number2].setIcon(image); cells[number1][number2].setChosenArea();
                        cells[number1 + 1][number2].setIcon(image); cells[number1 + 1][number2].setChosenArea();
                        cells[number1 + 2][number2].setIcon(image); cells[number1 + 2][number2].setChosenArea();
                        panel.updateUI();
                        armament++;
                    }
                }
                if (horizontallyOrVertically == 2)
                {
                    if(cells[number1][number2].getColumns() == 10 || cells[number1][number2].getColumns() == 9 && !cells[number1][number2].getChosenArea()
                        && !cells[number1][number2 - 1].getChosenArea() && !cells[number1][number2 - 2].getChosenArea())
                    {
                        cells[number1][number2].setIcon(image); cells[number1][number2].setChosenArea();
                        cells[number1][number2 - 1].setIcon(image); cells[number1][number2 - 1].setChosenArea();
                        cells[number1][number2 - 2].setIcon(image); cells[number1][number2 - 2].setChosenArea();
                        panel.updateUI();
                        armament++;
                    }
                    if(cells[number1][number2].getColumns() >= 1 && cells[number1][number2].getColumns() < 9 && !cells[number1][number2].getChosenArea()
                        && !cells[number1][number2 + 1].getChosenArea() && !cells[number1][number2 + 2].getChosenArea())
                    {
                        cells[number1][number2].setIcon(image); cells[number1][number2].setChosenArea();
                        cells[number1][number2 + 1].setIcon(image); cells[number1][number2 + 1].setChosenArea();
                        cells[number1][number2 + 2].setIcon(image); cells[number1][number2 + 2].setChosenArea();
                        panel.updateUI();
                        armament++;
                    }
                }
            }

            if (armament == 2)
            {
                step++;
            }
        }


        if(step==3)
        {
            while(armament < 3)
            {
                int number1 = randoNum.nextInt(10) + 1;
                int number2 = randoNum.nextInt(10) + 1;
                /*
                while (cells[number1][number2].getChosenArea())
                {
                    number1 = randoNum.nextInt(10) + 1;
                    number2 = randoNum.nextInt(10) + 1;
                }*/
                int horizontallyOrVertically = randoNum.nextInt(2) + 1;
                if(horizontallyOrVertically==1)
                {
                    if(cells[number1][number2].getRows() == 10 && !cells[number1][number2].getChosenArea()
                        && !cells[number1 - 1][number2].getChosenArea())
                    {
                        cells[number1][number2].setIcon(image); cells[number1][number2].setChosenArea();
                        cells[number1 - 1][number2].setIcon(image); cells[number1 - 1][number2].setChosenArea();
                        panel.updateUI();
                        armament++;
                    }

                    if (cells[number1][number2].getRows() >= 1 && cells[number1][number2].getRows() < 9 && !cells[number1][number2].getChosenArea()
                        && !cells[number1 + 1][number2].getChosenArea())
                    {
                        cells[number1][number2].setIcon(image); cells[number1][number2].setChosenArea();
                        cells[number1 + 1][number2].setIcon(image); cells[number1 + 1][number2].setChosenArea();
                        panel.updateUI();
                        armament++;
                    }
                }
                if(horizontallyOrVertically==2)
                {
                    if (cells[number1][number2].getColumns() == 10 && !cells[number1][number2].getChosenArea()
                        && !cells[number1][number2 - 1].getChosenArea())
                    {
                        cells[number1][number2].setIcon(image); cells[number1][number2].setChosenArea();
                        cells[number1][number2 - 1].setIcon(image); cells[number1][number2 - 1].setChosenArea();
                        panel.updateUI();
                        armament++;
                    }

                    if (cells[number1][number2].getColumns() >= 1 && cells[number1][number2].getColumns() < 9 && !cells[number1][number2].getChosenArea()
                        && !cells[number1][number2 + 1].getChosenArea())
                    {
                        cells[number1][number2].setIcon(image); cells[number1][number2].setChosenArea();
                        cells[number1][number2 + 1].setIcon(image); cells[number1][number2 + 1].setChosenArea();
                        panel.updateUI();
                        armament++;
                    }
                }
            }
            if (armament == 3)
            {
                step++;
            }
        }

        if(step==4)
        {
            while(armament < 4)
            {
                int number1 = randoNum.nextInt(10) + 1;
                int number2 = randoNum.nextInt(10) + 1;
                /*
                while (cells[number1][number2].getChosenArea())
                {
                    number1 = randoNum.nextInt(10) + 1;
                    number2 = randoNum.nextInt(10) + 1;
                }*/
                if(!cells[number1][number2].getChosenArea())
                {
                    cells[number1][number2].setIcon(image); cells[number1][number2].setChosenArea();
                    panel.updateUI();
                    armament++;
                }
            }
            if (armament > 4)
            {
                step++;
            }
        }
    }
}
