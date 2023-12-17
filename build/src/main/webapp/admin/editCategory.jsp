<%@page import="Model.BEAN.CategoryBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Chỉnh sửa danh mục</title>
    <style>
		        body {
		    font-family: 'Arial', sans-serif;
		    background-color: #f4f4f4;
		    margin: 0;
		    padding: 0;
		}
		
		h2 {
		    color: #333;
		    text-align: center;
		    padding: 20px;
		    background-color: #4CAF50;
		    color: white;
		    margin: 0;
		}
		
		table {
		    width: 80%;
		    margin: 20px auto;
		    background-color: #fff;
		    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
		    border-collapse: collapse;
		}
		
		th, td {
		    padding: 15px;
		    text-align: left;
		    border-bottom: 1px solid #ddd;
		}
		
		th {
		    background-color: #4CAF50;
		    color: white;
		}
		
		tr:hover {
		    background-color: #f5f5f5;
		}
		
		a {
		    text-decoration: none;
		    color: #0066cc;
		}
		
		a:hover {
		    color: #004080;
		    font-weight: bold;
		}
		button {
		    padding: 10px 20px;
		    background-color: #4CAF50;
		    color: white;
		    border: none;
		    border-radius: 5px;
		    cursor: pointer;
		}
		
		button:hover {
		    background-color: #45a049;
		}
		  input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 15px;
            cursor: pointer;
            border-radius: 2px;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

    </style>
</head>
<body>
    <h2>Chỉnh sửa danh mục</h2>
     <form action="/BanDienThoai/CategoryServlet" method="post">
       
		<br>
        <label for="categoryID">Mã Danh Mục:</label>
        <input type="number"  name="categoryID" required>
        <br>
        <label for="categoryName">Tên Danh Mục:</label>
        <input type="text"  name="categoryName" required>
        
		<input type="submit" name="action" value="InsertCategory">
       
    </form>
    
	
	
    <table border="1">
        <tr>
            <th>Mã Danh Mục</th>
            <th>Tên Danh Mục</th>
            <th>Sửa</th>
            <th>Xóa</th>
        </tr>
        <% 
            ArrayList<CategoryBean> categoryList = (ArrayList<CategoryBean>) request.getAttribute("categories");

            for (CategoryBean ct : categoryList) {
        %>
        <tr>
            <td><%= ct.getCategoryId() %></td>
            <td><%= ct.getName() %></td>
            <td><a href="/BanDienThoai/CategoryServlet?stdUpdateCategory=<%=ct.getCategoryId() %>">Sửa</a></td>
            <td><a href="/BanDienThoai/CategoryServlet?stdDeleteCategory=<%=ct.getCategoryId() %>">Xóa</a></td>
        </tr>
        <% 
            }
        %>
    </table>

    <br>
    <p><a>Trang chủ</a></p>
</body>
</html>
