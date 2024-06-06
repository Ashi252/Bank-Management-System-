import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

public class billUI  implements ActionListener {
JProgressBar bar = new JProgressBar();
JLabel label = new JLabel();
JPanel TPanel = new JPanel();
ImageIcon image = new ImageIcon("Images/Untitled.png");
JFrame frame = new JFrame();
JLabel massage = new JLabel();
JButton back = new JButton("<-Back");
JLabel number = new JLabel("Amount");
JLabel Title = new JLabel("Service Provider");
JTextField amount = new JTextField();
JPanel labePanel = new JPanel();
JComboBox<String> serviceProviders = new JComboBox<>(new String[]{"Water Board", "Ikeja electricity company", "PhEDc"});
Border border = BorderFactory.createLineBorder(Color.BLUE, 4);

billUI(){
  labePanel.setBounds(0,130,487,200);
  labePanel.setBorder(BorderFactory.createBevelBorder(2));
  labePanel.setBorder(border);

Title.setBounds(125,230,125,20);
serviceProviders.setBounds(125,350,230,20);
number.setBounds(125,380,125,20);
amount.setBounds(125,400,230,20);
// working on the massage label
massage.setBounds(170,500,230,25);
// working on the return button
back.setBounds(0,80,80,25);
back.setFocusable(false);
back.addActionListener(this);
back.setCursor(new Cursor(Cursor.HAND_CURSOR));
  // working on the progress bar
bar.setValue(0);
bar.setBounds(0, 598,500,15);
bar.setStringPainted(true);
bar.setFont(new Font("sana-strikethrough", Font.BOLD, 12));
bar.setForeground(Color.BLUE);
bar.setBackground(Color.black);
// working on ht e panel for the company name
TPanel.setLayout(new BorderLayout());
        TPanel.setBounds(0,0,500, 80);
        label.setBackground(new Color(25, 25, 255));
        label.setForeground(Color.black);
        label.setFont(new Font("sanserif", Font.BOLD, 35));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setText("Realm Bank");
        label.setOpaque(true);
        TPanel.add(label, BorderLayout.CENTER);
        frame.add(TPanel, BorderLayout.NORTH);
  
  // initializing and setting the frame features
  frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  frame.setSize(500,650);
  frame.getContentPane().setBackground(new Color(0xfafafa));
  frame.setIconImage(image.getImage());
  frame.setTitle("Realm Bank");
  frame.setResizable(false);
  frame.setLayout(null);
  frame.setLocationRelativeTo(null);
  frame.add(labePanel);
  frame.add(Title);
  frame.add(serviceProviders);
  frame.add(amount);
  frame.add(number);
  frame.add(massage);
  frame.add(TPanel);
  frame.add(back);
  frame.add(bar);
  frame.setVisible(true);
  bar();
}
// working on the progress bar
public void bar(){
  bar.setIndeterminate(true);
bar.setString("Waiting...");
}
// working on the massage method
private void showMessage(String message) {
massage.setText(message);
}
  @Override
  public void actionPerformed(ActionEvent e) {
  if (e.getSource()== back) {
    frame.dispose();
    new homePage();
  }
  }
public static void main(String[] args) {
  new billUI();
}
}
