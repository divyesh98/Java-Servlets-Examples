/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class OnServletContext extends HttpServlet {

   protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        PrintWriter pw=res.getWriter();
        res.setContentType("text/html");
 
        // I am using 2nd way to create Context object
        ServletContext context=getServletContext();  
 
        String s1=context.getInitParameter("n1");
        String s2=context.getInitParameter("n2");
 
        pw.println("n1 value is " +s1+ " and n2 is " +s2);
 
       pw.close();    
    }
};