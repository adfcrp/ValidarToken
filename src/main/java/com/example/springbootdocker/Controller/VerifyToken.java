package com.example.springbootdocker.Controller;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;
import java.util.Calendar;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.springbootdocker.Models.BodyRequest;
import com.example.springbootdocker.Models.Key;

public class VerifyToken {
	
	public static void check(BodyRequest body) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, URISyntaxException, RuntimeException {

		JWKaccess jwk = new JWKaccess();
		
		DecodedJWT jwt = JWT.decode(body.getTokenJWT());
		
		Key key = jwk.getKey(jwt.getKeyId(), body.getDomainJWK());
		System.out.println("kid: " + key.getKid());
		
		BigInteger modulus = new BigInteger(1, Base64.getUrlDecoder().decode(key.getN()));
		BigInteger exponent = new BigInteger(1, Base64.getUrlDecoder().decode(key.getE()));
		PublicKey publicKey = KeyFactory.getInstance(key.getKty()).generatePublic(new RSAPublicKeySpec(modulus, exponent));
		
		Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) publicKey, null);
		algorithm.verify(jwt);
		
		// Check expiration
		if(body.getValidateExpiration()) {
			if (jwt.getExpiresAt().before(Calendar.getInstance().getTime())) {
				throw new RuntimeException("Expired token!");
			}
		}
	}
}
