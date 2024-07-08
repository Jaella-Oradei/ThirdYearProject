import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WomenWindow implements ActionListener{
    JFrame baseFrame = new JFrame("Woman Mode");
    JPanel panel = new JPanel(new GridLayout(4,1));
    //JPanel basePanel = new JPanel();

    JLabel healthlabel = new JLabel("<html><u style='text-decoration: underline; border-bottom: 25px solid black;'>Health</u></html>");
    JPanel topPanelBase = new JPanel(new GridLayout(2,1));
    //JPanel topPanel = new JPanel(new GridLayout(1,3));
    JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 8,8));
    JButton[] healthbtns = new JButton[3];
    String[] healthTitles = {"Health Implications","Period Cycle","Calorie Intake"};


    JLabel fitnesslabel = new JLabel("<html><u style='text-decoration: underline; border-bottom: 25px solid black;'>Fitness</u></html>");
    JPanel middlePanelBase = new JPanel(new GridLayout(2,1));
    //JPanel middlepanel = new JPanel(new GridLayout(1,3));
    JPanel middlepanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 8,8));
    JButton[] fitnessbtns = new JButton[2];
   // String[] fitnessTitles = {"Movement","Stationary","Exercise"};
    String[] fitnessTitles = {"Movement","Exercise"};



    JLabel awardslabel = new JLabel("<html><u style='text-decoration: underline; border-bottom: 25px solid black;'>Awards</u></html>");
    JPanel bottomPanelBase = new JPanel(new GridLayout(2,1));
    //JPanel bottomPanel = new JPanel(new GridLayout(1,3));
    JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 8,8));
    JButton[] awardsbtns = new JButton[3];
    String[] awardsTitles = {"Daily","Weekly","Monthly"};



    JButton returnbtn = new JButton("RETURN");
    JPanel returnPanel = new JPanel(new BorderLayout());

    public WomenWindow(){
      
        bottomPanelBase.setBackground(Color.decode("#FFC2D1"));
        bottomPanel.setBackground(Color.decode("#FFC2D1"));
        returnbtn.setBackground(Color.decode("#ffffff"));
        middlePanelBase.setBackground(Color.decode("#FFB3C6"));
        middlepanel.setBackground(Color.decode("#FFB3C6"));
        returnPanel.setBackground(Color.decode("#FFE5EC"));
        topPanel.setBackground(Color.decode("#FF8FAB"));
        topPanelBase.setBackground(Color.decode("#FF8FAB"));
        
        returnbtn.addActionListener(this);
       
        healthlabel.setHorizontalAlignment(SwingConstants.CENTER);
        healthlabel.setVerticalAlignment(SwingConstants.CENTER);
        topPanelBase.add(healthlabel);
        for(int x = 0; x<healthbtns.length; x++){
            healthbtns[x] = new JButton(healthTitles[x]);
            healthbtns[x].setBackground(Color.decode("#ffffff"));
            healthbtns[x].addActionListener(this);
            topPanel.add(healthbtns[x]);
        }
        topPanelBase.add(topPanel);
        panel.add(topPanelBase);

        
        fitnesslabel.setHorizontalAlignment(SwingConstants.CENTER);
        fitnesslabel.setVerticalAlignment(SwingConstants.CENTER);
        middlePanelBase.add(fitnesslabel);
        for(int y = 0; y<fitnessbtns.length; y++){
            fitnessbtns[y] = new JButton(fitnessTitles[y]);
            fitnessbtns[y].setBackground(Color.decode("#ffffff"));
            fitnessbtns[y].addActionListener(this);
            middlepanel.add(fitnessbtns[y]);
        }
        middlePanelBase.add(middlepanel);
        panel.add(middlePanelBase);

        awardslabel.setHorizontalAlignment(SwingConstants.CENTER);
        awardslabel.setVerticalAlignment(SwingConstants.CENTER);
        bottomPanelBase.add(awardslabel);
        for(int z = 0; z<awardsbtns.length; z++){
            awardsbtns[z] = new JButton(awardsTitles[z]);
            awardsbtns[z].setBackground(Color.decode("#ffffff"));
            awardsbtns[z].addActionListener(this);
            bottomPanel.add(awardsbtns[z]);
        }
        bottomPanelBase.add(bottomPanel);
        panel.add(bottomPanelBase);


        returnbtn.setPreferredSize(new Dimension(100,10));
        returnbtn.setMinimumSize(new Dimension(100,10));
        returnbtn.setMaximumSize(new Dimension(100,10));

        returnPanel.add(returnbtn, BorderLayout.EAST);
        panel.add(returnPanel);

        baseFrame.setSize(450,324);
        baseFrame.add(panel);
        baseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        baseFrame.setResizable(false);
        baseFrame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
       
        if(e.getSource().equals(returnbtn)){
            FitnessAppBase fab =  new FitnessAppBase();
            baseFrame.dispose();
        }

        if (e.getSource().equals(healthbtns[0])) {
            baseFrame.dispose();
            HealthImplications hi = new HealthImplications();
        }

        else if(e.getSource().equals(healthbtns[1])){
            baseFrame.dispose();
            PeriodCycle pc = new PeriodCycle();

        }
        else if (e.getSource().equals(healthbtns[2])){
            baseFrame.dispose();
            CalorieIntake ci = new CalorieIntake();

        }

            if (e.getSource().equals(fitnessbtns[0])) {
            baseFrame.dispose();
            Movement move = new Movement();
        }

        else if(e.getSource().equals(fitnessbtns[1])){
            baseFrame.dispose();
            //Stationary station = new Stationary();
            Exercise exercise = new Exercise();
        }
        // else if (e.getSource().equals(fitnessbtns[2])){
        //     baseFrame.dispose();
        //     Exercise exercise = new Exercise();
        // }

        if (e.getSource().equals(awardsbtns[0])) {
            baseFrame.dispose();
            DailyAwards da = new DailyAwards();
        }

        else if(e.getSource().equals(awardsbtns[1])){
            baseFrame.dispose();
            WeeklyAwards wa = new WeeklyAwards();

        }
        else if (e.getSource().equals(awardsbtns[2])){
            baseFrame.dispose();
            MonthlyAwards ma = new MonthlyAwards();

        }
    }
    
}
