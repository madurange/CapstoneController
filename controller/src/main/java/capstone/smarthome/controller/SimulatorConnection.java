package capstone.smarthome.controller;


import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;


public class SimulatorConnection {
	
	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target("http://localhost:9000/api/get/networklist");
		
		//startdevice?network_chosen=IoT_SMART_HOME&device_id=device1
		
		
		System.out.println(target.request(MediaType.APPLICATION_JSON).get(String.class));
		
	}
    
}
