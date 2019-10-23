package fr.ng.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import fr.ng.beans.Utilisateur;

public class MyNoms {

	private Connection dbConnection = null;

	public List<Utilisateur> recupererUtilisateurs() {
		List<Utilisateur> utilisateurs = new ArrayList<>();

		loadDatabase();

		// Connexion à la base

		Statement statement = null;
		ResultSet resultat = null;

		try {
			statement = dbConnection.createStatement();

			// Exécution de la requête
			resultat = statement.executeQuery("SELECT nom, prenom FROM noms;");

			// Récupération des données
			while (resultat.next()) {
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");

				Utilisateur utilisateur = new Utilisateur(nom, prenom);
				utilisateurs.add(utilisateur);
			}
		} catch (SQLException e) {
			System.err.println("Oups: " + e.getMessage());
		} finally {
			try {
				if (resultat != null) {
					resultat.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (dbConnection != null) {
					dbConnection.close();
				}
			} catch (SQLException ignore) {

			}
		}
		return utilisateurs;
	}

	private void loadDatabase() {
		// Chargement du driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Oups");
		}

		try {

			String url = "jdbc:mysql://localhost:3306/javaee?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Properties info = new Properties();
			info.put("user", "root");
			info.put("password", "N1col@sN1col@s");

			dbConnection = DriverManager.getConnection(url, info);

			if (dbConnection != null) {
				System.out.println("Successfully connected to MySQL database test");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void ajouterUtilisateur(Utilisateur utilisateur) {
		loadDatabase();

		try {
			PreparedStatement ps = dbConnection.prepareStatement("INSERT INTO noms(nom, prenom) VALUES(?, ?);");
			ps.setString(1, utilisateur.getNom());
			ps.setString(2, utilisateur.getPrenom());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
