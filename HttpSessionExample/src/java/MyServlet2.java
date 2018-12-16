import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class MyServlet2 extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response){
  try{
      response.setContentType("text/html");
      PrintWriter pwriter = response.getWriter();
      HttpSession session=request.getSession(false);
      String myName=(String)session.getAttribute("uname");
      String myPass=(String)session.getAttribute("upass");
      pwriter.print("Name: "+myName+" Pass: "+myPass);
      pwriter.close();
  }catch(Exception exp){
      System.out.println(exp);
   }
  }
};