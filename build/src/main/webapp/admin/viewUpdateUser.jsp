<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.BEAN.UserBean" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update User</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        h2 {
            color: #333;
        }

        form {
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin: 10px 0;
        }

        input, select {
            margin: 5px 0;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

    <h2>Update User</h2>
    <c:if test="${not empty user}">
        <form action="/BanDienThoai/UserServlet" method="post">
            <label for="userID">Mã Người Dùng:</label>
            <input type="number" name="userID" value="${user.userId}" required readonly>
            <br>
            <label for="username">Tên Người Dùng:</label>
            <input type="text" name="username" value="${user.username}" required>
            <br>
            <label for="email">Email:</label>
            <input type="email" name="email" value="${user.email}" required>
          
            <label for="address">Địa Chỉ:</label>
            <input type="text" name="address" value="${user.address}">
            <br>
            <label for="phoneNumber">Số Điện Thoại:</label>
            <input type="text" name="phoneNumber" value="${user.phoneNumber}">
            <br>
            <label for="role">Quyền:</label>
            <select name="role" required>
                <option value="admin" ${user.role eq 'admin' ? 'selected' : ''}>Quản trị viên</option>
                <option value="user" ${user.role eq 'user' ? 'selected' : ''}>Người dùng</option>
            </select>
            <br>
            <input type="submit" name="action" value="updateUser">
        </form>
    </c:if>
</body>
</html>
