package Testing.DrawCommandsTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import DrawCommands.LoadImage;
import DrawCommands.SaveImage;

public class SaveImageTest {

	SaveImage saveTest;


	@Test
	public void executeBasic() {
		saveTest.execute();
	}

	
	@Test
	public void validExecute() {
		saveTest.execute(10,10);		
	}
	
	@Test
	public void validExecuteText() {
		saveTest.executeText("test", 10,10);		
	}
	
	@Test
	public void invalidExecute() {
				
		try{
			saveTest.execute((int)Double.POSITIVE_INFINITY,10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			saveTest.execute(10,(int)Double.POSITIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			saveTest.execute((int)Double.NEGATIVE_INFINITY,10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			saveTest.execute(10,(int)Double.NEGATIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			saveTest.execute((int)Double.NaN,10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			saveTest.execute(10,(int)Double.NaN);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		}
	
	
	
	
	
	@Test
	public void invalidExecuteText() {
		
		try{
			saveTest.executeText(null, 10,10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		
		try{
		saveTest.executeText("Text", (int)Double.POSITIVE_INFINITY,10);	
		fail("Expected exception not thrown");
		}
		catch (Exception e) {
            // ignore
        }
		
		try{
			saveTest.executeText("Text", 10,(int)Double.POSITIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			saveTest.executeText("Text", (int)Double.NEGATIVE_INFINITY, 10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			saveTest.executeText("Text", 10,(int)Double.NEGATIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			saveTest.executeText("Text", (int)Double.NaN, 10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			saveTest.executeText("Text", 10,(int)Double.NaN);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
	}
	

	
	@Test
	public void testUndo() {
		saveTest.undo();
	}

	@Test
	public void testRedo() {
		saveTest.redo();
	}

}
