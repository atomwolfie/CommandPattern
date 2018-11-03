package DrawCommands;

import DrawPad.DrawingPadConcept;

public class DeleteEverything implements Command {

	private DrawingPadConcept thePad;

	
	public DeleteEverything(DrawingPadConcept newPad){
		thePad = newPad;
	}
	
	@Override
	public void execute(int xCoor, int yCoor) {
		// TODO Auto-generated method stub
		thePad.delete();
	}

	@Override
	public void executeText(String input, int xCoor, int yCoor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		thePad.undoDelete();
	}

	@Override
	public void redo() {
		thePad.redoDelete();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
