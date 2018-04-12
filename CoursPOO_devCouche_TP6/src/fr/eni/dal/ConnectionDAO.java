package fr.eni.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.eni.configuration.Messages;

public abstract class ConnectionDAO {
	
	public static Connection getConnection() throws SQLException {
		String url = Messages.getValue("url"); //$NON-NLS-1$
		String user = Messages.getValue("user"); //$NON-NLS-1$
		String pwd = Messages.getValue("password"); //$NON-NLS-1$
		Connection cnx = DriverManager.getConnection(url, user, pwd);
		return cnx;
	}
}
