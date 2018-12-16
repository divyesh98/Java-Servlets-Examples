/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author user
 */
public class GetDataTable extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException{
        
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        Connection con;
        Statement stmt;
        ResultSet rs;
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/validate","div","div");
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery("Select * from DIV.PRODUCT");
            pw.println("Id      "+ " Name   " +" Address" + "<br>");
            while(rs.next()){
                pw.println(rs.getInt(1)+"       "+rs.getString(2) + "       " + rs.getString(3) + "<br>");
            }
        }catch (Exception e){
            pw.println(e);
        }
    }
};
