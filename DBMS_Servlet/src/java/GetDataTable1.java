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
public class GetDataTable1 extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException{
        
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        Connection con;
        Statement stmt;
        ResultSet rs;
        res.setContentType("text/html");  
        String str = req.getParameter("substr");
        String query;
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/lab_project","root","tour");
            stmt = (Statement) con.createStatement();
            /*rs = stmt.executeQuery("Select * from DIV.PRODUCT");
            pw.println("Id      "+ " Name   " +" Address" + "<br>");
            while(rs.next()){
                pw.println(rs.getInt(1)+"       "+rs.getString(2) + "       " + rs.getString(3) + "<br>");
            }*/
            query =  "select course_id, title from course where title like '%" + str +"%'";
            
            rs = stmt.executeQuery(query);
            
            ResultSetMetaData metaData = rs.getMetaData();
            int num_of_columns = metaData.getColumnCount();
            
            pw.println("<table style='border: 1px solid black;'>");
            pw.println("<tr style='border: 1px solid black;'>");
            pw.println("<th style='border: 1px solid black;'>Course ID</th>");
            pw.println("<th style='border: 1px solid black;'>Title</th>");
            pw.println("</tr>");
           
            while(rs.next()){
                pw.println("<tr style='border: 1px solid black;'>");   
                
                for(int i = 1 ; i <= num_of_columns ; i++){
                    pw.println("<th style='border: 1px solid black;'>" + rs.getString(i) + "</th>");
                }
                pw.println("</tr>");
            }
            pw.println("</table>");  
            
        }catch (Exception e){
            pw.println(e);
        }
    }
};
