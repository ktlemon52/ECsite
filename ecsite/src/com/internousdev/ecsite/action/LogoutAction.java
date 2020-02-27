package com.internousdev.ecsite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
public class LogoutAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;

//	sessionがclearされたらSUCCESSを返す
	public String execute() {
		session.clear(); //ここでセッションクリア
		return SUCCESS;
	}

//	Sesstionから取得した値をMap型に変換し、publicにして戻す
//	privateなフィールドの値を取得するためのメソッドをゲッター
	public Map<String, Object> getSession() {
		return this.session;
	}

//	セッターの名前は、「set ＋ 書き換えたいフィールド名」,　今回は上のsession.clear();したMap型セッションが引数になっている
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
