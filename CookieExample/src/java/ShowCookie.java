import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ShowCookie extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        String title = "Active Cookies";
        pw.println("<html><head><title>" + title + "</title></head></body>");
        pw.println("<table border=\"1\" align=\"center\">");
        pw.println("<tr><th>Cookie Name</th><th>Cookie Value</th></tr>");
        Cookie ck[] = req.getCookies();
        if (ck != null) {
            for (int i = 0; i < ck.length; i++) {
                pw.println("<tr><td>" + ck[i].getName() + "</td><td>" + ck[i].getValue() + "</td></tr>");
            }
        } else {
            System.out.println("NO COOKIES PRESENT");
        }
        pw.println("</table></body></html>");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
};