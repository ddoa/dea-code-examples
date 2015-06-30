<%-- 
    Document   : input
    Created on : Mar 19, 2014, 8:46:59 PM
    Author     : mdkr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to the sorter</title>
    </head>
    <body>
        <h1>Please input your sort numbers, comma separated</h1>
        <form action="SorterServlet" method="POST">
            <input name="sortData"/>
        </form>
    </body>
</html>
