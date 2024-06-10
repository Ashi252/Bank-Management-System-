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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
public class transactionHistoryUI implements ActionListener {
JTable table = new JTable();
  JFrame frame = new JFrame();
  ImageIcon frameIcon = new ImageIcon("Images/Untitled.png");
  JPanel TPanel = new JPanel();
  JLabel label = new JLabel();
  JButton back = new JButton("<-Back");
  JButton delete = new JButton("Delete History");
  Object[] column = {"Name","Amount","Transaction Type","Date"};
  DefaultTableModel model = new DefaultTableModel();
public transactionHistoryUI(){
// initializing and setting the frame features
frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
frame.setSize(500,650);
frame.getContentPane().setBackground(homePage.color1);
frame.getContentPane().setLayout(null);
frame.setIconImage(frameIcon.getImage());
frame.setTitle("Realm Bank");
frame.setResizable(false);
frame.setLocationRelativeTo(null);
// working on the transaction columns
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


JScrollPane scrollPane = new JScrollPane(table);
scrollPane.setBackground(Color.blue);
scrollPane.setForeground(Color.WHITE);
scrollPane.setBounds(0,140,500, 400);
frame.getContentPane().add(scrollPane);
back.setBounds(0,100,80,25);
  back.setFocusable(false);
  back.addActionListener(this);
  back.setCursor(new Cursor(Cursor.HAND_CURSOR));

  delete.setBounds(200,580,120,25);
  delete.setFocusable(false);
  delete.addActionListener(this);
  delete.setCursor(new Cursor(Cursor.HAND_CURSOR));
  // working on ht e panel for the company name
TPanel.setLayout(new BorderLayout());
        TPanel.setBounds(0,0,500,100);
        label.setBackground(new Color(25, 25, 255));
        label.setForeground(Color.black);
        label.setFont(new Font("sanserif", Font.BOLD, 35));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setText("Realm Bank");
        label.setOpaque(true);
        TPanel.add(label, BorderLayout.CENTER);
        frame.add(TPanel, BorderLayout.NORTH);
        frame.add(back);
        frame.add(delete);

frame.setVisible(true);
frame.revalidate();
details();
}
// this method is used to retrieve transaction information of this account store them in those variables so they will be available and displayed to the user 
private void details(){
  // sql statement to retrieve information using the the user phone number

  // assign they information retrieved to this variable below
  String FirstName = "Name";
  double amount = 0.0;
  String tType = "transfer";
  String tdate = "6/9/2024";

  Object[] rows = new Object[4];
  rows[0] = FirstName;
  rows[1] = amount;
  rows[2] = tType;
  rows[3] = tdate;
  model.addRow(rows);
}
  public static void main(String[] args) {
  new transactionHistoryUI();
}
@Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == back) {
      frame.dispose();
      new homePage(null);
    }
    if (e.getSource()==delete) {
      int index = table.getSelectedRow();
      if (index >= 0) {
        model.removeRow(index);
        JOptionPane.showMessageDialog(frame,"Transaction History Deleted Successfully");
      }
      else{
        JOptionPane.showMessageDialog(frame,"Error deleting, please select history");
      }
    }
  }

}
