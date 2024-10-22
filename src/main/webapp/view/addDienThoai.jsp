<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm sản phẩm</title>
<!-- Thay đổi tiêu đề -->
</head>
<body>


	<c:if test="${not empty error }">
		<div>${error }</div>
	</c:if>
	<form action="dienthoai" method="post">
		<!-- Thêm enctype -->
		<div>
			<label>Tên</label> <input type="text" name="ten">
		</div>
		<div>
			<label>Năm</label> <input type="text" name="nam">
		</div>
		<div>
			<label>Cấu hình</label> <input type="text" name="cauhinh">
			<!-- Thay đổi tên thành không có khoảng trắng -->
		</div>
		<div>
			<label>Mã nhà cung cấp</label> <select name="mancc">
				<c:forEach var="ncc" items="${ncc}">
					<option value="${ncc.mancc}">${ncc.mancc}</option>
				</c:forEach>
			</select>
		</div>

		<input type="submit" value="Submit">
	</form>
</body>
</html>
