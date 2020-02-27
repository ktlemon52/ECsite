<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>管理者画面</title>
</head>
<body>
	<div id="header"></div>
	<div id="main">
		<div id="top">
			<p>管理者画面</p>
		</div>
		<div id="text-conter">
			<div>商品</div>
			<s:form action="ItemCreateAction">
				<s:submit value="商品新規登録" />
			</s:form>

			<s:form action="ItemListAction">
				<s:submit value="商品情報一覧" />
			</s:form>

			<p>管理者画面</p>
		</div>
		<div id="text-conter">
			<div>ユーザー</div>
			<s:form action="UserCreateAction">
				<s:submit value="ユーザー新規登録" />
			</s:form>

			<s:form action="UserListAction">
				<s:submit value="ユーザー情報一覧" />
			</s:form>

			<%-- sessionがnullだった場合にログアウトが表示される--%>
			<s:if test="#session.login_user_id != null">
				<p>
					ログアウトする場合は <a href='<s:url action="LogoutAction" />'>こちら</a> ログイン <a
						href='<s:url action="HomeAction" />'>こちら</a>
				</p>
			</s:if>

		</div>
	</div>
	<div id="footer"></div>
</body>
</html>