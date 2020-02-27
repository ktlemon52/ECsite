package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;

public class LoginDAO {
	public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		LoginDTO loginDTO = new LoginDTO();
		String sql = "SELECT * FROM login_user_transaction where login_id = ? AND login_pass = ?";
//		ユーザーログイン情報取得
		try {
			PreparedStatement ps = con.prepareStatement(sql);
//			？に代入
			ps.setString(1, loginUserId);
			ps.setString(2, loginPassword);

//			ResultSet オブジェクトは、カーソルがデータの現在の行を指し示すよう維持します。初期状態では、カーソルは最初の行の先頭に配置されます。next メソッドにより、カーソルは次の行に移動します。 next は、ResultSet オブジェクトにそれ以上行がない場合に false を返すので、while ループに使用して結果セットを繰り返し処理することができます。
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				loginDTO.setLoginId(rs.getString("login_id")); //loginDTOにlogin_idを格納
				loginDTO.setLoginPassword(rs.getString("login_pass")); //loginDTOにlogin_idを格納
				loginDTO.setUserName(rs.getString("user_name"));

				if (!(rs.getString("login_id").equals(null))) {
					loginDTO.setLoginFlg(true); //ログインフラグtrueを入れる
				}
				loginDTO.setAdminFlg(rs.getString("admin_flg"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginDTO;
	}
}
