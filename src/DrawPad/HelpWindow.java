package DrawPad;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelpWindow {

	private JFrame frame;

	

	/**
	 * Create the application.
	 */
	public HelpWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Help");
		frame.setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRectangles = new JLabel("Rectangles:");
		lblRectangles.setBounds(29, 24, 72, 16);
		frame.getContentPane().add(lblRectangles);
		
		JLabel lblNewLabel = new JLabel("Click in one place then the next (left to right)");
		lblNewLabel.setBounds(113, 24, 316, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCircles = new JLabel("Circles:");
		lblCircles.setBounds(29, 66, 72, 16);
		frame.getContentPane().add(lblCircles);
		
		JLabel lblClickInOne = new JLabel("Click in one place then the next");
		lblClickInOne.setBounds(112, 66, 304, 16);
		frame.getContentPane().add(lblClickInOne);
		
		JLabel lblLines = new JLabel("Lines:");
		lblLines.setBounds(57, 94, 37, 16);
		frame.getContentPane().add(lblLines);
		
		JLabel lblClickInOne_1 = new JLabel("Click in one place then the next");
		lblClickInOne_1.setBounds(113, 94, 331, 16);
		frame.getContentPane().add(lblClickInOne_1);
		
		JLabel lblText = new JLabel("Text: ");
		lblText.setBounds(57, 122, 61, 16);
		frame.getContentPane().add(lblText);
		
		JLabel lblClickAnywhereTo = new JLabel("Click anywhere to insert text");
		lblClickAnywhereTo.setBounds(112, 122, 241, 16);
		frame.getContentPane().add(lblClickAnywhereTo);
		
		JLabel lblUndo = new JLabel("Undo:");
		lblUndo.setBounds(57, 150, 61, 16);
		frame.getContentPane().add(lblUndo);
		
		JLabel lblRedo = new JLabel("Redo:");
		lblRedo.setBounds(57, 185, 61, 16);
		frame.getContentPane().add(lblRedo);
		
		JLabel lblDelete = new JLabel("Delete:");
		lblDelete.setBounds(57, 219, 61, 16);
		frame.getContentPane().add(lblDelete);
		
		JLabel lblUndoesThePrevious = new JLabel("Undoes the previous action made");
		lblUndoesThePrevious.setBounds(111, 150, 242, 16);
		frame.getContentPane().add(lblUndoesThePrevious);
		
		JLabel lblCanReverseUndo = new JLabel("Can reverse undo or duplicate action");
		lblCanReverseUndo.setBounds(113, 185, 256, 16);
		frame.getContentPane().add(lblCanReverseUndo);
		
		JLabel lblPaintsCanvasWhite = new JLabel("Paints canvas white again");
		lblPaintsCanvasWhite.setBounds(113, 219, 240, 16);
		frame.getContentPane().add(lblPaintsCanvasWhite);
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(b);
	}

}
