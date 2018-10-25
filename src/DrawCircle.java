public class DrawCircle implements Command{
	
	DrawingPadConcept thePad;
	
	public DrawCircle(DrawingPadConcept newPad){
		thePad = newPad;
	}
	
	
	@Override
	public void execute(int xCoor, int yCoor) {
		// TODO Auto-generated method stub
		thePad.drawCircle(xCoor,  yCoor);
	}


	@Override
	public void undo() {
		// TODO Auto-generated method stub
		thePad.eraseCircle();
	}


	@Override
	public void executeText(String input, int xCoor, int yCoor) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void redo() {
		// TODO Auto-generated method stub
		thePad.redoCircle();
	}

}
