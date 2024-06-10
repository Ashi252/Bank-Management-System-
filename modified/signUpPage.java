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




public class signUpPage implements ActionListener {
    JFrame frame = new JFrame();
    ImageIcon image = new ImageIcon("Images/Untitled.png");
    JButton signUP = new JButton();
    JButton back = new JButton();
    JButton View = new JButton();
    static JTextField textField = new JTextField();
    static JTextField textField1 = new JTextField();
    static JTextField textField2 = new JTextField();
    JTextField dob = new JTextField();
    static JComboBox<String> gender = new JComboBox<>(new String[]{"Male", "Female"});
    JLabel Gender = new JLabel("Gender");
    JLabel DOB = new JLabel("Date Of Birth");
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
    static JComboBox<String> date = new JComboBox<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30", "31"});
    static JComboBox<String> month = new JComboBox<>(new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"});
    static JComboBox<String> year = new JComboBox<>(new String[]{"1990", "1991", "1993", "1994", "1995", "1996",
            "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006",
            "2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018",
            "2019","2020","2021","2022","2023","2024"});

    JCheckBox terms = new JCheckBox("Accept Terms and Conditions");
    JProgressBar bar = new JProgressBar(0,500);
    static JComboBox<String> account = new JComboBox<>(new String[]{"Savings", "Current", "Fixed Deposit"});
    JLabel AccountType = new JLabel("Account Type");
    Pattern pattern;
    Matcher matcher;

    signUpPage(){


// working on the progress bar
        frame.setUndecorated(true);
        bar.setValue(0);
        bar.setBounds(0, 635,500,15);
        bar.setStringPainted(true);
        bar.setFont(new Font("sana-strikethrough", Font.BOLD, 12));
        bar.setForeground(Color.BLUE);
        bar.setBackground(Color.black);


// working on the text fields and their titles
        firstNameMiddleName.setBounds(125,140,140,20);
        textField.setBounds(125,160,230,20);

        lastName.setBounds(125,180,75,20);
        textField1.setBounds(125,200,230,20);

        phone.setBounds(125,220,75,20);
        textField2.setBounds(125,240,230,20);

        Address.setBounds(125,260,75,20);
        AddressField.setBounds(125,280,230,20);


        Email.setBounds(125,300,90,20);
        EmailField.setBounds(125,320,230,20);


        password.setBounds(125,340,75,20);
        passwordField.setBounds(125,360,230,20);

        CPassword.setBounds(125,380,140,20);
        Confirm.setBounds(125,398,230,20);

        // pin.setBounds(125, 385, 140, 20);
        // pintxt.setBounds(125, 405, 230, 20);

        DOB.setBounds(125,420,100,20);
        date.setBounds(125,440,40,20);
        month.setBounds(162, 440, 60, 20);
        year.setBounds(220,440,60,20);

        // set cursor for the component
        date.setCursor(new Cursor(Cursor.HAND_CURSOR));
        date.addActionListener(this);
        month.setCursor(new Cursor(Cursor.HAND_CURSOR));
        month.addActionListener(this);
        year.setCursor(new Cursor(Cursor.HAND_CURSOR));
        year.addActionListener(this);
        gender.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gender.addActionListener(this);

        signUP.setCursor(new Cursor(Cursor.HAND_CURSOR));
        terms.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        View.setCursor(new Cursor(Cursor.HAND_CURSOR));

        Gender.setBounds(125,460,100,20);
        gender.setBounds(125,480,230,20);

        // working on the account type
        AccountType.setBounds(125,500,100,20);
        account.setBounds(125,520,230,20);

        // working on the terms check box
        terms.setBounds(125, 550, 230, 20);
        terms.setFocusable(false);
        terms.addActionListener(this);
// working on the signUP button
        signUP.setBounds(200, 600, 90, 25);
        signUP.setText("Sign UP");
        signUP.setFocusable(false);
        signUP.addActionListener(this);







// working on the back button to take you to the previous page
        back.setBounds(0, 80, 85, 25);
        back.addActionListener(this);
        back.setFocusable(false);
        back.setText("<-Back");

// working on the terms and conditions button
        View.setBounds(360, 550, 80, 20);
        View.setText("View");
        View.setToolTipText("View Terms and Conditions");
        View.setFocusable(false);
        View.addActionListener(this);

// working on the massage label
        Massage.setBounds(125,110,250,25);
        Massage.setFont(new Font(null, Font.ITALIC,12));

// adding all components to the frame
        frame.add(date);
        frame.add(month);
        frame.add(year);
        frame.add(passwordField);
        frame.add(back);
        frame.add(View);
        frame.add(terms);
        frame.add(signUP);
        frame.add(textField2);
        frame.add(textField);
        frame.add(textField1);
        frame.add(Confirm);
        frame.add(CPassword);
        frame.add(password);
        frame.add(phone);
        frame.add(firstNameMiddleName);
        frame.add(Massage);
        frame.add(lastName);
        frame.add(dob);
        frame.add(DOB);
        frame.add(gender);
        frame.add(account);
        frame.add(AccountType);
        frame.add(Gender);
        frame.add(Email);
        frame.add(EmailField);
        frame.add(Address);
        frame.add(AddressField);
        // frame.add(pin);
        // frame.add(pintxt);
        frame.add(formPanel, BorderLayout.CENTER);
        frame.add(TPanel, BorderLayout.NORTH);
        frame.setVisible(true);



// working on ht e panel for the company name
        TPanel.setLayout(new BorderLayout());
        TPanel.setPreferredSize(new Dimension(500, 80));
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
        frame.setVisible(true);
        frame.setIconImage(image.getImage());
        frame.setTitle("Realm Bank");
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.add(bar);

        bar();
    }


    private boolean anyFieldEmpty() {

        return textField1.getText().isEmpty()
                || textField2.getText().isEmpty()
                || textField.getText().isEmpty()
                || passwordField.getPassword().length == 0
                || Confirm.getPassword().length == 0
                || gender.getSelectedItem()== null
                || month.getSelectedItem()==null
                || date.getSelectedItem()==null
                || year.getSelectedItem()==null;
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
        Object Day = date.getSelectedItem();
        Object Month = month.getSelectedItem();
        Object Year = year.getSelectedItem();
        Object Gender = gender.getSelectedItem();
        char[] password = passwordField.getPassword();
        char[] confirmPassword = Confirm.getPassword();


        if (firstName.isEmpty() || lastName.isEmpty() || username.isEmpty() || password.length == 0 || confirmPassword.length == 0 || ((String) Day).isEmpty() || ((String) Month).isEmpty() || ((String) Year).isEmpty() || ((String) Gender).isEmpty() || email.isEmpty() || address.isEmpty() ) {
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
                bar.setString("Account Created Successfully");
            }else{
                Massage.setText("You already have an account with us.");
                bar.setString("Account created unsuccessfully");
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
            new logIn();
        }
        if (e.getSource() == View) {
            frame.dispose();
            new TermsFrame();
        }
        if (!terms.isSelected() && e.getSource() == signUP) {
            showMessage("Please Accept Terms and Conditions.");
            Massage.setForeground(Color.red);
        }
        else{
            Massage.setText(null);
        }



        if(terms.isSelected() &&  e.getSource()== signUP){
            signUp();
            if (Massage.getText().equals("Sign up successful. Redirecting to pin page...")) {
//                bar.setString("Validating...");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e1) {
//                    // TODO Auto-generated catch block
//                    e1.printStackTrace();
//                }
//                bar.setString("Account Created Successfully");
//                bar.setIndeterminate(false);
//            }else{
//                bar.setString("Waiting...");
                JOptionPane.showMessageDialog(frame, "Account created successfully, Please create a transaction Pin ", "Required", JOptionPane.PLAIN_MESSAGE);
                frame.dispose();
                new pin();
            }

            if (e.getSource() == signUP) {
                notice();
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


    }
    public void bar(){
        bar.setIndeterminate(true);
        bar.setString("Waiting...");
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
        String Day = date.getSelectedItem().toString();
        String Month = month.getSelectedItem().toString();
        String  Year = year.getSelectedItem().toString();
        String dob = Day+"/"+Month+"/"+Year;
        String Gender = gender.getSelectedItem().toString();
        String password = String.valueOf(passwordField.getPassword());
        String phoneNum = textField2.getText();
        String accountType = account.getSelectedItem().toString();
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
            statement = String.format("insert into account values('%s', '%s', '%s', '0.00', '%s', '%s')", accountNum, customerId, accountType, LocalDate.now());
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
        new signUpPage();
//        new pin();
    }
}