package com.telusko.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.telusko.Bean.UserBean;
import com.telusko.DAO.LoginDAO;

public class LoginService {

	ResultSet rs = null;

	public UserBean validateUser(UserBean userbean) {

		try {
			rs = LoginDAO.getResultSet();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String username = userbean.getUsername();
		String password = userbean.getPassword();
		boolean b = true;
		// iterate through the java resultset
		System.out.println(" rs " + rs);
		try {
			while (rs.next()) {
				String user_name = rs.getString("username");
				String pass_word = rs.getString("password");

				if (user_name != null) {
					if (user_name.equals(username) && pass_word.equals(password)) {
						System.out.println("Welcome " + username);
						userbean.setValid(true);
						return userbean;
					} else {

					}

				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userbean.setValid(false);
		return userbean;
	}
}
