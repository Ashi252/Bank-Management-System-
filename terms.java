import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class terms implements ActionListener {

public terms(){
  JFrame frame = new JFrame();
  JButton prePage = new JButton();
  JLabel label = new JLabel();
  JLabel welcome = new JLabel();
  JLabel welcome1 = new JLabel();
  JLabel welcome2 = new JLabel();
  JLabel term = new JLabel();
  JPanel TPanel = new JPanel();
  ImageIcon image = new ImageIcon("Images/Untitled.png");


  frame.add(TPanel);
  frame.add(label);
  frame.add(prePage);
  frame.add(welcome);
  frame.add(welcome1);
  frame.add(welcome2);
  frame.add(term);



  prePage.setBounds(0, 80, 85, 25);
  prePage.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == prePage) {
      frame.dispose();
      new signUpPage();
    }
    
  }});
  prePage.setFocusable(false);
  prePage.setText("<-Back");
  prePage.setForeground(new Color(60, 70, 100));

  welcome.setText("Welcome");
  welcome.setBounds(185,90,100,30);
  welcome.setFocusable(false);
  welcome.setFont(new Font("Arial", Font.BOLD, 19));

  welcome1.setText("To");
  welcome1.setBounds(220,115,100,30);
  welcome1.setFocusable(false);
  welcome1.setFont(new Font("Arial", Font.BOLD, 13));
  
  welcome2.setText("Realm");
  welcome2.setBounds(200,140,100,30);
  welcome2.setFocusable(false);
  welcome2.setFont(new Font("Arial", Font.BOLD, 20));
  welcome2.setForeground(Color.BLUE);

  term.setText("Thank you for using our services We work very hard to provide you with these");
  term.setBounds(0,20,500,350);
  term.setFocusable(false);
  term.setFont(new Font("Arial", Font.BOLD, 10));
  term.setForeground(Color.BLACK);


  TPanel.setLayout(new BorderLayout());
    TPanel.setBounds(0,0,500,80);

    //working on the header name "Realm Bank"
    label.setBackground(new Color(25,25,255));
    label.setForeground(Color.black);
    label.setFont(new Font("sanserif", Font.BOLD, 35));
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setText("Realm Bank");
    label.setOpaque(true);
    label.setLayout(new BorderLayout());

    // adding the header name to the tittle pan
    TPanel.add(label);

  // initializing and setting the frame features
  frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setSize(500,500);
    frame.getContentPane().setBackground(new Color(0xfafafa));
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setIconImage(image.getImage());
    frame.setTitle("Realm Bank");
    frame.setResizable(false);


    

}



  
public static void main(String[] args) {
  new terms();
}




@Override
public void actionPerformed(ActionEvent q) {
  
}
}
