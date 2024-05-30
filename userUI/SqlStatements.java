package Database;

import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SqlStatements {
    public static Integer customerID;
    public static String FirstName;
    public static String LastName;
    public static String DOB;
    public static String Email;
    public static String gender;
    public static String Address;
    public static String ContactNumber;
    public static String UserPass;
    static Statement st = null;

    public SqlStatements(){
        createConn();
    }

    public Statement createConn(){
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
        return st;
    }

    public void insert(String statement){
        try {
            st.execute(statement);
            System.out.println("Successful insert");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public  boolean select(String statement) {

        try {
            ResultSet rs = st.executeQuery(statement);
            if (rs.next()) {
//                System.out.println(rs.getString(2));
                return true;
            }
        } catch (Exception e) {

        }
        return false;

    }

    public  String selectCustomerId(String statement){
        String customerId = "";
        try{
            ResultSet rs = st.executeQuery(statement);
            if(rs.next()){
                customerId = rs.getString(1);
            }
        }catch (Exception e){

        }
        return customerId;
    }




//    public void select(String table, String[] cols, HashMap<String, String> conditions){
//            String statement = "Select ";
//            if(cols.length != 0){
//                for(int i = 0; i < cols.length; i++){
//                    if(i != cols.length-1) {
//                        statement += cols[i] + ", ";
//                    }else{
//                        statement += cols[i] + " ";
//                    }
//                }
//            }else{
//                statement += "* ";
//            }
//            statement += "from " + table + " (";
//
//            if(!conditions.isEmpty()){
//                int count = conditions.size();
//                for(Map.Entry<String, String> mapElement : conditions.entrySet()){
//                    if(count != 1) {
//                        statement += mapElement.getKey() + " = ";
//                        statement += String.format("'%s',", mapElement.getValue() + "");
//                    }else{
//                        statement += mapElement.getKey() + " = ";
//                        statement += String.format("'%s'", mapElement.getValue());
//                        statement += ")";
//                    }
//                    System.out.println(count);
//                    count --;
//                }
//            }
//        System.out.println(statement);
//    }
//
//    public static void main(String[] args) {
//            String[] cols = {"firstname", "lastname", "middlename", "gender"};
//            HashMap<String, String> conditions = new HashMap<>();
//            conditions.put("firstname", "teju");
//            conditions.put("lastname", "ogun");
//            conditions.put("middlename", "dami");
//            conditions.put("gender", "female");
//            new SqlStatements().select("customer", cols, conditions );
//    }
}
