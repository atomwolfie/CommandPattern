package Main;

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

import DrawCommands.DeleteEverything;
import DrawCommands.DrawCircle;
import DrawCommands.DrawLine;
import DrawCommands.DrawRectangle;
import DrawCommands.InsertText;
import DrawCommands.Invoker;
import DrawCommands.LoadImage;
import DrawPad.DrawArea;
import DrawPad.DrawingPadConcept;
import DrawPad.HelpWindow;
import DrawPad.Pencil;

 
public class Main {
 
   private JLabel recLabel, diamondLabel, lineLabel, helpLabel, textLabel, 
   redoLabel, circleLabel, undoLabel, redolabel, deleteLabel, saveLabel, loadLabel;
   
  DrawArea drawArea;
 
  private static DrawingPadConcept newConcept = Pencil.getDrawingPad();
  //---------------------------------------------------------------------
  static DrawRectangle rectangleCommand = new DrawRectangle(newConcept);
  private static Invoker invokeRectangle = new Invoker(rectangleCommand);
  //---------------------------------------------------------------------
  static DrawCircle circleCommand = new DrawCircle(newConcept);
   private static Invoker invokeCircle = new Invoker(circleCommand);
  //---------------------------------------------------------------------
   static DrawLine lineCommand = new DrawLine(newConcept);
   private static Invoker invokeLine = new Invoker(lineCommand);
   //--------------------------------------------------------------------
   static InsertText textCommand = new InsertText(newConcept);
   private static Invoker invokeText = new Invoker(textCommand);
   //----------------------------------------------------
   static DeleteEverything padDelete = new DeleteEverything(newConcept);
   static Invoker invokeDelete = new Invoker(padDelete);
   //-----------------------------------------------------------
   static LoadImage imageLoader = new LoadImage(newConcept);
   static Invoker invokeLoad = new Invoker(imageLoader);
 //-----------------------------------------------------------
   static LoadImage imageSaver = new LoadImage(newConcept);
   static Invoker invokeSave = new Invoker(imageSaver);
   
