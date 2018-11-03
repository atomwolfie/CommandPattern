package Testing.DrawCommandsTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import DrawCommands.DrawLine;

public class DrawLineTest {

	DrawLine lineTest;
	
	
	@Test
	public void executeBasic() {
		lineTest.execute();
	}

	
	@Test
	public void validExecute() {
		lineTest.execute(10,10);		
	}
	
	@Test
	public void validExecuteText() {
		lineTest.executeText("test", 10,10);		
	}
	
	@Test
	public void invalidExecute() {
				
		try{
			lineTest.execute((int)Double.POSITIVE_INFINITY,10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			lineTest.execute(10,(int)Double.POSITIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			lineTest.execute((int)Double.NEGATIVE_INFINITY,10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			lineTest.execute(10,(int)Double.NEGATIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			lineTest.execute((int)Double.NaN,10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			lineTest.execute(10,(int)Double.NaN);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		}
	
	
	
	
	
	@Test
	public void invalidExecuteText() {
		
		try{
			lineTest.executeText(null, 10,10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		
		try{
		lineTest.executeText("Text", (int)Double.POSITIVE_INFINITY,10);	
		fail("Expected exception not thrown");
		}
		catch (Exception e) {
            // ignore
        }
		
		try{
			lineTest.executeText("Text", 10,(int)Double.POSITIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			lineTest.executeText("Text", (int)Double.NEGATIVE_INFINITY, 10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			lineTest.executeText("Text", 10,(int)Double.NEGATIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			lineTest.executeText("Text", (int)Double.NaN, 10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			lineTest.executeText("Text", 10,(int)Double.NaN);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
	}
	

	
	@Test
	public void testUndo() {
		lineTest.undo();
	}

	@Test
	public void testRedo() {
		lineTest.redo();
	}

}
