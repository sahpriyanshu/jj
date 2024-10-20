/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.test;

import javax.ejb.Local;

/**
 *
 * @author sahpr
 */
@Local
public interface RoomManagementLocal {
    
    public void myTimer();

    String Booking(String Rtype, String Cname, String Cmobile);
}
