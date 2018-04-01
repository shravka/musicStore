import java.util.ArrayList;
import sdsu.*;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
/*
Sravani Kandarpa
jadrn015
proj2
*/
public class CartSize  extends HttpServlet {

  private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  HttpSession session = request.getSession();
  CartHelper cartBean = null;
  Object objCartBean = session.getAttribute("jadrn015");
  if(objCartBean!=null)
    {
      cartBean = (CartHelper) objCartBean ;
    }
    else
     {
       cartBean = new CartHelper();
       session.setAttribute("jadrn015", cartBean);
     }
   int size=cartBean.getCartSize();
    out.print(size);
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
