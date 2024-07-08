
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardioMEN implements ActionListener {
    JFrame baseFrame = new JFrame("Exercise");
    JPanel underPanel = new JPanel(new GridLayout(2,1));
    JPanel cardioPanel = new JPanel(new BorderLayout());
    JPanel cardioExercise = new JPanel(new GridLayout(3,4));
    JLabel cardioLabel = new JLabel("Cardio Exercises");
    JButton[] cardioWorkouts = new JButton[12];
    String[]   cardioNames = {"Skipping","Burpees","mount climbers","running","squat jumps",
                              "HIIT","Dancing","Cycle","Swim","Row","Elliptical","jumping jacks"};

    JButton returnbtn = new JButton("Return");
    JPanel rJPanel = new JPanel();


    public CardioMEN(){
        returnbtn.addActionListener(this);
        returnbtn.setBackground(Color.decode("#00FFDF"));
        //returnbtn.setBackground(Color.decode("#00FFDF"));
        underPanel.setBackground(Color.decode("#00FFDF"));
        cardioPanel.setBackground(Color.decode("#00FFDF"));
        rJPanel.setBackground(Color.decode("#00FFDF")); // 00FFDF - neon light blue 
        


       
        cardioPanel.add(cardioLabel , BorderLayout.NORTH);
        cardioLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cardioPanel.add(cardioExercise);
        for (int x = 0; x<cardioWorkouts.length; x++){
            cardioWorkouts[x] = new JButton(cardioNames[x]);
            cardioWorkouts[x].addActionListener(this);
            if(x % 4 == 0){
                cardioWorkouts[x].setBackground(Color.decode("#00FFDF"));//DA14FE - neon pink

            }else if(x %2 !=0){
                cardioWorkouts[x].setBackground(Color.decode("#007DFF"));//007DFF - neone blue

                
            }else{
                cardioWorkouts[x].setBackground(Color.decode("#9BFF00"));// 9BFF00 -  neon green 

            }
            cardioExercise.add(cardioWorkouts[x]);
        }
        cardioPanel.add(cardioExercise);
        underPanel.add(cardioPanel);
        rJPanel.add(returnbtn, BorderLayout.CENTER);
        underPanel.add(rJPanel);

        baseFrame.setSize(450,324);
        baseFrame.add(underPanel);
        baseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        baseFrame.setVisible(true);

        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(returnbtn)){
            baseFrame.dispose();
            ExerciseMen exercise = new ExerciseMen();
        }
    }



}
