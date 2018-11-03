package Testing.DrawPadTesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import DrawPad.DrawingPadConcept;

public class DrawPadConceptTest {

	
	DrawingPadConcept padTester;
	
	@Test
	public void testDrawRectangle() {
		padTester.drawRectangle(100, 200);	
	}
	
	@Test
	public void testInvalidDrawRectangle() {
		
		try{
			padTester.drawRectangle((int)Double.POSITIVE_INFINITY, 200);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			padTester.drawRectangle((int)Double.NEGATIVE_INFINITY, 200);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			padTester.drawRectangle((int)Double.NaN, 200);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			padTester.drawRectangle(200, (int)Double.POSITIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			padTester.drawRectangle(200, (int)Double.NEGATIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			padTester.drawRectangle(200, (int)Double.NaN);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
	}
	
	@Test
	public void testRedoRectangle() {
		padTester.drawRectangle(100, 200);
		padTester.redoRectangle();		
	}
	
	@Test
	public void testEraseRectangle() {
		padTester.drawRectangle(100, 200);
		padTester.eraseRectangle();		
	}
	
	
	@Test
	public void testDrawCircle() {
		padTester.drawCircle(100, 200);			
	}
	
	
	@Test
	public void testInvalidDrawCircle() {
		try{
			padTester.drawCircle((int)Double.POSITIVE_INFINITY, 200);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			padTester.drawCircle((int)Double.NEGATIVE_INFINITY, 200);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			padTester.drawCircle((int)Double.NaN, 200);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			padTester.drawCircle(200, (int)Double.POSITIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			padTester.drawCircle(200, (int)Double.NEGATIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			padTester.drawCircle(200, (int)Double.NaN);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }			
	}
	
	@Test
	public void testRedoCircle() {
		padTester.drawCircle(100, 200);
		padTester.redoCircle();		
	}
	
	@Test
	public void testEraseCircle() {
		padTester.drawCircle(100, 200);
		padTester.eraseCircle();		
	}
	
	
	
	@Test
	public void testDrawLine() {	
		padTester.drawLine(100, 200);
	}
	
	@Test
	public void testInvalidDrawLine() {	
		try{
			padTester.drawLine((int)Double.POSITIVE_INFINITY, 200);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			padTester.drawLine((int)Double.NEGATIVE_INFINITY, 200);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			padTester.drawLine((int)Double.NaN, 200);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			padTester.drawLine(200, (int)Double.POSITIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			padTester.drawLine(200, (int)Double.NEGATIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			padTester.drawLine(200, (int)Double.NaN);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
	}
	
	@Test
	public void testRedoLine() {
		padTester.drawLine(100, 200);
		padTester.redoLine();		
	}
	
	@Test
	public void testEraseLine() {
		padTester.drawLine(100, 200);
		padTester.eraseLine();		
	}
	
	
	
	@Test
	public void testInsertText() {
		padTester.insertText("test",100, 200);
		
	}
	
	@Test
	public void testInvalidInsertText() {
		try{
			padTester.insertText("test",(int)Double.POSITIVE_INFINITY, 200);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			padTester.insertText("test",(int)Double.NEGATIVE_INFINITY, 200);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			padTester.insertText("test",(int)Double.NaN, 200);
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			padTester.insertText("test",200, (int)Double.POSITIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			padTester.insertText("test",200, (int)Double.NEGATIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			padTester.insertText("test",200, (int)Double.NaN);
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
	}
	
	
	@Test
	public void testRedoText() {
		padTester.insertText("text", 100, 200);
		padTester.redoText();		
	}
	
	@Test
	public void testEraseText() {
		padTester.insertText("text", 100, 200);
		padTester.eraseText();		
	}

}
