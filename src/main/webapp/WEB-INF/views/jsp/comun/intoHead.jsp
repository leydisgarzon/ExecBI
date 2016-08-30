
        <spring:url value="/" var="home"/>
        <spring:url value="/resources/core/css/bootstrap.min.css" var="cssBootstrap"/>
        <spring:url value="/resources/core/css/layerCss.css" var="cssLayers"/>
        <spring:url value="/resources/core/js/bootstrap.min.js" var="jsBootstrap"/>
        <spring:url value="/resources/core/js/jquery-3.0.0.min.js" var="jsJQuery"/>
        <spring:url value="/resources/core/js/jquery.validate.min.js" var="jsJQueryValidator"/>
        <spring:url value="/resources/core/js/localization/messages_es.min.js" var="langMessages"/>
        <spring:url value="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/additional-methods.min.js" var="additionalJQueryValidator"/>
        <link href="${cssBootstrap}" rel="stylesheet" />
        <link href="${cssLayers}" rel="stylesheet" />
        <script src="${jsJQuery}"></script>
        <script src="${jsBootstrap}"></script>
        <script src="${jsJQueryValidator}"></script>
        <script src="${langMessages}"></script>
        <script src="${additionalJQueryValidator}"></script>
