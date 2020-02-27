<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>DeleteConfirm画面</title>
<script type="text/javascript">
	function submitAction(url) {
		$('form').attr('action', url);
		$('form').submit();
	}
</script>
</head>
<body>
	<div id="header">
		<div id="pr"></div>
	</div>
	<div id="main">
		<div id="top">
			<p>削除確認</p>
		</div>
		<div>
			<h3>すべての商品を削除します。よろしいですか?</h3>
			<s:form action="ItemListDeleteCompleteAction">
				<s:submit value="OK" />
			</s:form>

			<s:form action="ItemListAction">
				<s:submit value="キャンセル" />
			</s:form>

		</div>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>
</body>
</html>