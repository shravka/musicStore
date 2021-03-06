package sdsu;

import java.sql.*;
import java.util.*;

public class DBHelper implements java.io.Serializable {
    private static String connectionURL = "jdbc:mysql://opatija:3306/jadrn015?user=jadrn015&password=picture";
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    public DBHelper() {}

    public static Vector<String []> runQuery(String s) {
        String answer = "";
        Vector<String []> answerVector = null;

	try {
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	connection = DriverManager.getConnection(connectionURL);
	statement = connection.createStatement();
	resultSet = statement.executeQuery(s);
        ResultSetMetaData rsmd = resultSet.getMetaData();
        answerVector = new Vector<String []>();
	while(resultSet.next()) {
            String [] row = new String[rsmd.getColumnCount()];
            for(int i=0; i < rsmd.getColumnCount(); i++)
                row[i] = resultSet.getString(i+1);
            answerVector.add(row);
		}
	}
	catch(Exception e) {
	    e.printStackTrace();
	}
        //////////////////////////////////////////////////////////////////////////
        // The finally clause always runs, and closes resources if open.
        // DO NOT OMIT THIS!!!!!!
        finally {
            try {
                if(resultSet != null)
                    resultSet.close();
                if(statement != null)
                    statement.close();
                if(connection != null)
            	    connection.close();
                }
            catch(SQLException e) {
                answer += e;
                }
        //////////////////////////////////////////////////////////////////////////
        }
        return answerVector;
    }

    public static String doQuery(String s) {
            String answer = "";
	    try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connection = DriverManager.getConnection(connectionURL);
		statement = connection.createStatement();
		resultSet = statement.executeQuery(s);
                ResultSetMetaData rsmd = resultSet.getMetaData();
		int columns = rsmd.getColumnCount();
                answer += "<h2>Results from the database:</h2>\n";
                answer += "<table>\n<tr>";
                    for(int i=1; i <= columns; i++)
                        answer += "<th>"+rsmd.getColumnName(i) + "</th>";
                    answer += "</tr>";
		while(resultSet.next()) {
		    answer += "<tr>\n";
		    for(int i=1; i <= columns; i++)
                        answer += "<td>" + resultSet.getString(rsmd.getColumnName(i)) + "</td>\n";
                    answer += "</tr>\n";
		    }
                answer += "</table>\n";
		}
		catch(Exception e) {
			e.printStackTrace();
			return e.toString();
			}
        //////////////////////////////////////////////////////////////////////////
        // The finally clause always runs, and closes resources if open.
        // DO NOT OMIT THIS!!!!!!
        finally {
            try {
                if(resultSet != null)
                    resultSet.close();
                if(statement != null)
                    statement.close();
                if(connection != null)
            	    connection.close();
                }
            catch(SQLException e) {
                answer += e;
                }
        //////////////////////////////////////////////////////////////////////////
        }
        return answer;
    }
/********************copy of Sir's code without html table***************************/
    public synchronized static String getQuery(String s) {
     	Connection connection = null;
		Statement statement = null;
     	String answer = "";
     	try
     	{
		   Class.forName("com.mysql.jdbc.Driver").newInstance();
		   connection = DriverManager.getConnection(connectionURL);
		   statement = connection.createStatement();
		   resultSet = statement.executeQuery(s);
		  // System.out.println(resultSet);
		   if(resultSet == null)
		   		return null;

		   ResultSetMetaData rsmd = resultSet.getMetaData();
		   int columns = rsmd.getColumnCount();
		   while(resultSet.next()) {
			   for(int i=1; i <= columns; i++)
					answer +=  resultSet.getString(rsmd.getColumnName(i));
					answer += "|";
			   }
		   }
   catch(Exception e) {
     e.printStackTrace();
     return e.toString();
     }
        //////////////////////////////////////////////////////////////////////////
        // The finally clause always runs, and closes resources if open.
        // DO NOT OMIT THIS!!!!!!
        finally {
            try {
               if(resultSet != null)
                    resultSet.close();
               if(statement != null)
                    statement.close();
               if(connection != null)
                 connection.close();
                }
            catch(SQLException e) {
               answer += e;
                }
        //////////////////////////////////////////////////////////////////////////
        }
        return answer;
    }
    public static String Query(String s) {
            String answer = "";
      try {
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    connection = DriverManager.getConnection(connectionURL);
    statement = connection.createStatement();
    resultSet = statement.executeQuery(s);
                ResultSetMetaData rsmd = resultSet.getMetaData();
    int columns = rsmd.getColumnCount();
                //answer += "";
                //answer += "<table>\n<tr>";
                  //  for(int i=1; i <= columns; i++)
                    //    answer += "<th>"+rsmd.getColumnName(i) + "</th>";
                    //answer += "</tr>";
    while(resultSet.next()) {
      //  answer += "|";
        for(int i=1; i <= columns; i++)
                        answer +=  resultSet.getString(rsmd.getColumnName(i))+"|";
                  //  answer += "</tr>\n";
        }
                answer += "||";
    }
    catch(Exception e) {
      e.printStackTrace();
      return e.toString();
      }
        //////////////////////////////////////////////////////////////////////////
        // The finally clause always runs, and closes resources if open.
        // DO NOT OMIT THIS!!!!!!
        finally {
            try {
                if(resultSet != null)
                    resultSet.close();
                if(statement != null)
                    statement.close();
                if(connection != null)
                  connection.close();
                }
            catch(SQLException e) {
                answer += e;
                }
        //////////////////////////////////////////////////////////////////////////
        }
        return answer;
    }


}
