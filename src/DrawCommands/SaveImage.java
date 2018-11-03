package DrawCommands;

import DrawPad.DrawingPadConcept;

public class SaveImage implements Command{

	private DrawingPadConcept thePad;
	
	public SaveImage(DrawingPadConcept newPad){
		thePad = newPad;
	}
	
	
	@Override
	public void execute() {
		thePad.loadImage();		
	}
	
	@Override
	public void execute(int xCoor, int yCoor) {
		thePad.saveImage();
		
	}

	@Override
	public void executeText(String input, int xCoor, int yCoor) {
		thePad.saveImage();		
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
