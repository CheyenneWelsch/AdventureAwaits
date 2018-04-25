package gsu.edu.cis2370.GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import gsu.edu.cis2370.RUNTIME.ValueObject;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class forgotPassword extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	Button btnUserName = new Button("Search User Names");
	Button btnCheckAnswer = new Button("Check Answer");
	Button btnBack = new Button("Back");
	Label userName = new Label("User Name");
	Label securityQ = new Label("Security Question:");

	Label securityA = new Label("Security Answer:");
	Label scenetitle = new Label("Enter Your User Name: ");

	TextField txtUserName = new TextField("Enter your user name");
	TextField txtSecurityA = new TextField();
	final Text actiontarget = new Text();

	@Override
	public void start(Stage primaryStage) {

		ValueObject vo = new ValueObject();
		// column //row
		// create GridPane object
		GridPane grid = new GridPane();
		grid.add(txtUserName, 0, 0);
		grid.add(btnUserName, 1, 0);
		grid.add(actiontarget, 0, 1);
		grid.add(btnBack, 0, 6);
		btnUserName.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				if (vo.checkUserName(txtUserName.getText()) == false) {
					actiontarget.setText("ERROR: INVALID USERNAME");
				} else {
					String sq = vo.getSecurityQuestion(txtUserName.getText());
					Label grabSecurityQ = new Label(sq);
					grid.add(securityQ, 0, 2);
					grid.add(grabSecurityQ, 1, 2);
					grid.add(securityA, 0, 3);
					grid.add(txtSecurityA, 1, 3);
					grid.add(btnCheckAnswer, 1, 4);

					// starts new eventHandler action for new button that
					// appeared
					btnCheckAnswer.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {

							if (vo.checkSecurityAnswer(txtUserName.getText(), txtSecurityA.getText()) == false) {
								actiontarget.setText("WRONG ANSWER");
							} else {
								String pass = vo.getPassword(txtUserName.getText());
								Label password = new Label("Your password:");
								Label passwordShow = new Label(pass);

								grid.add(password, 0, 5);
								grid.add(passwordShow, 1, 5);
							}

						}
					});
				}
			}
		});

		btnBack.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Login login = new Login();
				login.start(primaryStage);
				
			}
		});

		// grid.add(scenetitle, 0, 0);
		// grid.add(txtUserName, 0, 0);
		// grid.add(btnUserName, 3, 0);
		// grid.add(securityQ, 4, 0);
		// grid.add(btnUserName, 2, 3);
		// grid.add(btnCheckAnswer, 3, 3);

		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.setHgap(10);
		grid.setVgap(10);

		// button alignment
		HBox hbBtn = new HBox(10);
		hbBtn.getChildren().addAll();
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.setHgap(10);
		grid.setVgap(10);

		Scene scene = new Scene(grid, 325, 275);
		primaryStage.setTitle("Forgot Password"); // set title
		primaryStage.setScene(scene);
		primaryStage.show();

		// btn.setOnAction(e -> textGrab(userTextField.getText(),
		// pwBox.getText()) );

		// adds location for text to appear if login fails

	}

}
