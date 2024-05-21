package Login;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Database.SqlStatements;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;



public class login implements ActionListener{
    JFrame frame = new JFrame();
    protected JPasswordField Password = new JPasswordField();
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
    JTextField textField = new JTextField();
    ImageIcon image = new ImageIcon("Images/Untitled.png");
    SqlStatements st = new SqlStatements();



    login(){

// this are titles used for the login fields
        userID.setBounds(150,170,75,25);
        UserPassword.setBounds(150,230,75,25);

// working on the error massage to be displayed if User input are invalid
        Massage.setBounds(170,120,250,25);
        Massage.setFont(new Font(null, Font.ITALIC,12));


// working on the singUp massage
        singUpMassage.setBounds(80,390,500,20);
        singUpMassage.setFont(new Font(null, Font.ITALIC,11));
        singUpMassage.setText("If you don't have an account, please sign up and get a bonus of 1000 Naira!");
        singUpMassage.setBackground(Color.blue);

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
        signUp.setBounds(200, 420, 100, 25);
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
        frame.add(userID);
        frame.add(UserPassword);
        frame.add(Massage);
        frame.add(textField);
        frame.add(Password);
        frame.add(logIn);
        frame.add(TPanel, BorderLayout.NORTH);
        frame.add(rButton);
        frame.add(singUpMassage);
        frame.add(signUp);
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
        frame.setSize(500,500);
        frame.getContentPane().setBackground(new Color(0xfafafa));
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setIconImage(image.getImage());
        frame.setTitle("Realm Bank");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);



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
        // setting a default value for the reset button
        if(e.getSource()==rButton){
            textField.setText(null);
            Password.setText(null);
        }
        // setting the action to be taking for the login button
        if (Password.getPassword().length <8 || Password.getPassword().length >8 && e.getSource()==logIn) {
            Massage.setText("password most be 8 characters long");
            Massage.setForeground(Color.red);
        }
        else{
            Massage.setText(null);
        }
        if (Password.getPassword().length ==8 && textField.getText().length() ==11 && e.getSource()==logIn) {
            String statement = String.format("Select * from customer where contactNumber = '%s'",textField.getText());
            boolean present = st.select(statement);
            if(present){
                frame.dispose();
                new HomePageFrame();
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
            new signUpPage();

        }

    }



    public static void main(String[] args) {
        new login();
    }

}
