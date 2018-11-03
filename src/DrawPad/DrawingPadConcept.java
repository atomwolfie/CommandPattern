package DrawPad;

public interface DrawingPadConcept {
	
	public void drawRectangle(int xCoor, int ycood);
	public void eraseRectangle();
	public void redoRectangle();
	
	public void drawCircle(int xCoor, int ycood);
	public void eraseCircle();
	public void redoCircle();
	
	public void drawLine(int xCoor, int yCoor);
	public void eraseLine();
	public void redoLine();
	
	public void insertText(String text,int xCoor, int yCoor);
	public void eraseText();
	public void redoText();
	
	public void delete();
	public void undoDelete();	
	public void redoDelete();
	
	public void saveImage();
	public void loadImage();
	

	

	

	
}
