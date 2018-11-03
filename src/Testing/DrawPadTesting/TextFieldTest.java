package Testing.DrawPadTesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import DrawPad.TextField;

public class TextFieldTest {

	TextField testTester = new TextField();

	@Test
	public void testValidConstruction() {
		TextField testTester1 = new TextField();
	}

	@Test
	public void testVisible() {
		testTester.setVisible(true);
	}
	
	
	@Test
	public void testX() {
		testTester.setX(10);
		assertEquals(10,testTester.getX(),0);
		testTester.setX(8);
		assertEquals(8,testTester.getX(),0);
		testTester.setX(2);
		assertEquals(2,testTester.getX(),0);
	}
	
	@Test
	public void testInvalidX() {
		try{
			testTester.setX((int)Double.POSITIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			testTester.setX((int)Double.NEGATIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			testTester.setX((int)Double.NaN);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
	}
	
	
	
	
	@Test
	public void testY() {
		testTester.setY(10);
		assertEquals(10,testTester.getY(),0);
		testTester.setY(8);
		assertEquals(8,testTester.getY(),0);
		testTester.setY(2);
		assertEquals(2,testTester.getY(),0);
	}
	
	@Test
	public void testInvalidY() {
		try{
			testTester.setY((int)Double.POSITIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			testTester.setY((int)Double.NEGATIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			testTester.setY((int)Double.NaN);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
	}
	
}
