/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package mybeans;
import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Stateless;


/**
 *
 * @author sahpr
 */
@Stateless
public class CCBean {
public CCBean(){}
public double r2Dollor(double r){ return r/84.02; }
public double d2Rupees(double d){ return d*84.02; }
}