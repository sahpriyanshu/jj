package com.test;
import java.sql.*;
import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class RoomManagement implements RoomManagementLocal {

    @Schedule(dayOfWeek = "Mon-Fri", month = "*", hour = "9-17", dayOfMonth = "*", year = "*", minute = "*", second = "0", persistent = false)
    @Override
    public void myTimer() {
        System.out.println("Timer event: " + new Date());
    }

    @Override
    public String Booking(String RoomType, String cust, String mob) {
        String msg = "";
        try {
            // Loading MySQL Driver
            Class.forName("com.mysql.jdbc.Driver");
            // Connecting to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sixb", "root", "robust");
            
            // Query to find available rooms
            String query = "select * from roombook where RoomType=? and status='Not Booked'";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, RoomType);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                String rno = rs.getString(1); // RoomId
                // Updating room details
                PreparedStatement stm1 = con.prepareStatement("update roombook set cust=? where RoomId=?");
                PreparedStatement stm2 = con.prepareStatement("update roombook set mob=? where RoomId=?");
                PreparedStatement stm3 = con.prepareStatement("update roombook set status=? where RoomId=?");
                
                stm1.setString(1, cust); stm1.setString(2, rno);
                stm2.setString(1, mob); stm2.setString(2, rno);
                stm3.setString(1, "Booked"); stm3.setString(2, rno);
                
                stm1.executeUpdate();
                stm2.executeUpdate();
                stm3.executeUpdate();
                
                msg = "Room " + rno + " Booked <br> Charges = " + rs.getString(3); // Room charges
            } else {
                msg = "Room " + RoomType + " currently Not available";
            }
        } catch (Exception e) {
            msg = "Error: " + e.getMessage();
        }
        return msg;
    }
}
