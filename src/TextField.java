import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.util.List;
import java.util.LinkedList;

public class TextField {

	private JFrame frame;
	private JTextField txtYourText;
	private JButton btnEnter;
	public int xCoor, yCoor;
	
	public String inputText = "nada";
	
	  final List<Integer> holder = new LinkedList<Integer>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextField window = new TextField();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TextField() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Enter Text");
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterTextHere = new JLabel("Enter text here:");
		lblEnterTextHere.setBounds(61, 72, 101, 16);
		frame.getContentPane().add(lblEnterTextHere);
		
		txtYourText = new JTextField();
		txtYourText.setText("your text");
		txtYourText.setBounds(167, 67, 130, 26);
		frame.getContentPane().add(txtYourText);
		txtYourText.setColumns(10);
		
		btnEnter = new JButton("enter");
		btnEnter.setBounds(125, 138, 117, 29);
		frame.getContentPane().add(btnEnter);
		
		
		btnEnter.addActionListener(buttonListener);
	}
	
	
	
	ActionListener buttonListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			
			
			if(e.getSource() ==btnEnter){
				inputText = txtYourText.getText();
				System.out.println("You entered " + inputText);
				
				
				SwingPaint.invokeText.invokeText(inputText,xCoor,yCoor);
				frame.setVisible(false);
			}
			
		}
	
	};
	
	
	
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(b);
		
	}
}
