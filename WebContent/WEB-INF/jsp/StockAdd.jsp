<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Stock ${ param.action == 'uiAdd' ? 'Add' : 'Edit' }</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body style="padding: 20px 10%">
	<h1>stock</h1>
	<h3 style="color: darkgray">[Info] ${ param.action == 'uiAdd' ? 'Add' : 'Edit' } Stock...</h3>
	<form method="post" action="./stock">
		<input type="hidden" name="action" value="${ param.action == 'uiAdd' ? 'add' : 'edit' }">
		<input type="hidden" name="id" value="${ stock.getId() }"> <!-- 設定在 request parameter 中 -->
		<div class="form-group">
			<label>Id</label>
			<input type="text" class="form-control" name="id" placeholder="default" disabled
				value="${ param.action == 'uiAdd' ? '' : stock.getId() }">
		</div>
		<div class="form-group">
			<label>Code</label>
			<input type="text" class="form-control" name="code" placeholder="Code"
					value="${ param.action == 'uiAdd' ? '' : stock.getCode() }">
		</div>
		<div class="form-group">
			<label>Name</label>
			<input type="text" class="form-control" name="name" placeholder="Name"
					value="${ param.action == 'uiAdd' ? '' : stock.getName() }">
		</div>
		<button type="button" class="btn btn-outline-dark" onclick="doCancel()">Cancel</button>
		<button type="submit" class="btn btn-primary" onclick="return doConfirm()">
			${ param.action == 'uiAdd' ? 'Finish' : 'Update' }</button>
	</form>
	<script>
		function doConfirm() {
			if (confirm('是否要' + "${ param.action == 'uiAdd' ? '新增' : '更新' }" + '股票?')) {
				return true
			}
			return false
		}
		function doCancel() {
			if (confirm('是否要取消' + "${ param.action == 'uiAdd' ? '新增' : '更新' }" + '股票?')) {
				window.location.href = './stock?action=search'
			}
		}
	</script>
</body>
</html>