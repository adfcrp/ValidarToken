package com.example.springbootdocker.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.example.springbootdocker.Models.Keys;
import com.example.springbootdocker.Models.Key;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class JWKaccess {

	private Map<String, Key> mapKeys;
	
	public JWKaccess() {
		this.mapKeys = new HashMap<String, Key>();
	}


	private void getKeys(String domainJWK) throws IOException{
		OkHttpClient client = new OkHttpClient().newBuilder().build();
		Request request = new Request.Builder()
				  .url(domainJWK)
				  .method("GET", null)
				  .build();
		Response response = client.newCall(request).execute();
		
		Gson gson = new Gson();
		Keys keys = gson.fromJson(response.body().string(), Keys.class);
		
		for(Key key : keys.getKeys()) {
			mapKeys.put(key.getKid(), key);
		}
	}
	
	public Key getKey(String kid, String domainJWK) throws IOException{
		if(this.mapKeys.isEmpty()) {
			this.getKeys(domainJWK);
		}
		
		System.out.println("Total de Public Keys disponibles: " + mapKeys.size());
		
		return this.mapKeys.get(kid);
	}
}
