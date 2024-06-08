package Login;


import Database.SqlStatements;
import Entities.User;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

public class Credit  implements ActionListener  {
    JProgressBar bar = new JProgressBar();
    ImageIcon image = new ImageIcon("src/Images/Untitled.png");
    ImageIcon icon = new ImageIcon("Images/data45MB.png"); //
    JFrame frame = new JFrame();
    JPanel TPanel = new JPanel();
    JLabel one, two,three,four,five,six,seven,eight,nine,ten,eleven,twelve;
    JLabel label = new JLabel();
    JPanel labePanel = new JPanel();
    JLabel NSPsTitle = new JLabel("Network");
    JLabel number = new JLabel("Number");
    JTextField numberField = new JTextField();
    JLabel massage = new JLabel();
    JButton[] items = new JButton[12];
    JButton back = new JButton("<-Back");
    JComboBox<String> NSPs = new JComboBox<>(new String[]{"MTN", "Airtel", "Glo", "9mobile"});
    Border border = BorderFactory.createLineBorder(Color.BLUE, 4);
    double balance = 10000.00;
    SqlStatements sq = new SqlStatements();
    String pin = "1234";
    String amount;
    String pass;
    User user;
    Credit(User user){
        this.user = user;
// working on the progress bar
        bar.setValue(0);
        bar.setBounds(0, 598,500,15);
        bar.setStringPainted(true);
        bar.setFont(new Font("sana-strikethrough", Font.BOLD, 12));
        bar.setForeground(Color.BLUE);
        bar.setBackground(Color.black);
// working on the label panel for the network
        for (int i=0;i<12;i++){
            items[i] = new JButton();
            labePanel.add(items[i]);
            items[i].setBackground(Color.red);
            items[i].setFocusable(false);
            items[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            items[i].addActionListener(this);
            items[i].setHorizontalAlignment(JButton.CENTER);
            items[i].setVerticalAlignment(JButton.CENTER);
        }
// working on the data label and prices
        one = new JLabel();
        one.setText("50 Naira");
        one.setHorizontalAlignment(JButton.CENTER);
        one.setVerticalAlignment(JButton.CENTER);
        items[0].setLayout(new BorderLayout());
        items[0].add(one, BorderLayout.CENTER);

        two= new JLabel();
        two.setText("100 Naira");
        two.setHorizontalAlignment(JButton.CENTER);
        two.setVerticalAlignment(JButton.CENTER);
        items[1].setLayout(new BorderLayout());
        items[1].add(two, BorderLayout.CENTER);

        three= new JLabel();
        three.setText("200 Naira");
        three.setHorizontalAlignment(JButton.CENTER);
        three.setVerticalAlignment(JButton.CENTER);
        items[2].setLayout(new BorderLayout());
        items[2].add(three, BorderLayout.CENTER);
        four = new JLabel();
        four.setText("500 Naira");
        four.setHorizontalAlignment(JButton.CENTER);
        four.setVerticalAlignment(JButton.CENTER);
        items[3].setLayout(new BorderLayout());
        items[3].add(four, BorderLayout.CENTER);
        five = new JLabel();
        five.setText("800 Naira");
        five.setHorizontalAlignment(JButton.CENTER);
        five.setVerticalAlignment(JButton.CENTER);
        items[4].setLayout(new BorderLayout());
        items[4].add(five, BorderLayout.CENTER);
        six = new JLabel();
        six.setText("1,000 Naira");
        six.setHorizontalAlignment(JButton.CENTER);
        six.setVerticalAlignment(JButton.CENTER);
        items[5].setLayout(new BorderLayout());
        items[5].add(six, BorderLayout.CENTER);


        seven = new JLabel();
        seven.setText("1,500 Naira");
        seven.setHorizontalAlignment(JButton.CENTER);
        seven.setVerticalAlignment(JButton.CENTER);
        items[6].setLayout(new BorderLayout());
        items[6].add(seven, BorderLayout.CENTER);

        eight = new JLabel();
        eight.setText("2,000, Naira");
        eight.setHorizontalAlignment(JButton.CENTER);
        eight.setVerticalAlignment(JButton.CENTER);
        items[7].setLayout(new BorderLayout());
        items[7].add(eight, BorderLayout.CENTER);
        nine = new JLabel();
        nine.setText("2,500 Naira");
        nine.setHorizontalAlignment(JButton.CENTER);
        nine.setVerticalAlignment(JButton.CENTER);
        items[8].setLayout(new BorderLayout());
        items[8].add(nine, BorderLayout.CENTER);
        ten = new JLabel();
        ten.setText("3,000 Naira");
        ten.setHorizontalAlignment(JButton.CENTER);
        ten.setVerticalAlignment(JButton.CENTER);
        items[9].setLayout(new BorderLayout());
        items[9].add(ten, BorderLayout.CENTER);
        eleven = new JLabel();
        eleven.setText("3,500 Naira");
        eleven.setHorizontalAlignment(JButton.CENTER);
        eleven.setVerticalAlignment(JButton.CENTER);
        items[10].setLayout(new BorderLayout());
        items[10].add(eleven, BorderLayout.CENTER);
        twelve = new JLabel();
        twelve.setText("5,000 Naira");
        twelve.setHorizontalAlignment(JButton.CENTER);
        twelve.setVerticalAlignment(JButton.CENTER);
        items[11].setLayout(new BorderLayout());
        items[11].add(twelve, BorderLayout.CENTER);


        labePanel.setBounds(0,280,487,200);
        labePanel.setBorder(BorderFactory.createBevelBorder(2));
        labePanel.setBorder(border);
        labePanel.setLayout(new GridLayout(3, 3, 2, 1));

        // labePanel.setBackground(Color.red);

// working on the return button
        back.setBounds(0,80,80,25);
        back.setFocusable(false);
        back.addActionListener(this);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));


// working on the massage label
        massage.setBounds(170,500,230,25);


// working on the NSPs "Network Service Providers"
        NSPsTitle.setBounds(125,150,125,20);
        NSPs.setBounds(125,170,230,20);
        number.setBounds(125,200,125,20);
        numberField.setBounds(125,220,230,20);
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
        frame.getContentPane().setBackground(homePage.color1);
        frame.setIconImage(image.getImage());
        frame.setTitle("Realm Bank");
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);


        // adding the components to the frame
        frame.add(massage);
        frame.add(number);
        frame.add(numberField);
        frame.add(TPanel);
        frame.add(labePanel);
        frame.add(back);
        frame.add(NSPsTitle);
        frame.add(NSPs);
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
    // working on the transaction approval process
    private void approve(int amt){
        String number = numberField.getText().trim();
// validating user input
        if (number.isEmpty()) {
            massage.setForeground(Color.red);
            showMessage("Please enter a number.");
        }
        else if (number.length() != 11) {
            massage.setForeground(Color.red);
            showMessage("Phone number must be 11 digits");
        }
        else if(new signUpPage().validatePhone(number)) {
            pass = JOptionPane.showInputDialog("Your Transaction Pin");
            if (pass.equals(user.pin)) {
                massage.setForeground(Color.BLUE);
                int n = JOptionPane.showConfirmDialog(frame, "Are you sure you want to approve this transaction of "+ amount,  "Confirm", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    user.balance -= amt;
                    String statement = String.format("Update account set balance = '%s' where customerId = '%s'",user.balance, user.customerID);
                    sq.Update(statement);
                    statement = String.format("Insert into transaction(accountNumber, transactionType, amount, transactionDate, receiver) values ('%s', '%s', '%s', '%s', '%s')", user.accountNumber, "recharge", amt, LocalDate.now(),number);
                    sq.insert(statement);
                    showMessage("Transaction Successful");
                    bar.setString("Transaction Approved");
// SQL Transaction statement or statement that reflects changes to the DB on balance and ammount


// checking if the user decides not to approve the transaction
                }else if (n==JOptionPane.NO_OPTION) {
                    // revert transaction
                    showMessage("Transaction Terminated Successfully");
                    bar.setString("Terminated");
                }
            }else{
                massage.setForeground(Color.red);
                showMessage("Invalid Transaction Pin");
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==items[0]) {
            if (balance <50) {
                showMessage("Insufficient funds.");
                massage.setForeground(Color.RED);
            }else{
                showMessage(null);
                approve(50);
            }
        }
        if (e.getSource()==items[1]) {
            if (balance <100) {
                showMessage("Insufficient funds.");
                massage.setForeground(Color.RED);
            }
            else{
                approve(100);
            }
        }
        if (e.getSource()==items[2]) {
            if (balance <200) {
                showMessage("Insufficient funds.");
                massage.setForeground(Color.RED);
            }
            else{
                approve(200);
            }
        }
        if (e.getSource()==items[3]) {
            if (balance <500) {
                showMessage("Insufficient funds.");
                massage.setForeground(Color.RED);
            }
            else{
                approve(500);
            }
        }
        if (e.getSource()==items[4]) {
            if (balance <800) {
                showMessage("Insufficient funds.");
                massage.setForeground(Color.RED);
            }
            else{
                approve(800);
            }
        }
        if (e.getSource()==items[5]) {
            if (balance <1000) {
                showMessage("Insufficient funds.");
                massage.setForeground(Color.RED);
            }
            else{
                approve(1000);
            }
        }
        if (e.getSource()==items[6]) {
            if (balance <1500) {
                showMessage("Insufficient funds.");
                massage.setForeground(Color.RED);
            }
            else{
                approve(1500);
            }
        }
        if (e.getSource()==items[7]) {
            if (balance <2000) {
                showMessage("Insufficient funds.");
                massage.setForeground(Color.RED);
            }
            else{
                approve(2000);
            }
        }
        if (e.getSource()==items[8]) {
            if (balance <2500) {
                showMessage("Insufficient funds.");
                massage.setForeground(Color.RED);
            }
            else{
                approve(2500);
            }
        }
        if (e.getSource()==items[9]) {
            if (balance <3000) {
                showMessage("Insufficient funds.");
                massage.setForeground(Color.RED);
            }
            else{
                approve(3000);
            }
        }
        if (e.getSource()==items[10]) {
            if (balance <3500) {
                showMessage("Insufficient funds.");
                massage.setForeground(Color.RED);
            }
            else{
                approve(3500);
            }
        }
        if (e.getSource()==items[11]) {
            if (balance <5000) {
                showMessage("Insufficient funds.");
                massage.setForeground(Color.RED);
            }
            else{
                approve(5000);
            }
        }
        if (e.getSource()== back) {
            frame.dispose();
            new homePage(user);
        }
    }


    public static void main(String[] args) {
//        new Credit();
    }
}