/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
/**
 *
 * @author user
 */
public class Time extends HttpServlet {

   
   public void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {

        rsp.setContentType("text/html");

        PrintWriter out = rsp.getWriter();

        Date now = new Date(); // The current Date/time

        out.println("<html>");

        out.println("<head><title> Time Check </title></head>");

        out.println("<body>");

        out.println("<p>The time is: " + now.toString() + "</p>");

        out.println("</body></html>");

    }
};
