/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author user
 */
public class GetDataTable2 extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException{
        
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        Connection con;
        Statement stmt;
        ResultSet rs;
        res.setContentType("text/html");
        
        String roll = req.getParameter("rollNo");
        String query;
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/lab_project","root","tour");
            stmt = (Statement) con.createStatement();
            pw.println("Get lost");
            /*rs = stmt.executeQuery("Select * from DIV.PRODUCT");
            pw.println("Id      "+ " Name   " +" Address" + "<br>");
            while(rs.next()){
                pw.println(rs.getInt(1)+"       "+rs.getString(2) + "       " + rs.getString(3) + "<br>");
            }*/
            query = "select name, student.dept_name,  takes.course_id,  "
                + "title, credits, grade from student, takes, course where student.ID=takes.ID and "
                + "takes.course_id=course.course_id and student.ID=" + roll;
            
            rs = stmt.executeQuery(query);
            
            ResultSetMetaData metaData = rs.getMetaData();
            
            int num_of_columns = metaData.getColumnCount();
            
            pw.println("<table style='border: 1px solid black;'>");
            pw.println("<tr style='border: 1px solid black;'>");
            pw.println("<th style='border: 1px solid black;'>Name</th>");
            pw.println("<th style='border: 1px solid black;'>Department</th>");
            pw.println("<th style='border: 1px solid black;'>Course ID</th>");
            pw.println("<th style='border: 1px solid black;'>Title</th>");
            pw.println("<th style='border: 1px solid black;'>Credits</th>");
            pw.println("<th style='border: 1px solid black;'>Grade</th>");
            pw.println("</tr>");
            
            while(rs.next()){
                pw.println("<tr style='border: 1px solid black;'>");   
            
                for(int i=1;i<=num_of_columns;i++){
                    pw.println("<th style='border: 1px solid black;'>"+rs.getString(i)+"</th>");
                }
                pw.println("</tr>");
            }
            pw.println("</table>");
            
        }catch (Exception e){
            pw.println(e);
        }
    }
};
