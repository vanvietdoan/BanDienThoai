<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.BEAN.CategoryBean" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cập Nhật Thông Tin Vaccin</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h1 {
            color: #333;
            text-align: center;
            padding: 20px;
            background-color: #4CAF50;
            color: white;
            margin: 0;
        }

        form {
            width: 50%;
            margin: 20px auto;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            box-sizing: border-box;
        }

        label {
            display: block;
            margin: 10px 0;
            color: #333;
        }

        input[type="text"],
        input[type="number"],
        textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Cập Nhật Thông Tin Danh Mục</h1>

    <c:if test="${not empty category}">
        <form action="/BanDienThoai/CategoryServlet" method="post">
            <label for="ID">Mã danh mục:</label>
            <input type="number" name="ID"  value="${category.getCategoryId()}" required readonly><br>

            <label for="Name">Tên Danh Mục:</label>
            <input type="text"  name="Name" value="${category.getName()}" required><br>

 
            <input type="hidden" name="action" value="updateCategory">
            <input type="submit" value="Update">
        </form>
    </c:if>
</body>
</html>
