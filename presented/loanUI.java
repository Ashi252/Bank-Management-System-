package Login;


import Database.SqlStatements;
import Entities.User;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

public class loanUI implements ActionListener{
    JFrame frame = new JFrame();
    JLabel labePanel = new JLabel();
    ImageIcon frameIcon = new ImageIcon("src/Images/Untitled.png");
    JPanel TPanel = new JPanel();
    JLabel label = new JLabel();
    JLabel amount = new JLabel();
    JButton approve = new JButton("Approve");
    JLabel amountLabel = new JLabel("Eligible Amount");
    JLabel interestRate = new JLabel("10%");
    JLabel interest = new JLabel("Interest Rate");
    JLabel Eligibility = new JLabel("Eligibility Status");
    JLabel userLabel = new JLabel();
    JPanel BPanel = new JPanel();
    JButton back = new JButton("<-Back");
    JButton viewTerms = new JButton("View~Terms");
    JCheckBox check = new JCheckBox("Accept Terms and Conditions");
    JCheckBox loanState = new JCheckBox();
    JLabel loanLabel = new JLabel("Loan State");
    JCheckBox status = new JCheckBox();
    JLabel state = new JLabel();
    JLabel massage = new JLabel();
    Border border = BorderFactory.createLineBorder(Color.BLUE, 4);
    String[] terms = {"Terms and Conditions", "Dear thanks for banking with us.",
            "A 10% interest rate will be charged for the loan", "fell free because you have no deu date", "the loan and the interest rate will be deducted","from your next deposit", "Thanks."};
//    String pin = "1234";
    String pass;
    static String level = "";
    static String showEl = "";
    User user;
    SqlStatements sq = new SqlStatements();
    // @SuppressWarnings("deprecation")
    public loanUI(User user){
        this.user = user;
// working on the massage label
        massage.setBounds(150,510,230,20);
// working on the terms button
        viewTerms.setBounds(180,195,120,20);
        viewTerms.addActionListener(this);
        viewTerms.setFocusable(false);
        viewTerms.setCursor(new Cursor(Cursor.HAND_CURSOR));

// working on the approve button
        approve.setBounds(200,480,100,25);
        approve.setFocusable(false);
        approve.setCursor(new Cursor(Cursor.HAND_CURSOR));
        approve.addActionListener(this);


// working on the terms pane
        labePanel.setBounds(0,220,487,200);
        // labePanel.setBorder(BorderFactory.createBevelBorder(2));
        labePanel.setBorder(border);
        labePanel.setHorizontalAlignment(JLabel.CENTER);
        labePanel.setVerticalAlignment(JLabel.CENTER);
        labePanel.setForeground(Color.green);


// working on the interest rate
        interest.setBounds(380,160, 100,20);
        interest.setFont(new Font("Arial",Font.CENTER_BASELINE,12));
        interestRate.setBounds(380,180, 100,20);
        interestRate.setHorizontalAlignment(JLabel.CENTER);
        interestRate.setVerticalAlignment(JLabel.CENTER);
        interestRate.setOpaque(true);
        interestRate.setBackground(Color.YELLOW);
        interestRate.setForeground(Color.GREEN);

// working on the eligibility status
        Eligibility.setBounds(190, 120,100,20);
        status.setBounds(230,140,20,20);
        status.setFocusable(false);
        status.doClick();
        status.setEnabled(false);

// working on the loan state
        check.setBounds(150, 440, 230, 20);
        check.setFocusable(false);
        check.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loanLabel.setBounds(400,10,100,20);
        loanState.setBounds(463,10,20,20);
        state.setBounds(400,30,90,20);
        state.setBackground(Color.yellow);
        state.setForeground(Color.green);
        state.setOpaque(true);
        state.setText(level);
        state.setFont(new Font("Arial",Font.CENTER_BASELINE,14));
        state.setHorizontalAlignment(JLabel.CENTER);
        state.setVerticalAlignment(JLabel.CENTER);
        loanState.setFocusable(false);
        loanState.setEnabled(false);


        back.setBounds(0,0,80,25);
        back.setFocusable(false);
        back.addActionListener(this);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));

        userLabel.setOpaque(true);
        userLabel.setBackground(Color.lightGray);
        userLabel.setIcon(profileUI.vel);

        userLabel.setBounds(200,20,90,100);

// working on the interest rate and amount and the eligibility status
        amountLabel.setBounds(0,160, 100,20);
        amountLabel.setFont(new Font("Arial",Font.CENTER_BASELINE,12));
        amount.setBounds(0,180, 100,20);
        amount.setFont(new Font("Arial",Font.BOLD,15));
        amount.setHorizontalAlignment(JLabel.CENTER);
        amount.setVerticalAlignment(JLabel.CENTER);
        amount.setOpaque(true);
        amount.setBackground(Color.YELLOW);
        amount.setForeground(Color.GREEN);

        BPanel.setBounds(0,85,500,650);
        BPanel.setLayout(null);
        BPanel.add(userLabel);
        BPanel.setBackground(modified.homePage.color1);
        BPanel.add(back);
        BPanel.add(amount);
        BPanel.add(amountLabel);
        BPanel.add(interest);
        BPanel.add(interestRate);
        BPanel.add(Eligibility);
        BPanel.add(status);
        BPanel.add(labePanel);
        BPanel.add(approve);
        BPanel.add(viewTerms);
        BPanel.add(loanState);
        BPanel.add(loanLabel);
        BPanel.add(state);
        BPanel.add(check);
        BPanel.add(massage);

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
        frame.getContentPane().setBackground(modified.homePage.color1);
        frame.setVisible(true);
        frame.setIconImage(frameIcon.getImage());
        frame.setTitle("Realm Bank");
        frame.setResizable(false);
        frame.add(BPanel);

        frame.add(TPanel, BorderLayout.NORTH);


        frame.setLocationRelativeTo(null);
        eligibility();
