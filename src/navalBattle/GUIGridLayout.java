package navalBattle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

/**
 * This class is used for ...
 * Alan Valderrama - 2042836 - alan.valderrama@correounivalle.edu.co
 * Jeison Perea - 2077250 - jeison.perea@correounivalle.edu.co
 * @version v.1.0.0 date:15/03/2022
 */
public class GUIGridLayout extends JFrame
{
    /*
    Attributes
    */
    public static final String BEGINNING_MESSAGE="Welcome to Naval Battle!!! \n"
            +"\nPush the 'PLAY' button to start the game."
            +"\nIf you want more ease to win the game, press the 'SEE ENEMY PANEL' button to see the enemy panel."
            +"\nYour goal is to destroy all enemy weapons."
            +"\nTo accommodate your ships you must click on a blue image in the Position Panel and select if you want it vertically or horizontally."
            +"\nTo make your shot you must click on any blue image on the Principal Panel.\n"
            +"\nHow does the organization of boats work? Well..."
            +"\nIf you chose to put the boat vertically and it's in the nine or ten row, the boat stands upright."
            +"\nIf you chose to put the boat vertically and it's in the one or two row, the boat is placed down."
            +"\nIf you chose to put the boat horizontally and it's in the nine or ten column, the boat is positioned to the left."
            +"\nIf you chose to put the boat horizontally and it's in the one or two column, the boat is positioned to the right.\n"
            +"\nWhat do the images on the panels mean? Well..."
            +"\nimage of the red X: It means that the shot you made missed and landed in the water."
            +"\nimage of the bomb: It means that you hit the shot somewhere on the ship."
            +"\nimage of fire: It means you completely sunk the ship.";

    private Listener listener;
    private JPanel positionPanel, principalPanel, enemyPanel, userPanel;
    private ImageIcon defaultImage, lettersImage, numbersImage, touchedImage, sunkenImage, waterImage, testImage;
    private JButton playButton, howToPlayButton, seeEnemyPanel, deactivateEnemyPanel;
    private Cells[][] positionPanelCells, principalPanelCells, enemyPanelCells;
    private ControlNavalBattle controlNavalBattle;
    private ImageIcon frigates, aircraft, submarine, destructors;


