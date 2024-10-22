<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>danh sach nha cung cap</title>
</head>
<body>


	<table>
		<thead>
			<tr>
				<td>id</td>

				<td>ten</td>

				<td>dia chi</td>

				<td>sdt</td>
			</tr>


		</thead>

		<tbody>
		<c:forEach items="${listncc }" var="listncc">
		
			<tr>
				<td>${listncc.mancc }</td>

				<td>${listncc.tenncc }</td>

				<td>${listncc.diachi }</td>

				<td>${listncc.sodienthoai }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>