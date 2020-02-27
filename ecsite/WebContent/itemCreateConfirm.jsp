<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>itemCreateConfirm画面</title>
</head>
<body>
	<div id="header"></div>
	<div id="main">
		<div id="top">
			<p>商品登録</p>
		</div>
		<div>
			<s:form action="ItemCreateCompleteAction" method="post">
				<tr>
					<td>商品名</td>
					<td><s:property value="session.itemName" /></td>
				</tr>
				<tr>
					<td>価格</td>
					<td><s:property value="session.itemPrice" /></td>
				<tr>
				<tr>
					<td>在庫数</td>
					<td><s:property value="session.itemStock" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="完了"
						onclick="submitAction('ItemCreateCompleteAction')" /></td>
				</tr>
			</s:form>
		</div>
		<div>
			<p>
				前画面に戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a>
			</p>
			<p>
				マイページは<a href='<s:url action="MyPageAction" />'>こちら</a>
			</p>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>