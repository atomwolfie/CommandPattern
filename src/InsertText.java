
public class InsertText implements Command{

	
DrawingPadConcept thePad;
	
	public InsertText(DrawingPadConcept newPad){
		thePad = newPad;
	}
	
	
	@Override
	public void executeText(String input, int xCoor, int yCoor) {
		// TODO Auto-generated method stub
		thePad.insertText(input, xCoor,  yCoor);
	}


	@Override
	public void undo() {
		thePad.eraseText();
	}


	@Override
	public void execute(int xCoor, int yCoor) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void redo() {
		thePad.redoText();
	}
	
}
