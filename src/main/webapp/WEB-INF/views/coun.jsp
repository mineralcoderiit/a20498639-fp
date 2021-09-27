<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create a New Country</title>
</head>
<body>

<c:if test="${not empty requestScope.violations}">
    <p>Here were the issues with your data input.  We care about data integrity.  You must fix them.  This is the way.</p>
    <ol>
        <c:forEach var="violation" items="${requestScope.violations}">
            <li>There is a problem with ${violation.propertyPath}.  The error message is: ${violation.message}</li>
        </c:forEach>
    </ol>
</c:if>

<form action="/a20498639-fp/coun" method="post">
    <div>
        <label for="countryId">Country ID</label>
        <input value="${requestScope.country.countryId}"id="countryId" name="countryId" type="text" />
    </div>


    <div>
        <label for="countryName">Country Name</label>
        <input value="${requestScope.country.countryName}"id="countryName" name="countryName" type="text" />
    </div>


    <button type="submit">Submit the request</button>

</form>



</body>
</html>
