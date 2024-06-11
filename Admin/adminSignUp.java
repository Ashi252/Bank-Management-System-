import Database.SqlStatements;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;




public class adminSignUp implements ActionListener {
    JFrame frame = new JFrame();
    ImageIcon image = new ImageIcon("Images/Untitled.png");
    JButton signUP = new JButton();
    JButton back = new JButton();
    static JTextField textField = new JTextField();
    static JTextField textField1 = new JTextField();
    static JTextField textField2 = new JTextField();
    JTextField dob = new JTextField();
    static JComboBox<String> BranchID = new JComboBox<>(new String[]{"Ike90720", "Aj23009","KD00001","AB00001", "UK00002", "UK00003", "AB00002", "OY10099"});
    JLabel BranchIDT = new JLabel("Branch ID");
    JLabel PositionT = new JLabel("Position");
    JLabel label = new JLabel();
    JPanel TPanel = new JPanel();
    JLabel firstNameMiddleName = new JLabel("First/Middle Name");
    JLabel lastName = new JLabel("Last Name");
    JLabel phone = new JLabel("Phone");
    JLabel password = new JLabel("Password");
    JLabel CPassword = new JLabel("Confirm Password");
    JLabel Massage = new JLabel();
    JPanel formPanel = new JPanel();
    static JPasswordField passwordField = new JPasswordField();
    JLabel Email = new JLabel("Email Address");
    JTextField EmailField = new JTextField();
    JLabel Address = new JLabel("Address");
    JTextField AddressField = new JTextField();
    JPasswordField Confirm = new JPasswordField();
    // JLabel pin = new JLabel("Pin");
    // static JPasswordField pintxt = new JPasswordField();
    static JComboBox<String> Position = new JComboBox<>(new String[]{"Accountant", "Business Administrator", "Marketing Manager", "Managing Director" });
    Pattern pattern;
    Matcher matcher;
    JPanel form = new JPanel();
    adminSignUp(){



// working on the text fields and their titles
        firstNameMiddleName.setBounds(150,80,140,20);
        textField.setBounds(150,100,230,20);

        lastName.setBounds(150,120,75,20);
        textField1.setBounds(150,140,230,20);

        phone.setBounds(150,160,75,20);
        textField2.setBounds(150,180,230,20);

        Address.setBounds(150,200,75,20);
        AddressField.setBounds(150,220,230,20);


        Email.setBounds(150,240,90,20);
        EmailField.setBounds(150,260,230,20);


        password.setBounds(150,280,75,20);
        passwordField.setBounds(150,300,230,20);

        CPassword.setBounds(150,320,140,20);
        Confirm.setBounds(150,340,230,20);

        // pin.setBounds(150, 385, 140, 20);
        // pintxt.setBounds(150, 405, 230, 20);

        PositionT.setBounds(150,360,100,20);
        Position.setBounds(150,380,230,20);

        // set cursor for the component
        Position.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Position.addActionListener(this);
        BranchID.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BranchID.addActionListener(this);

        signUP.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));

        BranchIDT.setBounds(150,400,100,20);
        BranchID.setBounds(150,420,230,20);

// working on the signUP button
        signUP.setBounds(200, 480, 90, 25);
        signUP.setText("Sign UP");
        signUP.setFocusable(false);
        signUP.addActionListener(this);







// working on the back button to take you to the previous page
        back.setBounds(0, 80, 85, 25);
        back.addActionListener(this);
        back.setFocusable(false);
        back.setText("<-Back");

// working on the massage label
        Massage.setBounds(150,450,250,25);
        Massage.setFont(new Font(null, Font.ITALIC,12));

