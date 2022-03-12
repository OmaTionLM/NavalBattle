package navalBattle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * This class is used for ...
 * @autor Paola-J Rodriguez-C paola.rodriguez@correounivalle.edu.co
 * @version v.1.0.0 date:21/11/2021
 */
public class GUIGridLayout extends JFrame
{
    public static final String BEGINNING_MESSAGE="Welcome to Naval Battle \n"
            +"Push the 'PLAY' button to start the game."
            +"\nIf you want more ease to win the game, press the 'SEE ENEMY PANEL' button to see the enemy panel."
            +"\nYour goal is to destroy all enemy weapons."
            +"\nTo accommodate your ships you must click on a blue image in the Position Panel and select if you want it vertically or horizontally."
            +"\nTo make your shot you must click on any blue image on the Principal Panel.";
    private Listener listener;
    private JPanel positionPanel, principalPanel, enemyPanel, userPanel;
    private ImageIcon defaultImage, lettersImage, numbersImage, touchedImage, sunkenImage, waterImage, testImage;
    private JButton playButton, howToPlayButton, seeEnemyPanel;
    private Cells[][] positionPanelCells, principalPanelCells, enemyPanelCells;
    private ControlNavalBattle controlNavalBattle;


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

    /**/
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

    /**/
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

    /**/
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
        */
        enemyPanelCells=new Cells[11][11];
        positionPanelCells=new Cells[11][11];
        principalPanelCells=new Cells[11][11];
        defaultImage=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/defaultImage.jpg")));
        sunkenImage=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/sunken.jpg")));
        touchedImage=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/touched.jpg")));
        waterImage=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/water.png")));
        testImage=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/cyan.jpg")));

        /*
        */
        positionPanel=new JPanel();
        positionPanel.setPreferredSize(new Dimension(600,400));
        positionPanel.setBorder(BorderFactory.createTitledBorder("Position Panel."));
        this.add(positionPanel, this.getContentPane());
        setCells(defaultImage, positionPanelCells, positionPanel, listener);
        setLettersImages(lettersImage, positionPanelCells, positionPanel);
        setNumbersImage(numbersImage, positionPanelCells, positionPanel);

        /*
         */
        principalPanel=new JPanel();
        principalPanel.setPreferredSize(new Dimension(600,400));
        principalPanel.setBorder(BorderFactory.createTitledBorder("Principal Panel."));
        this.add(principalPanel, this.getContentPane());
        setCells(defaultImage, principalPanelCells, principalPanel, listener);
        setLettersImages(lettersImage, principalPanelCells, principalPanel);
        setNumbersImage(numbersImage, principalPanelCells, principalPanel);

        /*
         */
        enemyPanel=new JPanel();
        enemyPanel.setPreferredSize(new Dimension(600,400));
        enemyPanel.setBorder(BorderFactory.createTitledBorder("Enemy Panel."));
        this.add(enemyPanel, this.getContentPane());
        setCells(defaultImage, enemyPanelCells, enemyPanel, listener);
        setLettersImages(lettersImage, enemyPanelCells, enemyPanel);
        setNumbersImage(numbersImage, enemyPanelCells, enemyPanel);

        /*
         */
        userPanel=new JPanel();
        userPanel.setPreferredSize(new Dimension(600,400));
        userPanel.setBorder(BorderFactory.createTitledBorder("User Panel."));
        this.add(userPanel, this.getContentPane());

        /**/
        playButton=new JButton("     PLAY     ");
        playButton.addActionListener(listener);
        userPanel.add(playButton);

        /**/
        howToPlayButton=new JButton("HOW TO PLAY");
        howToPlayButton.addActionListener(listener);
        userPanel.add(howToPlayButton);

        /**/
        seeEnemyPanel=new JButton("SEE ENEMY PANEL");
        seeEnemyPanel.addActionListener(listener);
        userPanel.add(seeEnemyPanel);
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
        private int flagEnemyPanel=0, armament=0, step=5, firstTime=0;
        private boolean setBoats=false, game=true;

