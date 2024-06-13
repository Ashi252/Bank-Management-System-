package Login;

import Database.SqlStatements;
import Entities.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
// import javax.swing.JFileChooser;


public class homePage implements ActionListener{
    public static Color color1;
    JFrame frame = new JFrame();
    ImageIcon frameIcon = new ImageIcon("src/Images/Untitled.png");
    JPanel buttonsPanel = new JPanel();
    JPanel containerPanel = new JPanel();
    JPanel conterPanel = new JPanel();
    JPanel TPanel = new JPanel();
    JLabel label = new JLabel();
    JButton[] buttons = new JButton[3];
    static JLabel userLabel = new JLabel();
    JButton transferLabel = new JButton();
    JButton transactionHistory = new JButton();
    JButton sports = new JButton();
    JButton PayBills = new JButton();
    JButton dataLabel = new JButton();
    JButton loan = new JButton();
    JLabel welcome = new JLabel();
    JLabel Hi = new JLabel();
    JLabel balances = new JLabel();
    JPanel BPanel = new JPanel();
    ImageIcon home = new ImageIcon("src/Images/home.png");
    ImageIcon setting = new ImageIcon("src/Images/settings.png");
    ImageIcon notification = new ImageIcon("src/Images/envelope.png");
    ImageIcon profile = new ImageIcon("src/Images/user.png");
    ImageIcon transfer = new ImageIcon("src/Images/money-coin-transfer.png");
    ImageIcon win = new ImageIcon("src/Images/trophy-star.png");
    ImageIcon history = new ImageIcon("src/Images/time-past.png");
    ImageIcon data = new ImageIcon("src/Images/priority-arrows.png");
    ImageIcon bills = new ImageIcon("src/Images/hand-bill.png");
    ImageIcon loanBills = new ImageIcon("src/Images/loan.png");
    User customer;


    public static ImageIcon v;

    public void buttons(){

        for(int i=0; i<3;i++){
            buttons[i] = new JButton();
            buttonsPanel.add(buttons[i]);
            buttons[i].setFocusable(false);
            buttons[i].setPreferredSize(new Dimension(100,30));
            buttons[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            buttons[i].addActionListener(this);
            buttons[i].setHorizontalAlignment(JButton.CENTER);
            buttons[i].setVerticalAlignment(JButton.BOTTOM);
            buttons[i].setBorder(BorderFactory.createRaisedSoftBevelBorder());
        }

        buttons[0].setText("Home");
        buttons[0].setIcon(home);
        buttons[1].setText("Profile");
        buttons[1].setIcon(profile);
        buttons[2].setText("Color Theme");
    }

    public homePage(User user){
        this.customer = user;
        // ImageIcon imagepath =new ImageIcon("Images/user.png");
        // Image s = imagepath.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        // v = new ImageIcon(s);
// working on the userprofileIcon
        userLabel.setOpaque(true);
        userLabel.setBackground(Color.lightGray);
        userLabel.setIcon(profileUI.vel);
        userLabel.setText("set image in profile");
        userLabel.setFont(new Font("Arial", Font.ROMAN_BASELINE,10));

        userLabel.setBounds(190,25,90,100);
// working on the Color scheme


        balances.setBounds(180,145,120,15);
        balances.setText("Balance: " + user.balance);
        balances.setForeground(Color.BLUE);
        balances.setFont(new Font(null, Font.BOLD, 12));
        balances.setOpaque(true);
        balances.setBackground(color1);
        balances.setFocusable(false);

        Hi.setBounds(180,125,120,13);
        Hi.setText("Hi " + user.FirstName);
        Hi.setForeground(Color.BLUE);
        Hi.setFont(new Font(null, Font.BOLD, 10));
        Hi.setBackground(color1);
        Hi.setOpaque(true);
        Hi.setFocusable(false);

        // Hi.setBorder(BorderFactory.createEtchedBorder());

        welcome.setBounds(0,10,120,15);
        welcome.setText("Welcome " + user.FirstName);
        welcome.setForeground(Color.BLUE);
        welcome.setFont(new Font(null, Font.BOLD, 12));
        welcome.setOpaque(true);
        welcome.setBackground(color1);
        welcome.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

// ------------------------------------------------------------------


// containerPanel.setSize(450, 300);
        containerPanel.setBounds(20, 230, 450, 200);
        containerPanel.setBackground(Color.BLUE);
        containerPanel.setLayout(new GridLayout(3, 3, 3, 2));


// working on the Utility components
        transferLabel.setOpaque(true);
        transferLabel.setBorder(BorderFactory.createBevelBorder(0));
        transferLabel.setIcon(transfer);
        transferLabel.setToolTipText("Make a Transfer");
        transferLabel.setText("Transfer");
        transferLabel.setHorizontalTextPosition(JButton.CENTER);
        transferLabel.setVerticalTextPosition(JButton.BOTTOM);
        transferLabel.setHorizontalAlignment(JButton.CENTER);
        transferLabel.setVerticalAlignment(JButton.CENTER);
        transferLabel.addActionListener(this);
        transferLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        transferLabel.setFocusable(false);


        dataLabel.setOpaque(true);
        dataLabel.setBorder(BorderFactory.createBevelBorder(0));
        dataLabel.setIcon(data);
        dataLabel.setToolTipText("Buy mobile Data");
        dataLabel.setText("Buy Data");
        dataLabel.setHorizontalTextPosition(JButton.CENTER);
        dataLabel.setVerticalTextPosition(JButton.BOTTOM);
        dataLabel.setHorizontalAlignment(JButton.CENTER);
        dataLabel.setVerticalAlignment(JButton.CENTER);
        dataLabel.addActionListener(this);
        dataLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        dataLabel.setFocusable(false);


        loan.setOpaque(true);
        loan.setBorder(BorderFactory.createBevelBorder(0));
        loan.setIcon(loanBills);
        loan.setToolTipText("Take a Loan");
        loan.setText("Take a loan");
        loan.setHorizontalTextPosition(JButton.CENTER);
        loan.setVerticalTextPosition(JButton.BOTTOM);
        loan.setHorizontalAlignment(JButton.CENTER);
        loan.setVerticalAlignment(JButton.CENTER);
        loan.addActionListener(this);
        loan.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loan.setFocusable(false);

        sports.setOpaque(true);
        sports.setIcon(win);
        sports.setToolTipText("Credit your betting account");
        sports.setText("Sports");
        sports.setHorizontalTextPosition(JButton.CENTER);
        sports.setVerticalTextPosition(JButton.BOTTOM);
        sports.setHorizontalAlignment(JButton.CENTER);
        sports.setVerticalAlignment(JButton.CENTER);
        sports.addActionListener(this);
        sports.setBorder(BorderFactory.createBevelBorder(0));
        sports.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sports.setFocusable(false);

        transactionHistory.setOpaque(true);
        transactionHistory.setIcon(history);
        transactionHistory.setToolTipText("View Transaction History");
        transactionHistory.setText("Transaction History");
        transactionHistory.setHorizontalTextPosition(JButton.CENTER);
        transactionHistory.setVerticalTextPosition(JButton.BOTTOM);
        transactionHistory.setHorizontalAlignment(JButton.CENTER);
        transactionHistory.setVerticalAlignment(JButton.CENTER);
        transactionHistory.addActionListener(this);
        transactionHistory.setBorder(BorderFactory.createBevelBorder(0));
        transactionHistory.setCursor(new Cursor(Cursor.HAND_CURSOR));
        transactionHistory.setFocusable(false);

        PayBills.setOpaque(true);
        PayBills.setIcon(bills);
        PayBills.setToolTipText("Pay Bills");
        PayBills.setText("Pay Bills");
        PayBills.setHorizontalTextPosition(JButton.CENTER);
        PayBills.setVerticalTextPosition(JButton.BOTTOM);
        PayBills.setHorizontalAlignment(JButton.CENTER);
        PayBills.setVerticalAlignment(JButton.CENTER);
        PayBills.addActionListener(this);
        PayBills.setBorder(BorderFactory.createBevelBorder(0));
        PayBills.setCursor(new Cursor(Cursor.HAND_CURSOR));
        PayBills.setFocusable(false);
// --------------------------------------------------------------------------

        BPanel.setBounds(0,85,500,650);
        BPanel.setLayout(null);
        BPanel.setBackground(color1);
        BPanel.add(userLabel);
        containerPanel.add(transferLabel);
        containerPanel.add(dataLabel);
        containerPanel.add(sports);
        containerPanel.add(transactionHistory);
        containerPanel.add(PayBills);
        BPanel.add(welcome);
        BPanel.add(Hi);
        BPanel.add(buttonsPanel);
        BPanel.add(balances);
        containerPanel.add(loan);
        BPanel.add(containerPanel);
        frame.add(BPanel);




//working on the button panel
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,4));
        buttonsPanel.setBounds(0,480,500,100);
        buttonsPanel.setBackground(color1);




