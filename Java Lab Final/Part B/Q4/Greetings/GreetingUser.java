// Program to accept username, address
// and display them in a web page by
// passing parameters.
//use classpath "/opt/tomcat/lib/servlet-api.jar/" release 8, use sudo if not superuser

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class GreetingUser extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name, addr;
        response.setContentType("text/html");
        name = request.getParameter("uname");
        addr = request.getParameter("addr");
        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>Welcome: " + name + " </h1><hr>Address: " + addr + "</body></html>");
        out.close();
    }
}
