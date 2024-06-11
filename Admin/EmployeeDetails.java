import static java.lang.StringTemplate.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import Database.SqlStatements;
public class EmployeeDetails implements ActionListener {
  JFrame frame = new JFrame();
  JTable table = new JTable();
    JButton Button = new JButton();
    JPanel TPanel = new JPanel();
    JLabel label = new JLabel();
    JLabel userID = new JLabel("Employee ID");
    JLabel Massage = new JLabel();
    JLabel info = new JLabel();
    JLabel Message = new JLabel();
    JTextField ID = new JTextField();
    ImageIcon frameIcon = new ImageIcon("Images/Untitled.png");
    SqlStatements st = new SqlStatements();
    JPanel formPanel = new JPanel();
    JPanel form = new JPanel();
    JButton back = new JButton("<-Back");
    Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
    String pass;
    Object[] column = {"EmployeeID","FirstName" ,"LastName","Position","ContactNumber","Email","BranchID"};
  DefaultTableModel model = new DefaultTableModel();
String pin = "1234";
  public EmployeeDetails(){
// working on the transaction view table
model.setColumnIdentifiers(column);
table.setModel(model);
table.setBackground(Color.white);
table.setForeground(Color.black);
table.setSelectionBackground(Color.blue);
table.setSelectionForeground(Color.white);
table.setGridColor(Color.RED);
table.setOpaque(true);
table.setFont(new Font("Arial", Font.PLAIN,11));
table.setRowHeight(30);
table.setAutoCreateRowSorter(true);
table.setEnabled(false);

JScrollPane scrollPane = new JScrollPane(table);
scrollPane.setBackground(Color.blue);
scrollPane.setForeground(Color.WHITE);
scrollPane.setBounds(0,120,500, 400);
// this are titles used for the login fields
userID.setBounds(150,70,300,25);

// working on the return button
back.setFocusable(false);
back.addActionListener(this);
back.setCursor(new Cursor(Cursor.HAND_CURSOR));

// working on the error massage to be displayed if User input are invalid
Massage.setBounds(150,40,250,25);
Massage.setFont(new Font(null, Font.ITALIC,12));


Message.setBounds(150,0,500,30);
Message.setFont(new Font(null, Font.ITALIC,20));
Message.setText("View Employee Information");
Message.setForeground(Color.blue);
// working on the phone input field
ID.setBounds(150,90,230,25);
// working on the reset button
Button.setBounds(200,520,80,25);
Button.setText("View");
Button.setFocusable(false);
Button.addActionListener(this);
Button.setCursor(new Cursor(Cursor.HAND_CURSOR));

formPanel.setLayout(null);
formPanel.add(userID);
formPanel.add(Massage);
formPanel.add(ID);
formPanel.add(info);
formPanel.add(Button);
formPanel.add(Message, STR);
formPanel.add(scrollPane);
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
TPanel.add(back, BorderLayout.WEST);




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
frame.revalidate();
  }
  private void showMessage(String message){
    Massage.setText(message);
    }
// this method is used to retrieve transaction information of this account and store's them in those variables so they will be available and displayed to the user 
private void details(){
  if (ID.getText().isEmpty()) {
    ID.setBackground(Color.RED);
    Massage.setForeground(Color.RED);
    showMessage("Please enter an Employee or Customer ID.");
    }
    if (!ID.getText().isEmpty() ){
      ID.setBackground(Color.white);
      pass = JOptionPane.showInputDialog("Your Password");
      if (pass.equals(pin)) {
        int n = JOptionPane.showConfirmDialog(frame, "Are you sure you want to view this user INFORMATION ",  "Confirm", JOptionPane.YES_NO_OPTION);
          if (n == JOptionPane.YES_OPTION) {
          // Sql statement to retrieve the customer from the database
          // assign they information retrieved to this variable below
              Integer ID = 1232456;
              String FirstName = "Love Teju";
              String LastName = " for real ";
              String Position = "forever";
              String BranchID = "9999";
              String ContactNumber = "07062764232";
              String Email = "nawaferdinand@outlook.com";
              
              Object[] rows = new Object[7];
              rows[0] = ID;
              rows[1] = FirstName;
              rows[2] = LastName;
              rows[3] =Position;
              rows[4] =ContactNumber;
              rows[5] =Email;
              rows[6] =BranchID;
              model.addRow(rows);
      // checking if the user decides not to approve the process
          }else if (n==JOptionPane.NO_OPTION) {
          JOptionPane.showMessageDialog(frame, "Process Terminated Successfully");
          }
          }
          else{
          JOptionPane.showMessageDialog(frame, "Invalid Password");
          }
    }

  
}
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource()==Button) {
      details();
    }
    if (e.getSource()==back) {
      frame.dispose();
      new adminHomepage();
    }
    }

public static void main(String[] args) {
  new EmployeeDetails();
}
}

