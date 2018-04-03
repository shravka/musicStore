import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
Sravani Kandarpa
jadrn015, Proj2
*/

public class CartClientDispatcher extends HttpServlet {


public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 PrintWriter write = response.getWriter();
 String strAction = request.getParameter("value");
 // Set the attribute and Forward to hello.jsp
 // request.setAttribute ("servletName", "servletToJsp");


 if(strAction.equals(""))
 	{
          //String toDo = "/WEB-INF/jsp/Cart.jsp";
         getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/jsp/Cart.jsp").forward(request, response);
        //dispatcher.forward(request, response);
    }

 }
}
