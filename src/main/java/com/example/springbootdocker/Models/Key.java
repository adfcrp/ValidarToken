package com.example.springbootdocker.Models;

public class Key {
	String kty;
	String n;
	String e;
	String alg;
	String use;
	String kid;
	public String getKty() {
		return kty;
	}
	public void setKty(String kty) {
		this.kty = kty;
	}
	public String getN() {
		return n;
	}
	public void setN(String n) {
		this.n = n;
	}
	public String getE() {
		return e;
	}
	public void setE(String e) {
		this.e = e;
	}
	public String getAlg() {
		return alg;
	}
	public void setAlg(String alg) {
		this.alg = alg;
	}
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public String getKid() {
		return kid;
	}
	public void setKid(String kid) {
		this.kid = kid;
	}
	@Override
	public String toString() {
		return "Key [kty=" + kty + ", n=" + n + ", e=" + e + ", alg=" + alg + ", use=" + use + ", kid=" + kid + "]";
	}
	
}
