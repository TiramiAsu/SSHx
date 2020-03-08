<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Fund Management</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body style="padding: 20px 10%">
	<jsp:include page="./list.jsp"></jsp:include>
	<h1>fund</h1>
	<h3 style="color: darkgray">[Info] ${ msg }</h3>
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Desc</th>
				<th>Stocks</th>
				<th>Operate</th>
			</tr>
			<tr>
				<th></th>
				<th>
					<input type="text" class="form-control" name="name" value="${ name }">
				</th>
				<th></th>
				<th></th>
				<th>
					<button type="button" class="btn btn-primary"
						onclick="location.href='./fund?action=uiAdd'">Add</button>
					<button type="button" class="btn btn-outline-info"
						onclick="doSearch()">Search</button>
				</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${fundList != null}">
				<c:forEach var="fund" items="${ fundList }">
					<tr>
						<td>${ fund.getId() }</td>
						<td>${ fund.getName() }</td>
						<td>${ fund.getDesc() }</td>
						<td>
							<c:forEach var="stock" items="${ fund.getStocks() }">
								<span>${ stock.getName() } </span>
							</c:forEach>
						</td>
						<td>
							<button type="button" class="btn btn-outline-primary"
								onclick="location.href='./fund?action=uiEdit&id=' + '${ fund.getId() }'">Edit</button>
							<button type="button" class="btn btn-outline-danger"
								onclick="doRemove('${ fund.getId()}')">Remove</button>
						</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${fundList == null}">
				<tr class="text-center">
					<td colspan="4">
						<h3>~ 查無資料 ~</h3>
					</td>
				</tr>
			</c:if>
		</tbody>
	</table>
	<script>
		/*
		// 頁面載入完, 執行方法檢查是否有資訊
		window.onload = function () {
			if ('${ msg }' !== '') {
				alert('${ msg }')
			}
		}
		*/
		function doRemove (id) {
			if (confirm('是否要刪除 id ' + id)) {
				window.location.href = './fund?action=remove&id=' + id
			}
		}
		function doSearch () {
			var name = document.getElementsByName('name')
			if (name !== '') {
				window.location.href = './fund?action=search&name=' + name[0].value
			} else {
				window.location.href = './fund?action=search'
			}
		}
	</script>
</body>
</html>