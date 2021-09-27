<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Country Confirmation Page</title>
</head>
<body>

<h1>Country ${requestScope.country.countryId} ${requestScope.country.countryName}</h1>
<ul>
    <li>${requestScope.country.countryId}</li>
    <li>${requestScope.country.countryName}</li>
    <li>${requestScope.country.lastUpdate}</li>
</ul>

</body>
</html>
