<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<jsp:include page="./include/head.jsp"></jsp:include>
	<title>Trader Management</title>
</head>
<body style="padding: 20px 10%">
	<jsp:include page="./include/menu.jsp"></jsp:include>
	<h1>trader</h1>
	<h3 style="color: darkgray">[Info] ${ msg }</h3>
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Fund</th>
				<th>Operate</th>
			</tr>
			<tr>
				<th></th>
				<th>
					<input type="text" class="form-control" name="name" value="${ name }">
				</th>
				<th></th>
				<th>
					<button type="button" class="btn btn-primary"
						onclick="location.href='./trader?action=uiAdd'">Add</button>
					<button type="button" class="btn btn-outline-info"
						onclick="doSearch()">Search</button>
				</th>
			</tr>
		</thead>
		<tbody>
		<c:if test="${traderList != null}">
			<c:forEach var="trader" items="${ traderList }">
				<tr>
					<td>${ trader.getId() }</td>
					<td>${ trader.getName() }</td>
					<td>${ trader.getFund().getName() }</td>
					<td>
						<button type="button" class="btn btn-outline-primary"
							onclick="location.href='./trader?action=uiEdit&id=' + '${ trader.getId() }'">Edit</button>
						<button type="button" class="btn btn-outline-danger"
							onclick="doRemove('${ trader.getId()}')">Remove</button>
					</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${traderList == null}">
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
				window.location.href = './trader?action=remove&id=' + id
			}
		}
		function doSearch () {
			var name = document.getElementsByName('name')
			if (name !== '') {
				window.location.href = './trader?action=search&name=' + name[0].value
			} else {
				window.location.href = './trader?action=search'
			}
		}
	</script>
	<jsp:include page="./include/foot.jsp"></jsp:include>
</body>
</html>