/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class ValidationServ extends HttpServlet {
    
    int stno = 0;
    float smarks = 0;
    String sname;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList al = new ArrayList();
        
        response.setContentType("text/html");
        
        PrintWriter pw = response.getWriter();
        
        String stno1 = request.getParameter("validpro_stno");
        sname = request.getParameter("validpro_sname");
        String smarks1 = request.getParameter("validpro_smarks");
        
        
        
        if((stno1 == null) || (stno1 == "")){
            al.add("Provide Student Number...");
        }
        else{
            try{
                stno = Integer.parseInt(stno1);
            }catch(NumberFormatException ae){
                al.add("Provide Integer data in Student Number..");
            }
        }
        
        if((sname == null) || (sname == "")){
            al.add("Enter Student Name");
        }
        if((smarks1 == null) || (smarks1 == "")){
            al.add("Enter Student Marks");
        }
        else{
            try{
                smarks = Float.parseFloat(smarks1);
            }catch(NumberFormatException ae){
                al.add("Provide float data in Student Marks..");
            }
        }
        if(al.size()!=0){
            pw.println(al);
        }
        else{
            Connection con;
            Statement stmt;
            ResultSet rs;
            try{
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                con = DriverManager.getConnection("jdbc:derby://localhost:1527/Student","divyesh","divyesh");
                stmt = (Statement) con.createStatement();
                stmt.executeUpdate("insert into DIVYESH.STUDENT values ("+stno+",'"+sname+"',"+smarks+")");
                pw.println("Records Inserted!!");
                
                
                rs = stmt.executeQuery("Select * from DIVYESH.STUDENT");
                
                pw.print("Student Number\t" + "Student Name\t" + "Student Marks"+"\n");
                pw.println();
                
                while(rs.next()){
                    pw.print(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\n");
                    pw.println();
                }
            
                con.close();
            }catch (Exception e){
                pw.println(e);
            }
                
        }
        
    }
    
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException,IOException{
      doGet(request, response);
  }

};