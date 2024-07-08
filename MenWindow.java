import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;
import java.net.*;
import java.awt.*;

public class MenWindow implements ActionListener{
    JFrame baseFrame = new JFrame("Man Mode");
    JPanel panel = new JPanel(new GridLayout(4,1));
    //JPanel basePanel = new JPanel();

    JLabel healthlabel = new JLabel("<html><u style='text-decoration: underline; border-bottom: 25px solid black;'>Health</u></html>");
    JPanel topPanelBase = new JPanel(new GridLayout(2,1));
    //JPanel topPanel = new JPanel(new GridLayout(1,3));
    JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 8,8));
    JButton[] healthbtns = new JButton[2];
    String[] healthTitles = {"Health Concerns","Calorie Intake"};


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

    public MenWindow(){

        panel.setBackground(Color.decode("#59981A"));
        topPanelBase.setBackground(Color.decode("#59981A"));
        topPanel.setBackground(Color.decode("#59981A"));

        middlePanelBase.setBackground(Color.decode("#81B622"));
        middlepanel.setBackground(Color.decode("#81B622"));

        bottomPanelBase.setBackground(Color.decode("#99cc33"));
        bottomPanel.setBackground(Color.decode("#99cc33"));

        returnPanel.setBackground(Color.decode("#a7dd48"));
        baseFrame.setBackground(Color.decode("#C9D5FD"));
        
        returnbtn.addActionListener(this);
       
        healthlabel.setHorizontalAlignment(SwingConstants.CENTER);
        healthlabel.setVerticalAlignment(SwingConstants.CENTER);
        topPanelBase.add(healthlabel);
        for(int x = 0; x<healthbtns.length; x++){
            healthbtns[x] = new JButton(healthTitles[x]);
            healthbtns[x].addActionListener(this);
            healthbtns[x].setBackground(Color.decode("#C9D5FD"));
            topPanel.add(healthbtns[x]);
        }
        topPanelBase.add(topPanel);
        panel.add(topPanelBase);

        
        fitnesslabel.setHorizontalAlignment(SwingConstants.CENTER);
        fitnesslabel.setVerticalAlignment(SwingConstants.CENTER);
        middlePanelBase.add(fitnesslabel);
        for(int y = 0; y<fitnessbtns.length; y++){
            fitnessbtns[y] = new JButton(fitnessTitles[y]);
            fitnessbtns[y].addActionListener(this);
            fitnessbtns[y].setBackground(Color.decode("#C9D5FD"));
            middlepanel.add(fitnessbtns[y]);
        }
        middlePanelBase.add(middlepanel);
        panel.add(middlePanelBase);

        awardslabel.setHorizontalAlignment(SwingConstants.CENTER);
        awardslabel.setVerticalAlignment(SwingConstants.CENTER);
        bottomPanelBase.add(awardslabel);
        for(int z = 0; z<awardsbtns.length; z++){
            awardsbtns[z] = new JButton(awardsTitles[z]);
            awardsbtns[z].addActionListener(this);
            awardsbtns[z].setBackground(Color.decode("#C9D5FD"));
            bottomPanel.add(awardsbtns[z]);
        }
        bottomPanelBase.add(bottomPanel);
        panel.add(bottomPanelBase);


        returnbtn.setPreferredSize(new Dimension(100,10));
        returnbtn.setMinimumSize(new Dimension(100,10));
        returnbtn.setMaximumSize(new Dimension(100,10));
        returnbtn.setBackground(Color.decode("#C9D5FD"));
        
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
            HalthConcerns hi = new HalthConcerns();
        }

        else if(e.getSource().equals(healthbtns[1])){
            baseFrame.dispose();
            CalorieIntakeMen ci = new CalorieIntakeMen();
        }

            if (e.getSource().equals(fitnessbtns[0])) {
            baseFrame.dispose();
            MovementMen move = new MovementMen();
        }

        else if(e.getSource().equals(fitnessbtns[1])){
            baseFrame.dispose();
            ExerciseMen exercise = new ExerciseMen();

        }

        if (e.getSource().equals(awardsbtns[0])) {
            baseFrame.dispose();
            DailyAwardsMen da = new DailyAwardsMen();
        }

        else if(e.getSource().equals(awardsbtns[1])){
            baseFrame.dispose();
            WeeklyAwardsMen wa = new WeeklyAwardsMen();

        }
        else if (e.getSource().equals(awardsbtns[2])){
            baseFrame.dispose();
            MonthlyAwardsMen ma = new MonthlyAwardsMen();

        }
    }
    
}
