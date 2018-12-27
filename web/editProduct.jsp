<%-- 
    Document   : editProduct
    Created on : Dec 27, 2018, 11:20:28 PM
    Author     : badan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>EDIT PRODUCT</h1>
        <s:iterator value="product" var="product">
            <form action="updateProduct">
                <input type="hidden" name="type" value="edit"/>
                Id: <input name="id" value="<s:property value="id"/>" disabled/><br/>
                Name: <input name="name" value="<s:property value="name"/>"/><br/>
                Price: <input name="price" value="<s:property value="price"/>"/><br/>
                Description: <input name="description" value="<s:property value="description"/>"/><br/>
                <input type="submit"/>
            </form>
        </s:iterator>
    </body>
</html>
