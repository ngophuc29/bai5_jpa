<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách điện thoại</title>
</head>
<body>

    <!-- Form tìm kiếm -->
    <form action="dienthoai" method="get">
        <input type="text" name="searchTerm" placeholder="Nhập tên điện thoại để tìm kiếm">
        <input type="submit" value="Tìm kiếm">
    </form>

    <c:if test="${not empty error}">
        <div>${error}</div>
    </c:if>

    <table border="">
        <thead>
            <tr>
                <td>id</td>
                <td>ten</td>
                <td>namsx</td>
                <td>cauhinh</td>
                <td>mancc</td>
                <td>action</td>
            </tr>
        </thead>
        
        <tbody>
            <c:forEach var="listUser" items="${listUser}">
                <tr>
                    <td>${listUser.maDT}</td>
                    <td>${listUser.tendt}</td>
                    <td>${listUser.namsx}</td>
                    <td>${listUser.cauhinh}</td>
                    <td>${listUser.nhacungcap.mancc}</td>
                    <td>
                        <a href="dienthoai?action=update&madt=${listUser.maDT}">Cập nhật</a>
                        <a href="dienthoai?action=xoa&madt=${listUser.maDT}">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <a href="dienthoai?action=add">Thêm điện thoại</a>
</body>
</html>
