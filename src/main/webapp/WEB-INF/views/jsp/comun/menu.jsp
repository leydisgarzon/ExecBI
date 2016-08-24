
<aside class="navbar navbar-default menu" style="width: 15%">
    <ul class="nav">
        <li class="dropdown">
            <a id="officeOptions" data-toggle="dropdown" class="dropdown-toggle" href="#">Gestionar Office <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href='<spring:url value="/office/add"/>'>Insert Office</a></li>
                <li><a href='<spring:url value="/office/edit"/>'>Edit Office</a></li>
                <li><a href='<spring:url value="/office/list"/>'>List Office</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a id="managerOptions" data-toggle="dropdown" class="dropdown-toggle" href="#">Gestionar Manager <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href='<spring:url value="/manager/add"/>'>Insert Manager</a></li>
                <li><a href='<spring:url value="/manager/edit"/>'>Edit Manager</a></li>
                <li><a href='<spring:url value="/manager/list"/>'>List Manager</a></li>
            </ul>
        </li>
    </ul>
</aside>
