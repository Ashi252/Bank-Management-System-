
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Database.SqlStatements;
import Database.User;



public class adminLogIn implements ActionListener{
    JFrame frame = new JFrame();
    JPasswordField Password = new JPasswordField();
    JButton logIn = new JButton();
    JButton rButton = new JButton();
    JButton signUp = new JButton();
    JPanel TPanel = new JPanel();
    JPanel TextPanel = new JPanel();
    JPanel Panel3 = new JPanel();
    JLabel label = new JLabel();
    JLabel userID = new JLabel("Phone");
    JLabel UserPassword = new JLabel("Password");
    JLabel Massage = new JLabel();
    JLabel singUpMassage = new JLabel();
    JLabel LogInMassage = new JLabel();
    JTextField textField = new JTextField();
    ImageIcon frameIcon = new ImageIcon("Images/Untitled.png");
    SqlStatements st = new SqlStatements();
    JPanel formPanel = new JPanel();
    JPanel form = new JPanel();


    adminLogIn(){

// this are titles used for the login fields
        userID.setBounds(150,170,75,25);
        UserPassword.setBounds(150,230,75,25);

// working on the error massage to be displayed if User input are invalid
        Massage.setBounds(170,120,250,25);
        Massage.setFont(new Font(null, Font.ITALIC,12));


// working on the singUp massage
        singUpMassage.setBounds(190,390,500,20);
        singUpMassage.setFont(new Font(null, Font.ITALIC,12));
        singUpMassage.setText("Sign Up as Admin");
        singUpMassage.setBackground(Color.blue);

// working on the singUp massage
LogInMassage.setBounds(190,100,500,30);
LogInMassage.setFont(new Font(null, Font.ITALIC,20));
LogInMassage.setText("LogIn as Admin");
LogInMassage.setForeground(Color.blue);

// working on the phone input field
        textField.setBounds(150,190,230,25);

// working on the password field
        Password.setBounds(150,250,230,25);

// working on the logIn button
        logIn.setBounds(150, 300, 90, 25);
        logIn.setText("Login");
        logIn.setFocusable(false);
        logIn.addActionListener(this);
        logIn.setCursor(new Cursor(Cursor.HAND_CURSOR));

// working on the signUp button
        signUp.setBounds(190, 420, 100, 25);
        signUp.setText("Sign Up");
        signUp.setFocusable(false);
        signUp.addActionListener(this);
        signUp.setCursor(new Cursor(Cursor.HAND_CURSOR));

// working on the reset button
        rButton.setBounds(250,300,80,25);
        rButton.setText("Reset");
        rButton.setFocusable(false);
        rButton.addActionListener(this);
        rButton.setCursor(new Cursor(Cursor.HAND_CURSOR));


// adding all components to the frame
formPanel.setLayout(null);
formPanel.add(userID);
formPanel.add(UserPassword);
formPanel.add(Massage);
formPanel.add(textField);
formPanel.add(Password);
formPanel.add(logIn);
formPanel.add(singUpMassage);
formPanel.add(signUp);
formPanel.add(rButton);
formPanel.add(LogInMassage, STR);
formPanel.setPreferredSize(new Dimension(500,600));

form.setBackground(adminHomepage.color1);
        formPanel.setBackground(adminHomepage.color1);
// working on ht e panel for the company name
TPanel.setLayout(new BorderLayout());
TPanel.setPreferredSize(new Dimension(500, 80));
label.setBackground(new Color(25, 25, 255));
label.setForeground(Color.black);
label.setFont(new Font("sanserif", Font.BOLD, 35));
label.setHorizontalAlignment(JLabel.CENTER);
label.setText("Realm Bank - Admin");
label.setOpaque(true);
TPanel.add(label, BorderLayout.CENTER);




// initializing and setting the frame features

frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
frame.setSize(5000,5000);
frame.getContentPane().setBackground(adminHomepage.color1);
frame.setVisible(true);
frame.setIconImage(frameIcon.getImage());
frame.setTitle("Realm Bank Admin");
frame.setResizable(true);
frame.setLayout(new BorderLayout());
frame.setLocationRelativeTo(null);
// adding all components to the frame

// frame.add(pin);
// frame.add(pintxt);
form.add(formPanel, BorderLayout.CENTER);
frame.add(form, BorderLayout.CENTER);
frame.add(TPanel, BorderLayout.NORTH);

frame.setVisible(true);
        
        
    }
    private boolean notice(){
        if (textField.getText().isEmpty()) {
            textField.setBackground(Color.RED);
        }else {
            textField.setBackground(Color.WHITE);
        }
        if (Password.getPassword().length== 0 ) {
            Password.setBackground(Color.RED);
        }
        else{
            Password.setBackground(Color.white);
        }
        return true;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String password = String.valueOf(Password.getPassword());
        String number = textField.getText();
        // setting a default value for the reset button
        if(e.getSource()==rButton){
            textField.setText(null);
            Password.setText(null);
        }
        // setting the action to be taking for the login button
        if (Password.getPassword().length != 8  && e.getSource()==logIn) {
            Massage.setText("password most be 8 characters long");
            Massage.setForeground(Color.red);
        }
        else{
            Massage.setText(null);
        }
        if (Password.getPassword().length == 8 && e.getSource()==logIn) {
            String statement = String.format("Select contactNumber, password from admin where contactNumber = '%s'",textField.getText());
            String[] data = st.selectCustomerData(statement);
            System.out.println(data[1]+data[2]);
            if(password.equals(data[2]) && number.equals(data[1])){
                frame.dispose();
                User user = new User();
                user.createCustomer(textField.getText());
                new homePage(user);

//                HomePageFrame.main(null);
            }else{
                Massage.setText("Invalid user");
                Massage.setForeground(Color.RED);
            }
        }
        // constraint check on the phone input
        if (textField.getText().length() !=  11 && e.getSource()==logIn ) {
            Massage.setText("Phone most be 11 digits long");
            Massage.setForeground(Color.red);
        }
//        else{
//            Massage.setText(null);
//        }


        notice();

        if (e.getSource()== signUp) {
            frame.dispose();
            new adminSignUp();

        }

    }



    public static void main(String[] args) {
        new adminLogIn();

    }

}