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
    ArrayList cartProductsList=new ArrayList();
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
     int existingQuantity=0 ,Index=0;
     String existingSku ="";
     //String s = "";
     boolean cartflag=false;
     boolean itemExistsFlag=false;
     Vector<String []> v   = DBHelper.runQuery(query);
     int vSize =v.size();

     //System.out.println(v);
     for(int i=0;i<vSize;i++)
      {
	    	String [] record=v.elementAt(i);
         //if the quantity asked is less than available quantity then add to cart
        if(Integer.parseInt(record[8]) >qty)
          {

            // get the cart items:
            cartProductsList=cartBean.getCartProducts();
            for(int j=0;j<cartProductsList.size();j++)
            {
                CartItemBean cartProduct= (CartItemBean) cartProductsList.get(j);
                 if(sku.equals(cartProduct.getSku()))
                 {
                     System.out.println("im adding here ");
                     out.print("im existing");
                     itemExistsFlag=true;
                     existingQuantity=cartProduct.getQuantity() ;
                     Index=j;
                     break;
                 }
            }

                if(itemExistsFlag)
                {
                   cartflag=true;
                   cartBean.AddQuantity(existingQuantity+qty ,Index);
                }
               else
                {
               //totalcost = qiantity * cost
              //double totalcost=Integer.parseInt(qty) * Float.parseFloat(record[7]);
               String categoryname="";
               String vendorname="";
               vendorname = DBHelper.getQuery("SELECT name FROM vendor where id="+record[2]+";");
               categoryname=DBHelper.getQuery("SELECT name FROM category where id="+record[1]+";");
               cartBean.addCartProduct(record[0],categoryname.replaceAll("[^a-zA-Z]",""),vendorname.replaceAll("[^a-zA-Z]",""),record[3],record[4],record[5],Float.parseFloat(record[6]),Float.parseFloat(record[7]),qty ,record[9]);
               cartflag=true;
              }

           }
          else
             cartflag=false;


     }//for end

       if (cartflag)
       {
           // int count=cartBean.getCartSize();
            out.print("Item added to the Cart");
       }
      else
          out.print("Sorry , Requested Quantity "+ qty + "exceeds the items in Stock(" + ")" );



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
