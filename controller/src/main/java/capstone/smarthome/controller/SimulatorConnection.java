package capstone.smarthome.controller;


import java.net.URI;

import org.json.JSONException;
import org.json.JSONObject;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriBuilder;


public class SimulatorConnection {
	
	public static String requestURL;
	
	// Simulator Broker API URL
	private static final String brokerAPI_URL = "http://localhost:9000/api";
	
	// Broker Functions
	private static final String networkList = "get/networklist";
	
	
	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:9000/api/get/networklist");
		//startdevice?network_chosen=IoT_SMART_HOME&device_id=device1
		System.out.println(target.request(MediaType.APPLICATION_JSON).get(String.class));
		
	}
	
	public static JSONObject connect() {
		String responseJSONString = null;
		JSONObject responseJSON = null;
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(getBaseURI());
		responseJSONString = target.path(networkList).request(MediaType.APPLICATION_JSON).get(String.class);
		
		try {
			responseJSON = new JSONObject(responseJSONString);
		} catch (JSONException e) {
			System.err.println(e.toString());
		}
		
		return responseJSON;
	}
	
	
	private static URI getBaseURI() {
		return UriBuilder.fromUri(brokerAPI_URL).build();
	}
	
    
}
