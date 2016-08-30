<%@page session="false"%>

<%--
    <%@page contentType="text/html" pageEncoding="windows-1252"%>
--%>
<%@include file="/WEB-INF/views/jsp/comun/directivas.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Insert Office</title>
        <%@include file="/WEB-INF/views/jsp/comun/intoHead.jsp"%>
        <spring:url value="/resources/core/js/addOfficeJS.js" var="jsAddOffice"/>

    </head>
    <body>
        <%@include file="/WEB-INF/views/jsp/comun/googleAnalytics.jsp"%>
        <!--        <div id="response"></div>-->
        <%@include file="/WEB-INF/views/jsp/comun/menu.jsp"%>
        <div class="container content">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3>Insert Office</h3>
                </div>
                <div class="panel-body">
                    <f:form role="form" method="post" commandName="office"  class="form-horizontal" id="addOffice-form">
                            <div class="form-group">
                                <label class="col-sm-1 control-label">Name</label>
                                <div class="col-sm-10">
                                    <f:input path="name" type="text" class="form-control" id="name"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-1 control-label">Telephone</label>
                                <div class="col-sm-10">
                                    <f:input path="telephone" type="tel" class="form-control" id="telephone"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-1 control-label">Fax</label>
                                <div class="col-sm-10">
                                    <f:input path="fax" type="text" class="form-control" id="fax"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-1 control-label">City</label>
                                <div class="col-sm-10">
                                    <f:input path="address.city" type="text" class="form-control" id="city"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-1 control-label">Number</label>
                                <div class="col-sm-10">
                                    <f:input path="address.number" type="text" class="form-control" id="number"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-1 control-label">Street</label>
                                <div class="col-sm-10">
                                    <f:input path="address.street" type="text" class="form-control" id="street"/>
                                </div>
                            </div>
                            <input type="hidden" id="rutaBase" value="${home}">

                        <div class="form-group">
                            <div class="col-sm-offset-1 col-sm-10">
                                <button type="submit" id="bth-addOffice"
                                        class="btn btn-success btn-sm">Insert</button>
                                <button type="reset" id="bth-cancel" class="btn btn-primary btn-sm">Cancel</button>
                            </div>
                        </div>
                    </f:form>
                </div>
            </div>
        </div>
        <!--<script src="${jsAddOffice}"></script>-->
    </body>
</html>
