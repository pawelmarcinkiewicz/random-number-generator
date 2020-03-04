<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Random Number Generator - Your generated number</title>
</head>
<body>
    <h1>Random Number Generator App</h2><br /><br />

    <h3>Your generated number is:
        <c:choose>
            <c:when test="${empty generatedNumber}">
                Error occurred during obtaining number. Please try again later.
            </c:when>
            <c:otherwise>
                ${generatedNumber}
            </c:otherwise>
        </c:choose>
    </h3>

    <form action="generateNumber" method="GET">
        Generate another number:
        <input type="submit" value="Generate!" />
    </form>

</body>
</html>