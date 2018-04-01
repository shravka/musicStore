import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import sdsu.*;

public class GetSelectedProducts extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

      response.setContentType("text/html");
    	PrintWriter out = response.getWriter();
      String category=request.getParameter("category");
      String vendor=request.getParameter("vendor");
      String s="";
      if((category != null && !category.isEmpty()) &&(vendor != null && !vendor.isEmpty()))
          s= "select * from product where venID IN (" + vendor + ") AND catID IN (" + category + ") ";
      else if (category.isEmpty())
           s= "select * from product where venID IN (" + vendor + ")  ";
      else if (vendor.isEmpty())
              s= "select * from product where venID IN (" + category + ")  ";

      //String s =  "select * from product where venID IN (" + vendor + ") AND catID IN (" + category + ") ";
      String result = DBHelper.getQuery(s);
      Vector<String []> v   = DBHelper.runQuery(s);
      int vSize =v.size();
      //creating bean for each record
      ProductBean[] beans=new ProductBean[vSize];
      for(int i=0;i<vSize;i++)
        {
          String [] record=v.elementAt(i);
          beans[i] =new ProductBean(record[0],record[1],record[2],record[3],record[4],	record[5],Float.parseFloat(record[6]),Float.parseFloat(record[7]),Integer.valueOf(record[8]) ,record[9]);

        }
      request.setAttribute("beans",beans);
      String toDo = "/WEB-INF/jsp/GetAllProducts.jsp";
      RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(toDo);
      dispatcher.forward(request, response);
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
