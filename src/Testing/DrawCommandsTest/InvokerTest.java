package Testing.DrawCommandsTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import DrawCommands.Command;
import DrawCommands.Invoker;

public class InvokerTest {

	Invoker testInvoker;
	
	@Test
    public void testValidConstruction()  {      
		Command commandTest = null;	
		 testInvoker = new Invoker(commandTest);        
    }
	
	@Test
    public void testBasicInvoke()  {      
		Command commandTest = null;	
		testInvoker = new Invoker(commandTest);
		testInvoker.invoke();
    }
	
	
	@Test
	public void invalidinvoke() {
				
		try{
			testInvoker.invoke((int)Double.POSITIVE_INFINITY,10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			testInvoker.invoke(10,(int)Double.POSITIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			testInvoker.invoke((int)Double.NEGATIVE_INFINITY,10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			testInvoker.invoke(10,(int)Double.NEGATIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			testInvoker.invoke((int)Double.NaN,10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			testInvoker.invoke(10,(int)Double.NaN);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		}
	
	@Test
	public void invalidinvokeText() {
		
		try{
			testInvoker.invokeText(null, 10,10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		
		try{
		testInvoker.invokeText("Text", (int)Double.POSITIVE_INFINITY,10);	
		fail("Expected exception not thrown");
		}
		catch (Exception e) {
            // ignore
        }
		
		try{
			testInvoker.invokeText("Text", 10,(int)Double.POSITIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			testInvoker.invokeText("Text", (int)Double.NEGATIVE_INFINITY, 10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			testInvoker.invokeText("Text", 10,(int)Double.NEGATIVE_INFINITY);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			testInvoker.invokeText("Text", (int)Double.NaN, 10);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
		
		try{
			testInvoker.invokeText("Text", 10,(int)Double.NaN);	
			fail("Expected exception not thrown");
			}
			catch (Exception e) {
	            // ignore
	        }
	}
	

	
	@Test
	public void testUndo() {
		testInvoker.pressUndo();
	}

	@Test
	public void testRedo() {
		testInvoker.pressRedo();
	}
}
