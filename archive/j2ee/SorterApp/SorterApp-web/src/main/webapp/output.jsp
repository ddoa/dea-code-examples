<%-- 
    Document   : output
    Created on : Mar 19, 2014, 8:50:12 PM
    Author     : mdkr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sorted data</title>
    </head>
    <body>
        <h1>The sorted data:</h1>
        <%= session.getAttribute("sortedData") %>           
    </body>
</html>
