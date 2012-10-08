<%@page import="java.util.List"%>
<%@page import="org.glassfish.samples.entities.Customer"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="org.glassfish.samples.CustomerSessionBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        Context context = new InitialContext();
        CustomerSessionBean bean = (CustomerSessionBean) context.lookup("java:global/JavaEE6SampleApp/CustomerSessionBean");
        List<Customer> customers = bean.getCustomers();

    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Java EE 6 Sample App - for DDOA</h1>
        <table>
            <%
                for (int i = 0; i < customers.size(); i++) {
                    %>
                    <tr>
                        <td><%= customers.get(i).getName() %> </td>
                        <td><%= customers.get(i).getCustomerId() %> </td>
                    </tr>
            <%
                }
            %> 

        </table>
    </body>
</html>
