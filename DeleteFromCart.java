import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import sdsu.*;

/*
Sravani Kandarpa
jadrn015, Proj2
*/

public class DeleteFromCart extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();
    String sku=(String)request.getParameter("sku");
    int ProductIndex=Integer.parseInt(request.getParameter("index"));
        // making cart for user and storing in cookie
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
     cartBean.deleteCartProduct(ProductIndex);
    // String toDo = "/WEB-INF/jsp/Cart.jsp";
      // RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(toDo);
       //dispatcher.forward(request, response);
     out.println("item deleted");

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