        @Override
        public void actionPerformed(ActionEvent e)
        {
            /**/
            if(e.getSource()==playButton)
            {
                setBoats=true;
                JOptionPane.showMessageDialog(null, "Is time to put your boats!!!");
                JOptionPane.showMessageDialog(null, "Now you will put the aircraft carrier (they occupy four cells).");
                playButton.setEnabled(false);
            }

            /**/
            if(e.getSource()==howToPlayButton)
            {
                JOptionPane.showMessageDialog(null, BEGINNING_MESSAGE);
            }

            /**/
            if(e.getSource()==seeEnemyPanel)
            {
                if(flagEnemyPanel==0)
                {
                    for (int i = 0; i < 11; i++)
                    {
                        for (int index = 0; index < 11; index++)
                        {
                            enemyPanelCells[i][index].setVisible(true);
                        }
                    }
                }
                enemyPanel.updateUI();
            }
            else if(setBoats)
            {
                for(int i=0; i < 11; i++)
                {
                    for(int j=0; j < 11; j++)
                    {
                        if (e.getSource() == positionPanelCells[i][j])
                        {
                            //controlNavalBattle.setAircraftCarrier(positionPanel, positionPanelCells[i][j], testImage, step);
                            if (step == 1)
                            {
                                int option = JOptionPane.showConfirmDialog(positionPanel, "Do you want to put the boat vertically?",
                                        "Choice Window", JOptionPane.YES_NO_OPTION);
                                if (option == JOptionPane.YES_OPTION)
                                {
                                    if (positionPanelCells[i][j].getRows() == 1 || positionPanelCells[i][j].getRows() == 2 || positionPanelCells[i][j].getRows() == 3)
                                    {
                                        positionPanelCells[i][j].setIcon(testImage); positionPanelCells[i][j].setChosenArea();
                                        positionPanelCells[i + 1][j].setIcon(testImage); positionPanelCells[i + 1][j].setChosenArea();
                                        positionPanelCells[i + 2][j].setIcon(testImage); positionPanelCells[i + 2][j].setChosenArea();
                                        positionPanelCells[i + 3][j].setIcon(testImage); positionPanelCells[i + 3][j].setChosenArea();
                                        positionPanel.updateUI();
                                        JOptionPane.showMessageDialog(null, "Now you will put the 2 submarines (they occupy three cells)");
                                        step++;
                                    }
                                    if(positionPanelCells[i][j].getRows() > 3 && positionPanelCells[i][j].getRows() < 9)
                                    {
                                        positionPanelCells[i][j].setIcon(testImage); positionPanelCells[i][j].setChosenArea();
                                        positionPanelCells[i - 1][j].setIcon(testImage); positionPanelCells[i - 1][j].setChosenArea();
                                        positionPanelCells[i - 2][j].setIcon(testImage); positionPanelCells[i - 2][j].setChosenArea();
                                        positionPanelCells[i - 3][j].setIcon(testImage); positionPanelCells[i - 3][j].setChosenArea();
                                        positionPanel.updateUI();
                                        JOptionPane.showMessageDialog(null, "Now you will put the 2 submarines (they occupy three cells)");
                                        step++;
                                    }
                                }

                                if (option == JOptionPane.NO_OPTION)
                                {
                                    if (positionPanelCells[i][j].getColumns() == 10 || positionPanelCells[i][j].getColumns() == 9 || positionPanelCells[i][j].getColumns() == 8)
                                    {
                                        positionPanelCells[i][j].setIcon(testImage); positionPanelCells[i][j].setChosenArea();
                                        positionPanelCells[i][j - 1].setIcon(testImage); positionPanelCells[i][j - 1].setChosenArea();
                                        positionPanelCells[i][j - 2].setIcon(testImage); positionPanelCells[i][j - 2].setChosenArea();
                                        positionPanelCells[i][j - 3].setIcon(testImage); positionPanelCells[i][j - 3].setChosenArea();
                                        positionPanel.updateUI();
                                        JOptionPane.showMessageDialog(null, "Now you will put the 2 submarines (they occupy three cells)");
                                        step++;
                                    }
                                    if(positionPanelCells[i][j].getColumns() >= 1 && positionPanelCells[i][j].getColumns() < 8)
                                    {
                                        positionPanelCells[i][j].setIcon(testImage); positionPanelCells[i][j].setChosenArea();
                                        positionPanelCells[i][j + 1].setIcon(testImage); positionPanelCells[i][j + 1].setChosenArea();
                                        positionPanelCells[i][j + 2].setIcon(testImage); positionPanelCells[i][j + 2].setChosenArea();
                                        positionPanelCells[i][j + 3].setIcon(testImage); positionPanelCells[i][j + 3].setChosenArea();
                                        positionPanel.updateUI();
                                        JOptionPane.showMessageDialog(null, "Now you will put the 2 submarines (they occupy three cells)");
                                        step++;
                                    }
                                }
                            }

                            if (step == 2)
                            {
                                if (firstTime >= 1)
                                {
                                    int option = JOptionPane.showConfirmDialog(positionPanel, "Do you want to put the boat vertically?",
                                            "Choice Window", JOptionPane.YES_NO_OPTION);
                                    if (option == JOptionPane.YES_OPTION)
                                    {
                                        if (positionPanelCells[i][j].getRows() == 10)
                                        {
                                            positionPanelCells[i][j].setIcon(testImage); positionPanelCells[i][j].setChosenArea();
                                            positionPanelCells[i - 1][j].setIcon(testImage); positionPanelCells[i - 1][j].setChosenArea();
                                            positionPanelCells[i - 2][j].setIcon(testImage); positionPanelCells[i - 2][j].setChosenArea();
                                            positionPanel.updateUI();
                                            armament++;
                                        }

                                        if(positionPanelCells[i][j].getRows() >= 1 && positionPanelCells[i][j].getRows() < 10)
                                        {
                                            positionPanelCells[i][j].setIcon(testImage); positionPanelCells[i][j].setChosenArea();
                                            positionPanelCells[i + 1][j].setIcon(testImage); positionPanelCells[i + 1][j].setChosenArea();
                                            positionPanelCells[i + 2][j].setIcon(testImage); positionPanelCells[i + 2][j].setChosenArea();
                                            positionPanel.updateUI();
                                            armament++;
                                        }
                                    }

                                    if (option == JOptionPane.NO_OPTION)
                                    {
                                        if (positionPanelCells[i][j].getColumns() == 10 || positionPanelCells[i][j].getColumns() == 9)
                                        {
                                            positionPanelCells[i][j].setIcon(testImage); positionPanelCells[i][j].setChosenArea();
                                            positionPanelCells[i][j - 1].setIcon(testImage); positionPanelCells[i][j - 1].setChosenArea();
                                            positionPanelCells[i][j - 2].setIcon(testImage); positionPanelCells[i][j - 2].setChosenArea();
                                            positionPanel.updateUI();
                                            armament++;
                                        }
                                        if(positionPanelCells[i][j].getColumns() >= 1 && positionPanelCells[i][j].getColumns() < 9)
                                        {
                                            positionPanelCells[i][j].setIcon(testImage); positionPanelCells[i][j].setChosenArea();
                                            positionPanelCells[i][j + 1].setIcon(testImage); positionPanelCells[i][j + 1].setChosenArea();
                                            positionPanelCells[i][j + 2].setIcon(testImage); positionPanelCells[i][j + 2].setChosenArea();
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

                            if (step == 3)
                            {
                                if (firstTime >= 1)
                                {
                                    int option = JOptionPane.showConfirmDialog(positionPanel, "Do you want to put the boat vertically?",
                                            "Choice Window", JOptionPane.YES_NO_OPTION);
                                    if (option == JOptionPane.YES_OPTION)
                                    {
                                        if (positionPanelCells[i][j].getRows() == 10)
                                        {
                                            positionPanelCells[i][j].setIcon(testImage); positionPanelCells[i][j].setChosenArea();
                                            positionPanelCells[i - 1][j].setIcon(testImage); positionPanelCells[i - 1][j].setChosenArea();
                                            positionPanel.updateUI();
                                            armament++;
                                        }

                                        if (positionPanelCells[i][j].getRows() >= 1 && positionPanelCells[i][j].getRows() < 9)
                                        {
                                            positionPanelCells[i][j].setIcon(testImage); positionPanelCells[i][j].setChosenArea();
                                            positionPanelCells[i + 1][j].setIcon(testImage); positionPanelCells[i + 1][j].setChosenArea();
                                            positionPanel.updateUI();
                                            armament++;
                                        }
                                    }

                                    if (option == JOptionPane.NO_OPTION)
                                    {
                                        if (positionPanelCells[i][j].getColumns() == 10)
                                        {
                                            positionPanelCells[i][j].setIcon(testImage); positionPanelCells[i][j].setChosenArea();
                                            positionPanelCells[i][j - 1].setIcon(testImage); positionPanelCells[i][j - 1].setChosenArea();
                                            positionPanel.updateUI();
                                            armament++;
                                        }

                                        if (positionPanelCells[i][j].getColumns() >= 1 && positionPanelCells[i][j].getColumns() < 9)
                                        {
                                            positionPanelCells[i][j].setIcon(testImage); positionPanelCells[i][j].setChosenArea();
                                            positionPanelCells[i][j + 1].setIcon(testImage); positionPanelCells[i][j + 1].setChosenArea();
                                            positionPanel.updateUI();
                                            armament++;
                                        }
                                    }
                                    if (armament == 3)
                                    {
                                        JOptionPane.showMessageDialog(null, "Now you will put the 4 frigates (they occupy one cell)");
                                        armament = 0;
                                        firstTime=0;
                                        step++;
                                    }
                                }
                                firstTime++;
                            }

                            if (step == 4)
                            {
                                if (firstTime >= 1)
                                {
                                    positionPanelCells[i][j].setIcon(testImage); positionPanelCells[i][j].setChosenArea();
                                    positionPanel.updateUI();
                                    armament++;
                                }
                                if (armament > 4)
                                {
                                    JOptionPane.showMessageDialog(null, "It's time to attack the enemy boats");
                                    step++;
                                }
                                firstTime++;
                            }
                        }
                    }
                }

                if (step == 5)
                {
                    controlNavalBattle.setEnemyPanel(enemyPanel, enemyPanelCells, testImage);

                    for(int i=0; i < 11; i++)
                    {
                        for(int j=0; j < 11; j++)
                        {
                            if(e.getSource()==principalPanelCells[i][j])
                            {
                                principalPanelCells[i][j].setIcon(testImage);
                                principalPanel.updateUI();
                            }
                        }
                    }
                }
            }
        }
    }
}
