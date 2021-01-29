package capstone.smarthome.testController;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import capstone.smarthome.controller.SimulatorConnection;

public class TestBasicConnection {
	
	JSONObject responseJSON;
	
	@BeforeMethod
	public void setUp() {
		responseJSON = SimulatorConnection.connect();
	}
	
	@Test
	public void simulatorConnectionTest() {
		JSONArray network = responseJSON.getJSONArray("Network_LIST");
		String network1 = network.getString(3);
		System.out.println(network);
		Assert.assertEquals(network1, "IOT_SMART_HOME");
	}
	
	@AfterMethod
	public void tearDown() {
		
	}

}
