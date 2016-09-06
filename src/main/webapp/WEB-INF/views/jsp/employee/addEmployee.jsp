<%@include file="/WEB-INF/views/jsp/comun/directivas.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Insert Employee</title>
        <%@include file="/WEB-INF/views/jsp/comun/intoHead.jsp"%>
        <spring:url value="/resources/core/js/addEmployeeJS.js" var="especificJs"/>-

    </head>
    <body>
        <%@include file="/WEB-INF/views/jsp/comun/layerStructureBegin.jsp"%>

        <f:form role="form" method="post" commandName="employee"  class="form-horizontal" id="addOffice-form">
            <fieldset id="emData">
                <legend>Employee Data</legend>
                <div class="form-group form-group-sm">
                    <label class="col-sm-2 control-label">Name</label>
                    <div class="col-sm-6">
                        <f:input path="name" type="text" class="form-control" id="emName"/>
                    </div>

                    <label class="col-sm-1 control-label">DNI</label>
                    <div class="col-sm-3">
                        <f:input path="dni" type="text" class="form-control" id="emDni"/>
                    </div>
                </div>
                <div class="form-group form-group-sm">
                    <label class="col-sm-2 control-label">Telephone</label>
                    <div class="col-sm-6">
                        <f:input path="telephone" type="tel" class="form-control" id="emTelephone"/>
                    </div>

                    <label class="col-sm-1 control-label">Birthday</label>
                    <div class="col-sm-3">
                        <f:input path="birthday" type="date" class="form-control" id="embirthday"/>
                    </div>
                </div>
                <div class="form-group form-group-sm">
                    <label class="col-sm-2 control-label">City</label>
                    <div class="col-sm-6">
                        <f:input path="address.city" type="text" class="form-control" id="emCity"/>
                    </div>

                    <label class="col-sm-1 control-label">House Number</label>
                    <div class="col-sm-3">
                        <f:input path="address.number" type="text" class="form-control" id="emNumber"/>
                    </div>
                </div>
                <div class="form-group form-group-sm">
                    <label class="col-sm-2 control-label">Street</label>
                    <div class="col-sm-6">
                        <f:input path="address.street" type="text" class="form-control" id="emStreet"/>
                    </div>

                    <label class="col-sm-1 control-label">Date in</label>
                    <div class="col-sm-3">
                        <f:input path="date_in" type="date" class="form-control" id="emInDate"/>
                    </div>
                </div>
                <div class="form-group form-group-sm">
                    <label class="col-sm-2 control-label">Job</label>
                    <div class="col-sm-6">
                        <f:input path="job" type="text" class="form-control" id="emJob"/>
                    </div>

                    <label class="col-sm-1 control-label">Salary</label>
                    <div class="col-sm-3">
                        <f:input path="salary" type="number" class="form-control" id="emSalary"/>
                    </div>
                </div>
                <div class="form-group form-group-sm">
                    <label class="col-sm-2 control-label">Office</label>
                    <div class="col-sm-6">
                        <f:select path="office.id" itemValue="id" itemLabel="name" items="${offices}" class="form-control" id="emOffice"/>
                    </div>
                </div>
                <div class="form-group form-group-sm">
                    <label class="control-label col-sm-2">Is administrative</label>
                    <div class="col-sm-1">
                        <f:checkbox path="isAdmin" id="emAdmin"/>
                    </div>

                    <label class="col-sm-2 control-label">Write Speed</label>
                    <div class="col-sm-3">
                        <%--<f:input path="speed_write" type="text" class="form-control" id="emSpeed" disabled="true"/>--%>
                        <input type="text" class="form-control" id="emSpeed" disabled="true"/>
                    </div>
                </div>
            </fieldset>

<!--            <fieldset>
                <%--<f:select path="supervisor.id" itemValue="id" itemLabel="name" items="${supervisors}" class="form-control" id="emSupervisor"/>--%>
            </fieldset>-->

            <fieldset id="fmData">
                <legend>Family Employee Data</legend>
                <div class="form-group form-group-sm">
                    <label class='col-sm-2 control-label'>Name:</label>
                    <div class="col-sm-6">
                        <f:input class=" form-control" path="familiar.name" type="text" id="fmName"/> 
                    </div>

                    <label class='col-sm-1 control-label'>Relation:</label>
                    <div class="col-sm-3">
                        <f:input class="form-control" path="familiar.relation" type="text" id="fmRelation"/> 
                    </div>
                </div>
                <div class="form-group form-group-sm">
                    <label class='col-sm-2 control-label'>Telephone:</label>
                    <div class="col-sm-6">
                        <f:input class=" form-control" path="familiar.telephone" type="text" id="fmTel"/> 
                    </div>

                    <label class='col-sm-1 control-label'>City:</label>
                    <div class="col-sm-3">
                        <f:input class="form-control" path="familiar.address.city" type="text" id="fmCity"/> 
                    </div>
                </div>
                <div class="form-group form-group-sm">
                    <label class='col-sm-2 control-label'>Street:</label>
                    <div class="col-sm-6">
                        <f:input class=" form-control" path="familiar.address.street" type="text" id="fmStreet"/> 
                    </div>

                    <label class='col-sm-1 control-label'>Number:</label>
                    <div class="col-sm-3">
                        <f:input class="form-control" path="familiar.address.number" type="text" id="fmNumber"/> 
                    </div>
                </div>
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

