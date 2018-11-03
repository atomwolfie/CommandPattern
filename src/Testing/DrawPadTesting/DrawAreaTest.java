package Testing.DrawPadTesting;

import static org.junit.Assert.*;

import java.awt.Graphics;

import org.junit.Before;
import org.junit.Test;

import DrawPad.DrawArea;

public class DrawAreaTest {

	DrawArea drawtester = new DrawArea();
	
	@Test
	public void testValidContruction() {
		DrawArea drawtester1;
	}


	@Test
	public void testOldX() {
		drawtester.setOldX(10);
		assertEquals(10,drawtester.getOldX(),0);
		drawtester.setOldX(8);
		assertEquals(8,drawtester.getOldX(),0);
		drawtester.setOldX(2);
		assertEquals(2,drawtester.getOldX(),0);
	}
	
	@Test
	public void testInvalidOldX() {
		try{
			drawtester.setOldX((int)Double.POSITIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			drawtester.setOldX((int)Double.NEGATIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			drawtester.setOldX((int)Double.NaN);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
	}
	
	
	
	
	@Test
	public void testOldY() {
		drawtester.setOldY(10);
		assertEquals(10,drawtester.getOldY(),0);
		drawtester.setOldY(8);
		assertEquals(8,drawtester.getOldY(),0);
		drawtester.setOldY(2);
		assertEquals(2,drawtester.getOldY(),0);
	}
	
	@Test
	public void testInvalidOldY() {
		try{
			drawtester.setOldY((int)Double.POSITIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			drawtester.setOldY((int)Double.NEGATIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			drawtester.setOldY((int)Double.NaN);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
	}
	
	@Test
	public void testOldLineX() {
		drawtester.setOldLineX(10);
		assertEquals(10,drawtester.getOldX(),0);
		drawtester.setOldLineX(8);
		assertEquals(8,drawtester.getOldX(),0);
		drawtester.setOldLineX(2);
		assertEquals(2,drawtester.getOldX(),0);
	}
	
	@Test
	public void testInvalidOldLineX() {
		try{
			drawtester.setOldLineX((int)Double.POSITIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			drawtester.setOldLineX((int)Double.NEGATIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			drawtester.setOldLineX((int)Double.NaN);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
	}
	

	
	@Test
	public void testOldLineY() {
		drawtester.setOldLineY(10);
		assertEquals(10,drawtester.getOldY(),0);
		drawtester.setOldLineY(8);
		assertEquals(8,drawtester.getOldY(),0);
		drawtester.setOldLineY(2);
		assertEquals(2,drawtester.getOldY(),0);
	}
	
	@Test
	public void testInvalidLineOldY() {
		try{
			drawtester.setOldLineY((int)Double.POSITIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			drawtester.setOldLineY((int)Double.NEGATIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			drawtester.setOldLineY((int)Double.NaN);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
	}
	
	@Test
	public void testNumClicks() {
		drawtester.setOldLineY(10);
		assertEquals(10,drawtester.getOldY(),0);
		drawtester.setOldLineY(8);
		assertEquals(8,drawtester.getOldY(),0);
		drawtester.setOldLineY(2);
		assertEquals(2,drawtester.getOldY(),0);
	}
	
	@Test
	public void testInvalidNumClicks() {
		try{
			drawtester.setNumClicks((int)Double.POSITIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			drawtester.setNumClicks((int)Double.NEGATIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			drawtester.setNumClicks((int)Double.NaN);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
	}
	
	
	@Test
	public void testDelete() {
		drawtester.delete();
	}
	
	
	
	@Test
	public void testDrawRectangle() {
		drawtester.drawRectangle(100, 200);	
	}
	
	@Test
	public void testInvalidDrawRectangle() {
		
		try{
			drawtester.drawRectangle((int)Double.POSITIVE_INFINITY, 200);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			drawtester.drawRectangle((int)Double.NEGATIVE_INFINITY, 200);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			drawtester.drawRectangle((int)Double.NaN, 200);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			drawtester.drawRectangle(200, (int)Double.POSITIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			drawtester.drawRectangle(200, (int)Double.NEGATIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			drawtester.drawRectangle(200, (int)Double.NaN);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
	}
	
	@Test
	public void testRedoRectangle() {
		drawtester.drawRectangle(100, 200);
		drawtester.redoRectangle();		
	}
	
	@Test
	public void testEraseRectangle() {
		drawtester.drawRectangle(100, 200);
		drawtester.eraseRectangle();		
	}
	
	
	@Test
	public void testDrawCircle() {
		drawtester.drawCircle(100, 200);			
	}
	
	
	@Test
	public void testInvalidDrawCircle() {
		try{
			drawtester.drawCircle((int)Double.POSITIVE_INFINITY, 200);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			drawtester.drawCircle((int)Double.NEGATIVE_INFINITY, 200);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			drawtester.drawCircle((int)Double.NaN, 200);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			drawtester.drawCircle(200, (int)Double.POSITIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			drawtester.drawCircle(200, (int)Double.NEGATIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			drawtester.drawCircle(200, (int)Double.NaN);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }			
	}
	
	@Test
	public void testRedoCircle() {
		drawtester.drawCircle(100, 200);
		drawtester.redoCircle();		
	}
	
	@Test
	public void testEraseCircle() {
		drawtester.drawCircle(100, 200);
		drawtester.eraseCircle();		
	}
	
	
	
	@Test
	public void testDrawLine() {	
		drawtester.drawLine(100, 200);
	}
	
	@Test
	public void testInvalidDrawLine() {	
		try{
			drawtester.drawLine((int)Double.POSITIVE_INFINITY, 200);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			drawtester.drawLine((int)Double.NEGATIVE_INFINITY, 200);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			drawtester.drawLine((int)Double.NaN, 200);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			drawtester.drawLine(200, (int)Double.POSITIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			drawtester.drawLine(200, (int)Double.NEGATIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			drawtester.drawLine(200, (int)Double.NaN);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
	}
	
	@Test
	public void testRedoLine() {
		drawtester.drawLine(100, 200);
		drawtester.redoLine();		
	}
	
	@Test
	public void testEraseLine() {
		drawtester.drawLine(100, 200);
		drawtester.eraseLine();		
	}
	
	
	
	@Test
	public void testInsertText() {
		drawtester.insertText("test",100, 200);
		
	}
	
	@Test
	public void testInvalidInsertText() {
		try{
			drawtester.insertText("test",(int)Double.POSITIVE_INFINITY, 200);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			drawtester.insertText("test",(int)Double.NEGATIVE_INFINITY, 200);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			drawtester.insertText("test",(int)Double.NaN, 200);
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			drawtester.insertText("test",200, (int)Double.POSITIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			drawtester.insertText("test",200, (int)Double.NEGATIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		try{
			drawtester.insertText("test",200, (int)Double.NaN);
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
	}
	
	
	@Test
	public void testRedoText() {
		drawtester.insertText("text", 100, 200);
		drawtester.redoText();		
	}
	
	@Test
	public void testEraseText() {
		drawtester.insertText("text", 100, 200);
		drawtester.eraseText();		
	}
	
	
}
