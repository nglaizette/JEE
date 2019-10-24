package fr.ng.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DaoFactory {
	private String url;
	private Properties info;

	DaoFactory(String url, Properties info) {
		this.url = url;
		this.info = info;
	}

	public static DaoFactory getInstance() {
		// Chargement du driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Oups");
		}

		String url = "jdbc:mysql://localhost:3306/javaee?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		Properties info = new Properties();
		info.put("user", "root");
		info.put("password", "N1col@sN1col@s");
		DaoFactory instance = new DaoFactory(url, info);
		return instance;
	}

	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(url, info);
		connection.setAutoCommit(false); // Pour la gestion des transactions
		return connection;
	}

	// Récupération du Dao
	public UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOImpl(this);
	}

}
