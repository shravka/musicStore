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

public class AddToCart extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();
    String sku=request.getParameter("sku");
     String qty=request.getParameter("qty");
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

     String query ="SELECT * FROM product where sku="+"'"+sku+"'" ;
     //String s = DBHelper.getQuery(query);
     //System.out.println(s);
     //out.println(query);
     Vector<String []> v   = DBHelper.runQuery(query);
     int vSize =v.size();
     //System.out.println(v);
     for(int i=0;i<vSize;i++)
      {
		String [] record=v.elementAt(i);
        cartBean.addCartProduct(record[0],record[1],record[2],record[3],record[4],record[5],Float.parseFloat(record[6]),Float.parseFloat(record[7]),Integer.valueOf(record[8]) ,record[9]);
     }
     int count=cartBean.getCartSize();
      	out.print("product added to cart"+count);
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
