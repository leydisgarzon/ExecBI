<%-- 
    Document   : editOffice
    Created on : 17-ago-2016, 11:09:17
    Author     : ley
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <spring:url value="/" var="home"/>
        <spring:url value="/resources/core/css/bootstrap.min.css" var="cssBootstrap"/>
        <spring:url value="/resources/core/js/bootstrap.min.js" var="jsBootstrap"/>
        <spring:url value="/resources/core/js/jquery-3.0.0.min.js" var="jsJQuery"/>
        <spring:url value="/resources/core/js/editOfficeJs.js" var="editOfficeJs"/>
        <link href="${cssBootstrap}" rel="stylesheet" />
        <script src="${jsJQuery}"></script>
        <script src="${jsBootstrap}"></script>
        <title>Edit Office</title>
    </head>
    <body>
        <div class="container">
            <div class="page-header">
                <h3>Edit Office</h3>
            </div>
            <!--<div id="feedback"></div>-->
            <f:form role="form" method="post" commandName="office" id="idformOffice" class="form-horizontal">
                <div class="form-group">                
                    <label for="list_offices">Offices list</label>
                    <f:select id="list_offices" path="id" items="${offices}" itemLabel="name" itemValue="id" cssClass="form-control"/>        
                </div>
                <fieldset>
                    <legend>Office's Data Selected </legend>
                    <div class="form-group">                
                        <label for="office_name">Name</label>
                        <input type="text" class="form-control" id="office_name"/>
                    </div>
                    <div class="form-group">                
                        <label for="office_tel">Telephone</label>
                        <input type="text" class="form-control" id="office_tel"/>
                    </div>
                    <div class="form-group">                
                        <label for="office_fax">Telephone</label>
                        <input type="text" class="form-control" id="office_fax"/>
                    </div>
                    <div class="form-group">                
                        <label for="office_city">City</label>
                        <input type="text" class="form-control" id="office_city"/>
                    </div>
                    <div class="form-group">                
                        <label for="office_street">Street</label>
                        <input type="text" class="form-control" id="office_street"/>
                    </div>
                    <div class="form-group">                
                        <label for="office_number">Number</label>
                        <input type="text" class="form-control" id="office_number"/>
                    </div>
                    <div class="form-group">                
                        <label for="office_manager">Manager</label>
                        <input type="text" class="form-control" id="office_manager"/>
                    </div>
                    <input type="hidden" id="rutaBase" value="${home}">
                </fieldset>
            </f:form> 
        </div>
        <script src="${editOfficeJs}"></script>
    </body>
</html>