    /**
     * Constructor of GUI class
     */
    public GUIGridLayout()
    {
        initGUI();
        //Default JFrame configuration
        this.setTitle("Naval Battle App");
        //this.setUndecorated(true);
        this.setBackground(new Color(255,255,255,255));
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /*
    Set the letters on the panel
    */
    private void setLettersImages(ImageIcon image, Cells[][] cells, JPanel panel)
    {
        for(int i=1; i <= 10; i++)
        {
            image=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/"+i+"-letters.jpg")));
            cells[0][i].setIcon(image);
            cells[0][i].removeActionListener(listener);
            cells[0][i].setBorder(null);
            panel.updateUI();
        }
    }

    /*
    Set the numbers on the panel
    */
    private void setNumbersImage(ImageIcon image, Cells[][] cells, JPanel panel)
    {
        for(int i=1; i <= 10; i++)
        {
            image=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/"+i+"-numbers.jpg")));
            cells[i][0].setIcon(image);
            cells[i][0].removeActionListener(listener);
            cells[i][0].setBorder(null);
            panel.updateUI();
        }
    }

    /*
    Set the Cells on the panel
    */
    private void setCells(ImageIcon image, Cells[][] cells, JPanel panel, ActionListener theListener)
    {
        for(int i=0; i < 11; i++)
        {
            for(int index=0; index < 11; index++)
            {
                cells[i][index]=new Cells(i, index, false);
                cells[i][index].setIcon(image);
                cells[i][index].setBorder(null);
                panel.add(cells[i][index]);
                cells[i][index].addActionListener(theListener);
                if(cells==enemyPanelCells)
                {
                    cells[i][index].setVisible(false);
                }
            }
        }
    }

    /*
    Set the aircraft on the panel
    */
    private void setAircraft(int theOption, int place, Cells cell1, Cells cell2, Cells cell3, Cells cell4)
    {
        if(theOption==JOptionPane.YES_OPTION)
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
        if(theOption==JOptionPane.NO_OPTION)
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
    Set the submarines on the panel
    */
    private void setSubmarine(int theOption, int place, Cells cell1, Cells cell2, Cells cell3)
    {
        if(theOption==JOptionPane.YES_OPTION)
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
        if(theOption==JOptionPane.NO_OPTION)
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
    Set the destructors on the panel
    */
    private void setDestructors(int theOption, int place, Cells cell1, Cells cell2)
    {
        if(theOption==JOptionPane.YES_OPTION)
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
        if(theOption==JOptionPane.NO_OPTION)
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

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI()
    {
        //Set up JFrame Container's Layout
        this.getContentPane().setLayout(new GridLayout(2,2));
        //Create Listener Object and Control Object
        listener=new Listener();
        controlNavalBattle=new ControlNavalBattle();
        //Set up JComponents
        /*
        creating cells and images
        */
        enemyPanelCells=new Cells[11][11];
        positionPanelCells=new Cells[11][11];
        principalPanelCells=new Cells[11][11];
        defaultImage=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/defaultImage.jpg")));
        sunkenImage=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/sunken.jpg")));
        touchedImage=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/touched.jpg")));
        waterImage=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/water.png")));
        testImage=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/cyan.jpg")));
        frigates=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/frigates.jpg")));

        /*
        Position Panel creation
        */
        positionPanel=new JPanel();
        positionPanel.setPreferredSize(new Dimension(600,400));
        positionPanel.setBorder(BorderFactory.createTitledBorder("Position Panel."));
        this.add(positionPanel, this.getContentPane());
        setCells(defaultImage, positionPanelCells, positionPanel, listener);
        setLettersImages(lettersImage, positionPanelCells, positionPanel);
        setNumbersImage(numbersImage, positionPanelCells, positionPanel);

        /*
        Principal Panel creation
         */
        principalPanel=new JPanel();
        principalPanel.setPreferredSize(new Dimension(600,400));
        principalPanel.setBorder(BorderFactory.createTitledBorder("Principal Panel."));
        this.add(principalPanel, this.getContentPane());
        setCells(defaultImage, principalPanelCells, principalPanel, listener);
        setLettersImages(lettersImage, principalPanelCells, principalPanel);
        setNumbersImage(numbersImage, principalPanelCells, principalPanel);

        /*
        Enemy Panel creation
         */
        enemyPanel=new JPanel();
        enemyPanel.setPreferredSize(new Dimension(600,400));
        enemyPanel.setBorder(BorderFactory.createTitledBorder("Enemy Panel."));
        this.add(enemyPanel, this.getContentPane());
        setCells(defaultImage, enemyPanelCells, enemyPanel, listener);
        setLettersImages(lettersImage, enemyPanelCells, enemyPanel);
        setNumbersImage(numbersImage, enemyPanelCells, enemyPanel);

        /*
        User Panel creation
         */
        userPanel=new JPanel();
        userPanel.setPreferredSize(new Dimension(600,400));
        userPanel.setBorder(BorderFactory.createTitledBorder("User Panel."));
        this.add(userPanel, this.getContentPane());

        /*
        Play Button creation
        */
        playButton=new JButton("     PLAY     ");
        playButton.addActionListener(listener);
        userPanel.add(playButton);

        /*
        See Enemy Panel Button creation
        */
        seeEnemyPanel=new JButton("ACTIVATE ENEMY PANEL");
        seeEnemyPanel.addActionListener(listener);
        userPanel.add(seeEnemyPanel);

        /*
        Deactivate enemy panel button creation
        */
        deactivateEnemyPanel=new JButton("DEACTIVATE ENEMY PANEL");
        deactivateEnemyPanel.addActionListener(listener);
        userPanel.add(deactivateEnemyPanel);

        /*
        How to Plat Button creation
        */
        howToPlayButton=new JButton("ABOUT(?)");
        howToPlayButton.addActionListener(listener);
        userPanel.add(howToPlayButton);
    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            GUIGridLayout miProjectGUI = new GUIGridLayout();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Listener implements ActionListener
    {
        /*
        Attributes
        */
        private int flagEnemyPanel=0, armament=0, step=1, firstTime=0, hits=0;
        private boolean setBoats=false, flag=false;

        @Override
        public void actionPerformed(ActionEvent e)
        {
            /*
            Play button action
            */
            if(e.getSource()==playButton)
            {
                setBoats=true;
                JOptionPane.showMessageDialog(null, "Is time to put your boats!!!");
                JOptionPane.showMessageDialog(null, "Now you will put the aircraft carrier (they occupy four cells).");
                playButton.setEnabled(false);
            }

            /*
            How to play button action
            */
            if(e.getSource()==howToPlayButton)
            {
                JOptionPane.showMessageDialog(null, BEGINNING_MESSAGE);
            }

            /*
            See enemy panel action
            */
            if(e.getSource()==seeEnemyPanel)
            {
                for (int i = 0; i < 11; i++)
                {
                    for (int index = 0; index < 11; index++)
                    {
                        enemyPanelCells[i][index].setVisible(true);
                    }
                }
                enemyPanel.updateUI();
            }

            /*
            Deactivate enemy panel action
            */
            if(e.getSource()==deactivateEnemyPanel)
            {
                for (int i = 0; i < 11; i++)
                {
                    for (int index = 0; index < 11; index++)
                    {
                        enemyPanelCells[i][index].setVisible(false);
                    }
                }
                enemyPanel.updateUI();
            }

            /*
            The player begins to play
            */
            else if(setBoats)
            {
                /*
                find the specific cell button
                */
                for(int i=0; i < 11; i++)
                {
                    for(int j=0; j < 11; j++)
                    {
                        if (e.getSource() == positionPanelCells[i][j])
                        {
                            /*
                            Set the aircraft
                            */
                            if (step == 1)
                            {
                                int option = JOptionPane.showConfirmDialog(positionPanel, "Do you want to put the boat vertically? (if you choose 'No' the ship is placed horizontally)",
                                        "Choice Window", JOptionPane.YES_NO_OPTION);
                                if (option == JOptionPane.YES_OPTION)
                                {
                                    if (positionPanelCells[i][j].getRows() >= 1 && positionPanelCells[i][j].getRows() <= 3)
                                    {
                                        positionPanelCells[i][j].setChosenArea();
                                        positionPanelCells[i + 1][j].setChosenArea();
                                        positionPanelCells[i + 2][j].setChosenArea();
                                        positionPanelCells[i + 3][j].setChosenArea();
                                        setAircraft(option, positionPanelCells[i][j].getRows(), positionPanelCells[i][j], positionPanelCells[i + 1][j],
                                                    positionPanelCells[i + 2][j], positionPanelCells[i + 3][j]);
                                        positionPanel.updateUI();
                                        JOptionPane.showMessageDialog(null, "Now you will put the 2 submarines (they occupy three cells)");
                                        step++;
                                    }
                                    if(positionPanelCells[i][j].getRows() > 3 && positionPanelCells[i][j].getRows() <= 10)
                                    {
                                        positionPanelCells[i][j].setChosenArea();
                                        positionPanelCells[i - 1][j].setChosenArea();
                                        positionPanelCells[i - 2][j].setChosenArea();
                                        positionPanelCells[i - 3][j].setChosenArea();
                                        setAircraft(option, positionPanelCells[i][j].getRows(), positionPanelCells[i][j], positionPanelCells[i - 1][j],
                                                    positionPanelCells[i - 2][j], positionPanelCells[i - 3][j]);
                                        positionPanel.updateUI();
                                        JOptionPane.showMessageDialog(null, "Now you will put the 2 submarines (they occupy three cells)");
                                        step++;
                                    }
                                }

                                if (option == JOptionPane.NO_OPTION)
                                {
                                    if (positionPanelCells[i][j].getColumns() >=8 && positionPanelCells[i][j].getColumns() <= 10)
                                    {
                                        positionPanelCells[i][j].setChosenArea();
                                        positionPanelCells[i][j - 1].setChosenArea();
                                        positionPanelCells[i][j - 2].setChosenArea();
                                        positionPanelCells[i][j - 3].setChosenArea();
                                        setAircraft(option, positionPanelCells[i][j].getColumns(), positionPanelCells[i][j], positionPanelCells[i][j - 1],
                                                    positionPanelCells[i][j - 2], positionPanelCells[i][j - 3]);
                                        positionPanel.updateUI();
                                        JOptionPane.showMessageDialog(null, "Now you will put the 2 submarines (they occupy three cells)");
                                        step++;
                                    }
                                    if(positionPanelCells[i][j].getColumns() >= 1 && positionPanelCells[i][j].getColumns() < 8)
                                    {
                                        positionPanelCells[i][j].setChosenArea();
                                        positionPanelCells[i][j + 1].setChosenArea();
                                        positionPanelCells[i][j + 2].setChosenArea();
                                        positionPanelCells[i][j + 3].setChosenArea();
                                        setAircraft(option, positionPanelCells[i][j].getColumns(), positionPanelCells[i][j], positionPanelCells[i][j + 1],
                                                    positionPanelCells[i][j + 2], positionPanelCells[i][j + 3]);
                                        positionPanel.updateUI();
                                        JOptionPane.showMessageDialog(null, "Now you will put the 2 submarines (they occupy three cells)");
                                        step++;
                                    }
                                }
                            }

                            /*
                            Set the submarines
                            */
                            if (step == 2)
                            {
                                if (firstTime >= 1)
                                {
                                    int option = JOptionPane.showConfirmDialog(positionPanel, "Do you want to put the boat vertically? (if you choose 'No' the ship is placed horizontally)",
                                            "Choice Window", JOptionPane.YES_NO_OPTION);
                                    if (option == JOptionPane.YES_OPTION)
                                    {
                                        if (positionPanelCells[i][j].getRows() >= 9 && positionPanelCells[i][j].getRows() <= 10)
                                        {
                                            positionPanelCells[i][j].setChosenArea();
                                            positionPanelCells[i - 1][j].setChosenArea();
                                            positionPanelCells[i - 2][j].setChosenArea();
                                            setSubmarine(option, positionPanelCells[i][j].getRows(), positionPanelCells[i][j],
                                                        positionPanelCells[i - 1][j], positionPanelCells[i - 2][j]);
                                            positionPanel.updateUI();
                                            armament++;
                                        }

                                        if(positionPanelCells[i][j].getRows() >= 1 && positionPanelCells[i][j].getRows() < 9)
                                        {
                                            positionPanelCells[i][j].setChosenArea();
                                            positionPanelCells[i + 1][j].setChosenArea();
                                            positionPanelCells[i + 2][j].setChosenArea();
                                            setSubmarine(option, positionPanelCells[i][j].getRows(), positionPanelCells[i][j],
                                                        positionPanelCells[i + 1][j], positionPanelCells[i + 2][j]);
                                            positionPanel.updateUI();
                                            armament++;
                                        }
                                    }

                                    if (option == JOptionPane.NO_OPTION)
                                    {
                                        if (positionPanelCells[i][j].getColumns() >= 9 && positionPanelCells[i][j].getColumns() <= 10)
                                        {
                                            positionPanelCells[i][j].setChosenArea();
                                            positionPanelCells[i][j - 1].setChosenArea();
                                            positionPanelCells[i][j - 2].setChosenArea();
                                            setSubmarine(option, positionPanelCells[i][j].getColumns(), positionPanelCells[i][j],
                                                        positionPanelCells[i][j - 1], positionPanelCells[i][j - 2]);
                                            positionPanel.updateUI();
                                            armament++;
                                        }
                                        if(positionPanelCells[i][j].getColumns() >= 1 && positionPanelCells[i][j].getColumns() < 9)
                                        {
                                            positionPanelCells[i][j].setChosenArea();
                                            positionPanelCells[i][j + 1].setChosenArea();
                                            positionPanelCells[i][j + 2].setChosenArea();
                                            setSubmarine(option, positionPanelCells[i][j].getColumns(), positionPanelCells[i][j],
                                                        positionPanelCells[i][j + 1], positionPanelCells[i][j + 2]);
                                            positionPanel.updateUI();
                                            armament++;
                                        }
                                    }
                                }
                                firstTime++;
                                if (armament == 2)
                                {
                                    JOptionPane.showMessageDialog(null, "Now you will put the 3 destructors (they occupy two cells)");
                                    armament = 0;
                                    firstTime=0;
                                    step++;
                                }
                            }

                            /*
                            Set the destructors
                            */
                            if (step == 3)
                            {
                                if (firstTime >= 1)
                                {
                                    int option = JOptionPane.showConfirmDialog(positionPanel, "Do you want to put the boat vertically? (if you choose 'No' the ship is placed horizontally)",
                                            "Choice Window", JOptionPane.YES_NO_OPTION);
                                    if (option == JOptionPane.YES_OPTION)
                                    {
                                        if (positionPanelCells[i][j].getRows() == 10)
                                        {
                                            positionPanelCells[i][j].setChosenArea();
                                            positionPanelCells[i - 1][j].setChosenArea();
                                            setDestructors(option, positionPanelCells[i][j].getRows(), positionPanelCells[i][j], positionPanelCells[i - 1][j]);
                                            positionPanel.updateUI();
                                            armament++;
                                        }

                                        if (positionPanelCells[i][j].getRows() >= 1 && positionPanelCells[i][j].getRows() <= 9)
                                        {
                                            positionPanelCells[i][j].setChosenArea();
                                            positionPanelCells[i + 1][j].setChosenArea();
                                            setDestructors(option, positionPanelCells[i][j].getRows(), positionPanelCells[i][j], positionPanelCells[i + 1][j]);
                                            positionPanel.updateUI();
                                            armament++;
                                        }
                                    }

                                    if (option == JOptionPane.NO_OPTION)
                                    {
                                        if (positionPanelCells[i][j].getColumns() == 10)
                                        {
                                            positionPanelCells[i][j].setChosenArea();
                                            positionPanelCells[i][j - 1].setChosenArea();
                                            setDestructors(option, positionPanelCells[i][j].getColumns(), positionPanelCells[i][j], positionPanelCells[i][j - 1]);
                                            positionPanel.updateUI();
                                            armament++;
                                        }

                                        if (positionPanelCells[i][j].getColumns() >= 1 && positionPanelCells[i][j].getColumns() <= 9)
                                        {
                                            positionPanelCells[i][j].setChosenArea();
                                            positionPanelCells[i][j + 1].setChosenArea();
                                            setDestructors(option, positionPanelCells[i][j].getColumns(), positionPanelCells[i][j], positionPanelCells[i][j + 1]);
                                            positionPanel.updateUI();
                                            armament++;
                                        }
                                    }
                                }
                                firstTime++;
                                if (armament == 3)
                                {
                                    JOptionPane.showMessageDialog(null, "Now you will put the 4 frigates (they occupy one cell)");
                                    armament = 0;
                                    firstTime=0;
                                    step++;
                                }
                            }

                            /*
                            Set the frigates
                            */
                            if (step == 4)
                            {
                                if (firstTime >= 1)
                                {
                                    positionPanelCells[i][j].setIcon(frigates); positionPanelCells[i][j].setChosenArea();
                                    positionPanelCells[i][j].setBoatName("frigates");
                                    positionPanel.updateUI();
                                    armament++;
                                }
                                if (armament == 4)
                                {
                                    JOptionPane.showMessageDialog(null, "It's time to attack the enemy boats");
                                    step++;
                                }
                                firstTime++;
                            }
                        }
                    }
                }

                /*
                The player starts shooting the enemy
                */
                if (step == 5)
                {
                    /*
                    Set the enemy panel and determines if the player is winner or not
                    */
                    controlNavalBattle.setEnemyPanel(enemyPanel, enemyPanelCells);
                    seeEnemyPanel.updateUI();
                    boolean win=controlNavalBattle.winner(hits);
                    boolean enemyWin=controlNavalBattle.enemyWin();
                    /*
                    While the player doesn't win, he'll continue to make his shots
                    */
                    if (!win)
                    {
                        for (int i = 0; i < 11; i++)
                        {
                            for (int j = 0; j < 11; j++)
                            {
                                if (e.getSource() == principalPanelCells[i][j])
                                {
                                    if(enemyPanelCells[i][j].getChosenArea())
                                    {
                                        principalPanelCells[i][j].setIcon(touchedImage);
                                        principalPanel.updateUI();
                                        hits++;
                                    }
                                    if(!enemyPanelCells[i][j].getChosenArea())
                                    {
                                        principalPanelCells[i][j].setIcon(waterImage);
                                        principalPanel.updateUI();
                                    }
                                    if(enemyPanelCells[i][j].getBoatName().equals("frigates"))
                                    {
                                        principalPanelCells[i][j].setIcon(sunkenImage);
                                        principalPanel.updateUI();
                                    }
                                }
                            }
                        }
                        if(firstTime >= 1)
                        {
                            controlNavalBattle.enemyShoot(positionPanel, positionPanelCells);
                        }
                        firstTime++;
                    }

                    /*
                    If the enemy is winner
                    */
                    if(enemyWin)
                    {
                        for(int i=1; i < 11; i++)
                        {
                            for(int j=1; j < 11; j++)
                            {
                                if(positionPanelCells[i][j].getChosenArea())
                                {
                                    positionPanelCells[i][j].setIcon(sunkenImage);
                                    positionPanel.updateUI();
                                }
                            }
                        }
                        JOptionPane.showMessageDialog(null, "You lose, good luck next time. Thanks for play");
                        System.exit(0);
                    }

                    /*
                    If the player is winner
                    */
                    if(win)
                    {
                        for(int i=1; i < 11; i++)
                        {
                            for(int j=1; j < 11; j++)
                            {
                                if(enemyPanelCells[i][j].getChosenArea())
                                {
                                    principalPanelCells[i][j].setIcon(sunkenImage);
                                    principalPanel.updateUI();
                                }
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Congratulations, you win!!! thanks for play");
                        System.exit(0);
                    }
                }
            }
        }
    }
}
