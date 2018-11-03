package Testing.DrawCommandsTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import DrawCommands.Command;

public class CommandTesting {

	//ALL FUNCTONS ARE VOID, NO VARIABLES, NOTHNG TO ASSERT
	Command commandTesting;
	
	@Test
	public void executeBasic() {
		commandTesting.execute();
	}

	
	@Test
	public void validExecute() {
		commandTesting.execute(10,10);		
	}
	
	@Test
	public void validExecuteText() {
		commandTesting.executeText("test", 10,10);		
	}
	
	
	@Test
	public void invalidExecute() {
				
		try{
			commandTesting.execute((int)Double.POSITIVE_INFINITY,10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			commandTesting.execute(10,(int)Double.POSITIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			commandTesting.execute((int)Double.NEGATIVE_INFINITY,10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			commandTesting.execute(10,(int)Double.NEGATIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			commandTesting.execute((int)Double.NaN,10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			commandTesting.execute(10,(int)Double.NaN);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		}
	
	
	
	
	
	@Test
	public void invalidExecuteText() {
		
		try{
			commandTesting.executeText(null, 10,10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		
		try{
		commandTesting.executeText("Text", (int)Double.POSITIVE_INFINITY,10);	
		fail("Expected exception not thrown");
		}
		catch (Exception e) {
            // ignore
        }
		
		try{
			commandTesting.executeText("Text", 10,(int)Double.POSITIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			commandTesting.executeText("Text", (int)Double.NEGATIVE_INFINITY, 10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			commandTesting.executeText("Text", 10,(int)Double.NEGATIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			commandTesting.executeText("Text", (int)Double.NaN, 10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			commandTesting.executeText("Text", 10,(int)Double.NaN);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
	}
	

	
	@Test
	public void testUndo() {
		commandTesting.undo();
	}

	@Test
	public void testRedo() {
		commandTesting.redo();
	}

	
	
	
	
	
}
