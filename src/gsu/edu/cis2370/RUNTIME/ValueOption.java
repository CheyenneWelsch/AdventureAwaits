package gsu.edu.cis2370.RUNTIME;

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


public class ValueOption {

	//FOR TESTING - display user name 
			private TextField textGrab(TextField txt){
				return txt;
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
	
	
	
}
