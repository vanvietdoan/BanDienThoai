<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="Model.BEAN.UserBean"%>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Xem Tất Cả Người Dùng</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        h2 {
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table, th, td {
            border: 1px solid #333;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        a {
            text-decoration: none;
            color: #0066cc;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h2>Xem Tất Cả Người Dùng</h2>
    
    <form action="/BanDienThoai/UserServlet" method="post">
    <br>
    <label for="userID">Mã Người Dùng:</label>
    <input type="number" name="userID" required>
    <br>
    <label for="username">Tên Người Dùng:</label>
    <input type="text" name="username" required>
    <br>
    <label for="email">Email:</label>
    <input type="email" name="email" required>
    <br>
    <label for="password">Mật Khẩu:</label>
    <input type="password" name="password" required>
    <br>
    <label for="address">Địa Chỉ:</label>
    <input type="text" name="address">
    <br>
    <label for="phoneNumber">Số Điện Thoại:</label>
    <input type="text" name="phoneNumber">
    <br>
    <label for="role">Quyền:</label>
    <select name="role" required>
        <option value="admin">Quản trị viên</option>
        <option value="user">Người dùng</option>
    </select>
    <br>
    <input type="submit" name="action" value="InsertUser">
</form>
    
    <table border="1">
        <tr>
            <th>Mã Tài Khoản</th>
            <th>Tên Đăng Nhập</th>
            <th>Mail</th>
            <th>Mật Khẩu</th>
            <th>Địa Chỉ</th>
            <th>Số Điện Thoại</th>
            <th>Vai Trò</th>
            <th>Sủa</th>
            <th>Xóa</th>
        </tr>
        <% 
            ArrayList<UserBean> listUser = (ArrayList<UserBean>) request.getAttribute("listUser");

            for (UserBean user : listUser) {
        %>
        <tr>
            <td><%= user.getUserId() %></td>
            <td><%= user.getUsername() %></td>
            <td><%= user.getEmail() %></td>
            <td><a href="/BanDienThoai/UserServlet?stdResetPassWord=<%=user.getUserId() %>">Đặt Lại</a></td>
            <td><%= user.getAddress() %></td>
            <td><%= user.getPhoneNumber() %></td>
            <td><%= user.getRole() %></td>
            <td><a href="/BanDienThoai/UserServlet?stdUpdateUser=<%=user.getUserId() %>">Sửa</a></td>
            <td><a href="/BanDienThoai/UserServlet?stdDeleteUser=<%=user.getUserId() %>">Xóa</a></td>
        </tr>
        <% 
            }
        %>
    </table>
</body>
</html>
