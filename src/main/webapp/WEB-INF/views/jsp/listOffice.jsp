<%@page session="false"%>
<%-- 
    Document   : listOffice
    Created on : 15-ago-2016, 10:58:59
    Author     : ley
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <spring:url value="/" var="home"/>
        <spring:url value="/resources/core/css/bootstrap.min.css" var="cssBootstrap"/>
        <spring:url value="/resources/core/js/bootstrap.min.js" var="jsBootstrap"/>
        <spring:url value="/resources/core/js/jquery-3.0.0.min.js" var="jsJQuery"/>
        <link href="${cssBootstrap}" rel="stylesheet" />
        <script src="${jsJQuery}"></script>
        <script src="${jsBootstrap}"></script>
        <title>List Offices </title>
    </head>
    <body>
        <h3>Offices:</h3>
        <div class="container">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Telephone</th>
                        <th>Fax</th>
                        <th>City</th>
                        <th>Streets</th>
                        <th>Home_#</th>
                        <th>Manager<th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="office" items="${offices}">
                        <tr>
                            <td>${office.name}</td>
                            <td>${office.telephone}</td>
                            <td>${office.fax}</td>
                            <td>${office.address.city}</td>
                            <td>${office.address.street}</td>
                            <td>${office.address.number}</td>
                            <td>${office.manager.name}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>   
        </div>
    </body>
</html>
