<%@ page import = "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html;
    charset=iso-8859-1" />

    <title>JSP Page Template</title>

<!-- of course, you want to substitute your CSS file for my sdsu.css -->
    <link rel="stylesheet" type="text/css"
        href="http://pindar.sdsu.edu/sdsu.css" />

</head>

<body>
    <div>
    <h2>Test of JSP, Fetching Bean Properties</h2>
       <jsp:useBean id="person_bean"
       		class="sdsu.PersonBean" />
		<jsp:getProperty name="person_bean"
			property="color" />
		<% String x=person_bean.getColor(); %>
		<h3>The color assigned to this person is: <%= x %></h3>
        <h2>JSP EL processing</h2>
        EL is as easy as 1+2+3=${1+2+3};<br />
        The color is ${person_bean.color}<br />
	The name of this person is ${person_bean.name}<br />
	The name of this person is <%= person_bean.getName() %>


        <p />

    </div>
</body>

</html>
