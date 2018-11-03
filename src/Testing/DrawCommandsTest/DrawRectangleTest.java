package Testing.DrawCommandsTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import DrawCommands.DrawRectangle;

public class DrawRectangleTest {

	DrawRectangle recTest;
	
	@Test
	public void executeBasic() {
		recTest.execute();
	}

	
	@Test
	public void validExecute() {
		recTest.execute(10,10);		
	}
	
	@Test
	public void validExecuteText() {
		recTest.executeText("test", 10,10);		
	}
	
	@Test
	public void invalidExecute() {
				
		try{
			recTest.execute((int)Double.POSITIVE_INFINITY,10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			recTest.execute(10,(int)Double.POSITIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			recTest.execute((int)Double.NEGATIVE_INFINITY,10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			recTest.execute(10,(int)Double.NEGATIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			recTest.execute((int)Double.NaN,10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			recTest.execute(10,(int)Double.NaN);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		}
	
	
	
	
	
	@Test
	public void invalidExecuteText() {
		
		try{
			recTest.executeText(null, 10,10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		
		try{
		recTest.executeText("Text", (int)Double.POSITIVE_INFINITY,10);	
		fail("Expected exception not thrown");
		}
		catch (Exception e) {
            // ignore
        }
		
		try{
			recTest.executeText("Text", 10,(int)Double.POSITIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			recTest.executeText("Text", (int)Double.NEGATIVE_INFINITY, 10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			recTest.executeText("Text", 10,(int)Double.NEGATIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			recTest.executeText("Text", (int)Double.NaN, 10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			recTest.executeText("Text", 10,(int)Double.NaN);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
	}
	

	
	@Test
	public void testUndo() {
		recTest.undo();
	}

	@Test
	public void testRedo() {
		recTest.redo();
	}

}
