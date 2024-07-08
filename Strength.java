
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Strength implements ActionListener{
    JFrame baseFrame = new JFrame("Exercise");
    JPanel underPanel = new JPanel(new GridLayout(2,1));
    JPanel strengthPanel =  new JPanel(new BorderLayout());
    JPanel stregthexercise = new JPanel(new GridLayout(3,4));
    JLabel strengthLabel = new JLabel("Strength Exercises");
    JButton[] strengthWorkouts = new JButton[12];
    String[]   strengthNames = {"Pull ups","Box jumps","suqats","push ups",
                              "step ups","deadlifts","heel raises","barbell row",
                              "romanian deadlifts","hip thrust","abduction", "N/A"};

    JButton returnbtn = new JButton("Return");
    JPanel rJPanel = new JPanel();
    
    
    public Strength(){

        returnbtn.addActionListener(this);
        returnbtn.setBackground(Color.decode("#FC0C00"));
        //returnbtn.setBackground(Color.decode("#00FFDF"));
        underPanel.setBackground(Color.decode("#FF9E99"));
        strengthPanel.setBackground(Color.decode("#FF9E99"));
        rJPanel.setBackground(Color.decode("#FF9E99")); // 00FFDF - neon light blue 
        

        strengthPanel.add(strengthLabel , BorderLayout.NORTH);
        strengthLabel.setHorizontalAlignment(SwingConstants.CENTER);
        strengthPanel.add(stregthexercise);
        for (int x = 0; x<strengthWorkouts.length; x++){
            strengthWorkouts[x] = new JButton(strengthNames[x]);
            strengthWorkouts[x].addActionListener(this);
            if(x % 4 == 0){
                strengthWorkouts[x].setBackground(Color.decode("#FFFFFF"));//DA14FE - neon pink

            }else if(x %2 !=0){
                strengthWorkouts[x].setBackground(Color.decode("#FFFFFF"));//007DFF - neone blue

                
            }else{
                strengthWorkouts[x].setBackground(Color.decode("#FFFFFF"));// 9BFF00 -  neon green 

            }
            stregthexercise.add(strengthWorkouts[x]);
        }
        strengthPanel.add(stregthexercise);

        underPanel.add(strengthPanel);
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
            Exercise exercise = new Exercise();
        }
    }

}