<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<jsp:include page="./include/head.jsp"></jsp:include>
	<title>Investor ${ param.action == 'uiAdd' ? 'Add' : 'Edit' }</title>
</head>
<body style="padding: 20px 10%">
	<jsp:include page="./include/menu.jsp"></jsp:include>
	<h1>investor</h1>
	<h3 style="color: darkgray">[Info] ${ param.action == 'uiAdd' ? 'Add' : 'Edit' } Investor...</h3>
	<form method="post" action="./investor" class="was-validated">
		<input type="hidden" name="action" value="${ param.action == 'uiAdd' ? 'add' : 'edit' }">
		<input type="hidden" name="id" value="${ investor.getId() }"> <!-- 設定在 request parameter 中 -->
		<div class="form-group">
			<label>Id</label>
			<input type="text" class="form-control" name="id" placeholder="default" disabled
				value="${ param.action == 'uiAdd' ? '' : investor.getId() }">
		</div>
		<div class="form-group">
			<label>Name</label>
			<input type="text" class="form-control custom-select" name="name" placeholder="Name" required
					value="${ param.action == 'uiAdd' ? '' : investor.getName() }">
		</div>
		<div class="form-group">
			<label>Unit</label>
			<input type="text" class="form-control custom-select" name="unit" placeholder="Unit" required
					value="${ param.action == 'uiAdd' ? '' : investor.getUnit() }">
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
			if (confirm('是否要' + "${ param.action == 'uiAdd' ? '新增' : '更新' }" + '投資人?')) {
				return true
			}
			return false
		}
		function doCancel() {
			if (confirm('是否要取消' + "${ param.action == 'uiAdd' ? '新增' : '更新' }" + '投資人?')) {
				window.location.href = './investor?action=search'
			}
		}
	</script>
	<jsp:include page="./include/foot.jsp"></jsp:include>
</body>
</html>