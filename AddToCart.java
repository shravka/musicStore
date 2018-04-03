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
    String sku=(String)request.getParameter("sku");
    int qty=Integer.parseInt(request.getParameter("quantity"));
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
     String s = "Sorry , item not available";
     boolean cartflag=false;
     //System.out.println(s);
     //out.println(query);
     Vector<String []> v   = DBHelper.runQuery(query);
     int vSize =v.size();
     //System.out.println(v);
     for(int i=0;i<vSize;i++)
      {
		String [] record=v.elementAt(i);
      //if the quantity asked is less than available quantity then add to cart
       if(Integer.parseInt(record[8]) >qty)
       {
          //totalcost = qiantity * cost
          //double totalcost=Integer.parseInt(qty) * Float.parseFloat(record[7]);
          cartBean.addCartProduct(record[0],record[1],record[2],record[3],record[4],record[5],Float.parseFloat(record[6]),Float.parseFloat(record[7]),qty ,record[9]);
          cartflag=true;
       }
      else
         cartflag=false;

        //s=record[0];
     }

       if (cartflag)
       {
            int count=cartBean.getCartSize();
            out.print("product added to cart"+count );
       }
      else
          out.print(s );




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
