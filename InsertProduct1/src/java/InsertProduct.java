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
public class InsertProduct extends HttpServlet {
    
    int pid;
    float price;
    String pname;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        response.setContentType("text/html");
        
        PrintWriter pw = response.getWriter();
        
        String pid1 = request.getParameter("prodata_id");
        pname = request.getParameter("prodata_name");
        String price1 = request.getParameter("prodata_price");
        
        pid = Integer.parseInt(pid1);
        price = Float.parseFloat(price1);
        
        Connection con;
        Statement stmt;
        ResultSet rs;
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/validate","div","div");
            stmt = (Statement) con.createStatement();
            stmt.executeUpdate("insert into DIV.PRODUCT values ("+pid+",'"+pname+"',"+price+")");
            pw.println("Records Inserted!!");
            
        }catch (Exception e){
            pw.println(e);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

};
