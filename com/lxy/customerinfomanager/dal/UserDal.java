package com.lxy.customerinfomanager.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.lxy.customerinfomanager.model.User;

/**
 * 用户的数据库操作类
 * @author xiaoyang
 *
 */
public class UserDal {
	/**
	 * 用户登录验证
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(Connection con,User user) throws Exception{
		User ResultUser = null;
		String sql="select * from t_user where userName =? and password =?";
		PreparedStatement pStatement=con.prepareStatement(sql);
		pStatement.setString(1, user.getUserName());
		pStatement.setString(2, user.getPassword());  
		
		ResultSet rs=pStatement.executeQuery();
		if (rs.next()) {
			ResultUser = new User();
			ResultUser.setId(rs.getInt("id"));
			ResultUser.setUserName(rs.getString("userName"));
			ResultUser.setPassword(rs.getString("password"));
		}
		return ResultUser;		
	}
}
