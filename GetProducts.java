import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import sdsu.*;


public class GetProducts extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String s = "SELECT * FROM product;";
    Vector<String []> v   = DBHelper.runQuery(s);
    int vSize =v.size();
    //creating bean for each record
    ProductBean[] beans=new ProductBean[vSize];
    String message="";
    for(int i=0;i<vSize;i++)
    {
		String [] record=v.elementAt(i);
    if(Integer.parseInt(record[8])>0)
     message="in stock";
    else
    message="coming soon";

		beans[i] =new ProductBean(record[0],record[1],record[2],record[3],record[4],	record[5],Float.parseFloat(record[6]),Float.parseFloat(record[7]),Integer.parseInt(record[8]) ,record[9],message);

    }
	request.setAttribute("beans",beans);
	String toDo = "/WEB-INF/jsp/GetAllProducts.jsp";
    RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(toDo);
    dispatcher.forward(request, response);






    }
}
