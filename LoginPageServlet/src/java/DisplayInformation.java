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

/**
 *
 * @author user
 */
public class DisplayInformation extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String course = request.getParameter("course");
        
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        
        out.println("<html>");

        out.println("<head><title> Time Check </title></head>");

        out.println("<body>");

        out.println("<p>The name of student is: " + name + "</p>");
        
        out.println("<p>The course taken by student is: " + course + "</p>");
        
        out.println("</body></html>");
        
    }

};