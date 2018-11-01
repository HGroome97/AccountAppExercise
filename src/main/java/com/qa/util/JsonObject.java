package com.qa.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.persistence.domain.Account;
import com.google.gson.Gson;

public class JsonObject {
	

	private ObjectMapper mapper;
	
	public JsonObject() {
		mapper = new ObjectMapper();
	}
	
	public void ObjectJsonFile(Account acc) {
		
		try {
			mapper.writeValue(new File("c:\\file.json"), acc);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String HashJsonString(Map<Integer, Account> map) {
		try {
			String stringToJson = mapper.writeValueAsString(map);
	    	return stringToJson; 
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Error occured, see console";
	
	}
	
	
	public String ObjectJsonString(Object ob) {
		
		try {
			return mapper.writeValueAsString(ob);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Error occured, see console";
	}
	
	public Account JsonToObjectFile(String File) {
		Account acc;
		try {
			acc = mapper.readValue(new File(File), Account.class);
			return acc;
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Account(0, null,null);
	}
	
	public Account JsonToObjectURL(String URL) {
		Account acc;
		try {
			acc = mapper.readValue(new URL(URL), Account.class);
			return acc;
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Account(0, null,null);
	}
	
	public Account JsonToObjectString(String Json) {
		Account acc;
		try {
			acc = mapper.readValue(Json, Account.class);
			return acc;
			//return new Account(0, acc.getfName(),acc.getlName());
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Account(0, "test","test");
		//return new Account(0, acc.getfName(),acc.getlName());
	}
	

	
	
	public ObjectMapper getMapper() {
		return mapper;
	}

	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}
	
	
}
