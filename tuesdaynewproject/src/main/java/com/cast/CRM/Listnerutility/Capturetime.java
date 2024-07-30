package com.cast.CRM.Listnerutility;

import java.util.Date;

import org.testng.annotations.Test;



public class Capturetime {

	@Test
	
	public String time()
 {
		            String time1 = new Date().toString().replace(" ", "_").replace(":", "_");
		            
		        return time1;
	}

}
