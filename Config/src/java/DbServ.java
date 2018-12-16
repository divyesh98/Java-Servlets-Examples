import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;

public class DbServ extends HttpServlet {

    ServletConfig sc = null;

    public void init(ServletConfig sc) throws ServletException {
        super.init(sc);
        this.sc = sc;
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        String dname = sc.getInitParameter("dname");
        String url = sc.getInitParameter("url");
        String tab = sc.getInitParameter("tab");
        try {
            Class.forName(dname);
            Connection con = DriverManager.getConnection(url, "div", "div");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from " + tab);
            while (rs.next()) {
                pw.println("<h2>" + rs.getString(1) + "     " + rs.getString(2) + "     " + rs.getString(3) + "</h2>");
            }
            con.close();
        } catch (Exception e) {
            res.sendError(503, "PROBLEM IN DATABASE...");
        }
    }
};