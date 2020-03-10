<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<jsp:include page="./include/head.jsp"></jsp:include>
	<title>Trader ${ param.action == 'uiAdd' ? 'Add' : 'Edit' }</title>
</head>
<body style="padding: 20px 10%">
	<jsp:include page="./include/menu.jsp"></jsp:include>
	<h1>trader</h1>
	<h3 style="color: darkgray">[Info] ${ param.action == 'uiAdd' ? 'Add' : 'Edit' } Trader...</h3>
	<form method="post" action="./trader" class="was-validated">
		<input type="hidden" name="action" value="${ param.action == 'uiAdd' ? 'add' : 'edit' }">
		<input type="hidden" name="id" value="${ trader.getId() }"> <!-- 設定在 request parameter 中 -->
		<div class="form-group">
			<label>Id</label>
			<input type="text" class="form-control" name="id" placeholder="default" disabled
				value="${ param.action == 'uiAdd' ? '' : trader.getId() }">
		</div>
		<div class="form-group">
			<label>Name</label>
			<input type="text" class="form-control custom-select" name="name" placeholder="Name" required
					value="${ param.action == 'uiAdd' ? '' : trader.getName() }">
		</div>
		<div class="form-group">
			<label>Fund</label>
			<select class="custom-select" name="fundName" required>
				<option value="">請選擇基金</option>
				<c:forEach var="fund" items="${ fundList }">
					<c:if test="${ param.action == 'uiAdd' ? true : false }">
						<option value="${ fund.getName() }">${ fund.getName() }</option>
					</c:if>
					<c:if test="${ param.action == 'uiAdd' ? false : true }">
						<option value="${ fund.getName() }" ${ (fundName == fund.getName()) ? 'selected' : '' }>
							${ fund.getName() }
						</option>
					</c:if>
				</c:forEach>
			</select>
			<div class="invalid-feedback">未選擇基金</div>
		</div>
		<button type="button" class="btn btn-outline-dark" onclick="doCancel()">Cancel</button>
		<button type="submit" class="btn btn-primary" onclick="return doConfirm()">
			${ param.action == 'uiAdd' ? 'Finish' : 'Update' }
		</button>
	</form>
	<script>
		function doConfirm() {
			if (confirm('是否要' + "${ param.action == 'uiAdd' ? '新增' : '更新' }" + '基金經理人?')) {
				return true
			}
			return false
		}
		function doCancel() {
			if (confirm('是否要取消' + "${ param.action == 'uiAdd' ? '新增' : '更新' }" + '基金經理人?')) {
				window.location.href = './trader?action=search'
			}
		}
	</script>
	<jsp:include page="./include/foot.jsp"></jsp:include>
</body>
</html>