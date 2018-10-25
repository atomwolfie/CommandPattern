 
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
 

public class DrawArea extends JComponent implements DrawingPadConcept{
 
  // Image in which we're going to draw
  private Image image;
  // Graphics2D object ==> used to draw on
  private static Graphics2D g2;
  // Mouse coordinates
  public static int currentX;
  public static int currentY;
  public int oldX;
  public int oldY;
  private int oldLineX = 0;
  private int oldLineY = 0;
  public int numClicks = 0;
  Point location;
  public String shape;
  private static String myInput;
  
  private int windowWidth = getSize().width;
  private int windowHeight = getSize().height;
  
  public static String topOfUndoStack;
  public static String topOfRedoStack;
  
  
  //for undo command//
  public ArrayList<String> previousShapes = new ArrayList<String>();
  public ArrayList<Integer> previousOldXCoor = new ArrayList<Integer>();
  public ArrayList<Integer> previousOldYCoor = new ArrayList<Integer>();
  public ArrayList<Integer> previousXCoor = new ArrayList<Integer>();
  public ArrayList<Integer> previousYCoor = new ArrayList<Integer>();
  
 
  //for redo command
  public ArrayList<String> redoCommands = new ArrayList<String>();
  public ArrayList<Integer> redoX = new ArrayList<Integer>();
  public ArrayList<Integer> redoY = new ArrayList<Integer>();
  public ArrayList<Integer> redoOldX = new ArrayList<Integer>();
  public ArrayList<Integer> redoOldY = new ArrayList<Integer>();
  
  //soecifically for text input
  public ArrayList<String> textInputs = new ArrayList<String>();
  
  
  public DrawArea() {
         
	  System.out.println("Height and width of window: " + getSize().width + "," + getSize().height);
	  previousShapes.add("start");
	  previousOldXCoor.add(0);
	  previousOldYCoor.add(0);
	  previousXCoor.add(0);
	  previousYCoor.add(0);
	  redoCommands.add("start");
	  redoX.add(0);
	  redoY.add(0);
	  redoOldX.add(0);
	  redoOldY.add(0);
	  
	  for(int i = 0; i < 1000; ++i){
		  textInputs.add("none");
	  }
	  
	  
	  
	  setDoubleBuffered(false);
    
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        // save coord x,y when mouse is pressed
        oldX = e.getX();
        oldY = e.getY();      
      }
    });
 
    
    
    addMouseListener(new MouseAdapter() 
	{
	    public void mouseClicked(MouseEvent e) 
	    {   	
	    	
	    	
	    	numClicks++;
	        //get coordinates
	    	currentX = e.getX();
	        currentY = e.getY();	    	
	    	//System.out.println("canvas just got clicked on");
	    	
	    	
	    	if(shape.equals("rec")){	    		
	    		SwingPaint.invokeRectangle.invoke(currentX,currentY);
	    		if(numClicks == 2){
	    		//previousShapes.add(shape);
	    		
	    		
	    		numClicks = 0;
	    		}
	    	}
	    	 if(shape.equals("circ")){
	    		//circle(currentX,currentY);
	    		 SwingPaint.invokeCircle.invoke(currentX,currentY);
	    		 if(numClicks == 2){
	 	    	//	previousShapes.add(shape);
	 	    		numClicks = 0;
	 	    		}
	    	}
	    	 if(shape.equals("line")){
		    		//line(currentX,currentY);
	    		 SwingPaint.invokeLine.invoke(currentX,currentY);
	    		 if(numClicks == 2){
	 	    		//previousShapes.add(shape);
	 	    		numClicks = 0;
	 	    		}
		    	}
	    	 if(shape.equals("text")){	
	    		
	    		 //get text from user in gui 
	    		 TextField textField = new TextField();
	    		 textField.xCoor = currentX;
	    		 textField.yCoor = currentY;
	    		 textField.setVisible(true);
	    		 if(numClicks == 2){
	 	    		//previousShapes.add(shape);
	 	    		numClicks = 0;
	 	    		}
	    	 }
	    	 repaint();	
	    }
	   
	});
    
    
    
    
    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        // coord x,y when drag mouse
        currentX = e.getX();
        currentY = e.getY();
 
        if (g2 != null) {
        	
          repaint();
          // store current coords x,y as olds x,y
          oldX = currentX;
          oldY = currentY;
        }
      }
    });
    
    
    
  }
 
  protected void paintComponent(Graphics g) {
    if (image == null) {
      // image to draw null ==> we create
      image = createImage(getSize().width, getSize().height);
      g2 = (Graphics2D) image.getGraphics();
      // enable antialiasing
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      // clear draw area
      delete();
    }
 
    g.drawImage(image, 0, 0, null);
  }
 	 
	  
