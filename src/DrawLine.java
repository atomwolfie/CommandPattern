
public class DrawLine implements Command{

	
DrawingPadConcept thePad;
	
	public DrawLine(DrawingPadConcept newPad){
		thePad = newPad;
	}
	
	
	@Override
	public void execute(int xCoor, int yCoor) {
		// TODO Auto-generated method stub
		thePad.drawLine(xCoor,  yCoor);
	}


	@Override
	public void undo() {
		// TODO Auto-generated method stub
		thePad.eraseLine();
	}


	@Override
	public void executeText(String input, int xCoor, int yCoor) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void redo() {
		// TODO Auto-generated method stub
		thePad.redoLine();
	}
	
}
