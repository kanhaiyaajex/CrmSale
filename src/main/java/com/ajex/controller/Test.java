//package com.ajex.controller;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//public class Test {
//	
//	
//	public static void main(String[] args) {
//		
//		JSONObject jsonComplex = new JSONObject();
//	    JSONObject notification = new JSONObject();
//	    JSONObject targetJsonObject= new JSONObject();
//	    JSONArray targetJsonArray= new JSONArray();
//	    JSONObject appsJsonObject= new JSONObject();
//	    
//	    notification.put("regid", "3");
//	    notification.put("regname", "Delhi");
//	  
//	    appsJsonObject.put("cityId","55");
//	    appsJsonObject.put("cityName","Noida");
//
//	    JSONArray platformArray = new JSONArray();
//	    //platformArray.add("ios");
//	    appsJsonObject.put("platforms",platformArray);
//	    targetJsonArray.put(appsJsonObject);
//	    targetJsonObject.put("city", targetJsonArray);
//	    notification.put("target", targetJsonObject);
//	    jsonComplex.put("region", notification);
//	    jsonComplex.put("country", "India");
//	    System.out.println(jsonComplex);
//	}
//
//}
