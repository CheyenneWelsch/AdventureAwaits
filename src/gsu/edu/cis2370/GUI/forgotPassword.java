package gsu.edu.cis2370.GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import gsu.edu.cis2370.RUNTIME.ValueObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.text.Text;
import javafx.stage.Stage;

public class forgotPassword {

	Button btnuUserName = new Button("Search User Names");
	Button btnCheckAnswer = new Button("Check Answer");
	Label userName = new Label("User Name");
	Label securityQ = new Label("Security Question");
	Label securityA = new Label("Security Answer");
	Label scenetitle = new Label("Enter Your User Name ");
	
	
	
	
	
	// create GridPane object
	GridPane grid = new GridPane();
	grid.add()
	
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
	grid.add(btnSignUp, 0, 3);
	grid.add(btnLogin, 1, 3, 3, 1);
	grid.add(btnForgotPass, 1, 4, 3, 1);
	btnLogin.setMinWidth(130);
	btnForgotPass.setMinWidth(130);
	
	
	
	
}
