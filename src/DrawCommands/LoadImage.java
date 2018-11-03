package DrawCommands;

import DrawPad.DrawingPadConcept;

public class LoadImage implements Command{

	private DrawingPadConcept thePad;
	
	public LoadImage(DrawingPadConcept newPad){
		thePad = newPad;
	}
	
	@Override
	public void execute() {
		thePad.loadImage();		
	}
	
	@Override
	public void execute(int xCoor, int yCoor) {
		thePad.loadImage();
		
	}

	@Override
	public void executeText(String input, int xCoor, int yCoor) {
		thePad.loadImage();	
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}
}
