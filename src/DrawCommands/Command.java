package DrawCommands;

public interface Command {

	public void execute();
	public void execute(int xCoor, int yCoor);
	public void executeText(String input, int xCoor, int yCoor);
	public void undo();
	public void redo();
	
}
