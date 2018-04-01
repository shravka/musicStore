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
/*    public ProductBean(String sku, String category, String vendor, String vendorModel, String description, String features, float cost, float retail, int quantity,String image)
	                       AHT-774 1 1 PAC612VIIFM
	                       Electric guitar
	                       The Pacifica series was driven by the California session scene of the day-where versatility, performance and individuality were key. Maple and Alder Body,Flamed Maple Laminated,Seymour Duncan Pickups/SSL-1, SSL-1 RwRp, Custom 5 TB-14Push-Pull Coil Split (Master Tone Knob)Wilkinson VS50 Bridge,Grover Locking Tuners,Graph Tech TUSQ Nut
	                       150.00
	                       200.00
	                       20
	                       AHT-774.jpg


*/


	//String [] tmp = v.elementAt(1);
   // for(int i=0 ;i<tmp.length;i++)
   //out.println(tmp[i]);

	//beans = new ProductBean(tmp[0],tmp[1],tmp[2],tmp[3],tmp[4],	tmp[5],Float.parseFloat(tmp[6]),Float.parseFloat(tmp[7]),Integer.valueOf(tmp[8]) ,tmp[9]);


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
}
