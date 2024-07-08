import javax.swing.*;
import javax.swing.border.Border;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeeklyAwardsMen implements ActionListener{
    JFrame baseFrame = new JFrame("Weekly Awards");
    JPanel returnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JButton returnbtn = new JButton("Return");

    JPanel basePanel = new JPanel(new GridLayout(2, 1));
    
    JPanel contentPanel = new JPanel(new GridLayout(1,2));

    JPanel fitnesPanel = new JPanel(new GridLayout(2,1));

    JPanel healthPanel = new JPanel(new GridLayout(2,1));

    JLabel fitnessTitle, healthTitle, pageTitle;
    JPanel fTitlePanel, hTitlePanel;

    private Map<String, JLabel> fitnessAwardsLabels = new HashMap<>();
    private Map<String, JLabel> healthAwardsLabels = new HashMap<>();
    JPanel healthPanelAWARDS = new JPanel(new GridLayout(2,1));
    JPanel fitnesPanelAWARDS = new JPanel(new GridLayout(2,1));
    Font font = returnbtn.getFont();
    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);



    public WeeklyAwardsMen(){

        healthPanel.setBorder(border);
        fitnesPanel.setBorder(border);

        fitnessTitle = new JLabel("FITNESS AWARDS");
        healthTitle = new JLabel("HEALTH AWARDS");
        fTitlePanel = new JPanel();
        hTitlePanel = new JPanel();
        fitnessTitle.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        healthTitle.setFont(new Font(font.getFontName(), Font.PLAIN, 19));

        addFitnessAward("10k steps Streak");
        addFitnessAward("7-Workout Week");
        addFitnessAward("Running Streak");
        //addFitnessAward("N/A");

        addhealthAward("12 cups Water");
        addhealthAward("Calorie Intake Streak");
        addhealthAward("Balanced Diet");
        addhealthAward("5-a-day streak");

        fTitlePanel.setBackground(Color.decode("#C9D5FD"));
        hTitlePanel.setBackground(Color.decode("#C9D5FD"));
        returnbtn.setBackground(Color.decode("#5061C5"));
        returnPanel.setBackground(Color.decode("#C9D5FD"));



        fTitlePanel.add(fitnessTitle, BorderLayout.NORTH);
        hTitlePanel.add(healthTitle, BorderLayout.NORTH);

        fitnesPanel.add(fTitlePanel, BorderLayout.NORTH);
        fitnesPanel.add(fitnesPanelAWARDS, BorderLayout.SOUTH);

        healthPanel.add(hTitlePanel, BorderLayout.NORTH);
        healthPanel.add(healthPanelAWARDS, BorderLayout.SOUTH);

        contentPanel.add(fitnesPanel, BorderLayout.EAST);
        contentPanel.add(healthPanel, BorderLayout.EAST);

        basePanel.add(contentPanel, BorderLayout.CENTER);
        basePanel.add(returnPanel, BorderLayout.SOUTH);

        returnbtn.addActionListener(this);
        returnPanel.add(returnbtn, BorderLayout.SOUTH);
        baseFrame.setSize(450,324);
        baseFrame.add(basePanel);
        baseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        baseFrame.setVisible(true);
    }

    public void addFitnessAward(String awardName){
        if (!fitnessAwardsLabels.containsKey(awardName)){
            JLabel newAwards = new JLabel(awardName);
            newAwards.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Set border with fixed size and color
            newAwards.setFont(new Font(font.getFontName(), Font.PLAIN, 19)); 
            //newAwards.setPreferredSize(new Dimension(50, 50)); // Set fixed size for the label
            newAwards.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
            newAwards.setVerticalAlignment(SwingConstants.CENTER);
            fitnessAwardsLabels.put(awardName, newAwards);
            fitnesPanelAWARDS.add(newAwards);
            fitnesPanelAWARDS.revalidate();
            fitnesPanelAWARDS.setBackground(Color.decode("#D4AF37"));

            fitnesPanelAWARDS.repaint();
        } 
    }

    public void addhealthAward(String awardName){
        if(!healthAwardsLabels.containsKey(awardName)){
            JLabel newAwards = new JLabel(awardName);
            newAwards.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Set border with fixed size and color
            newAwards.setFont(new Font(font.getFontName(), Font.PLAIN, 19)); 
            //newAwards.setPreferredSize(new Dimension(50, 50)); // Set fixed size for the label
            newAwards.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
            newAwards.setVerticalAlignment(SwingConstants.CENTER);
            healthAwardsLabels.put(awardName, newAwards);
            healthPanelAWARDS.add(newAwards);
            healthPanelAWARDS.revalidate();
            healthPanelAWARDS.setBackground(Color.decode("#D4AF37"));

            healthPanelAWARDS.repaint();
        }
    }



    public void deletefitnessAward(String awardName){
        if (fitnessAwardsLabels.containsKey(awardName)){
            JLabel deleteAwards = fitnessAwardsLabels.get(awardName);
            fitnesPanelAWARDS.remove(deleteAwards);
            fitnessAwardsLabels.remove(awardName);
            fitnesPanelAWARDS.revalidate();
            fitnesPanelAWARDS.setBackground(Color.decode("#ffffff"));

            fitnesPanelAWARDS.repaint();
        } 
    }

    public void deletehealthAward(String awardName){
        if(healthAwardsLabels.containsKey(awardName)){
            JLabel deleteAwards = healthAwardsLabels.get(awardName);
            healthPanelAWARDS.remove(deleteAwards);
            healthAwardsLabels.remove(awardName);
            healthPanelAWARDS.revalidate();
            fitnesPanelAWARDS.setBackground(Color.decode("#ffffff"));

            healthPanelAWARDS.repaint();
            
      
        }
    }



    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(returnbtn)){
            MenWindow menWindow = new MenWindow();
            baseFrame.dispose();
            //baseFrame.setVisible(false);
        }
    }

    
}