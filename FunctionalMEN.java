
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class FunctionalMEN implements ActionListener{

    JFrame baseFrame = new JFrame("Exercise");
    JPanel underPanel = new JPanel(new GridLayout(2,1));
    JButton returnbtn = new JButton("Return");

    JPanel functionalPanel = new JPanel(new BorderLayout());
    JPanel functionalexercise = new JPanel(new GridLayout(3,4));
    JLabel functionalLabel = new JLabel("Functional Exercises");
    JButton[] functionalWorkouts = new JButton[12];
    String[]   functionalNames = {"squats","lunges","deadlifts","pushups","chin-ups",
                              "planks","russian twist","glute bridges","step-ups","single-leg deadlifts",
                              "renegade rows","medicine ball slams"};

    JPanel rJPanel = new JPanel();
    
    public FunctionalMEN(){
        returnbtn.addActionListener(this);
        returnbtn.setBackground(Color.decode("#ddd0f3"));
        //returnbtn.setBackground(Color.decode("#00FFDF"));
        underPanel.setBackground(Color.decode("#ddd0f3"));
        functionalPanel.setBackground(Color.decode("#ddd0f3"));
        rJPanel.setBackground(Color.decode("#ddd0f3")); // 00FFDF - neon light blue 
        
        functionalPanel.add(functionalLabel, BorderLayout.NORTH);
        functionalLabel.setHorizontalAlignment(SwingConstants.CENTER);
        functionalPanel.add(functionalexercise);
        for (int x = 0; x<functionalWorkouts.length; x++){
            functionalWorkouts[x] = new JButton(functionalNames[x]);
            functionalWorkouts[x].addActionListener(this);
            if(x % 4 == 0){
                functionalWorkouts[x].setBackground(Color.decode("#BDF2FF"));//DA14FE - neon pink

            }else if(x %2 !=0){
                functionalWorkouts[x].setBackground(Color.decode("#BDF2FF"));//007DFF - neone blue

                
            }else{
                functionalWorkouts[x].setBackground(Color.decode("#BDF2FF"));// 9BFF00 -  neon green 

            }
            functionalexercise.add(functionalWorkouts[x]);
        }
        functionalPanel.add(functionalexercise);


        underPanel.add(functionalPanel);
        underPanel.add(rJPanel);
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
