package gsu.edu.cis2360.GUI;
import javafx.*;
//Used
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javafx.application.Application;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay; 
import javafx.scene.control.Label;
import javafx.scene.image.Image;
 import javafx.scene.image.ImageView;
 import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;



public class Splish extends Application {
	public void start(Stage primaryStage) {
		//JWindow window = new JWindow();
		
		//this line should act as the popup window creation and pull the image located at the address in ImageIcon()
		//CURRENTLY ONLY CREATES POPUP, NO IMAGE DISPLAYED
		//window.getContentPane().add(new JLabel("", new ImageIcon("Macintosh HD/Users/crazymoose55/Desktop/imageTest.jpg"), SwingConstants.CENTER));
		
		//window.getContentPane().add(new JLabel("", new ImageIcon("Macintosh HD/Users/cheyennewelsch/Desktop/Screen Shot 2018-02-06 at 15.50.21.png"), SwingConstants.CENTER));
		
		ImageView IMG_0708 = new ImageView(new Image("Macintosh HD/Users/cheyennewelsch/Desktop/IMG_0708.jpg"));
		Label lb1 = new Label("US\n50 States", IMG_0708);
		lb1.setStyle("-fx-border-color: green; -fx-border-width: 2");
		lb1.setContentDisplay(ContentDisplay.BOTTOM);
		lb1.setTextFill(Color.RED);
		
		/*
		window.setBounds(350, 200, 600, 400);
		
		window.setVisible(true);
		
		try
		{
			//runtime (ms)
			Thread.sleep(5000);
		}
		
		//???
		catch(InterruptedException e) {}
		window.dispose();
		*/
		
		
	}
	
	public static void main (String[] args){
		
		Application.launch(args);
	}
}

