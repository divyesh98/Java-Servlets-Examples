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
public class GetDataTable extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException{
        
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        Connection con;
        Statement stmt;
        ResultSet rs;
        res.setContentType("text/html");  
        String str = req.getParameter("query");
        String opt = req.getParameter("option");
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
            query = str;
            
            rs = stmt.executeQuery(query);
            
            if(opt.compareTo("rs") == 0){
                System.out.println("1");
                createDropDown(rs, req, res);
            }
            if(opt.compareTo("str") == 0){
                System.out.println("2");
                createDropDown(query , stmt, req, res);
            }
        }catch (Exception e){
            pw.println(e);
        }
    }
    public void createDropDown(String sql,Statement stmt,HttpServletRequest request,
            HttpServletResponse response) throws IOException, SQLException{
        //Statement stmt = null;
        ResultSet rs = stmt.executeQuery(sql);
        ResultSetMetaData rsmd = null;
        try {
            rsmd = rs.getMetaData();
        
            int columnsNumber = 0;                     
            columnsNumber = rsmd.getColumnCount();
            
            System.out.println("Ste");
                
            
            PrintWriter out = response.getWriter();
           /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet_DBMS</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>createDropDown(sql) using Query string sql</h1><br>");
            out.println("<select>");
            while (rs.next()) {
                for(int i = 1 ; i <= columnsNumber ; i++){
                    out.println("<option value=" + rs.getString(i) + ">" + rs.getString(i)+"</option>");
                }
                System.out.println();
            }
            out.println("</select>");
            out.println("</body>");
            out.println("</html>");

        } catch (SQLException ex) {
            Logger.getLogger(GetDataTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createDropDown(ResultSet rs,HttpServletRequest request,HttpServletResponse response) 
            throws IOException{
        ResultSetMetaData rsmd = null;
        try {
            rsmd = rs.getMetaData();
        
            int columnsNumber = 0;                     
            columnsNumber = rsmd.getColumnCount();
            System.out.println("S");
                
            PrintWriter out = response.getWriter();
           /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet_DBMS</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>createDropDown(rs) using ResultSet rs</h1><br>");
            out.println("<select>");
            while (rs.next()) {
                //Print one row
                for(int i = 1 ; i <= columnsNumber; i++){
                    out.println("<option value="+rs.getString(i)+">"+rs.getString(i)+"</option>");
                }
                System.out.println();
            }
            out.println("</select>");
            out.println("</body>");
            out.println("</html>");

        } catch (SQLException ex) {
            Logger.getLogger(GetDataTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
};
