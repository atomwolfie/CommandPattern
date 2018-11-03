package DrawCommands;

import DrawPad.DrawingPadConcept;

public class DrawRectangle implements Command {

	private DrawingPadConcept thePad;
	
	public DrawRectangle(DrawingPadConcept newPad){
		thePad = newPad;
	}
	
	
	@Override
	public void execute(int xCoor, int yCoor) {
		// TODO Auto-generated method stub
		thePad.drawRectangle(xCoor,  yCoor);
	}


	@Override
	public void undo() {
		thePad.eraseRectangle();
	}

	
	

	@Override
	public void executeText(String input, int xCoor, int yCoor) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void redo() {
		thePad.redoRectangle();
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
