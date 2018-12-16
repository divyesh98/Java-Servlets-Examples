/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.servlet.*;
import java.io.*;
import java.util.*;
import javax.servlet.http.*;
/**
 *
 * @author user
 */
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uname = request.getParameter("username");
        String upass = request.getParameter("password");
        
        if(uname.equals("admin") && upass.equals("admin")){
            response.sendRedirect("success.html");
            return;
        }
        else{
            response.sendRedirect("error.html");
            return;
        }
    }
};