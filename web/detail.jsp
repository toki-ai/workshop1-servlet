<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="models.Car"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homepage</title>
    </head>
    <body>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Action</th>
            </tr>
            <%
                List<Car> carList = (List<Car>) request.getAttribute("carList");
                if (carList != null) {
                    for (Car item : carList) {
            %>
                    <tr>
                        <td><%= item.getCarID()%></td>
                        <td><%= item.getCarName()%></td>
                        <td>
                            <a href="edit?id=<%= item.getCarID()%>">Edit</a>
                            <a href="delete?id=<%= item.getCarID()%>">Delete</a>
                            <a href="add">Add</a>
                        </td>
                    </tr>
            <% } }%>
        </table>
    </body>
</html>
