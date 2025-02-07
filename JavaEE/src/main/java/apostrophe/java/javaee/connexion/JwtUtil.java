package apostrophe.java.javaee.connexion;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import java.util.Date;

public class JwtUtil {

	private static final String SECRET_KEY = "superSecretKey"; // Clé secrète pour signer le token

	// Génère un token JWT
	public static String generateToken(String username) throws JOSEException {
		// Définir les revendications du token (JWT Claims)
		JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
				.subject(username)
				.issuer("yourApp")
				.audience("yourAppUsers")
				.expirationTime(new Date(System.currentTimeMillis() + 60 * 1000)) // Expire dans 1h
				.issueTime(new Date())
				.build();

		// Signer le token avec une clé secrète
		JWSSigner signer = new MACSigner(SECRET_KEY);

		// Créer le JWT signé
		SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
		signedJWT.sign(signer);

		// Retourner le token sous forme de string
		return signedJWT.serialize();
	}


	// Valide le token JWT
	public static boolean validateToken(String token) {
		return false;
	}

	public static boolean validerJWT(String jwt, String nomUtilisateur) {
		return true;
	}
}
