package fr.ng.servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Envoi
 */
@WebServlet("/Envoi")
public class Envoi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final int TAILLE_TAMPON = 10240;
	private static final String CHEMIN_FICHIERS = "/Users/nicolas_G/Downloads/TestEnvoiFichier/"; // dossier où sont
																									// stocké les
																									// fichiers

	public Envoi() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/envoi.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// On récupère le champ description comme d'habitude
		String description = request.getParameter("description");
		request.setAttribute("description", description);

		// On récupère le champ du fichier
		Part part = request.getPart("fichier");

		// On vérifie qu'on a bien reçu un fichier
		String nomFichier = getNomFichier(part);

		// Si on a bien un fichier
		if (nomFichier != null && !nomFichier.isEmpty()) {
			String nomChamp = part.getName();
			// Correction d'un bug dans le fonctionnement d'IE
			// nomFichier =
			// nomFichier.substring(nomFichier.lastIndexOf('/')+1).substring(nomFichier.lastIndexOf('\\'+1));

			// On écrit définitivement le fichier sur le disque.
			ecrireFichier(part, nomFichier, CHEMIN_FICHIERS);
			request.setAttribute(nomChamp, nomFichier);
		}
		doGet(request, response);
	}

	private void ecrireFichier(Part part, String nomFichier, String chemin) throws IOException {
		BufferedInputStream entree = null;
		BufferedOutputStream sortie = null;

		try {
			entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
			sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);

			byte[] tampon = new byte[TAILLE_TAMPON];
			int longueur;
			while ((longueur = entree.read(tampon)) > 0) {
				sortie.write(tampon, 0, longueur);
			}
		} finally {
			try {
				sortie.close();
			} catch (IOException ignore) {

			}
			try {
				entree.close();
			} catch (IOException ignore) {

			}
		}

	}

	private String getNomFichier(Part part) {
		for (String contentDisposition : part.getHeader("content-disposition").split(";")) {
			if (contentDisposition.trim().startsWith("filename")) {
				return contentDisposition.substring(contentDisposition.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
}
