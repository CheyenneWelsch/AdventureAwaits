package SplashScreen;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class Splish {
	public static void main(String[] arg){
		JWindow window = new JWindow();
		
		//this line should act as the popup window creation and pull the image located at the address in ImageIcon()
		//CURRENTLY ONLY CREATES POPUP, NO IMAGE DISPLAYED
		window.getContentPane().add(new JLabel("", new ImageIcon("Macintosh HD/Users/crazymoose55/Desktop/imageTest.jpg"), SwingConstants.CENTER));
		
		window.setBounds(350, 200, 600, 400);
		
		window.setVisible(true);
		
		try
		{
			Thread.sleep(3000);
		}
		catch(InterruptedException e) {}
		window.dispose();
	}
}

