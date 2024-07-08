import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;
import java.net.*;
import java.awt.*;

public class HalthConcerns implements ActionListener {
    JFrame baseFrame = new JFrame("Health Implications");
    JPanel panel = new JPanel(); 

    //JPanel centerJPanel = new JPanel();

    JLabel ed, tc, lt, bleedingDisorder, edDescription, tcDescription, ltDescription, bdDescription;
    JPanel infoPanel = new JPanel(new GridLayout(1,4));
    JPanel tcPanel = new JPanel();
    JPanel ltPanel = new JPanel();
    JPanel bdPanel = new JPanel();
    JPanel edPanel = new JPanel();

    JButton returnbtn = new JButton("Return");
    JPanel returnPanel =  new JPanel();
    Font font = returnbtn.getFont();

    
    public HalthConcerns(){


        returnbtn.addActionListener(this);
        returnPanel.setBackground(Color.decode("#FDFDAF"));
        returnbtn.setBackground(Color.decode("#FDFD31"));
        returnbtn.setFont(new Font(font.getFontName(), Font.PLAIN, 19));

        ed = new JLabel("<html><u>Erectile Dysfunc- tion</u></html><br><i>Description:</i> Erectile dysfunction (ED) is the inability to get or maintain an erection long enough to have sexual intercourse. There are many different causes, which may include conditions that affect your blood vessels, neurological conditions, mental health conditions and injuries. A healthcare provider can diagnose and treat erectile dysfunction.");
        linkAttachment(ed, "https://www.nhs.uk/conditions/erection-problems-erectile-dysfunction/");
        ed.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        borderCreation(ed);
        ed.setPreferredSize(new Dimension(100,300));
        edPanel.add(ed);

        tc = new JLabel("<html><u>Orchitis</u></html>");
        linkAttachment(tc, "https://my.clevelandclinic.org/health/diseases/21658-orchitis");
        tc.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        borderCreation(tc);
        tc.setPreferredSize(new Dimension(100,300));
        tc.setHorizontalAlignment(SwingConstants.LEFT);
        tcPanel.add(tc);

        lt = new JLabel("<html><u>Low Testo- ster- one</u></html>");
        linkAttachment(lt, "https://my.clevelandclinic.org/health/diseases/15603-low-testosterone-male-hypogonadism");
        lt.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        borderCreation(lt);
        lt.setPreferredSize(new Dimension(100,300));
        lt.setHorizontalAlignment(SwingConstants.LEFT);
        ltPanel.add(lt);

        bleedingDisorder = new JLabel("<html><u>Kline- felter Synd- rome</u></html>");
        linkAttachment(bleedingDisorder, "https://my.clevelandclinic.org/health/diseases/21116-klinefelter-syndrome");
        bleedingDisorder.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        borderCreation(bleedingDisorder);
        bleedingDisorder.setPreferredSize(new Dimension(100,300));
        bdPanel.add(bleedingDisorder);

        bdPanel.setBackground(Color.decode("#C9D5FD"));
        ltPanel.setBackground(Color.decode("#C9D5FD"));
        tcPanel.setBackground(Color.decode("#5061C5"));
        edPanel.setBackground(Color.decode("#5061C5"));
        returnPanel.setBackground(Color.decode("#5061C5"));
        returnbtn.setBackground(Color.decode("#C9D5FD"));
    
        infoPanel.add(tcPanel);
        infoPanel.add(bdPanel);
        infoPanel.add(ltPanel);
        infoPanel.add(edPanel);

        JScrollPane scrollpane = new JScrollPane(infoPanel);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollpane.setBackground(Color.decode("#5061C5"));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        returnPanel.add(returnbtn);
        panel.add(scrollpane);
        panel.add(Box.createHorizontalGlue());
        panel.add(returnPanel);
        panel.add(Box.createHorizontalGlue());

        baseFrame.setSize(450,324);
        baseFrame.add(panel);
        baseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //baseFrame.setResizable(false);
        baseFrame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(returnbtn)){
            MenWindow menWindow = new MenWindow();
            baseFrame.dispose();
        }
    }

    public void linkAttachment(JLabel label, String url){
        label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 0) {
                    // Open the link in the default browser
                    if (java.awt.Desktop.isDesktopSupported()) {
                        try {
                            java.awt.Desktop.getDesktop().browse(new java.net.URI(url));
                        } catch (java.io.IOException | java.net.URISyntaxException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
            }
        });
    }

    public void borderCreation(JLabel label){
        Border compoundBorder = BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.BLACK), // Outer line border
            BorderFactory.createEmptyBorder(5, 10, 5, 10) // Inner empty border for padding
        );
        label.setBorder(compoundBorder);

    }
    
}