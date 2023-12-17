<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Danh mục</title>
    <style>
        ul {
            list-style: none;
            padding: 0;
            display: flex; /* Hiển thị các mục danh sách theo chiều ngang */
        }

        li {
            margin: 15px;
            cursor: pointer;
            color: blue;
        }

        body {
            background-color: lightgray;
        }
    </style>
</head>
<body>
    <ul>
        <li>
            <a href="/BanDienThoai/admin/home.jsp" target="homePage">Trang Chủ</a>
        </li>
        <li>
            <a href="/BanDienThoai/CategoryServlet?action=editCategory" target="homePage">Danh Mục</a>
        </li>
        <li>
            <a href="/BanDienThoai/ProductServlet?action=editProduct" target="homePage">Sản Phẩm</a> 
        </li>
        <li>
            <a href="/BanDienThoai/UserServlet?action=editUser" target="homePage">Tài Khoản</a> 
        </li>
        <li>
            <a href="" target="T3">Hóa đơn</a> 
        </li>
        <li>
            <a href="Login.jsp">Đăng Xuất</a> 
        </li>
    </ul>
</body>
</html>
