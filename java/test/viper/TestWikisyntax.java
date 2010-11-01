package viper;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestWikisyntax {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test 
	public void testToHTML(){
		assertEquals("<h2>olle</h2>",WikiSyntax.toHTML("==olle=="));
	}
	
	
	@Test 
	public void TestUrlizeTitle(){
		
	} 
		
	
	@Test 
	public void deUrlizeTitle(){
		
	}
}
