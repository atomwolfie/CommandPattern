package DrawCommands;
import DrawPad.DrawingPadConcept;

public class DrawLine implements Command{

	
private DrawingPadConcept thePad;
	
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


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
	
}
