
<c:if test="${msg != null}">
    <c:choose>
        <c:when test="${msg.type == 0}">
            <c:set var="cssMessaje" scope="page" value="alert alert-danger"/>
            <c:set var="headerMessaje" scope="page" value="¡Error!"/>   
        </c:when>
        <c:when test="${msg.type == 1}">
            <c:set var="cssMessaje" scope="page" value="alert alert-warning"/>
            <c:set var="headerMessaje" scope="page" value="¡Warning!"/>
        </c:when>
        <c:when test="${msg.type == 2}">
            <c:set var="cssMessaje" scope="page" value="alert alert-info"/>
            <c:set var="headerMessaje" scope="page" value="¡Ok!"/>
        </c:when>
    </c:choose>

        <div class="${cssMessaje}" id="alertaMensaje">
            <strong>${headerMessaje}</strong> ${msg.message}
        </div>

</c:if>