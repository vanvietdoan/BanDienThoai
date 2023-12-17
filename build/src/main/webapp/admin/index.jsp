<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <title>Your Page Title</title>
</head>
<body>
    <jsp:include page="/admin/NameAccount.jsp" />
    <jsp:include page="/admin/list.jsp" />
   <iframe style="border: none; overflow: hidden;" src="/BanDienThoai/admin/home.jsp" name="homePage" width="100%" height="500"></iframe>

</body>
</html>
