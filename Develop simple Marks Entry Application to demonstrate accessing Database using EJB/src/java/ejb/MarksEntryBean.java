package ejb;

import java.sql.*;
import javax.ejb.Stateful;

@Stateful
public class MarksEntryBean {

    String sname;
    int m1, m2, m3;
    Connection con = null;
    Statement st = null;
    String query = "";

    public void addMarks(String sname, int m1, int m2, int m3) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sevenc", "root", "robust");
            st = con.createStatement();
            query ="insert into marks (sname,marks1,marks2,marks3) values ('"+sname+"'  ,'"+m1+"'  ,'"+m2+"'  ,'"+m3+"'  )"; 

            st.executeUpdate(query);
            System.out.print("Marks entered sucessfully!!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
