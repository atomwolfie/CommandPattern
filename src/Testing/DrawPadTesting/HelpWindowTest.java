package Testing.DrawPadTesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import DrawPad.HelpWindow;

public class HelpWindowTest {

	HelpWindow windowTester = new HelpWindow();

	@Test
	public void testValidConstruction() {
		HelpWindow windowTester1 = new HelpWindow();
	}

	
	@Test
	public void testVisible() {
		windowTester.setVisible(true);
	}

	
}
