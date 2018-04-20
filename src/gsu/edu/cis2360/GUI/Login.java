package gsu.edu.cis2360.GUI;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class Login extends Application {
		
	
	
	Label userName = new Label("User Name: ");
	Label pw = new Label("Password: ");
	TextField userTextField = new TextField();
	PasswordField pwBox = new PasswordField();
	Text scenetitle = new Text("Adventure Awaits");
	// creates a specialized password input box that hides the password
	// input
	
	
	//creates a login button
	Button btnLogin = new Button("Login");
	final Text actiontarget = new Text();
	
	Button btnSignUp = new Button("Sign-Up");
	//sign-up window pop up
	
	@Override
		public void start(Stage primaryStage) {

			// create GridPane object
			GridPane grid = new GridPane();
			grid.add(scenetitle, 0, 0);
			
			grid.add(userName, 0, 1);
			grid.add(userTextField, 1, 1);
			grid.add(pw, 0, 2);
			grid.add(pwBox, 1, 2);
			grid.add(actiontarget, 1, 6);
			
			grid.setAlignment(Pos.CENTER);
			grid.setPadding(new Insets(25, 25, 25, 25));
			grid.setHgap(10);
			grid.setVgap(10);
			

			//button alignment
			HBox hbBtn = new HBox(10);
			hbBtn.getChildren().addAll(btnSignUp, btnLogin);
			grid.add(btnLogin, 0, 3);
			grid.add(btnSignUp, 1, 3);
			
			
		
			
			
			
			//use to do action when button pressed
			//include all actions within the setOnAction method
			
			btnLogin.setOnAction(new EventHandler<ActionEvent>() {
				@Override
			    public void handle(ActionEvent e) {
			        actiontarget.setText("Sign in button pressed");
			        if(testUser(userTextField.getText()) == true &&
			        		testPass(pwBox.getText()) == true){
			        	  textGrab(userTextField.getText(), pwBox.getText());
			        	 
			        	  
			        }else{
			        	actiontarget.setText("ERROR, FORGOT PASSWORD?");
			        }

			    }
			});
			
			btnSignUp.setOnAction(new EventHandler<ActionEvent>() {
				@Override
			    public void handle(ActionEvent e) {
			        actiontarget.setText("Sign in button pressed");
			        //pulls from the sign up class
			        	  SignUp s1 = new SignUp();
			        	  s1.start(primaryStage);
			       
			        }

			    
			});
			
			// create a new scene and place it on stage
			Scene scene = new Scene(grid, 325, 275);
			primaryStage.setTitle("Login"); //set title
			primaryStage.setScene(scene);
			primaryStage.show();
			
			//btn.setOnAction(e -> textGrab(userTextField.getText(), pwBox.getText()) );
		
			
			String uPass = pwBox.getText();
			
			
			// adds location for text to appear if login fails
			final Text actiontarget = new Text();
			grid.add(actiontarget, 1, 6);
			

		}
		
		
	public static void main(String[] args){
		Application.launch(args);
	}
	
}