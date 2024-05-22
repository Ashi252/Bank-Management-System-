package Database;

import java.sql.*;

public class SqlStatements {
    Statement st = null;
        public SqlStatements(){
            String user= "root", url= "jdbc:mysql://localhost:3400/luminous",
            password = "";
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3400/luminous", "root", "");
                System.out.println("Driver loaded");
                st = conn.createStatement();
                System.out.println("Statement created");
            }catch(Exception e){
                System.out.println("An error occured"+ e);
            }
        }

        public void insert(String statement){
            try {
                st.execute(statement);
                System.out.println("Success");
            }catch(Exception e){
                System.out.println(e);
            }
        }

        public boolean select(String statement) {
            try {
                ResultSet rs = st.executeQuery(statement);
                if (rs.next()) {
                    System.out.println(rs.getString(2));
                    return true;
                }
            } catch (Exception e) {

            }
            return false;

        }
}
