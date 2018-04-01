import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.json.*;
import java.util.*;

import sdsu.*;


public class JsonTest extends HttpServlet {


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {   
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    Vector<String []> v = DBHelper.runQuery("SELECT sku, vendorModel, description, retail FROM product;");
    StringBuffer toSend = new StringBuffer();
    toSend.append("[");
    for(int i=0; i < v.size(); i++) {
            String [] tmp = v.elementAt(i);
            toSend.append("[");
            toSend.append("\""+tmp[0]+"\",");
            toSend.append("\""+tmp[1]+"\",");
            toSend.append("\""+tmp[2]+"\",");
            toSend.append("\""+tmp[3]+"\""); 
            toSend.append("],");                                               
    }
            String s = toSend.toString();
            s = s.substring(0, (s.length()-1));
            out.print(s+"]");
	
    }
    
    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
    	doGet(request, response);
    }  
}



