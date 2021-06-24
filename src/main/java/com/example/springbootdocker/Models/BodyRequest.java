package com.example.springbootdocker.Models;

import org.springframework.lang.NonNull;

public class BodyRequest {
	@NonNull
	String tokenJWT;
	@NonNull
	String domainJWK;
	@NonNull
	Boolean validateExpiration;

	public BodyRequest() {
		super();
	}
	
	public String getTokenJWT() {
		return tokenJWT;
	}
	public void setTokenJWT(String tokenJWT) {
		this.tokenJWT = tokenJWT;
	}
	public String getDomainJWK() {
		return domainJWK;
	}
	public void setDomainJWK(String domainJWK) {
		this.domainJWK = domainJWK;
	}
	public Boolean getValidateExpiration() {
		return validateExpiration;
	}
	public void setValidateExpiration(Boolean validateExpiration) {
		this.validateExpiration = validateExpiration;
	}
	
	@Override
	public String toString() {
		return "RequestBody [tokenJWT=" + "NotEmpty" + ", domainJWK=" + domainJWK + ", validateExpiration="
				+ validateExpiration + "]";
	}

}
