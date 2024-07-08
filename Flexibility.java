
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Flexibility implements ActionListener{
    JFrame baseFrame = new JFrame("Exercise");
    JPanel underPanel = new JPanel(new GridLayout(2,1));
    JButton returnbtn = new JButton("Return");

    JPanel flexiblePanel = new JPanel(new BorderLayout());
    JButton flexibleBtn = new JButton("FLEXIILITY");
    JPanel flexibleexercise = new JPanel(new GridLayout(3,4));
    JLabel flexibleLabel = new JLabel("Flexibility Exercises");
    JButton[] flexibleWorkouts = new JButton[12];
    String[] flexibleNames = {"Forward fold","Quad stretch","Cobra stretch",
                              "Child's pose","seated forward bend","Hip flexor stretch",
                              "Butterfly stretch","Triceps stretch","Nect stretch",
                              "standing side stretch","Pigeon Pose","Standing Quad Stretch"};

    JPanel rJPanel = new JPanel();
    
    public Flexibility(){
        returnbtn.addActionListener(this);
        returnbtn.setBackground(Color.decode("#ddd0f3"));
        //returnbtn.setBackground(Color.decode("#00FFDF"));
        underPanel.setBackground(Color.decode("#ddd0f3"));
        flexiblePanel.setBackground(Color.decode("#ddd0f3"));
        rJPanel.setBackground(Color.decode("#ddd0f3")); // 00FFDF - neon light blue 

        flexiblePanel.add(flexibleLabel , BorderLayout.NORTH);
        flexibleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        flexiblePanel.add(flexibleexercise);
        for (int x = 0; x<flexibleWorkouts.length; x++){
            flexibleWorkouts[x] = new JButton(flexibleNames[x]);
            flexibleWorkouts[x].addActionListener(this);
            if(x % 4 == 0){
                flexibleWorkouts[x].setBackground(Color.decode("#BDF2FF"));//DA14FE - neon pink

            }else if(x %2 !=0){
                flexibleWorkouts[x].setBackground(Color.decode("#BDF2FF"));//007DFF - neone blue

                
            }else{
                flexibleWorkouts[x].setBackground(Color.decode("#BDF2FF"));// 9BFF00 -  neon green 

            }
            flexibleexercise.add(flexibleWorkouts[x]);
        }
        flexiblePanel.add(flexibleexercise);

        underPanel.add(flexiblePanel);
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