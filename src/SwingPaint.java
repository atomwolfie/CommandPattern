 
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

 
public class SwingPaint {
 
    JLabel recLabel, diamondLbl, lineLbl, undoLbl, redolbl, deleteLabel;
   
  DrawArea drawArea;
 
  static DrawingPadConcept newConcept = Pencil.getDrawingPad();
  //---------------------------------------------------------------------
  static DrawRectangle rectangleCommand = new DrawRectangle(newConcept);
  static Invoker invokeRectangle = new Invoker(rectangleCommand);
  //---------------------------------------------------------------------
  static DrawCircle circleCommand = new DrawCircle(newConcept);
   static Invoker invokeCircle = new Invoker(circleCommand);
  //---------------------------------------------------------------------
   static DrawLine lineCommand = new DrawLine(newConcept);
   static Invoker invokeLine = new Invoker(lineCommand);
   //--------------------------------------------------------------------
   static InsertText textCommand = new InsertText(newConcept);
   static Invoker invokeText = new Invoker(textCommand);
   //----------------------------------------------------
   static DeleteEverything padDelete = new DeleteEverything(newConcept);
   static Invoker invokeDelete = new Invoker(padDelete);
   
   
  public static void main(String[] args) {
    new SwingPaint().show();
  }
 
  public void show() {
	  	  
    // create main frame
    JFrame frame = new JFrame("Aaron's UML Program");
    Container content = frame.getContentPane();
    // set layout on content pane
    content.setLayout(new BorderLayout());
    // create draw area
    drawArea = new DrawArea();
 
    // add to content pane
    content.add(drawArea, BorderLayout.CENTER);
 
    // create controls to apply colors and call clear feature
    JPanel controls = new JPanel();
 
    
    
    ImageIcon recIcon = new ImageIcon(
  		  SwingPaint.class.getResource("icons/48pixel-Editing-Rectangle-icon.png"));
    JLabel recLabel = new JLabel(recIcon);	
    recLabel.addMouseListener(new MouseAdapter() 
	{
	    @Override
	    public void mouseClicked(MouseEvent e) 
	    {   	
	    	drawArea.shape = "rec";    	
	    	System.out.println("Hey you clicked the rectangle Button");
	    	System.out.println("Ready to draw shape: " + drawArea.shape + "\n");
	    }
	});
  	
    ImageIcon lineIcon = new ImageIcon(
  		  SwingPaint.class.getResource("icons/48pixel-Line-icon.png"));
     JLabel lineLabel = new JLabel(lineIcon);
     lineLabel.addMouseListener(new MouseAdapter() 
		{
		   @Override
		    public void mouseClicked(MouseEvent e) 
		    {
			   drawArea.shape = "line";
		        //statement 		    	
		    	System.out.println("Hey you clicked the line Button");
		    	System.out.println("Ready to draw shape: " + drawArea.shape + "\n");
		    }
		});
     
    ImageIcon circleIcon = new ImageIcon(
  		  SwingPaint.class.getResource("icons/Arrow-Circle-icon.png"));
    JLabel circleLabel = new JLabel(circleIcon);
    circleLabel.addMouseListener(new MouseAdapter() 
	{
	    @Override
	    public void mouseClicked(MouseEvent e) 
	    {
	        //statement 
	    	drawArea.shape = "circ";
	    	System.out.println("Hey you clicked the circle Button");
	    	System.out.println("Ready to draw shape: " + drawArea.shape + "\n");
	    }
	});  
       
    ImageIcon redoIcon = new ImageIcon(
  		  SwingPaint.class.getResource("icons/redo-icon.png"));
    JLabel redoLabel = new JLabel(redoIcon);
    redoLabel.addMouseListener(new MouseAdapter() 
	{
	    @Override
	    public void mouseClicked(MouseEvent e) 
	    {
	        //statement 
	    	System.out.println("Hey you clicked the redo Button");
	    	
	    	System.out.println("top of redo stack: " + drawArea.topOfRedoStack);
	    	
	    	if(drawArea.topOfRedoStack.equals("rec")){
	    	invokeRectangle.pressRedo();
	    	}
	    	else if(drawArea.topOfRedoStack.equals("circ")){
		    	System.out.println("redoing the circle");
	    		invokeCircle.pressRedo();
	    	}
	    	else if(drawArea.topOfRedoStack.equals("line")){
		    	System.out.println("redoing the line");
	    		invokeLine.pressRedo();
	    	}
	    	else if(drawArea.topOfRedoStack.equals("text")){
		    	System.out.println("redoing the text");
	    		invokeText.pressRedo();
	    	}
	    	else if(drawArea.topOfRedoStack.equals("delete")){
		    	System.out.println("redoing the delete");
	    		invokeDelete.pressRedo();
	    	}
	    	
	    	drawArea.repaint();
	    	
	    }
	});
    
    ImageIcon undoIcon = new ImageIcon(
  		  SwingPaint.class.getResource("icons/undo-icon.png"));
    JLabel undoLabel = new JLabel(undoIcon);
    undoLabel.addMouseListener(new MouseAdapter() 
	{
	    @Override
	    public void mouseClicked(MouseEvent e) 
	    {
	        //statement 
	    	System.out.println("Hey you clicked the undo Button");	    
	    	System.out.println("top of undo stack: " + drawArea.topOfUndoStack);
	    	
	    	if(drawArea.topOfUndoStack.equals("rec")){
	    	invokeRectangle.pressUndo();
	    	}
	    	else if (drawArea.topOfUndoStack.equals("circ")){
	    		invokeCircle.pressUndo();
	    	}
	    	else if (drawArea.topOfUndoStack.equals("line")){
	    		invokeLine.pressUndo();
	    	}
	    	else if (drawArea.topOfUndoStack.equals("delete")){
	    		invokeDelete.pressUndo();
	    	}
	    	else if (drawArea.topOfUndoStack.equals("text")){
	    		invokeText.pressUndo();
	    	}
	    	
	    	drawArea.repaint();
	    }
	});
    
    ImageIcon deleteIcon = new ImageIcon(
  		  SwingPaint.class.getResource("icons/Close-2-icon.png"));
      deleteLabel = new JLabel(deleteIcon);
      deleteLabel.addMouseListener(new MouseAdapter() 
		{
		    @Override
		    public void mouseClicked(MouseEvent e) 
		    {
		    	invokeDelete.invoke(0, 0);
		    	System.out.println("Hey you clicked the delete Button");	    	
		    	drawArea.repaint();
		    }
		});
      
      ImageIcon textIcon = new ImageIcon(
      		  SwingPaint.class.getResource("icons/Text-icon.png"));
      JLabel textLabel = new JLabel(textIcon);     
      textLabel.addMouseListener(new MouseAdapter() 
		{
		    @Override
		    public void mouseClicked(MouseEvent e) 
		    {
		    	
		    	drawArea.shape = "text";
		    	System.out.println("Hey you clicked the text Button");		    	
		    }
		});
      
      ImageIcon helpIcon = new ImageIcon(
      		  SwingPaint.class.getResource("icons/help-icon.png"));
      JLabel helpLabel = new JLabel(helpIcon);     
      helpLabel.addMouseListener(new MouseAdapter() 
		{
		    @Override
		    public void mouseClicked(MouseEvent e) 
		    {
		    	System.out.println("Hey you clicked the help Button");
		    	
		    	//make dialog box pop up
		    	HelpWindow help = new HelpWindow();
		    	help.setVisible(true);
		    	
		    }
		});
    
      
    controls.add(recLabel);
    controls.add(circleLabel);
    controls.add(lineLabel);
    controls.add(textLabel);
    controls.add(undoLabel);
    controls.add(redoLabel);
    controls.add(deleteLabel);
    controls.add(helpLabel);
 
    content.add(controls, BorderLayout.NORTH);
 
    frame.setSize(600, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
 
  }
 
}