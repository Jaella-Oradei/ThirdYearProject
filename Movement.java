import javax.swing.*;
import javax.swing.border.MatteBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Movement extends JFrame implements ActionListener {
    JFrame baseFrame = new JFrame("Movement");
    JPanel contentPanel = new JPanel(new GridLayout(3,1));
    

    JPanel passiveMovementPanel = new JPanel(new GridLayout(5,1));
    JPanel activeMovementPanel = new JPanel(new GridLayout(5,1));

    //JPanel stepScale = new JPanel(new GridLayout(1, 2));
    JPanel runScale = new JPanel();

    String runDistance, stepGoal, runGoal;
    //String stepCount = "1000";

    JButton passDownButton = new JButton("▼");
    JButton passUPbutton = new JButton("▲");

    JButton activeDownButton = new JButton("▼");
    JButton activeUPbutton = new JButton("▲");

    
    
    JPanel returnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    //returnPanel.
    JButton returnbtn = new JButton("Return");

    JLabel[] passiveLabels = new JLabel[2];
    JLabel[] activeLabels = new JLabel[2];

    JPanel passiveGoalPanel = new JPanel();
    JPanel activeGoalPanel = new JPanel();


    JPanel activeBTNPanel = new JPanel(new GridLayout(2,1));
    JPanel passiveBTNPanel = new JPanel(new GridLayout(2,1));

    JPanel activePanelBase = new JPanel(new GridLayout(1,2));
    JPanel passivePanelBase = new JPanel(new GridLayout(1,2));

    // JPanel passivecalories =  new JPanel();
    // JPanel activecalories = new JPanel();
   // JPanel calories =  new JPanel();

    int counter = 0;
    int stepCounter = 0;
    double runningCounter = 0;
    double runningCount =0;
    JLabel goalLabel, passiveSteps, activeSteps, runningGoalLabel;// = new JLabel(goalSteps);
    Font font = returnbtn.getFont();

    public Movement(){
        activeDownButton.addActionListener(this);
        activeUPbutton.addActionListener(this);
        passDownButton.addActionListener(this);
        passUPbutton.addActionListener(this);

        passiveBTNPanel.setBackground(Color.decode("#FDFDAF"));//lighter hex
        passivePanelBase.setBackground(Color.decode("#FDFDAF"));//lighter hex
        passiveGoalPanel.setBackground(Color.decode("#FDFDAF"));//lighter hex
        passiveMovementPanel.setBackground(Color.decode("#FDFDAF"));//lighter hex
        //passive.setBackground(Color.decode("#FDFDAF"));//lighter hex
        activeBTNPanel.setBackground(Color.decode("#FDFDAF"));//lighter hex
        activeGoalPanel.setBackground(Color.decode("#FDFDAF"));//lighter hex
        activeMovementPanel.setBackground(Color.decode("#FDFDAF"));//lighter hex
        activePanelBase.setBackground(Color.decode("#FDFDAF"));//lighter hex
        //runScale.setBackground(Color.decode("#FDFDAF"));//lighter hex
        contentPanel.setBackground(Color.decode("#FDFDAF"));//lighter hex
        returnPanel.setBackground(Color.decode("#FDFDAF"));
        returnbtn.setBackground(Color.decode("#E0D6FF"));
        
        passDownButton.setBackground(Color.decode("#E0D6FF"));
        passUPbutton.setBackground(Color.decode("#E0D6FF"));
        activeDownButton.setBackground(Color.decode("#E0D6FF"));
        activeUPbutton.setBackground(Color.decode("#E0D6FF"));

        returnbtn.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        passDownButton.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        passUPbutton.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        activeDownButton.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        activeUPbutton.setFont(new Font(font.getFontName(), Font.PLAIN, 19));


        Timer time = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run(){
                Random r = new Random();
                int incrementValue = r.nextInt(16) + 2;
                stepIncrementer(incrementValue);
            }
        };
        time.scheduleAtFixedRate(tt,0,5000);

        JLabel passivetitle = new JLabel("Passive Movement");
        passivetitle.setFont(new Font(font.getFontName(), Font.PLAIN, 19));

    
        passiveMovementPanel.add(passivetitle);
        passiveSteps = new JLabel("Steps: " +stepCounter);
        passiveSteps.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        passiveMovementPanel.add(passiveSteps);


        passiveMovementPanel.add(passiveGoalPanel);
        goalLabel = new JLabel("Goal: " + counter);
        goalLabel.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        activePanelBase.add(goalLabel);

        activeBTNPanel.add(activeUPbutton);
        activeBTNPanel.add(activeDownButton);

        activePanelBase.add(activeBTNPanel);
        passiveMovementPanel.add(activePanelBase);

        ProgressBarPanel pbp = new ProgressBarPanel();
        pbp.setBackground(Color.decode("#FDFDAF"));
        ProgressIncrease progressIncrease = new ProgressIncrease(pbp);
        Thread thread = new Thread(progressIncrease);
        thread.start();
        passiveMovementPanel.add(pbp);

        Timer timeACTIVE = new Timer();
        TimerTask ttACTIVE = new TimerTask() {
            @Override
            public void run(){
                Random rACTIVE = new Random();
                double incrementValueACTIVE = rACTIVE.nextDouble(0.12) + 0.53;
                runningIncrementer(incrementValueACTIVE);
            }
        };
        timeACTIVE.scheduleAtFixedRate(ttACTIVE,0,5000);


        JLabel activeTitle = new JLabel("Active Movement");
        activeTitle.setFont(new Font(font.getFontName(), Font.PLAIN, 19));

        activeMovementPanel.add(activeTitle);
        activeSteps = new JLabel("Running: " +runningCounter +" km");
        activeSteps.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        activeMovementPanel.add(activeSteps);

        activeMovementPanel.add(activeGoalPanel);
        runningGoalLabel = new JLabel("Running Goal: " + runningCount + " km");
        runningGoalLabel.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        passivePanelBase.add(runningGoalLabel);

        passiveBTNPanel.add(passUPbutton);
        passiveBTNPanel.add(passDownButton);

        passivePanelBase.add(passiveBTNPanel);
        
        activeMovementPanel.add(passivePanelBase);
        ProgressBarPanel pbpActive = new ProgressBarPanel();
        pbpActive.setBackground(Color.decode("#FDFDAF"));
        ProgressIncrease progressIncreaseActive = new ProgressIncrease(pbpActive);
        Thread threadActive = new Thread(progressIncreaseActive);
        threadActive.start();
        passiveMovementPanel.add(pbpActive);

        activeMovementPanel.add(pbpActive);



        returnbtn.addActionListener(this);
        returnPanel.add(returnbtn);

        contentPanel.add(passiveMovementPanel);
        contentPanel.add(activeMovementPanel);
        contentPanel.add(returnPanel);

        //basepanel.add(contentPanel);
        baseFrame.setSize(450,324);
        //baseFrame.add(basepanel);
        baseFrame.add(contentPanel);
        baseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        baseFrame.setVisible(true);

    }

    public void goalUpdate(int incrementValue){
        if (incrementValue <0 && counter == 0){
            return;
        }
        counter = counter + incrementValue;
        goalLabel.setText("Goal: " + counter);
    }

    public synchronized void stepIncrementer(int incrementValue){
        stepCounter = stepCounter + incrementValue+100;
        SwingUtilities.invokeLater(() -> {
            passiveSteps.setText("Steps: " + stepCounter);
        });
    

    }

    public void goalUpdateActive(double incrementValue){
        if (incrementValue <0 && runningCount == 0){
            return;
        }
        runningCount = runningCount + incrementValue;
        runningGoalLabel.setText("Goal: " + runningCount +" km");
    }

    public synchronized void runningIncrementer(Double incrementValue){
        runningCounter = runningCounter + incrementValue;
        String formattedCounter = String.format("%.2f", runningCounter);
        SwingUtilities.invokeLater(() -> {
            activeSteps.setText("Running: " + formattedCounter + " km");
        });
    

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(returnbtn)){
            WomenWindow wowindow = new WomenWindow();
            baseFrame.dispose();
            //baseFrame.setVisible(false);
        }
        else if(e.getSource().equals(passDownButton)){
            goalUpdateActive(-0.5);
        }
        else if(e.getSource().equals(passUPbutton)){
            goalUpdateActive(0.5);
            
        }
        else if(e.getSource().equals(activeDownButton)){
           goalUpdate(-1000);
            
        }
        else if(e.getSource().equals(activeUPbutton)){
            goalUpdate(1000);
            
        }
    }
}