// working on the form panel
formPanel.setLayout(null);
formPanel.add(Position);
formPanel.add(passwordField);
formPanel.add(signUP);
formPanel.add(textField2);
formPanel.add(textField);
formPanel.add(textField1);
formPanel.add(Confirm);
formPanel.add(CPassword);
formPanel.add(password);
formPanel.add(phone);
formPanel.add(firstNameMiddleName);
formPanel.add(Massage);
formPanel.add(lastName);
formPanel.add(dob);
formPanel.add(PositionT);
formPanel.add(BranchID);
formPanel.add(BranchIDT);
formPanel.add(Email);
formPanel.add(EmailField);
formPanel.add(Address);
formPanel.add(AddressField);
formPanel.setPreferredSize(new Dimension(500,600));
form.add(formPanel , BorderLayout.CENTER);
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
        TPanel.add(back, BorderLayout.WEST);
        frame.add(TPanel, BorderLayout.NORTH);



        // initializing and setting the frame features

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(5000,5000);
        frame.getContentPane().setBackground(new Color(0xfafafa));
        frame.setVisible(true);
        frame.setIconImage(image.getImage());
        frame.setTitle("Realm Bank Admin");
        frame.setResizable(true);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
// adding all components to the frame
        
        // frame.add(pin);
        // frame.add(pintxt);
        frame.add(form, BorderLayout.CENTER);
        frame.add(TPanel, BorderLayout.NORTH);
        frame.setVisible(true);
    }


    private boolean anyFieldEmpty() {

        return textField1.getText().isEmpty()
                || textField2.getText().isEmpty()
                || textField.getText().isEmpty()
                || passwordField.getPassword().length == 0
                || Confirm.getPassword().length == 0
                || BranchID.getSelectedItem()== null
                || Position.getSelectedItem()==null;
    }

    private void showMessage(String message) {
        Massage.setText(message);
    }
    private void signUp() {
        String firstName = textField.getText().trim();
        String lastName = textField1.getText().trim();
        String username = textField2.getText().trim();
        String email = EmailField.getText().trim();
        String address = AddressField.getText().trim();
        Object Day = Position.getSelectedItem();
        Object Gender = BranchID.getSelectedItem();
        char[] password = passwordField.getPassword();
        char[] confirmPassword = Confirm.getPassword();

        notice();
        if (firstName.isEmpty() || lastName.isEmpty() || username.isEmpty() || password.length == 0 || confirmPassword.length == 0 || ((String) Day).isEmpty()  || ((String) Gender).isEmpty() || email.isEmpty() || address.isEmpty() ) {
            showMessage("Please fill in all fields.");
        }
        else if (password.length != 8 || confirmPassword.length != 8) {
            showMessage("password must be 8 characters long.");
            passwordField.setBackground(Color.RED);
        }
        else if(!validateNames(textField.getText()) || !validateNames(textField1.getText())){
            Massage.setText("Names should be 3 letters or more");
            Massage.setForeground(Color.RED);
        }else if(!validatePhone(textField2.getText()))
        {
            Massage.setText("Phone no should be of format 080 or 070 or 090.... and should be 11 digits");
            Massage.setForeground(Color.RED);
        }else if(!validateEmail(EmailField.getText())){
            Massage.setText("Invalid email address");
            Massage.setForeground(Color.RED);
        }else if (!passwordMatches(password, confirmPassword)) {
            showMessage("Passwords do not match.");
            passwordField.setBackground(Color.red);
            Confirm.setBackground(Color.red);

        // }else if(!validatePin(String.valueOf(pintxt.getPassword()))){
        //     Massage.setText("Pin should be 4 digits long");
        //     Massage.setForeground(Color.RED);
        }
        else{
            // sql statement to retrieve information regarding the user through the user phone number
            // if the user phone exists then the user should login instead

            //if user does not exist in DB then Sql bach statement to insert user data into the database

            // if data is successfully inserted
            if(insertData())
            {
                Massage.setForeground(Color.BLUE);
                showMessage("Sign up successful. Redirecting to login page...");
            }else{
                Massage.setText("You already have an account with us.");
            }
        }
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

    private void notice(){
        if (textField.getText().isEmpty()) {
            textField.setBackground(Color.RED);
        }else {
            textField.setBackground(Color.WHITE);
        }
        if (textField1.getText().isEmpty()) {
            textField1.setBackground(Color.RED);
        }else{
            textField1.setBackground(Color.WHITE);
        }
        if (textField2.getText().isEmpty()) {
            textField2.setBackground(Color.RED);
        }
        else{
            textField2.setBackground(Color.WHITE);
        }
        if (passwordField.getPassword().length== 0 ) {
            passwordField.setBackground(Color.RED);
        }
        else{
            passwordField.setBackground(Color.white);
        }
        if (Confirm.getPassword().length == 0) {
            Confirm.setBackground(Color.red);
        }
        else{
            Confirm.setBackground(Color.white);
        }
        if (AddressField.getText().isEmpty()) {
            AddressField.setBackground(Color.red);
        }else{
            AddressField.setBackground(Color.WHITE);
        }
        if (EmailField.getText().isEmpty()) {
            EmailField.setBackground(Color.red);
        }
        else{
            EmailField.setBackground(Color.WHITE);
        }

    }




    // working on the actions for each component
    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource()==back) {
            frame.dispose();
            new adminLogIn();
        }
        if( e.getSource()== signUP){
            signUp();
            if (Massage.getText().equals("Sign up successful. Redirecting to pin page...")){
                JOptionPane.showMessageDialog(frame, "Account created successfully, Please create a transaction Pin ", "Required", JOptionPane.PLAIN_MESSAGE);
                frame.dispose();
                new adminHomepage();
            }
            if (anyFieldEmpty()) {
                Massage.setText("Please fill in all fields correctly.");
                Massage.setForeground(Color.RED);
            }
            if (!passwordsMatch()) {
                Massage.setText("Passwords do not match.");
                Massage.setForeground(Color.RED);
                passwordField.setBackground(Color.red);
                Confirm.setBackground(Color.red);
            }
            
        }


    }
    private boolean passwordsMatch() {
        char[] password = passwordField.getPassword();
        char[] confirmPassword = Confirm.getPassword();
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

    public boolean validateNames(String name){
        pattern = Pattern.compile("[a-zA-z]{3,}");
        matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public boolean validatePhone(String phone){
        pattern = Pattern.compile("^0[7-9]{1}[0-1]{1}[0-9]{8}");
        matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public boolean validateEmail(String email){
        pattern = Pattern.compile("^[a-zA-Z0-9\\._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validatePin(String pin){
        pattern = Pattern.compile("[0-9]{4}");
        matcher = pattern.matcher(pin);
        if(!matcher.matches()){
            return false;
        }
        return true;
    }

    public static String generateAccountNum(){
        Random rd  = new Random();
        Long accounNum = rd.nextLong(1000000000, 9999999999L);
        return accounNum.toString();

    }

    public boolean insertData(){
        String  firstName = textField.getText().trim();
        String lastname = textField1.getText().trim();
        String Day = Position.getSelectedItem().toString();
        String Gender = BranchID.getSelectedItem().toString();
        String password = String.valueOf(passwordField.getPassword());
        String phoneNum = textField2.getText();
        String email = EmailField.getText().trim();
        String address = AddressField.getText().trim();
        // String pin = String.valueOf(pintxt.getPassword());
         SqlStatements st = new SqlStatements();
        String statement = "";
        if (!isPresent(phoneNum, st)) {
            statement = String.format("insert into customer(fistName, lastName, dob, gender, contactNumber,address, email, password) values('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s') ", firstName, lastname, dob, Gender, phoneNum,email, address, password);
            st.insert(statement);
            statement = String.format("select customerId from customer where contactNumber = '%s'", phoneNum);
            String[] customerData = st.selectCustomerData(statement);
            String customerId = customerData[1];
            String accountNum = generateAccountNum();
            statement = String.format("insert into account values('%s', '%s', '%s', '0.00', '%s', '%s')", accountNum, customerId,LocalDate.now());
            st.insert(statement);
            return true;
//            Massage.setText("You already have an account");
//            Massage.setForeground(Color.RED);
        }
    return false;
    }



    public static boolean isPresent(String phoneNum, SqlStatements st){
        String statement = String.format("select * from customer where contactNumber = '%s'", phoneNum);
        return st.select(statement);

    }

    public static void main(String[] args) {
    new adminSignUp();
//        new pin();
    }
}