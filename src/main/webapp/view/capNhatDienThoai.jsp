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

	<form action="dienthoai?action=update" method="post">
		<!-- Thêm enctype -->
			<label>id</label> <input type="text" name="madt" value="${dtUpdate.maDT }">
		<div>
			<label>Tên</label> <input type="text" name="ten" value="${dtUpdate.tendt }">
		</div>
		<div>
			<label>Năm</label> <input type="text" name="nam" value="${dtUpdate.namsx }">
		</div>
		<div>
			<label>Cấu hình</label> <input type="text" name="cauhinh" value="${dtUpdate.cauhinh }">
			<!-- Thay đổi tên thành không có khoảng trắng -->
		</div>
		<div>
			<label>Mã nhà cung cấp</label> <select name="mancc">
				<c:forEach var="ncc" items="${ncc}">
					<option value="${ncc.mancc }"   <c:if test="${ncc.mancc == dtUpdate.nhacungcap.mancc}">selected</c:if>>${ncc.mancc}</option>
				</c:forEach>
			</select>
		</div>

		<input type="submit" value="Submit">
	</form>
</body>
</html>
