<%-- 
    Document   : updateProduct
    Created on : Dec 26, 2018, 12:12:13 PM
    Author     : badan
--%>

<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Product</title>
    </head>
    <body>
        <h1>ADD PRODUCT</h1>
        <form action="updateProduct">
            <input type="hidden" name="type" value="add"/>
            Name: <input name="name"/><br/>
            Price: <input name="price"/><br/>
            Description: <input name="description"/><br/>
            <input type="submit"/>
        </form>
    </body>
</html>
