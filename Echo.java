/*	Echo.java
	Echos back to the client any parameters received.
	Alan Riggins
	Spring 2018
*/	

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class Echo extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        			throws IOException, ServletException  {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
	StringBuffer buf = new StringBuffer();

        buf.append("<!DOCTYPE html><html>");
        buf.append("<head>");
        buf.append("<meta charset='UTF-8' />");
	buf.append("<style>");
	buf.append("h1 { text-align: center; }");
	buf.append("table { border-collapse: collapse; margin: auto;}");
	buf.append("td { border: 2px solid black;  padding: 5px; }");
	buf.append("</style>");
        buf.append("</head>");
        buf.append("<body>");
	buf.append("<h1>Parameters Received</h1>");
	buf.append("<table>");
	Enumeration<String> keys = request.getParameterNames();
	while(keys.hasMoreElements()) {
		String s = keys.nextElement(); 
		buf.append("<tr><td>"+s+"</td><td>"+
			request.getParameter(s) + "</td></tr>");
		}
	buf.append("</table>");
        buf.append("</body>");
        buf.append("</html>");
	out.print(buf.toString());
    }
    
    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        			throws IOException, ServletException  {
    		doGet(request, response);
		}   
}



