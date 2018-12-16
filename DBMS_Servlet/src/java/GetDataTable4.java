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
public class GetDataTable4 extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException{
        
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        Connection con;
        Statement stmt;
        ResultSet rs;
        res.setContentType("text/html");
        String roll = req.getParameter("rollNo");
        String name = req.getParameter("name");
        String dept = req.getParameter("dept_name");
        int tot_credits = 0;
        
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
            query = "insert into student values('"
                    + roll +"', '" + name + "', '" + dept + "', " +tot_credits + ")";
            
            int inserted = stmt.executeUpdate(query);
            
            if(inserted != 0){
                pw.println("<h3>Record added successfully</h3>");
                pw.println("<p><a href=" + "register.jsp" + ">Click to go back</a></p>");
            }
            
        }catch (Exception e){
            pw.println(e);
        }
    }
};
