package Testing.DrawCommandsTest;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import DrawCommands.DeleteEverything;


public class DeleteTest {

	DeleteEverything deleteTest;

	@Test
	public void executeBasic() {
		deleteTest.execute();
	}

	
	@Test
	public void validExecute() {
		deleteTest.execute(10,10);		
	}
	
	@Test
	public void validExecuteText() {
		deleteTest.executeText("test", 10,10);		
	}
	
	@Test
	public void invalidExecute() {
				
		try{
			deleteTest.execute((int)Double.POSITIVE_INFINITY,10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			deleteTest.execute(10,(int)Double.POSITIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			deleteTest.execute((int)Double.NEGATIVE_INFINITY,10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			deleteTest.execute(10,(int)Double.NEGATIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			deleteTest.execute((int)Double.NaN,10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			deleteTest.execute(10,(int)Double.NaN);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		}
	
	
	
	
	
	@Test
	public void invalidExecuteText() {
		
		try{
			deleteTest.executeText(null, 10,10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		
		try{
		deleteTest.executeText("Text", (int)Double.POSITIVE_INFINITY,10);	
		fail("Expected exception not thrown");
		}
		catch (Exception e) {
            // ignore
        }
		
		try{
			deleteTest.executeText("Text", 10,(int)Double.POSITIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			deleteTest.executeText("Text", (int)Double.NEGATIVE_INFINITY, 10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			deleteTest.executeText("Text", 10,(int)Double.NEGATIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			deleteTest.executeText("Text", (int)Double.NaN, 10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			deleteTest.executeText("Text", 10,(int)Double.NaN);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
	}
	

	
	@Test
	public void testUndo() {
		deleteTest.undo();
	}

	@Test
	public void testRedo() {
		deleteTest.redo();
	}
	
}
