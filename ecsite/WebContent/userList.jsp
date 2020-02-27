<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>ユーザー情報画面</title>
</head>
<body>
	<div id="header"></div>
	<div id="main">
		<div id="top">
			<p>UserCreateComplete</p>
		</div>
		<div>
			<h3>ユーザー情報一覧</h3>
			<table border="1">
				<tr>
					<th>ID</th>
					<th>ユーザーID</th>
					<th>パスワード</th>
					<th>ユーザー名</th>
					<th>登録日</th>
					<th>更新日</th>
				</tr>
				<s:iterator value="userInfoDTOList">
					<tr>
						<td><s:property value="id" /></td>
						<td><s:property value="loginId" /></td>
						<td><s:property value="loginPass" /></td>
						<td><s:property value="userName" /></td>
						<td><s:property value="insert_date" /></td>
						<td><s:property value="update_date" /></td>
					</tr>
				</s:iterator>
			</table>
			<s:form action="UserListDeleteConfirmAction">
				<s:submit value="削除" />
			</s:form>
		</div>
		<div>
			<a href='<s:url action="HomeAction" />'>ログインへ</a>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>