package com.gsccs.sme.plat.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

public class DataUtils {

	public static void main(String[] args) {
		DruidDataSource dataSource = null;
		DruidPooledConnection connection = null;
		try {
			String initsql = "";
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(initsql);
			statement.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
