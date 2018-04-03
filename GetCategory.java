import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import sdsu.*;

public class GetCategory extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      response.setContentType("text/html");
    	PrintWriter out = response.getWriter();
      String s = "SELECT name FROM category;";
      System.out.println(s);
      String result = DBHelper.getQuery(s);
      out.print(result);
      }

     /**
    	     * We are going to perform the same operations for POST requests
    	     * as for GET methods, so this method just sends the request to
    	     * the doGet method.
    	 */
  	   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	     // TODO Auto-generated method stub
    	     processRequest(request, response);
    	   }

  	   protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	     // TODO Auto-generated method stub
    	     processRequest(request, response);
      }

}