        buttons();

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
        frame.getContentPane().setBackground(color1);
        frame.setVisible(true);
        frame.setIconImage(frameIcon.getImage());
        frame.setTitle("Realm Bank");
        frame.setResizable(false);

        frame.add(TPanel, BorderLayout.NORTH);


        frame.setLocationRelativeTo(null);

        if(user.balance == 0.00){
            String deposit = JOptionPane.showInputDialog("Initial deposit");
            String statement = String.format("Update account set balance = '%s' where customerId = '%s'", user.balance += Double.parseDouble(deposit),user.customerID);
            new SqlStatements().Update(statement);
            balances.setText("Balance " + user.balance);
        }

    }


    public static void main(String[] args) {
        User user = new User();
        new homePage(user);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttons[1]) {
            frame.dispose();
            new profileUI(customer);
        }
        if (e.getSource()== buttons[0]) {
            frame.dispose();
            new homePage(customer);
        }
        // making the utilities responsive
        if (e.getSource()== transferLabel) {
            frame.dispose();
             new transferUI(customer);
        }
        if (e.getSource()== dataLabel) {
            frame.dispose();
            new buyCredit(customer);
        }
        if (e.getSource()== sports) {
            frame.dispose();
            new sportUI(customer);
        }
        if (e.getSource()== transactionHistory) {
            frame.dispose();
            new transactionHistoryUI(customer);
        }
        if (e.getSource()== loan) {
            frame.dispose();
            new loanUI(customer);
        }
        if (e.getSource()== PayBills) {
            frame.dispose();
            new billUI(customer);
        }
        if (e.getSource()== buttons[2]){
            JColorChooser theme = new JColorChooser();
            Color color = JColorChooser.showDialog(theme, "Set theme color", Color.BLACK);
            frame.getContentPane().setBackground(color);
            buttonsPanel.setBackground(color);
            BPanel.setBackground(color);
            color1= color;
        }
    }


}