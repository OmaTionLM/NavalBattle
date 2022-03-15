package navalBattle;

import javax.swing.*;
import java.util.Objects;
import java.util.Random;

/**
 * This class is used for ...
 * Alan Valderrama - 2042836 - alan.valderrama@correounivalle.edu.co
 * Jeison Perea - 2077250 - jeison.perea@correounivalle.edu.co
 * @version v.1.0.0 date:15/03/2022
 */
public class ControlNavalBattle
{
    /*
    Attributes
    */
    private int numberOfHits=0, step=1, armament=0;
    private ImageIcon touchedImage, sunkenImage, waterImage, frigates;
    private ImageIcon aircraft, submarine, destructors;

    /*
    Constructor of the class
    */
    public ControlNavalBattle()
    {
        sunkenImage=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/sunken.jpg")));
        touchedImage=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/touched.jpg")));
        waterImage=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/water.png")));
        frigates=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/frigates.jpg")));
    }

    /*
    Set the enemy panel
    */
    public void setEnemyPanel(JPanel panel, Cells[][] cells, ImageIcon image)
    {
        Random randoNum=new Random();
        /*
        Set the aircraft
        */
        if(step==1)
        {
            int number1=randoNum.nextInt(10)+1;
            int number2=randoNum.nextInt(10)+1;
            int horizontallyOrVertically=randoNum.nextInt(2)+1;
            if(horizontallyOrVertically==1)
            {
                if(cells[number1][number2].getRows() >= 1 && cells[number1][number2].getRows() <= 3 && !cells[number1][number2].getChosenArea())
                {
                    cells[number1][number2].setChosenArea();
                    cells[number1 + 1][number2].setChosenArea();
                    cells[number1 + 2][number2].setChosenArea();
                    cells[number1 + 3][number2].setChosenArea();
                    setAircraft(horizontallyOrVertically, cells[number1][number2].getRows(), cells[number1][number2], cells[number1 + 1][number2],
                                cells[number1 + 2][number2], cells[number1 + 3][number2]);
                    panel.updateUI();
                    step++;
                }
                if(cells[number1][number2].getRows() > 3 && cells[number1][number2].getRows() < 9 && !cells[number1][number2].getChosenArea())
                {
                    cells[number1][number2].setChosenArea();
                    cells[number1 - 1][number2].setChosenArea();
                    cells[number1 - 2][number2].setChosenArea();
                    cells[number1 - 3][number2].setChosenArea();
                    setAircraft(horizontallyOrVertically, cells[number1][number2].getRows(), cells[number1][number2], cells[number1 - 1][number2],
                                cells[number1 - 2][number2], cells[number1 - 3][number2]);
                    panel.updateUI();
                    step++;
                }
            }
            if(horizontallyOrVertically==2)
            {
                if(cells[number1][number2].getColumns() >= 8 && cells[number1][number2].getColumns() <= 10 && !cells[number1][number2].getChosenArea())
                {
                    cells[number1][number2].setChosenArea();
                    cells[number1][number2 - 1].setChosenArea();
                    cells[number1][number2 - 2].setChosenArea();
                    cells[number1][number2 - 3].setChosenArea();
                    setAircraft(horizontallyOrVertically, cells[number1][number2].getColumns(), cells[number1][number2], cells[number1][number2 - 1],
                                cells[number1][number2 - 2], cells[number1][number2 - 3]);
                    panel.updateUI();
                    step++;
                }
                if(cells[number1][number2].getColumns() >= 1 && cells[number1][number2].getColumns() < 8 && !cells[number1][number2].getChosenArea())
                {
                    cells[number1][number2].setChosenArea();
                    cells[number1][number2 + 1].setChosenArea();
                    cells[number1][number2 + 2].setChosenArea();
                    cells[number1][number2 + 3].setChosenArea();
                    setAircraft(horizontallyOrVertically, cells[number1][number2].getColumns(), cells[number1][number2], cells[number1][number2 + 1],
                            cells[number1][number2 + 2], cells[number1][number2 + 3]);
                    panel.updateUI();
                    step++;
                }
            }
        }

        /*
        Set the submarines
        */
        if(step==2)
        {
            while(armament < 2)
            {
                int number1 = randoNum.nextInt(10) + 1;
                int number2 = randoNum.nextInt(10) + 1;
                while(cells[number1][number2].getChosenArea())
                {
                    number1 = randoNum.nextInt(10) + 1;
                    number2 = randoNum.nextInt(10) + 1;
                }
                int horizontallyOrVertically = randoNum.nextInt(2) + 1;
                if (horizontallyOrVertically == 1)
                {
                    if (cells[number1][number2].getRows() >= 9 && cells[number1][number2].getRows() <= 10 && !cells[number1][number2].getChosenArea()
                        && !cells[number1 - 1][number2].getChosenArea() && !cells[number1 - 2][number2].getChosenArea())
                    {
                        cells[number1][number2].setChosenArea();
                        cells[number1 - 1][number2].setChosenArea();
                        cells[number1 - 2][number2].setChosenArea();
                        setSubmarine(horizontallyOrVertically, cells[number1][number2].getRows(), cells[number1][number2],
                                    cells[number1 - 1][number2], cells[number1 - 2][number2]);
                        panel.updateUI();
                        armament++;
                    }
                    if(cells[number1][number2].getRows() >= 1 && cells[number1][number2].getRows() <=8 && !cells[number1][number2].getChosenArea()
                        && !cells[number1 + 1][number2].getChosenArea() && !cells[number1 + 2][number2].getChosenArea())
                    {
                        cells[number1][number2].setChosenArea();
                        cells[number1 + 1][number2].setChosenArea();
                        cells[number1 + 2][number2].setChosenArea();
                        setSubmarine(horizontallyOrVertically, cells[number1][number2].getRows(), cells[number1][number2],
                                    cells[number1 + 1][number2], cells[number1 + 2][number2]);
                        panel.updateUI();
                        armament++;
                    }
                }
                if (horizontallyOrVertically == 2)
                {
                    if(cells[number1][number2].getColumns() == 10 || cells[number1][number2].getColumns() == 9 && !cells[number1][number2].getChosenArea()
                        && !cells[number1][number2 - 1].getChosenArea() && !cells[number1][number2 - 2].getChosenArea())
                    {
                        cells[number1][number2].setChosenArea();
                        cells[number1][number2 - 1].setChosenArea();
                        cells[number1][number2 - 2].setChosenArea();
                        setSubmarine(horizontallyOrVertically, cells[number1][number2].getColumns(), cells[number1][number2],
                                    cells[number1][number2 - 1], cells[number1][number2 - 2]);
                        panel.updateUI();
                        armament++;
                    }
                    if(cells[number1][number2].getColumns() >= 1 && cells[number1][number2].getColumns() < 9 && !cells[number1][number2].getChosenArea()
                        && !cells[number1][number2 + 1].getChosenArea() && !cells[number1][number2 + 2].getChosenArea())
                    {
                        cells[number1][number2].setChosenArea();
                        cells[number1][number2 + 1].setChosenArea();
                        cells[number1][number2 + 2].setChosenArea();
                        setSubmarine(horizontallyOrVertically, cells[number1][number2].getColumns(), cells[number1][number2],
                                    cells[number1][number2 + 1], cells[number1][number2 + 2]);
                        panel.updateUI();
                        armament++;
                    }
                }
            }

            if (armament == 2)
            {
                step++;
                armament=0;
            }
        }

        /*
        Set the destructors
        */
        if(step==3)
        {
            while(armament < 3)
            {
                int number1 = randoNum.nextInt(10) + 1;
                int number2 = randoNum.nextInt(10) + 1;
                while(cells[number1][number2].getChosenArea())
                {
                    number1 = randoNum.nextInt(10) + 1;
                    number2 = randoNum.nextInt(10) + 1;
                }
                int horizontallyOrVertically = randoNum.nextInt(2) + 1;
                if(horizontallyOrVertically==1)
                {
                    if(cells[number1][number2].getRows() == 10 && !cells[number1][number2].getChosenArea()
                        && !cells[number1 - 1][number2].getChosenArea())
                    {
                        cells[number1][number2].setChosenArea();
                        cells[number1 - 1][number2].setChosenArea();
                        setDestructors(horizontallyOrVertically, cells[number1][number2].getRows(), cells[number1][number2], cells[number1 - 1][number2]);
                        panel.updateUI();
                        armament++;
                    }

                    if (cells[number1][number2].getRows() >= 1 && cells[number1][number2].getRows() < 9 && !cells[number1][number2].getChosenArea()
                        && !cells[number1 + 1][number2].getChosenArea())
                    {
                        cells[number1][number2].setChosenArea();
                        cells[number1 + 1][number2].setChosenArea();
                        setDestructors(horizontallyOrVertically, cells[number1][number2].getRows(), cells[number1][number2], cells[number1 + 1][number2]);
                        panel.updateUI();
                        armament++;
                    }
                }
                if(horizontallyOrVertically==2)
                {
                    if (cells[number1][number2].getColumns() == 10 && !cells[number1][number2].getChosenArea()
                        && !cells[number1][number2 - 1].getChosenArea())
                    {
                        cells[number1][number2].setChosenArea();
                        cells[number1][number2 - 1].setChosenArea();
                        setDestructors(horizontallyOrVertically, cells[number1][number2].getColumns(), cells[number1][number2], cells[number1][number2 - 1]);
                        panel.updateUI();
                        armament++;
                    }

                    if (cells[number1][number2].getColumns() >= 1 && cells[number1][number2].getColumns() < 9 && !cells[number1][number2].getChosenArea()
                        && !cells[number1][number2 + 1].getChosenArea())
                    {
                        cells[number1][number2].setChosenArea();
                        cells[number1][number2 + 1].setChosenArea();
                        setDestructors(horizontallyOrVertically, cells[number1][number2].getColumns(), cells[number1][number2], cells[number1][number2 + 1]);
                        panel.updateUI();
                        armament++;
                    }
                }
            }
            if (armament == 3)
            {
                step++;
                armament=0;
            }
        }

        /*
        Set the frigates
        */
        if(step==4)
        {
            while(armament < 4)
            {
                int number1 = randoNum.nextInt(10) + 1;
                int number2 = randoNum.nextInt(10) + 1;
                while(cells[number1][number2].getChosenArea())
                {
                    number1 = randoNum.nextInt(10) + 1;
                    number2 = randoNum.nextInt(10) + 1;
                }
                if(!cells[number1][number2].getChosenArea())
                {
                    cells[number1][number2].setIcon(frigates); cells[number1][number2].setChosenArea();
                    cells[number1][number2].setBoatName("frigates");
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

    /*
    Determines the enemy shoot
    */
    public void enemyShoot(JPanel panel, Cells[][] cells)
    {
        Random random=new Random();
        int number1 = random.nextInt(10) + 1;
        int number2 = random.nextInt(10) + 1;
        if(cells[number1][number2].getChosenArea())
        {
            cells[number1][number2].setIcon(touchedImage);
            panel.updateUI();
            numberOfHits++;
        }
        if(!cells[number1][number2].getChosenArea())
        {
            cells[number1][number2].setIcon(waterImage);
            panel.updateUI();
        }
        if(cells[number1][number2].getBoatName().equals("frigates"))
        {
            cells[number1][number2].setIcon(sunkenImage);
            panel.updateUI();
        }
    }

    /*
    Determines if the player is the winner
    */
    public boolean winner(int hits)
    {
        boolean winner=false;
        if(hits==20)
        {
           winner=true;
        }
        return winner;
    }

    /*
    Determines if the enemy is the winner
    */
    public boolean enemyWin()
    {
        boolean win=false;
        if(numberOfHits==20)
        {
            win=true;
        }
        return win;
    }

    /*
    Set the aircraft on the enemy panel
    */
    private void setAircraft(int theOption, int place, Cells cell1, Cells cell2, Cells cell3, Cells cell4)
    {
        if(theOption==1)
        {
            if(place >=1 && place<=3)
            {
                for(int i=1; i <=4; i++)
                {
                    aircraft=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/"+i+"-aircraftDown.jpg")));
                    if(i==1)
                    {
                        cell1.setIcon(aircraft);
                    }
                    if(i==2)
                    {
                        cell2.setIcon(aircraft);
                    }
                    if(i==3)
                    {
                        cell3.setIcon(aircraft);
                    }
                    if(i==4)
                    {
                        cell4.setIcon(aircraft);
                    }
                }
            }
            if(place > 3 && place <=10)
            {
                for(int i=1; i <=4; i++)
                {
                    aircraft=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/"+i+"-aircraft.jpg")));
                    if(i==1)
                    {
                        cell1.setIcon(aircraft);
                    }
                    if(i==2)
                    {
                        cell2.setIcon(aircraft);
                    }
                    if(i==3)
                    {
                        cell3.setIcon(aircraft);
                    }
                    if(i==4)
                    {
                        cell4.setIcon(aircraft);
                    }
                }
            }
        }
        if(theOption==2)
        {
            if(place >=8 && place <=10)
            {
                for(int i=1; i <=4; i++)
                {
                    aircraft=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/"+i+"-aircraftLeft.jpg")));
                    if(i==1)
                    {
                        cell1.setIcon(aircraft);
                    }
                    if(i==2)
                    {
                        cell2.setIcon(aircraft);
                    }
                    if(i==3)
                    {
                        cell3.setIcon(aircraft);
                    }
                    if(i==4)
                    {
                        cell4.setIcon(aircraft);
                    }
                }
            }
            if(place >= 1 && place <=7)
            {
                for(int i=1; i <=4; i++)
                {
                    aircraft=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/"+i+"-aircraftRight.jpg")));
                    if(i==1)
                    {
                        cell1.setIcon(aircraft);
                    }
                    if(i==2)
                    {
                        cell2.setIcon(aircraft);
                    }
                    if(i==3)
                    {
                        cell3.setIcon(aircraft);
                    }
                    if(i==4)
                    {
                        cell4.setIcon(aircraft);
                    }
                }
            }
        }
    }

    /*
    Set the submarines on the enemy panel
    */
    private void setSubmarine(int theOption, int place, Cells cell1, Cells cell2, Cells cell3)
    {
        if(theOption==1)
        {
            if(place >= 9 && place <=10)
            {
                for(int i=1; i <=3; i++)
                {
                    submarine=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/"+i+"-submarine.jpg")));
                    if(i==1)
                    {
                        cell1.setIcon(submarine);
                    }
                    if(i==2)
                    {
                        cell2.setIcon(submarine);
                    }
                    if(i==3)
                    {
                        cell3.setIcon(submarine);
                    }
                }
            }
            if(place >=1 && place <9)
            {
                for(int i=1; i <=3; i++)
                {
                    submarine=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/"+i+"-submarineDown.jpg")));
                    if(i==1)
                    {
                        cell1.setIcon(submarine);
                    }
                    if(i==2)
                    {
                        cell2.setIcon(submarine);
                    }
                    if(i==3)
                    {
                        cell3.setIcon(submarine);
                    }
                }
            }
        }
        if(theOption==2)
        {
            if(place >= 9 && place <= 10)
            {
                for(int i=1; i <=3; i++)
                {
                    submarine=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/"+i+"-submarineLeft.jpg")));
                    if(i==1)
                    {
                        cell1.setIcon(submarine);
                    }
                    if(i==2)
                    {
                        cell2.setIcon(submarine);
                    }
                    if(i==3)
                    {
                        cell3.setIcon(submarine);
                    }
                }
            }

            if(place >= 1 && place < 9)
            {
                for(int i=1; i <=3; i++)
                {
                    submarine=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/"+i+"-submarineRight.jpg")));
                    if(i==1)
                    {
                        cell1.setIcon(submarine);
                    }
                    if(i==2)
                    {
                        cell2.setIcon(submarine);
                    }
                    if(i==3)
                    {
                        cell3.setIcon(submarine);
                    }
                }
            }
        }
    }

    /*
    Set the destructors on the enemy panel
    */
    private void setDestructors(int theOption, int place, Cells cell1, Cells cell2)
    {
        if(theOption==1)
        {
            if(place==10)
            {
                for(int i=1; i <=2; i++)
                {
                    destructors=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/"+i+"-destructor.jpg")));
                    if(i==1)
                    {
                        cell1.setIcon(destructors);
                    }
                    if(i==2)
                    {
                        cell2.setIcon(destructors);
                    }
                }
            }
            if(place >= 1 && place <= 9)
            {
                for(int i=1; i <=2; i++)
                {
                    destructors=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/"+i+"-destructorDown.jpg")));
                    if(i==1)
                    {
                        cell1.setIcon(destructors);
                    }
                    if(i==2)
                    {
                        cell2.setIcon(destructors);
                    }
                }
            }
        }
        if(theOption==2)
        {
            if(place==10)
            {
                for(int i=1; i <=2; i++)
                {
                    destructors=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/"+i+"-destructorLeft.jpg")));
                    if(i==1)
                    {
                        cell1.setIcon(destructors);
                    }
                    if(i==2)
                    {
                        cell2.setIcon(destructors);
                    }
                }
            }
            if(place >=1 && place <=9)
            {
                for(int i=1; i <=2; i++)
                {
                    destructors=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/"+i+"-destructorRight.jpg")));
                    if(i==1)
                    {
                        cell1.setIcon(destructors);
                    }
                    if(i==2)
                    {
                        cell2.setIcon(destructors);
                    }
                }
            }
        }
    }
}
