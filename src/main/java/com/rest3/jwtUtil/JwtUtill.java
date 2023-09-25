package com.rest3.jwtUtil;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



@Component
public class JwtUtill {
	
	@Value("${app.secret}")
	private String secret;
	
//	1 generate Token
	
	public String generateToken(String subject) {
		return Jwts.builder()
				.setSubject(subject)
				.setIssuer("naveen")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(15)))
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
				
	}
	
//	2 Read Claims
	public Claims getClaims(String token) {
		return Jwts.parser()
				.setSigningKey(secret.getBytes())
				.parseClaimsJws(token)
				.getBody();
	}
//	3 Read Exp Date
	public Date getExpDate(String token) {
		return getClaims(token).getExpiration();
	}
	
//	4 Read Subject User name
	public String getUserName(String token) {
		return getClaims(token).getSubject();
	}
	
//	5 validate exp date
	public boolean isTokenExp(String token) {
		Date expDate=getExpDate(token);
		return expDate.before(new Date(System.currentTimeMillis()));
	}
//	6 token vallidate
	public boolean validToken(String token,String username) {
		String tokenUsername=getUserName(token);
		return (username.equals(tokenUsername) && !isTokenExp(token));
				
		
	}
	
	

}
