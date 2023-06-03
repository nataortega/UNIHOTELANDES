package view;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.io.File;

/**
 * This class is a demo of a background image in a JFrame.
 * 
 * This code was derived from the following source:
 * 
 * @see http://java-demos.blogspot.in/2012/09/setting-background-image-in-jframe.html
 * @see http://stackoverflow.com/questions/18777893/jframe-background-image?noredirect=1#comment27722482_18777893
 * 
 * My code is an improvement of the code given in the links above.
 * 
 * 1. The instance variables are private for better encapsulation.
 * 2. The window size adjusts to the size of the image automatically because the method pack() is called in this new code.
 * 3. The method setVisible() is called last of all, as it should be, to make the hacks of calling setSize() twice with
 *    different sizes is unnecessary.
 * 4. The full pathnames in the Windows style, specifying a particular image (that you probably don't have) has been changed
 *    to allow you to choose a path with a GUI interface, using the class MyFileChooser (see the bottom of this file).
 * 5. The JFrame is created in the way recommended by Oracle in its tutorials:
 *    @see http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
 *
 */
public class background extends JFrame
{
  // instance variables
	// instance variables should really be private to keep code in other classes from messing them up.
	private JButton b1;
	private JLabel l1;

	/**
	 * This constructor now takes a File object as a parameter, making this class more general, removing the need
	 * for had-coded pathnames.
	 * 
	 * @param imageFile The file to be the background image of this JFrame
	 */
	public background(File imageFile)
	{
	    // This worked well, except for the hard-coded, Windows type of full pathname
	    // One way
	    // -----------------
		
	    setLayout(new BorderLayout());
	    JLabel background=new JLabel(new ImageIcon(imageFile.getAbsolutePath()));
	    add(background);
	    background.setLayout(new FlowLayout());
	    l1=new JLabel("Here is a button");
	    b1=new JButton("I am a button");
	    background.add(l1);
	    background.add(b1);
	    
	    /* This worked well, except for the hard-coded, Windows type of full pathname
		// Another way
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon(imageFile.getAbsolutePath())));
		setLayout(new FlowLayout());
		l1=new JLabel("Here is a button");
		b1=new JButton("I am a button");
		add(l1);
		add(b1);
		 */

		// finish initializing the window (this is best done last)
		setTitle("Background Image Demo for JFrame");
		pack(); // automatically size the window to fit its components
		setLocationRelativeTo(null); // center this window on the screen
		setDefaultCloseOperation(EXIT_ON_CLOSE); // when this window is closed, exit this application
		// setVisible(true); // call setVisible(true) last of all (best if done by method that created this JFrame
	}

	public static void main(String args[])
	{
		/**
		 * You really need to get in the habit of creating GUI objects in the following way, as recommended by Oracle
		 * @see http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
		 */
		// 
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				File imageFile = MyFileChooser.chooseFile("Image Files (png & jpg)", "png", "jpg");
				if (imageFile != null) {
					background frame = new background(imageFile);
					frame.setVisible(true); // call setVisible(true) last of all
				}
			}
		});
	}

}

/**
 * This class allows the user to choose a file with the given extensions.
 * This class is general and could be a public class in its own file.
 * 
 * @author kaydell
 *
 */
class MyFileChooser {
	public static File chooseFile(String description, String... extensions) {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(description, extensions);
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File selectedFile = chooser.getSelectedFile(); 
			System.out.println("You chose to open this file: " + selectedFile.getAbsolutePath());
			return selectedFile;
		} else {
			return null;
		}
	}
}
