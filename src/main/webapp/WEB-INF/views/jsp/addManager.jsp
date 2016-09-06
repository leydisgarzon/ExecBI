<%@include file="/WEB-INF/views/jsp/comun/directivas.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Insert Manager</title>
        <%@include file="/WEB-INF/views/jsp/comun/intoHead.jsp"%>
        <spring:url value="/resources/core/js/addManagerJS.js" var="especificJs"/>

    </head>
    <body>
        <%@include file="/WEB-INF/views/jsp/comun/layerStructureBegin.jsp"%>

        <f:form role="form" method="post" commandName="manager"  class="form-horizontal" id="addOffice-form">
            <fieldset><legend>Office Manager Data</legend>
                <div class="form-group form-group-sm">
                    <label class="col-sm-2 control-label">Office</label>
                    <div class="col-sm-6">
                        <f:select path="office.id" items="${offices}" class="form-control" id="office" itemValue="id" itemLabel="name"  />
                    </div>
                </div>

                <input type="hidden" id="rutaBase" value="${home}">

                <div class="form-group form-group-sm">
                    <label class="col-sm-2 control-label">Manager</label>
                    <div class="col-sm-6">
                        <f:select path="id" items="${employees}" disabled="true" class="form-control" id="mgList" itemValue="id" itemLabel="name"  />
                    </div>
                </div>
                <div class="form-group form-group-sm">
                    <label class="col-sm-2 control-label">New Manager</label>
                    <div class="col-sm-4">
                        <input type="checkbox" id="checkbox" checked="false">
                    </div>
                </div>
                <fieldset id="mgData">
                    <div class="form-group form-group-sm">
                        <label class="col-sm-2 control-label">Name</label>
                        <div class="col-sm-6">
                            <input type=text class="form-control" id="mgName">
                        </div>

                        <label class="col-sm-1 control-label">DNI</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="dni">
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label class="col-sm-2 control-label">Telephone</label>
                        <div class="col-sm-6">
                            <input type="tel" class="form-control" id="mgTelephone">
                        </div>

                        <label class="col-sm-1 control-label">Birthday</label>
                        <div class="col-sm-3">
                            <input type="date" class="form-control" id="birthday">
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label class="col-sm-2 control-label">City</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="city">
                        </div>

                        <label class="col-sm-1 control-label">House Number</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="number">
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label class="col-sm-2 control-label">Street</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="street">
                        </div>

                        <label class="col-sm-1 control-label">Date in</label>
                        <div class="col-sm-3">
                            <input type="date" class="form-control" id="inDate">
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label class="col-sm-2 control-label">Job</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="job">
                        </div>

                        <label class="col-sm-1 control-label">Salary</label>
                        <div class="col-sm-3">
                            <input type="number" class="form-control" id="salary">
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label class="col-sm-2 control-label">Write Speed</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="speed">
                        </div>
                    </div>
                </fieldset>        
            </fieldset>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" id="bth-addOffice"
                            class="btn btn-primary btn-sm">Insert</button>
                </div>
            </div>
        </f:form>
        <%@include file="/WEB-INF/views/jsp/comun/layerStructureEnd.jsp"%>
    </body>
</html>
