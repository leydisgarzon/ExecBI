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
                    <label for="list_offices" class="col-sm-1 control-label">Offices</label>
                    <div class="col-sm-5">
                        <f:select id="list_offices" path="id" items="${offices}" itemLabel="name" itemValue="id" cssClass="form-control"/>        
                    </div>
                </div>
                <fieldset>
                    <legend>Office's Data Selected </legend>
                    <div class="form-group">                
                        <label for="office_name" class="col-sm-1 control-label">Name</label>
                        <div class="col-sm-5">
                            <f:input path="name" type="text" class="form-control" id="office_name"/>
                        </div>
                        
                        <label for="office_tel" class="col-sm-1 control-label">Telephone</label>
                        <div class="col-sm-5">
                            <f:input path="telephone" type="text" class="form-control" id="office_tel"/>
                        </div>
                    </div>
                    <div class="form-group">                
                        <label for="office_fax" class="col-sm-1 control-label">Fax</label>
                        <div class="col-sm-5">
                            <f:input path="fax" type="text" class="form-control" id="office_fax"/>
                        </div>
                        
                        <label for="office_city" class="col-sm-1 control-label">City</label>
                        <div class="col-sm-5">
                            <f:input path="address.city" type="text" class="form-control" id="office_city"/>
                        </div>
                    </div>
                    <div class="form-group">                
                        <label for="office_number" class="col-sm-1 control-label">Number</label>
                        <div class="col-sm-3">
                            <f:input path="address.number" type="text" class="form-control" id="office_number"/>
                        </div>              
                        <label for="office_street" class="col-sm-3 control-label">Street</label>
                        <div class="col-sm-5">
                            <f:input path="address.street" type="text" class="form-control" id="office_street"/>
                        </div>
                    </div> 
                    <div class="form-group">                
                        <label for="office_manager" class="col-sm-1 control-label">Manager</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="office_manager"/>
                        </div>
                    </div>
                    <input type="hidden" id="rutaBase" value="${home}">
                    <f:input path="address.id" type="hidden" id="addressId" />
                </fieldset>
                <div class="form-group">
                    <div class="col-sm-offset-1 col-sm-10">
                        <button type="submit" name="edit" id="bth-edit" class="btn btn-success btn-sm">Edit</button>
                        <button type="reset" id="bth-cancel" class="btn btn-primary btn-sm">Cancel</button>
                        <button type="submit" name="delete" id="bth-delete" class="btn btn-danger btn-sm">Delete</button>
                    </div>
                </div>
            </f:form> 
        </div>
        <script src="${editOfficeJs}"></script>
    </body>
</html>