  public static void main(String[] args) {
    new Main().show();
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
 
    
    
    ImageIcon saveIcon = new ImageIcon(
    		  Main.class.getResource("icons/floppy-disk.png"));
     saveLabel = new JLabel(saveIcon);     
    saveLabel.addMouseListener(new MouseAdapter() 
		{
		    @Override
		    public void mouseClicked(MouseEvent e) 
		    {
		    	
		    	drawArea.setShape("save");
		    	System.out.println("Hey you clicked the save Button");		
		    	
		    	drawArea.saveImage();
		    }
		});
    
    
    ImageIcon loadIcon = new ImageIcon(
  		  Main.class.getResource("icons/folder.png"));
  loadLabel = new JLabel(loadIcon);     
  loadLabel.addMouseListener(new MouseAdapter() 
		{
		    @Override
		    public void mouseClicked(MouseEvent e) 
		    {		    	
		    	drawArea.setShape("load");
		    	System.out.println("Hey you clicked the load Button");		
		    	drawArea.loadImage();
		    }
		});
    
    
    ImageIcon recIcon = new ImageIcon(
  		  Main.class.getResource("icons/48pixel-Editing-Rectangle-icon.png"));
    recLabel = new JLabel(recIcon);	
    recLabel.addMouseListener(new MouseAdapter() 
	{
	    @Override
	    public void mouseClicked(MouseEvent e) 
	    {   	
	    	drawArea.setShape("rec");    	
	    	System.out.println("Hey you clicked the rectangle Button");
	    	System.out.println("Ready to draw shape: " + drawArea.getShape() + "\n");
	    }
	});
  	
    ImageIcon lineIcon = new ImageIcon(
  		  Main.class.getResource("icons/48pixel-Line-icon.png"));
     lineLabel = new JLabel(lineIcon);
     lineLabel.addMouseListener(new MouseAdapter() 
		{
		   @Override
		    public void mouseClicked(MouseEvent e) 
		    {
			   drawArea.setShape("line");
		        //statement 		    	
		    	System.out.println("Hey you clicked the line Button");
		    	System.out.println("Ready to draw shape: " + drawArea.getShape() + "\n");
		    }
		});
     
    ImageIcon circleIcon = new ImageIcon(
  		  Main.class.getResource("icons/Arrow-Circle-icon.png"));
    circleLabel = new JLabel(circleIcon);
    circleLabel.addMouseListener(new MouseAdapter() 
	{
	    @Override
	    public void mouseClicked(MouseEvent e) 
	    {
	        //statement 
	    	drawArea.setShape("circ");
	    	System.out.println("Hey you clicked the circle Button");
	    	System.out.println("Ready to draw shape: " + drawArea.getShape() + "\n");
	    }
	});  
       
    ImageIcon redoIcon = new ImageIcon(
  		  Main.class.getResource("icons/redo-icon.png"));
    redoLabel = new JLabel(redoIcon);
    redoLabel.addMouseListener(new MouseAdapter() 
	{
	    @Override
	    public void mouseClicked(MouseEvent e) 
	    {
	        //statement 
	    	System.out.println("Hey you clicked the redo Button");
	    	
	    	System.out.println("top of redo stack: " + drawArea.gettopOfRedoStack());
	    	
	    	if(drawArea.gettopOfRedoStack().equals("rec")){
	    	getInvokeRectangle().pressRedo();
	    	}
	    	else if(drawArea.gettopOfRedoStack().equals("circ")){
		    	System.out.println("redoing the circle");
	    		getInvokeCircle().pressRedo();
	    	}
	    	else if(drawArea.gettopOfRedoStack().equals("line")){
		    	System.out.println("redoing the line");
	    		getInvokeLine().pressRedo();
	    	}
	    	else if(drawArea.gettopOfRedoStack().equals("text")){
		    	System.out.println("redoing the text");
	    		getInvokeText().pressRedo();
	    	}
	    	else if(drawArea.gettopOfRedoStack().equals("delete")){
		    	System.out.println("redoing the delete");
	    		invokeDelete.pressRedo();
	    	}
	    	
	    	drawArea.repaint();
	    	
	    }
	});
    
    ImageIcon undoIcon = new ImageIcon(
  		  Main.class.getResource("icons/undo-icon.png"));
    undoLabel = new JLabel(undoIcon);
    undoLabel.addMouseListener(new MouseAdapter() 
	{
	    @Override
	    public void mouseClicked(MouseEvent e) 
	    {
	        //statement 
	    	System.out.println("Hey you clicked the undo Button");	    
	    	System.out.println("top of undo stack: " + drawArea.gettopOfUndoStack());
	    	
	    	if(drawArea.gettopOfUndoStack().equals("rec")){
	    	getInvokeRectangle().pressUndo();
	    	}
	    	else if (drawArea.gettopOfUndoStack().equals("circ")){
	    		getInvokeCircle().pressUndo();
	    	}
	    	else if (drawArea.gettopOfUndoStack().equals("line")){
	    		getInvokeLine().pressUndo();
	    	}
	    	else if (drawArea.gettopOfUndoStack().equals("delete")){
	    		invokeDelete.pressUndo();
	    	}
	    	else if (drawArea.gettopOfUndoStack().equals("text")){
	    		getInvokeText().pressUndo();
	    	}
	    	
	    	drawArea.repaint();
	    }
	});
    
    ImageIcon deleteIcon = new ImageIcon(
  		  Main.class.getResource("icons/Close-2-icon.png"));
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
      		  Main.class.getResource("icons/Text-icon.png"));
      textLabel = new JLabel(textIcon);     
      textLabel.addMouseListener(new MouseAdapter() 
		{
		    @Override
		    public void mouseClicked(MouseEvent e) 
		    {	    	
		    	drawArea.setShape("text");
		    	System.out.println("Hey you clicked the text Button");		    	
		    }
		});
      
      ImageIcon helpIcon = new ImageIcon(
      		  Main.class.getResource("icons/help-icon.png"));
      helpLabel = new JLabel(helpIcon);     
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
    
    controls.add(saveLabel);  
    controls.add(loadLabel);
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

public static Invoker getInvokeRectangle() {
	return invokeRectangle;
}

public static void setInvokeRectangle(Invoker invokeRectangle) {
	Main.invokeRectangle = invokeRectangle;
}

public static Invoker getInvokeCircle() {
	return invokeCircle;
}

public static void setInvokeCircle(Invoker invokeCircle) {
	Main.invokeCircle = invokeCircle;
}

public static Invoker getInvokeText() {
	return invokeText;
}

public static void setInvokeText(Invoker invokeText) {
	Main.invokeText = invokeText;
}

public static Invoker getInvokeLine() {
	return invokeLine;
}

public static void setInvokeLine(Invoker invokeLine) {
	Main.invokeLine = invokeLine;
}
 
}