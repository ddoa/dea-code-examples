<%-- 
    Document   : index
    Created on : Mar 13, 2012, 9:49:31 AM
    Author     : mdkr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <%
                if (request.getParameter("language").equals("NL")) 
                    out.print("Hallo");
                else 
                    out.print("Hello");
            %>
        </h1>
    </body>
</html>
