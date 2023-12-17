<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome Page</title>
</head>
<body>
    <h2>Welcome</h2>
    
    <c:if test="${not empty us}">
        <table>
            <tr>
                <td>Username:</td>
                <td>${us.username}</td>
            </tr>
            <!-- Add other user details as needed -->
        </table>
    </c:if>

</body>
</html>
