package com.qa.qa_ims;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class ClassTest {
	
	@Test
	public void itemTest() {
		Item newItem = new Item("Swiffer", 10.96, 15);
		Assertions.assertEquals("Swiffer", newItem.getName());
		Assertions.assertEquals(10.96, newItem.getValue());
		Assertions.assertEquals(15, newItem.getInStock());
		
		
	}
	
	
	
	
}
