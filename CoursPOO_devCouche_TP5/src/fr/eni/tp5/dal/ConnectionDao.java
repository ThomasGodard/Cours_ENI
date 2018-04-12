package fr.eni.tp5.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.eni.tp5.configuration.Configuration;

public abstract class ConnectionDao {

	public static Connection getConnection() throws SQLException {

		String url = Configuration.getValue("url"); //$NON-NLS-1$
		String user = Configuration.getValue("user"); //$NON-NLS-1$
		String pwd = Configuration.getValue("pwd"); //$NON-NLS-1$
		
		Connection cnx = DriverManager.getConnection(url, user, pwd);
		
		return cnx;
	}
}
