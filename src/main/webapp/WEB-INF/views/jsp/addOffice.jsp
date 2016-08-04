<%@page session="false"%>

<%--
    <%@page contentType="text/html" pageEncoding="windows-1252"%>
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Insert Office</title>
        <spring:url value="/" var="home"/>
        <spring:url value="/resources/core/css/bootstrap.min.css" var="cssBootstrap"/>
        <spring:url value="/resources/core/js/bootstrap.min.js" var="jsBootstrap"/>
        <spring:url value="/resources/core/js/addOfficeJS.js" var="jsAjaxOffice"/>
        <spring:url value="/resources/core/js/jquery-3.0.0.min.js" var="jsJQuery"/>
        <link href="${cssBootstrap}" rel="stylesheet" />
        <script src="${jsJQuery}"></script>
        <script src="${jsBootstrap}"></script>
        
    </head>
    <body>
        <div id="response">
            
        </div>
        <div class="container" style="min-height: 80%">
            <h1>Insert Office</h1>
            <f:form role="form" method="post" commandName="office"  class="form-horizontal" id="addOffice-form">
                <fieldset><legend>Office Data</legend>
                            <div class="form-group form-group-lg">
                                    <label class="col-sm-2 control-label">Name</label>
                                    <div class="col-sm-10">
                                        <f:input path="name" type="text" class="form-control" id="name"/>
                                    </div>
                            </div>
                            <div class="form-group form-group-lg">
                                    <label class="col-sm-2 control-label">Telephone</label>
                                    <div class="col-sm-10">
                                        <f:input path="telephone" type="tel" class="form-control" id="telephone"/>
                                    </div>
                            </div>
                            <div class="form-group form-group-lg">
                                    <label class="col-sm-2 control-label">Fax</label>
                                    <div class="col-sm-10">
                                            <f:input path="fax" type="text" class="form-control" id="fax"/>
                                    </div>
                            </div>
                            <input type="hidden" id="rutaBase" value="${home}">
                </fieldset>
                <fieldset><legend>Office Manager Data</legend>
                    <div class="form-group form-group-lg">
                                    <label class="col-sm-2 control-label">Manager</label>
                                    <div class="col-sm-10">
                                        <f:select path="manager.id" items="${employees}" class="form-control" id="mgList" itemValue="id"  />
                                    </div>
                    </div>
                    <div class="form-group form-group-lg">
                                    <label class="col-sm-2 control-label">New Manager</label>
                                    <div class="col-sm-10">
                                        <input type="checkbox" id="checkbox">
                                    </div>
                    </div>
                    <fieldset disabled id="mgData">
                            <div class="form-group form-group-lg">
                                    <label class="col-sm-2 control-label">Name</label>
                                    <div class="col-sm-10">
                                            <input type=text class="form-control" id="mgName">
                                    </div>
                            </div>
                            <div class="form-group form-group-lg">
                                    <label class="col-sm-2 control-label">DNI</label>
                                    <div class="col-sm-10">
                                            <input type="text" class="form-control" id="dni">
                                    </div>
                            </div>
                            <div class="form-group form-group-lg">
                                    <label class="col-sm-2 control-label">Telephone</label>
                                    <div class="col-sm-10">
                                        <input type="tel" class="form-control" id="mgTelephone">
                                    </div>
                            </div>
                            <div class="form-group form-group-lg">
                                    <label class="col-sm-2 control-label">Birthday</label>
                                    <div class="col-sm-10">
                                        <input type="date" class="form-control" id="birthday">
                                    </div>
                            </div>
                            <div class="form-group form-group-lg">
                                    <label class="col-sm-2 control-label">City</label>
                                    <div class="col-sm-10">
                                            <input type="text" class="form-control" id="city">
                                    </div>
                            </div>
                            <div class="form-group form-group-lg">
                                    <label class="col-sm-2 control-label">House Number</label>
                                    <div class="col-sm-10">
                                            <input type="text" class="form-control" id="number">
                                    </div>
                            </div>
                            <div class="form-group form-group-lg">
                                    <label class="col-sm-2 control-label">Street</label>
                                    <div class="col-sm-10">
                                            <input type="text" class="form-control" id="street">
                                    </div>
                            </div>
                            <div class="form-group form-group-lg">
                                    <label class="col-sm-2 control-label">Date in</label>
                                    <div class="col-sm-10">
                                            <input type="date" class="form-control" id="inDate">
                                    </div>
                            </div>
                            <div class="form-group form-group-lg">
                                    <label class="col-sm-2 control-label">Job</label>
                                    <div class="col-sm-10">
                                            <input type="text" class="form-control" id="job">
                                    </div>
                            </div>
                            <div class="form-group form-group-lg">
                                    <label class="col-sm-2 control-label">Salary</label>
                                    <div class="col-sm-10">
                                        <input type="number" class="form-control" id="salary">
                                    </div>
                            </div>
                            <div class="form-group form-group-lg">
                                    <label class="col-sm-2 control-label">Write Speed</label>
                                    <div class="col-sm-10">
                                            <input type="text" class="form-control" id="speed">
                                    </div>
                            </div>
                    </fieldset>        
                </fieldset>
                            <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-10">
                                            <button type="submit" id="bth-addOffice"
                                                    class="btn btn-primary btn-lg">Insert</button>
                                    </div>
                            </div>
                    </f:form>
        </div>
    <script src="${jsAjaxOffice}"></script>
    </body>
</html>
