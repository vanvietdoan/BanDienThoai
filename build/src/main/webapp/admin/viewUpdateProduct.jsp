<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.BEAN.CategoryBean" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chỉnh sửa sản phẩm</title>

    <!-- Thêm phần CSS -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        form {
            width: 70%;
            margin: auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        input, select {
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            box-sizing: border-box;
        }

        input[type="checkbox"] {
            margin-top: 8px;
        }

        img {
            display: block;
            margin-top: 8px;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <c:if test="${not empty product}">
        <form action="/BanDienThoai/ProductServlet" method="post">
    <br>
    <input type="hidden" name="action" value="updateProduct">
    <input type="hidden" name="productID" value="${product.productId}" readonly>

    <label for="productName">Tên Sản Phẩm:</label>
    <input type="text" name="productName" value="${product.name}" required>

    <label for="description">Mô Tả:</label>
    <input type="text" name="description" value="${product.description}" required>

    <label for="price">Giá Gốc:</label>
    <input type="number" name="price" value="${product.priceOriginal}" required>

    <label for="discountPrice">Giá Khuyến Mại:</label>
    <input type="number" name="discountPrice" value="${product.priceSale}">

    <label for="manufacturer">Nhà Sản Xuất:</label>
    <input type="text" name="manufacturer" value="${product.manufacturer}">
    <br>

    <label for="topTrending">Top Trending:</label>
    <input type="number" name="topTrending" value="${product.toptrending}">

    <label for="hot">Hot:</label>
    <input type="checkbox" name="hot" ${product.hot ? 'checked' : ''}>

    <label for="onSale">On Sale:</label>
    <input type="checkbox" name="onSale" ${product.onSale ? 'checked' : ''}>

    <label for="bestSeller">Best Seller:</label>
    <input type="checkbox" name="bestSeller" ${product.bestSeller ? 'checked' : ''}>

    <label for="topViewed">Top Viewed:</label>
    <input type="checkbox" name="topViewed" ${product.topViewed ? 'checked' : ''}>
    <br>

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
	<label for="previewImage">Ảnh Sản Phẩm</label>
<img id="previewImage" src="images/${product.imageUrl}" alt="Ảnh xem trước" style="width: 70px; height: 150px;">

<label for="newReplacementImageInput">Ảnh Thay Thế Mới</label>
<input type="file" id="newReplacementImageInput" name="newReplacementImage" accept="image/*" onchange="previewNewReplacementImage(this)">
<img id="newReplacementImage" src="" alt="Ảnh thay thế mới xem trước" style="width: 70px; height: 150px; display: none;">
<br>

    <input type="submit" value="Cập Nhật">
</form>

    </c:if><script>
function previewNewReplacementImage(input) {
    var previewImage = document.getElementById("previewImage");
    var newReplacementImage = document.getElementById("newReplacementImage");

    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            newReplacementImage.src = e.target.result;
            newReplacementImage.style.display = "block";

            // Ẩn ảnh cũ
            previewImage.style.display = "none";
        };

        reader.readAsDataURL(input.files[0]);
    }
}
</script>
</body>
</html>
