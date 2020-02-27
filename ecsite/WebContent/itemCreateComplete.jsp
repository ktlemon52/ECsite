<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>UserCreateComplete画面</title>
</head>
<body>
	<div id="header"></div>
	<div id="main">
		<div id="top">
			<p>ItemCreateComplete</p>
		</div>
		<div>
			<h3>商品登録が完了しました。</h3>
		</div>
		<div>
			<a href='<s:url action="AdminAction" />'>管理者画面へ</a> <a
				href='<s:url action="ItemCreateAction" />'>商品登録画面へ</a> ログイン <a
				href='<s:url action="HomeAction" />'>こちら</a>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>