//	  public static void string(String input, int xCoor, int yCoor){
//		  		
//		  		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//		        RenderingHints.VALUE_ANTIALIAS_ON);
//		        Font font = new Font("Serif", Font.PLAIN, 24);
//		        g2.setFont(font);
//		        System.out.println("Writing: " + input + "at " + xCoor + "," + yCoor);
//		        g2.drawString(input, xCoor, yCoor);		   	       
//	  }
	  
	  
	 
	  @Override
	  public void delete() {
		  		
	    g2.setPaint(Color.white);
	    // draw white on entire draw area to clear
	    System.out.println("width and height of drawArea: " + getSize().width + "'" + getSize().height);
	    g2.fillRect(0, 0, 600, 520);
	    g2.setPaint(Color.black);
	    repaint();
	    previousShapes.add("delete");
    	topOfUndoStack = "delete";
    	previousOldXCoor.add(0);
    	previousOldYCoor.add(0);
    	previousXCoor.add(0);
    	previousYCoor.add(0);
		  
	  }
	  
	  
	  public void viewUndoStack(){
		  System.out.println("Undo Stack");
		  System.out.print("[");
		  for(int i = 0; i < previousShapes.size(); ++i){
			  System.out.print(previousShapes.get(i) + ",");
		  }
		  System.out.print("] \n");
		  for(int i = 0; i < previousOldXCoor.size(); ++i){
			  System.out.print(previousOldXCoor.get(i) + ",");
		  }
		  System.out.print("] \n");
		  for(int i = 0; i < previousOldYCoor.size(); ++i){
			  System.out.print(previousOldYCoor.get(i) + ",");
		  }
		  System.out.print("] \n");
		  for(int i = 0; i < previousXCoor.size(); ++i){
			  System.out.print(previousXCoor.get(i) + ",");
		  }
		  System.out.print("] \n");
		  for(int i = 0; i < previousYCoor.size(); ++i){
			  System.out.print(previousYCoor.get(i) + ",");
		  }
		  System.out.print("] \n \n");
	  }
	  
	  
	  
	  
	  public void viewRedoStack(){
		  System.out.println("Redo Stack");
		  System.out.print("[");
		  for(int i = 0; i < redoCommands.size(); ++i){
			  System.out.print(redoCommands.get(i) + ",");
		  }
		  System.out.print("] \n");
		  System.out.print("[");
		  for(int i = 0; i < redoOldX.size(); ++i){
			  System.out.print(redoOldX.get(i) + ",");
		  }
		  System.out.print("] \n");
		  System.out.print("[");
		  for(int i = 0; i < redoOldY.size(); ++i){
			  System.out.print(redoOldY.get(i) + ",");
		  }
		  System.out.print("] \n");
		  System.out.print("[");
		  for(int i = 0; i < redoX.size(); ++i){
			  System.out.print(redoX.get(i) + ",");
		  }
		  System.out.print("] \n");
		  System.out.print("[");
		  for(int i = 0; i < redoY.size(); ++i){
			  System.out.print(redoY.get(i) + ",");
		  }
		  System.out.print("] \n \n");
	  }

	  @Override
		public void undoDelete() {
		
		  viewUndoStack();
		  viewRedoStack();
		  
		  for(int i = 0; i < previousShapes.size() -1; ++i){
			  		    
			  if(previousShapes.get(i).equals("start")){
				  System.out.println("nothing to put back on");
			  }
			  if(previousShapes.get(i).equals("rec")){
				  System.out.println("Putting a rectangle back");
				    
				    redoOldX.add(previousOldXCoor.get(i));
				    redoOldY.add(previousOldYCoor.get(i));
				    System.out.println("redoX size: " +redoX.size()  );
				    redoX.add(previousXCoor.get(i));
				  
				    System.out.println("redoY size: " +redoY.size()  );
				    redoY.add(previousYCoor.get(i));
				    
				    SwingPaint.invokeRectangle.pressRedo();
			  }
			  else if(previousShapes.get(i).equals("circ")){
				  System.out.println("Putting a circle back");
				  SwingPaint.invokeCircle.pressRedo();
			  }
			  else if(previousShapes.get(i).equals("line")){
				  System.out.println("Putting a line back");
				  SwingPaint.invokeLine.pressRedo();
			  }
			  else if(previousShapes.get(i).equals("text")){
				  System.out.println("Putting a text back");
				  SwingPaint.invokeText.pressRedo();
			  }
		  }	
		  
		  //remove from undo stack
		  previousShapes.remove(previousShapes.size()-1); 
		    topOfUndoStack = previousShapes.get(previousShapes.size()-1);
		    previousOldXCoor.remove(previousOldXCoor.size() -1);	    
		    previousOldYCoor.remove(previousOldYCoor.size()-1);
		    previousXCoor.remove(previousXCoor.size()-1);	    
		    previousYCoor.remove(previousYCoor.size()-1);
		      
		    //add to redo stack
		    topOfRedoStack = "delete";    	        
		    redoCommands.add("delete");
		    redoOldX.add(0);
		    redoOldY.add(0);
		    redoX.add(0);
		    redoY.add(0); 
		  
		  
		  }
		
	  
	  
	  
	  @Override
		public void redoDelete() {
		  g2.setPaint(Color.white);
		    // draw white on entire draw area to clear
		    System.out.println("width and height of drawArea: " + getSize().width + "'" + getSize().height);
		    g2.fillRect(0, 0, 600, 520);
		    g2.setPaint(Color.black);
		    repaint();
		    
		  //remove from redo stack
	        if(redoCommands.size() > 1){
			    redoCommands.remove(redoCommands.size()-1);				    				    
			    redoOldX.remove(redoOldX.size() -1);			    
			    redoOldY.remove(redoOldY.size()-1);				    
			    redoX.remove(redoX.size() -1);
			    redoY.remove(redoY.size() -1);

			    
			    //add to undo
			    previousShapes.add("delete");
			    topOfUndoStack = "delete";
			    previousOldXCoor.add(0);
			    previousOldYCoor.add(0);
			    previousXCoor.add(0);
			    previousYCoor.add(0);
		    
		}  
	  
	  }
	  

	@Override
	public void drawRectangle(int xCoor, int ycood) {
		g2.setPaint(Color.black);
	  	   
		int first = oldLineX;
		int second = oldLineY;
		int third = xCoor - oldLineX;
		int forth = ycood - oldLineY;
				
		   if(oldLineX == 0 && oldLineY == 0){
				  oldLineX = xCoor;
				  oldLineY = ycood;		
				  
				  first = xCoor;
				  second = ycood;
			  }
		   		   	   
		   else if(g2 != null){
			  	//draw rectangle here	
			   System.out.println("Inserting rectangle at " + first + ","+ second + "," + third + "," +forth);
			   g2.drawRect (first, second, third,forth);		   
		        repaint();
		        oldLineX = 0;
		        oldLineY = 0;
		        
		           previousShapes.add("rec");
		           topOfUndoStack = "rec";
				   previousOldXCoor.add(first);
				   previousOldYCoor.add(second);
				   previousXCoor.add(third);
				   previousYCoor.add(forth);
				   
				   topOfRedoStack = "rec";    	        
				    redoCommands.add("rec");
				    redoOldX.add(first);
				    redoOldY.add(second);
				    redoX.add(third);
				    redoY.add(forth);
				    
				    viewUndoStack();
					  viewRedoStack();
			  }		   
	}
	
	@Override
	public void eraseRectangle() {
		// TODO Auto-generated method stub
       
		if(previousShapes.size() == 1){
			System.out.println("No rectangle to erase");
		}
		else{
		System.out.println("Erasing previous rectangle");
        
        g2.setPaint(Color.white);
	  	   
        int firstValue = previousOldXCoor.get(previousOldXCoor.size() -1);
        int secondValue = previousOldYCoor.get(previousOldYCoor.size()-1);
        int thirdValue = previousXCoor.get(previousXCoor.size() -1);
        int fourthValue = previousYCoor.get(previousYCoor.size() -1);
		   	   
        System.out.println("My previousOldXCoor: " + firstValue);
        
		    if(g2 != null){
			  	//draw rectangle here		   
			   g2.drawRect (firstValue, secondValue, thirdValue, fourthValue);		   
		        repaint();
		        oldLineX = 0;
		        oldLineY = 0;
		        System.out.println("Erasing rectangle at " + firstValue + ","+ secondValue + "," + thirdValue + "," +fourthValue);
		     
		        
		        System.out.println("previous shapes size: " + previousShapes.size());
		        if(previousShapes.size() > 1){
			
		    previousShapes.remove(previousShapes.size()-1); 
		    topOfUndoStack = previousShapes.get(previousShapes.size()-1);
		    previousOldXCoor.remove(previousOldXCoor.size() -1);	    
		    previousOldYCoor.remove(previousOldYCoor.size()-1);
		    previousXCoor.remove(previousXCoor.size()-1);	    
		    previousYCoor.remove(previousYCoor.size()-1);
		        
		    topOfRedoStack = "rec";    	        
		    redoCommands.add("rec");
		    redoOldX.add(firstValue);
		    redoOldY.add(secondValue);
		    redoX.add(thirdValue);
		    redoY.add(fourthValue);    	    
		        }    		    
		    }	
		    
		    
		    for(int i = 0; i < previousShapes.size(); ++i){
		    	System.out.println("Undo: " + previousShapes.get(i));
		    }
		    
		    for(int i = 0; i < redoCommands.size(); ++i){
		    	System.out.println("Redo: " + redoCommands.get(i));
		    }
		    
		    System.out.println("redo stack size: " + redoCommands.size());
	        System.out.println("undo stack size: " + previousShapes.size());
		}
		
	}
	
	@Override
	public void redoRectangle(){
		System.out.println("Repainting the previous rectangle");
		        
        g2.setPaint(Color.black);
	  	   
        int firstValue = redoOldX.get(redoOldX.size() -1);
        int secondValue = redoOldY.get(redoOldY.size()-1);
        int thirdValue = redoX.get(redoX.size() -1);
        int fourthValue = redoY.get(redoY.size() -1);
		   	   
		    if(g2 != null){
			  	//draw rectangle here		   
			   g2.drawRect (firstValue, secondValue, thirdValue, fourthValue);		   
		        repaint();
		        oldLineX = 0;
		        oldLineY = 0;
		        System.out.println("repainting rectangle at " + firstValue + ","+ secondValue + "," + thirdValue + "," +fourthValue);
			 
		        System.out.println("redo stack size: " + redoCommands.size());
		        System.out.println("undo stack size: " + previousShapes.size());
		        
		    //remove from redo stack
		        if(redoCommands.size() > 1){
				    redoCommands.remove(redoCommands.size()-1);				    				    
				    redoOldX.remove(redoOldX.size() -1);			    
				    redoOldY.remove(redoOldY.size()-1);				    
				    redoX.remove(redoX.size() -1);
				    redoY.remove(redoY.size() -1);

				    
				    //add to undo
				    previousShapes.add("rec");
				    topOfUndoStack = "rec";
				    previousOldXCoor.add(firstValue);
				    previousOldYCoor.add(secondValue);
				    previousXCoor.add(thirdValue);
				    previousYCoor.add(fourthValue);	
		        }
		    }
		
	}

	@Override
	public void drawCircle(int xCoor, int yCoor) {
			
		
		if(oldLineX == 0 && oldLineY == 0){
			  oldLineX = xCoor;
			  oldLineY = yCoor;			  
		  }
		  
		  else if(g2 != null){
			  g2.setPaint(Color.black);
			  int circleX, cicleY, r;
			 
			  if(xCoor > oldLineX){
			  r = xCoor - oldLineX;
			  }
			  else{
				  r = oldLineX - xCoor;
			  }
			  
			  circleX = xCoor-(r/2);
			  cicleY = yCoor-(r/2);
			  System.out.println("drawing circle at: " + circleX + "," + cicleY + "," + r + "," + r);
			  g2.drawOval(circleX,cicleY,r,r);
		        repaint();
		        
		        oldLineX = 0;
		        oldLineY = 0;
		       	        
		           previousShapes.add("circ");
		           topOfUndoStack = "circ";
				   previousOldXCoor.add(circleX);
				   previousOldYCoor.add(cicleY);
				   previousXCoor.add(r);
				   previousYCoor.add(r);
				   
				   topOfRedoStack = "circ";  
				    redoCommands.add("circ");
				    redoOldX.add(circleX);
				    redoOldY.add(cicleY);
				    redoX.add(r);
				    redoY.add(r);
			  }	
	}

	
	
	@Override
	public void eraseCircle() {
		
		if(previousShapes.size() == 1){
			System.out.println("No circle to undo");
		}
		else{
		System.out.println("Erasing previous circle");
		
		 if(g2 != null){
			 g2.setPaint(Color.white);
			  int circleX = previousOldXCoor.get(previousOldXCoor.size()-1);
			  			  
			  int cicleY = previousOldYCoor.get(previousOldYCoor.size()-1);
			  
			  int r = previousXCoor.get(previousXCoor.size()-1);
			 
			  System.out.println("erasing circle at: " + circleX + "," + cicleY + "," + r + "," + r);
			  g2.drawOval(circleX,cicleY,r,r);
		        repaint();
		        
		        oldLineX = 0;
		        oldLineY = 0;
		        
		        //remove from undo queue
		        previousShapes.remove(previousShapes.size()-1); 
			    topOfUndoStack = previousShapes.get(previousShapes.size()-1);
			    previousOldXCoor.remove(previousOldXCoor.size() -1);	    
			    previousOldYCoor.remove(previousOldYCoor.size()-1);
			    previousXCoor.remove(previousXCoor.size()-1);	    
			    previousYCoor.remove(previousYCoor.size()-1);
			        
			    //add to redo queue    
			    topOfRedoStack = "circ";  
			    redoCommands.add("circ");
			    redoOldX.add(circleX);
			    redoOldY.add(cicleY);
			    redoX.add(r);
			    redoY.add(r);
			  }			
		}
	}
	
	
		
	@Override
	public void redoCircle() {
			
		if(g2 != null){
			  g2.setPaint(Color.black);
			  
			  int circleX = redoOldX.get(redoOldX.size()-1);
			  
			  int cicleY = redoOldY.get(redoOldY.size()-1);
			  
			  int r = redoX.get(redoX.size()-1);
			 
			  
			  System.out.println("drawing circle at: " + circleX + "," + cicleY + "," + r + "," + r);
			  g2.drawOval(circleX,cicleY,r,r);
		        repaint();
		        
		        oldLineX = 0;
		        oldLineY = 0;
		       	   		        
		      //remove from redo stack
		        if(redoCommands.size() > 1){
				    redoCommands.remove(redoCommands.size()-1);				    				    
				    redoOldX.remove(redoOldX.size() -1);			    
				    redoOldY.remove(redoOldY.size()-1);				    
				    redoX.remove(redoX.size() -1);
				    redoY.remove(redoY.size() -1);
				    
				    //add to undo
				    previousShapes.add("circ");
				    topOfUndoStack = "circ";
				    previousOldXCoor.add(circleX);
				    previousOldYCoor.add(cicleY);
				    previousXCoor.add(r);
				    previousYCoor.add(r);
		         
			  }
		}
		
	}
	
	
	@Override
	public void drawLine(int xCoor, int yCoor) {
		// TODO Auto-generated method stub
		if(oldLineX == 0 && oldLineY == 0){
			  oldLineX = xCoor;
			  oldLineY = yCoor;			  
		  }
		  
		  else if(g2 != null ){
			g2.setPaint(Color.black);
			
			System.out.println("creating line with coordinates: " + oldLineX + "," + oldLineY + "," +  xCoor + "," + yCoor);
		    g2.drawLine(oldLineX, oldLineY, xCoor, yCoor);
	        repaint();
	        previousOldXCoor.add(oldLineX);
			   previousOldYCoor.add(oldLineY);
	        oldLineX = 0;
	        oldLineY = 0;	
	        
	        
	        previousShapes.add("line");
	           topOfUndoStack = "line";
			   previousXCoor.add(xCoor);
			   previousYCoor.add(yCoor);
			   
			   topOfRedoStack = "line";  
			    redoCommands.add("line");
			    redoOldX.add(oldLineX);
			    redoOldY.add(oldLineY);
			    redoX.add(xCoor);
			    redoY.add(yCoor);        
		  }
		
	}
	
	
	@Override
	public void eraseLine() {
		// TODO Auto-generated method stub
		System.out.println("Erasing previous line");
		
		
		  
		   if(g2 != null ){
			   g2.setPaint(Color.white);
			 int first =  previousOldXCoor.get(previousOldXCoor.size()-1);
			 int second =  previousOldYCoor.get(previousOldYCoor.size()-1);
			  int third = previousXCoor.get(previousXCoor.size()-1);
			  int forth =  previousYCoor.get(previousYCoor.size()-1);
			  
				System.out.println("undoing line with coordinates: " + first + "," + second + "," +  third + "," + forth);

		    g2.drawLine(first, second, third, forth);
	        repaint();
	        oldLineX = 0;
	        oldLineY = 0;
	        
	        
	      //remove from undo queue
	        previousShapes.remove(previousShapes.size()-1); 
		    topOfUndoStack = previousShapes.get(previousShapes.size()-1);
		    previousOldXCoor.remove(previousOldXCoor.size() -1);	    
		    previousOldYCoor.remove(previousOldYCoor.size()-1);
		    previousXCoor.remove(previousXCoor.size()-1);	    
		    previousYCoor.remove(previousYCoor.size()-1);
		        
		    //add to redo queue    
		    topOfRedoStack = "line";  
		    redoCommands.add("line");
		    redoOldX.add(first);
		    redoOldY.add(second);
		    redoX.add(third);
		    redoY.add(forth);	        
		  }
	}

	@Override
	public void redoLine() {
				
		 if(g2 != null ){
			
			 g2.setPaint(Color.black);
			 int first =  redoOldX.get(redoOldX.size()-1);
			 int second =  redoOldY.get(redoOldY.size()-1);
			 int third = redoX.get(redoX.size()-1);
			 int forth =  redoY.get(redoY.size()-1);
			 
			System.out.println("redoing line with coordinates: " + first + "," + second + "," +  third + "," + forth);

		    g2.drawLine(first, second, third, forth);
	        repaint();
	             
	      //remove from redo stack
	        if(redoCommands.size() > 1){
			    redoCommands.remove(redoCommands.size()-1);				    				    
			    redoOldX.remove(redoOldX.size() -1);			    
			    redoOldY.remove(redoOldY.size()-1);				    
			    redoX.remove(redoX.size() -1);
			    redoY.remove(redoY.size() -1);
			    
			    //add to undo
			    previousShapes.add("line");
			    topOfUndoStack = "line";
			    previousOldXCoor.add(first);
			    previousOldYCoor.add(second);
			    previousXCoor.add(third);
			    previousYCoor.add(forth);
	               
		  }
		 }
		
		
	}
	
	
	

	@Override
	public void insertText(String text, int xCoor, int yCoor) {
		if(g2 != null ){
		        Font font = new Font("Serif", Font.PLAIN, 24);
		        g2.setFont(font);
		        System.out.println("Writing: " + text + "at " + xCoor + "," + yCoor);
		        g2.drawString(text, xCoor, yCoor);	
		        repaint();
		        		        
				   previousShapes.add("text");
				   topOfUndoStack = "text";
				   previousOldXCoor.add(xCoor);
				   previousOldYCoor.add(yCoor);
				   previousXCoor.add(0);
				   previousYCoor.add(0);
				   				   
				  textInputs.add(previousShapes.size()-1, text);
				   
				   topOfRedoStack = "text";  
				    redoCommands.add("text");
				    redoOldX.add(xCoor);
				    redoOldY.add(yCoor);
				    redoX.add(0);
				    redoY.add(0); 		        
	}
	}

	@Override
	public void eraseText() {
		if(g2 != null ){
	       
			String text = textInputs.get(previousShapes.size()-1);
			int xCoor = previousOldXCoor.get(previousOldXCoor.size()-1);
			int yCoor = previousOldYCoor.get(previousOldYCoor.size()-1);
			
			g2.setPaint(Color.white);
			Font font = new Font("Serif", Font.PLAIN, 24);
	        g2.setFont(font);
	        System.out.println("erasing text at: " + text + "at " + xCoor + "," + yCoor);
	        g2.drawString(text, xCoor, yCoor);	
	        repaint();	 
	        	        
//	      //remove from undo queue
	        previousShapes.remove(previousShapes.size()-1); 
		    topOfUndoStack = previousShapes.get(previousShapes.size()-1);
		    previousOldXCoor.remove(previousOldXCoor.size() -1);	    
		    previousOldYCoor.remove(previousOldYCoor.size()-1);
		    previousXCoor.remove(previousXCoor.size()-1);	    
		    previousYCoor.remove(previousYCoor.size()-1);
		        
//		    //add to redo queue    
		    topOfRedoStack = "text";  
		    redoCommands.add("text");
		    redoOldX.add(xCoor);
		    redoOldY.add(yCoor);
		    redoX.add(0);
		    redoY.add(0);
		    
		    textInputs.add(redoCommands.size()-1, text);	        
}	
	}

	@Override
	public void redoText() {
		if(g2 != null ){
		       
			String text = textInputs.get(redoCommands.size()-1);
			int xCoor = redoOldX.get(redoOldX.size()-1);
			int yCoor = redoOldY.get(redoOldY.size()-1);
			
			g2.setPaint(Color.black);
			Font font = new Font("Serif", Font.PLAIN, 24);
	        g2.setFont(font);
	        System.out.println("redoing text at: " + text + "at " + xCoor + "," + yCoor);
	        g2.drawString(text, xCoor, yCoor);	
	        repaint();	 	
	        
	      //remove from redo queue
	        redoCommands.remove(redoCommands.size()-1); 
		    topOfRedoStack = redoCommands.get(redoCommands.size()-1);
		    redoOldX.remove(redoOldX.size() -1);	    
		    redoOldY.remove(redoOldY.size()-1);
		    redoX.remove(redoX.size()-1);	    
		    redoY.remove(redoY.size()-1);
		        
		    //add to undo queue    
		    topOfUndoStack = "text";  
		    previousShapes.add("text");
		    previousOldXCoor.add(xCoor);
		    previousOldYCoor.add(yCoor);
		    previousXCoor.add(0);
		    previousYCoor.add(0);
		    
		    textInputs.add(previousShapes.size()-1, text);
}		
	}
 
}