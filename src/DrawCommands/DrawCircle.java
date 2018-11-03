package DrawCommands;
import DrawPad.DrawingPadConcept;

public class DrawCircle implements Command{
	
	private DrawingPadConcept thePad;
	
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


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
