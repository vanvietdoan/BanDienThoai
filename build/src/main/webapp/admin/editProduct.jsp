<%@page import="Model.BEAN.CategoryBean"%>
<%@page import="Model.BEAN.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Chỉnh sửa sản phẩm</title>
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

        img {
            max-width: 100px;
            max-height: 100px;
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
    <h2>Chỉnh sửa sản phẩm</h2>
   <form action="/BanDienThoai/ProductServlet" method="post" >
    <br>
    <label for="productID">Mã Sản Phẩm:</label>
    <input type="number" name="productID" required>
     <label for="productName">Tên Sản Phẩm:</label>
    <input type="text" name="productName" required>
    
    
   
    <!-- Assuming there is only one category for each product -->
    <label for="categoryID">Thương hiệu:</label>
    
    <select name="categoryID" required>
   
        <% 
            ArrayList<CategoryBean> ctlist = (ArrayList<CategoryBean>) request.getAttribute("categories");

            for (CategoryBean ct : ctlist) {
        %>
        <option value="<%= ct.getCategoryId() %>"><%= ct.getName() %></option>
        <% 
            }
        %>
    </select>
     <br>
    
   
    
    <label for="description">Mô Tả:</label>
    <input type="text" name="description" required>
    
    <label for="price">Giá Gốc:</label>
    <input type="number" name="price" required>
    
    <label for="discountPrice">Giá Khuyến Mại:</label>
    <input type="number" name="discountPrice">
    
    <label for="manufacturer">Nhà Sản Xuất:</label>
    <input type="text" name="manufacturer">
    <br>
   
    <label for="topTrending">Top Trending:</label>
    <input type="number" name="topTrending">
    
    <label for="hot">Hot:</label>
    <input type="checkbox" name="hot">
    
    <label for="onSale">On Sale:</label>
    <input type="checkbox" name="onSale">
    
    <label for="bestSeller">Best Seller:</label>
    <input type="checkbox" name="bestSeller">
    
    <label for="topViewed">Top Viewed:</label>
    <input type="checkbox" name="topViewed">
  
   <br>
	<label for="imageURL">URL Hình Ảnh:</label>
	<input type="file" id="imageURL" name="imageURL" accept="image/*">
	<img id="previewImage" src="#" alt="Ảnh xem trước">

    <br>
    <input type="submit" name="action" value="InsertProduct">
</form>
	
    
    
    <table border="2">
        <tr>
            <th>Mã Sản Phẩm</th>
            <th>Tên Sản Phẩm</th>
             <th>Thương hiệu</th>
            <th>Mô tả</th>
            <th>Giá Gốc</th>
            <th>Giá Khuyến Mại</th>
            <th>Nhà Sản Xuất</th>
            <th>URL Hình Ảnh</th>
            <th>Top Trending</th>
            <th>Hot</th>
            <th>On Sale</th>
            <th>Best Seller</th>
            <th>Top Viewed</th>
            <th>Sửa</th>
            <th>Xóa</th>
        </tr>
        <% 
            ArrayList<ProductBean> productList = (ArrayList<ProductBean>) request.getAttribute("listProduct");

            for (ProductBean product : productList) {
        %>
        <tr>
            <td><%= product.getProductId() %></td>
            <td><%= product.getName() %></td>
             <td><%= product.getCategoryName() %></td>
            <td><%= product.getDescription() %></td>
            <td><%= product.getPriceOriginal() %></td>
            <td><%= product.getPriceSale() %></td>
            <td><%= product.getManufacturer() %></td>
            <td><img src="images/<%= product.getImageUrl() %>" style="width: 70px; height: 150px;" alt="Ảnh sản phẩm"></td>
        	<td><%= product.getToptrending() %></td>
          
			<td><%= product.isHot() ? "&#x2713;" : "X" %></td>
			<td><%= product.isOnSale() ? "&#x2713;" : "X" %></td>
			<td><%= product.isBestSeller() ? "&#x2713;" : "X" %></td>
			<td><%= product.isTopViewed() ? "&#x2713;" : "X" %></td>

            <td><a href="/BanDienThoai/ProductServlet?stdUpdateProduct=<%=product.getProductId() %>">Sửa</a></td>
            <td><a href="/BanDienThoai/ProductServlet?stdDeleteProduct=<%=product.getProductId() %>">Xóa</a></td>
        </tr>
        <% 
            }
        %>
    </table>
    
   <script>
    document.getElementById('imageURL').addEventListener('change', function (event) {
        var preview = document.getElementById('previewImage');
        var file = event.target.files[0];

        if (file) {
            var reader = new FileReader();

            reader.onload = function (e) {
                preview.src = e.target.result;
                // Đặt kích thước hiển thị bằng CSS
                preview.style.width = "70px";
                preview.style.height = "150px";
            };

            reader.readAsDataURL(file);
        }
    });
</script>


    <br>
    <p><a href="">Trang chủ</a></p>
</body>
</html>
