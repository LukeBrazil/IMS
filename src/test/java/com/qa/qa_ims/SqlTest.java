package com.qa.qa_ims;
import org.junit.jupiter.api.Test;
import  org.junit.jupiter.api.Assertions;

public class SqlTest {
	
	@Test
	public void test() {
		SqlCon mySqlCon = new SqlCon();
		String addedCustomer = mySqlCon.addCustomer("John", "Mable", 19);
		
		Assertions.assertEquals("Added Customer!", addedCustomer);
		
	}
	
}
