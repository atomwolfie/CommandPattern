
public class Invoker {

	Command theCommand;
	
	public Invoker(Command newCommand){
		theCommand = newCommand;
	}
	
	public void invoke(int xCoor, int yCoor){
		theCommand.execute(xCoor,  yCoor);
	}
	
	public void invokeText(String input, int xCoor, int yCoor){
		theCommand.executeText(input,xCoor,  yCoor);
	}
	
	public void pressUndo(){			
		        theCommand.undo();		
		    }

	public void pressRedo(){
		theCommand.redo();
	}
	
}