// working on the loans state
        if (user.loanAmount != 0.00) {
            showEl="0.0";
            showBalance(showEl);
            status.setSelected(false);
            loanState.setEnabled(true);
            loanState.doClick();
            loanState.setEnabled(false);
            massage.setForeground(Color.blue);
            showMessage("Please you have an outstanding loan.");
            approve.removeActionListener(this);
        }
// checking if the user has payed the loan

    }
    // working on the loan application,Approval, and status
    private boolean approve(){
        int amt = 0;
        LocalDate time = LocalDate.now();
        if (check.isSelected()) {
            showMessage(null);
            pass = JOptionPane.showInputDialog("Your Transaction Pin");
            if (pass.equals(user.pin)) {
                massage.setForeground(Color.BLUE);
                int n = JOptionPane.showConfirmDialog(frame, "Are you sure you want to approve this transaction of "+ amount.getText(),  "Confirm", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    showEl="0.0";
                    showBalance(showEl);
                    status.setSelected(false);
                    loanState.setEnabled(true);
                    loanState.doClick();
                    loanState.setEnabled(false);
//                    level= "Active";
                    state.setText(level);
                    approve.removeActionListener(this);
                    showMessage("Transaction Successful");
// add loan amount to balance
                    if (user.balance >= 0.0 && user.balance <=2000) {
                        user.balance = user.balance + 1000;
                        amt = 1000;
                        time = time.plusMonths(2);
                    }
                    if (user.balance >= 2000 && user.balance <=5000) {
                        user.balance = user.balance + 3000;
                        amt = 3000;
                        time = time.plusMonths(2);
                    }
                    if (user.balance >= 5000 && user.balance<=10000) {
                        user.balance = user.balance + 7500;
                        amt = 7500;
                        time = time.plusMonths(3);
                    }
                    if (user.balance >= 10000 && user.balance <=50000){
                        user.balance = user.balance + 15000;
                        amt = 15000;
                        time = time.plusMonths(3);
                    }
                    if (user.balance >= 50000 && user.balance<=200000){
                        user.balance = user.balance + 75000;
                        amt = 75000;
                        time = time.plusMonths(6);
                    }
                    if (user.balance >=200000){
                        user.balance = user.balance + 100000;
                        amt = 100000;
                        time = time.plusYears(1);
                    }
// SQL Transaction statement or statement that reflects changes to the DB on balance and ammount
                    String statement = String.format("Update account set balance = '%s' where customerId = '%s'",user.balance, user.customerID);
                    sq.Update(statement);
                    statement = String.format("Insert into loan values('%s', '%s', '%s', '%s', '%s')", user.customerID, amt, "10", LocalDate.now(), time);
                    sq.insert(statement);
                    user.createLoan();
// checking if the user decides not to approve the transaction
                }else if (n==JOptionPane.NO_OPTION) {
                    // revert transaction
                    showMessage("Transaction Terminated Successfully");
                    level= "Deactivated";
                }
            }else{
                massage.setForeground(Color.red);
                showMessage("Invalid Transaction Pin");
            }
        }
        else{
            massage.setForeground(Color.red);
            showMessage("Please accept Terms and Conditions");
        }
        return true;
    }
    // working on the eligible amount of money for the user
    public void eligibility(){
        if (user.balance >= 0.0 && user.balance <=2000) {
            showEl= "1,000 Naira";
            showBalance(showEl);
        }
        if (user.balance >= 2000 && user.balance <=5000) {
            showEl= "3,000 Naira";
            showBalance(showEl);
        }
        if (user.balance >= 5000 && user.balance<=10000) {
            showEl= "7,500 Naira";
            showBalance(showEl);
        }
        if (user.balance >= 10000 && user.balance <=50000){
            showEl= "15,000 Naira";
            showBalance(showEl);
        }
        if (user.balance >= 50000 && user.balance<=200000){
            showEl= "75,000 Naira";
            showBalance(showEl);
        }
        if (user.balance >=200000){
            showEl= "100,000 Naira";
            showBalance(showEl);
        }
    }

    private void showMessage(String message) {
        massage.setText(message);
    }

    // working on the massage method
    private void showBalance(String balanceString) {
        amount.setText(balanceString);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==back) {
            frame.dispose();
            new homePage(user);
        }
        if (e.getSource()==approve) {
            approve();
        }
        if (e.getSource()==viewTerms) {
            labePanel.setBackground(Color.black);
            labePanel.setOpaque(true);
            labePanel.setText("Hello here are the");
            // working on the time and delay for the terms to display
            TimerTask t = new TimerTask() {
                @Override
                public void run() {
                    while (true) {
                        for(int i = 0; i <terms.length; i++){
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                            }
                            labePanel.setText(terms[i]);
                        }
                    }
                }
            };
            Timer timer = new Timer();
            timer.schedule(t, 2000);
        }
    }
    public static void main(String[] args) {
        new modified.loanUI();
    }
}