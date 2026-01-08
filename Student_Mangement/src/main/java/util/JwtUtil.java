package util;

import io.jsonwebtoken.Claims;

import java.security.Key;
//import java.awt.RenderingHints.Key;
import java.util.Date;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

//import java.security.Key;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.*;

//@Component

@Service
public class JwtUtil {

	private final String SECRET_KEY = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

	public String generateToken(String username) {
		
		return Jwts.builder()
				.setSubject(username)

				.setIssuedAt(new Date())

				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours

				.signWith(getSignKey(),SignatureAlgorithm.HS256)

				.compact();
    }
	
	private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
	
	
	 public String extractUsername(String token) {

			return extractClaims(token).getSubject();

		}

	//validate token
	public boolean validateToken(String token, UserDetails userDetails) {

				String username = extractUsername(token);
				return username.equals(userDetails.getUsername())&& !isTokenExpired(token);
				//return userDetails.equals(extractUsername(token)) && !isTokenExpired(token);

	   }

	private boolean isTokenExpired(String token) {

				return   extractClaims(token).getExpiration().before(new Date());

			}
			
			private Claims extractClaims(String token)
			{
				return Jwts.parser()
						.setSigningKey(SECRET_KEY)
						.parseClaimsJws(token)
						.getBody();
			} 
	}



















/*  public String extractUsername(String token) {

	return extractClaims(token).getSubject();

	}

	//validate token
	public boolean validateToken(String token, UserDetails userDetails) {

		String username = extractUsername(token);
		return username.equals(userDetails.getUsername())&& !isTokenExpired(token);
		
		
//		return userDetails.equals(extractUsername(token)) && !isTokenExpired(token);

	}

	private boolean isTokenExpired(String token) {

		return   extractClaims(token).getExpiration().before(new Date());

	}
	
	private Claims extractClaims(String token)
	{
		return Jwts.parser()
				.setSigningKey(SECRET_KEY)
				.parseClaimsJws(token)
				.getBody();
	} */











/*
 * return Jwts.builder() .setClaims(claims) .setSubject(userName)
 * .setIssuedAt(new Date()) .setExpiration(new Date(System.currentTimeMillis() +
 * 1000 * 60 * 30)) // Token valid for 30 minutes .signWith(getSignKey(),
 * SignatureAlgorithm.HS256) .compact();
 */




//	return Jwts.builder()
			
//			.claims()
//			.add(claims)
//			.subject(username)
//			.issuedAt(new Date(System.currentTimeMillis()))
//			.expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
//			.and()
//			.signWith(getKey())
//			.compact();














/*
 * private SecretKey getKey() { byte[] keyBytes =
 * Decoders.BASE64.decode(SECRET_KEY); return Keys.hmacShaKeyFor(keyBytes); }
 * public String extractUserName(String token) { return extractClaim(token,
 * Claims::getSubject); } private <T> T extractClaim(String token,
 * Function<Claims, T> claimResolver) { final Claims claims =
 * extractAllClaims(token); return claimResolver.apply(claims); } private Claims
 * extractAllClaims(String token) { return Jwts.parserBuilder()
 * .verifyWith(getKey()) .build() .parseSignedClaims(token) .getPayload(); }
 * public boolean validateToken(String token, UserDetails userDetails) { final
 * String userName = extractUserName(token); //
 * System.out.println("extracted user name ", username); return
 * (userName.equals(userDetails.getUsername()) && !isTokenExpired(token)); }
 * private boolean isTokenExpired(String token) { return
 * extractExpiration(token).before(new Date()); } private Date
 * extractExpiration(String token) { return extractClaim(token,
 * Claims::getExpiration); }
 * 
 * 
 */

