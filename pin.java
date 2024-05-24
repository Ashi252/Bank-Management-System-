import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.WindowConstants;
import javax.swing.JProgressBar;
import javax.swing.BorderFactory;

public class pin implements ActionListener {
  String[] word = new String[] {
    "Hello, "+ userDB.FirstName,
    "Please create a transaction pin,",
    "Please note that the transaction pin",
    "Will be required and used only",
    "To approve transactions made by you.",
    "Regarding that, please make sure that",
    "The transaction pin is something you won't forget",
    "And most importantly do not share your",
    "Transaction pin with others.",
    "Thanks for banking with us."
};
JFrame frame = new JFrame();
static JPasswordField pin = new JPasswordField();
JButton rButton = new JButton();
JButton create = new JButton();
JPanel TPanel = new JPanel();
JLabel label = new JLabel();
JLabel statement = new JLabel();
JLabel user = new JLabel("Pin");
JLabel UserPin = new JLabel("Confirm Pin");
public static JLabel Massage = new JLabel();
JLabel singUpMassage = new JLabel();
static JPasswordField confirmPin = new JPasswordField(); 
ImageIcon image = new ImageIcon("Images/Untitled.png");
static JProgressBar bar = new JProgressBar(0,500);
JButton cancel = new JButton("Cancel");



pin(){

  
// working on the progress bar

bar.setValue(0);
bar.setBounds(0, 495,500,20);
bar.setStringPainted(true);
bar.setFont(new Font("sana-strikethrough", Font.BOLD, 12));
bar.setForeground(Color.BLUE);
bar.setBackground(Color.black);

  
// this are titles used for the login fields
user.setBounds(150,230,75,25);
UserPin.setBounds(150,270,75,25);

// working on the error massage to be displayed if User input are invalid
Massage.setBounds(170,200,250,25);
Massage.setFont(new Font(null, Font.ITALIC,12));

// working on the statement label
statement.setBounds(100,110,320,90);
statement.setOpaque(true);
statement.setFont(new Font("sanserif", Font.LAYOUT_LEFT_TO_RIGHT, 14));
statement.setBorder(BorderFactory.createCompoundBorder());
statement.setForeground(Color.GREEN);
statement.setBackground(Color.BLACK);
statement.setText("Hello, "+ userDB.FirstName);
frame.add(statement);

// working on the create pin field
pin.setBounds(150,290,200,25);

// working on the confirm pin field
confirmPin.setBounds(150,250,200,25);

// working on the create button
create.setBounds(200, 460, 100, 25);
create.setText("Create");
create.setFocusable(false);
create.addActionListener(this);
create.setCursor(new Cursor(Cursor.HAND_CURSOR));
create.setBorder(BorderFactory.createBevelBorder(0));


// working on the reset button
rButton.setBounds(200,330,100,25);
rButton.setText("Reset");
rButton.setFocusable(false);
rButton.addActionListener(this);
rButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
rButton.setBorder(BorderFactory.createBevelBorder(0));



// adding all components to the frame
frame.add(user);
frame.add(UserPin);
frame.add(Massage);
frame.add(pin);
frame.add(confirmPin);
frame.add(TPanel, BorderLayout.NORTH);
frame.add(rButton);
frame.add(singUpMassage);
frame.add(create);
frame.add(cancel);
// working on the Tittle pan or header pan
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
    frame.setSize(500,550);
    frame.getContentPane().setBackground(new Color(0xfafafa));
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setIconImage(image.getImage());
    frame.setTitle("Realm Bank");
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.add(bar);
    bar();
 while (true){
  
  for (int i = 0; i < word.length; i++) {

    try {
      Thread.sleep(2500);
    } catch (InterruptedException e) {
    }
    
    statement.setText(word[i]);
  }
 }
    
  

}
public void bar(){
  bar.setIndeterminate(true);
bar.setString("Waiting...");
}
private boolean notice(){
  if (pin.getPassword().length==0) {
    pin.setBackground(Color.RED);
  }else {
    pin.setBackground(Color.WHITE);
  }
  if (confirmPin.getPassword().length== 0 ) {
    confirmPin.setBackground(Color.RED);
  }
  else{
    confirmPin.setBackground(Color.white);
  }
  return true;
}


  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == cancel) {
      frame.dispose();
    }
    // setting a default value for the reset button 
    if(e.getSource()==rButton){
      confirmPin.setBackground(Color.WHITE);
      pin.setBackground(Color.white);
      pin.setText(null);
      confirmPin.setText(null);
      
    }
    
    notice();
    

    if (e.getSource()== create) {
      create();
      
    }
      }
private boolean create(){
  char[] password = pin.getPassword();
  char[] confirmPassword = confirmPin.getPassword();
 if (password.length == 0 || confirmPassword.length == 0 ) {
  showMessage("Please fill in all fields.");
  Massage.setForeground(Color.red);
  return true;
}
else{
showMessage(null);
}
if (password.length >4 || password.length <4) {
  showMessage("Pin must be 4 digits long.");
  Massage.setBackground(Color.RED);
  pin.setBackground(Color.RED);
  return true;
}
else{
  pin.setBackground(Color.white);
}
if (confirmPassword.length >4 || password.length <4) {
  showMessage("Pin must be 4 digits long.");
  Massage.setBackground(Color.RED);
  confirmPin.setBackground(Color.RED);
  return true;
}
else{
  confirmPin.setBackground(Color.white);
}

if (!passwordMatches(password, confirmPassword)) {
    showMessage("Pin's do not match.");
    Massage.setBackground(Color.RED);
    pin.setBackground(Color.red);
    confirmPin.setBackground(Color.red);
    return true;
    
}else{
  pin.setBackground(Color.white);
    confirmPin.setBackground(Color.white);
}
if (!anyFieldEmpty() && passwordMatches(password, confirmPassword)) {
  //sql statement write data into the database

  bar.setString("Successfully created");
  Massage.setBackground(Color.blue);
  showMessage("Pin created successfully");
    frame.dispose();
    new logIn();
  
}

return true;
}

public void run(){
  
}

private void showMessage(String message) {
  Massage.setText(message);
}

private boolean anyFieldEmpty() {
  return
          pin.getPassword().length == 0
          || confirmPin.getPassword().length == 0;
}

private boolean passwordMatches(char[] password, char[] confirmPassword) {
  if (password.length != confirmPassword.length) {
      return false;
  }
  for (int i = 0; i < password.length; i++) {
      if (password[i] != confirmPassword[i]) {
          return false;
      }
  }
  return true;
}


  public static void main(String[] args) {
    new pin();
  }

  

}

