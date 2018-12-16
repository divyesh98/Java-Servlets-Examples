import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SetCookie extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // default maximum age is -1, indicating cookie applies only to current browsing session
        res.setContentType("text/html");
        Cookie c1 = new Cookie("ANDHRA_PRADESH", "HYDERABAD");
        Cookie c2 = new Cookie("TAMILNADU", "CHENNAI");
        res.addCookie(c1);
        res.addCookie(c2);
        // c3 is valid for 5mins & c4 for 10mins, regardless of user quits browser, reboots computer
        Cookie c3 = new Cookie("KARNATAKA", "BANGLORE");
        Cookie c4 = new Cookie("BIHAR", "PATNA");
        c3.setMaxAge(300);
        c4.setMaxAge(600);
        res.addCookie(c3);
        res.addCookie(c4);
        System.out.println("SUCCESSFUL IN SETTING COOKIES");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
};