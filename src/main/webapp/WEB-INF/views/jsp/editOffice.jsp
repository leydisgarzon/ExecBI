<%-- 
    Document   : editOffice
    Created on : 17-ago-2016, 11:09:17
    Author     : ley
--%>
<%@include file="/WEB-INF/views/jsp/comun/directivas.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <%@include file="/WEB-INF/views/jsp/comun/intoHead.jsp"%>
        <spring:url value="/resources/core/js/editOfficeJs.js" var="editOfficeJs"/>
        <title>Edit Office</title>
    </head>
    <body>
        <%@include file="/WEB-INF/views/jsp/comun/googleAnalytics.jsp"%>
        <%@include file="/WEB-INF/views/jsp/comun/menu.jsp"%>
        <div class="container content">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3>Edit Office</h3>
                </div>
                <!--<div id="feedback"></div>-->
                <div class="panel-body">
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
            </div>
        </div>
        <script src="${editOfficeJs}"></script>
    </body>
</html>
