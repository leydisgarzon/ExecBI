<%@page session="false"%>
<%-- 
    Document   : listOffice
    Created on : 15-ago-2016, 10:58:59
    Author     : ley
--%>

<%@include file="/WEB-INF/views/jsp/comun/directivas.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <%@include file="/WEB-INF/views/jsp/comun/intoHead.jsp"%>
        <title>List Offices </title>
    </head>
    <body>
        <%@include file="/WEB-INF/views/jsp/comun/googleAnalytics.jsp"%>
        <%@include file="/WEB-INF/views/jsp/comun/menu.jsp"%>

        <div class="container content">
            <div class='panel panel-default'>
                <div class="panel-heading"><h3>Offices:</h3></div>
                <div class="panel-body">
                    <table class="table table-striped table-responsive">
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
            </div>
        </div>
    </body>
</html>
