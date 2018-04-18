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
import javafx.scene.paint.Paint;


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
			hbBtn.getChildren().add(btnLogin);
			grid.add(hbBtn, 1, 4);
			
			HBox loginBtn = new HBox(10);
			loginBtn.getChildren().add(btnSignUp);
			grid.add(hbBtn, 2, 4);
			
			
			
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
			        	actiontarget.setText("ERROR, BAD ENTRY");
			        }

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
		//FOR TESTING - display user name 
		private void textGrab(String user, String pass){
			System.out.println("Username: " + user + "\nPassword: " + pass);
		}
		
		
		private boolean testUser(String s1){
			//if(s1.matches("[a-zA-Z0-9._-]{3,}")){
			if(s1.matches("[a-zA-Z0-9._-].{3,}")){
				return true;
			}else{
				return false;
			}
		}
		
		private boolean testPass(String s1){
			if(s1.matches("(?=.*[0-9a-zA-Z@#$%^&+=]).{8,}")){
				return true;
			}else{
				return false;
			}
		}
		
	public static void main(String[]args){
		Application.launch(args);
	}
	

}