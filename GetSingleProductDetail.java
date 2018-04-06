import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import sdsu.*;


public class GetSingleProductDetail extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String sku=request.getParameter("sku");
    String s = "SELECT * FROM product where sku="+"'"+sku+"'";
    Vector<String []> v   = DBHelper.runQuery(s);
    int vSize =v.size();
    //creating bean for each record
    ProductBean[] beans=new ProductBean[vSize];
    //out.print(v);
    String message="";
    for(int i=0;i<vSize;i++)
    {

	  String [] record=v.elementAt(i);

	 if(Integer.parseInt(record[8])>0)
      message="in stock";
    else
      message="coming soon";

       String categoryname="";
	         String vendorname="";
	          vendorname = DBHelper.getQuery("SELECT name FROM vendor where id="+record[2]+";");
         categoryname=DBHelper.getQuery("SELECT name FROM category where id="+record[1]+";");
         //categoryname=categoryname.replaceAll("[^a-zA-Z]","");

    beans[i] =new ProductBean(record[0],categoryname.replaceAll("[^a-zA-Z]",""),vendorname.replaceAll("[^a-zA-Z]",""),record[3],record[4],	record[5],Float.parseFloat(record[6]),Float.parseFloat(record[7]),Integer.valueOf(record[8]) ,record[9],message);

    }
request.setAttribute("beans",beans);
	String toDo = "/WEB-INF/jsp/GetProductDetails.jsp";
	//String toDo = "/WEB-INF/jsp/GetAllProducts.jsp";
    RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(toDo);
    dispatcher.forward(request, response);
    }
}
