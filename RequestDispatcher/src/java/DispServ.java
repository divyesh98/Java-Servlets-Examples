/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class DispServ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String uname = request.getParameter("header_euname");
        String pwd = request.getParameter("header_epwd");
        
        RequestDispatcher rdl = request.getRequestDispatcher("header.html");
        
        rdl.include(request, response);
        
        pw.println("<br><br><br>");
        
        if(uname.equals("kvr") && pwd.equals("advanced")){
            pw.println("<center><font color=#ffff66><h3>Valid Credentials</h3></center>");
        }
        else{    pw.println("<center><font color=#ffff66><h3>Invalid Credentials</h3></center>");
        }
        
        pw.println("</font><br><br>");
        RequestDispatcher rd2 = request.getRequestDispatcher("footer.html");
        rd2.include(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

};
