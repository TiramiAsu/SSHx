<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<jsp:include page="./include/head.jsp"></jsp:include>
	<title>Fund ${ param.action == 'uiAdd' ? 'Add' : 'Edit' }</title>
</head>
<body style="padding: 20px 10%">
	<jsp:include page="./include/menu.jsp"></jsp:include>
	<h1>fund</h1>
	<h3 style="color: darkgray">[Info] ${ param.action == 'uiAdd' ? 'Add' : 'Edit' } Fund...</h3>
	<form method="post" action="./fund">
		<input type="hidden" name="action" value="${ param.action == 'uiAdd' ? 'add' : 'edit' }">
		<input type="hidden" name="id" value="${ fund.getId() }"> <!-- 設定在 request parameter 中 -->
		<div class="form-group">
			<label>Id</label>
			<input type="text" class="form-control" name="id" placeholder="default" disabled
				value="${ param.action == 'uiAdd' ? '' : fund.getId() }">
		</div>
		<div class="form-group">
			<label>Name</label>
			<input type="text" class="form-control" name="name" placeholder="Name"
					value="${ param.action == 'uiAdd' ? '' : fund.getName() }">
		</div>
		<div class="form-group">
			<label>Desc</label>
			<input type="text" class="form-control" name="desc" placeholder="Desc"
					value="${ param.action == 'uiAdd' ? '' : fund.getDesc() }">
		</div>
		<div class="form-group">
			<label>FundNet</label>
			<c:if test="${ param.action == 'uiAdd' ? true : false }">
				<input type="text" class="form-control" name="fundNet" placeholder="FundNet"
					value="${ param.action == 'uiAdd' ? '' : fund.getFundNet().getValue() }">
			</c:if>
			<c:if test="${ param.action == 'uiAdd' ? false : true }">
				<input type="text" class="form-control" name="fundNet" placeholder="FundNet" disabled
					value="${ param.action == 'uiAdd' ? '' : fund.getFundNet().getValue() }">
			</c:if>
		</div>
		<div class="form-group">
			<label>Stocks</label>
			<div id="vueTransfer"></div>
		</div>
		<button type="button" class="btn btn-outline-dark" onclick="doCancel()">Cancel</button>
		<button type="submit" class="btn btn-primary" onclick="return doConfirm()">
			${ param.action == 'uiAdd' ? 'Finish' : 'Update' }</button>
	</form>
	<script>
		function doConfirm() {
			if (confirm('是否要' + "${ param.action == 'uiAdd' ? '新增' : '更新' }" + '基金?')) {
				return true
			}
			return false
		}
		function doCancel() {
			if (confirm('是否要取消' + "${ param.action == 'uiAdd' ? '新增' : '更新' }" + '基金?')) {
				window.location.href = './fund?action=search'
			}
		}
	</script>
	<script src="https://unpkg.com/vue/dist/vue.js"></script>
	<script type="text/javascript" src="https://unpkg.com/element-ui@2.4.0/lib/index.js"></script>
	<script type="text/javascript" src="https://unpkg.com/element-ui@2.4.0/lib/umd/locale/zh-TW.js"></script>
	<script>
		var stocks = '${ stockList }'
		var choose = '${ chooseList }'
		var template = `
			<div>
				<el-transfer
					:titles="['可選擇', '已選擇']"
					filterable
					filter-placeholder="請輸入股票名稱"
					:data="stockList"
					:props="{
						key: 'item'
					}"
					v-model="chooseList">
				</el-transfer>
				<input type="hidden" name="stockIds" v-model="getStockIdList()">
			</div>
		`
		new Vue({
			el: '#vueTransfer',
			template,
			data: {
				stockList: [],
				chooseList: []
			},
			mounted() {
				this.initList(stocks, choose)
			},
			updated() {
				console.log('choose stocks: ', this.chooseList)
			},
			methods: {
				initList(stocks, choose) {
					var leftArray = this.map2Array(stocks)
					leftArray.forEach(s => {
						this.stockList.push({
							key: s.split('=')[0],
							value: s.split('=')[1],
							item: s.split('=')[0] + '-' + s.split('=')[1]
						})
					})
					var rightString = this.map2Array(choose)
					rightString.forEach(s => {
						if (s) {
							this.chooseList.push(s.split('=')[0] + '-' + s.split('=')[1])
						}
					})
				},
				getStockIdList() {
					var self = this
					var stockIds = []
					self.chooseList.forEach(s => {
						stockIds.push(s.split('-')[0])
					})
					return stockIds
				},
				map2Array(str) {
					// console.log('str: ' + str)               // {3008=大立光, 1301=台塑, 1201=味全, 2454=聯發科, 2330=台積電}
					var data = str.substring(1, str.length - 1) // 3008=大立光, 1301=台塑, 1201=味全, 2454=聯發科, 2330=台積電             -> 去除 '{', '}'
					var arr = data.split(', ')                  // ["3008=大立光", "1301=台塑", "1201=味全", "2454=聯發科", "2330=台積電"] -> 切分成陣列
					return arr
				}
			}
		})
	</script>
	<jsp:include page="./include/foot.jsp"></jsp:include>
</body>
</html>