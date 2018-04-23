package gsu.edu.cis2370.RUNTIME;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import gsu.edu.cis2370.RUNTIME.TESTCLASS;
import gsu.edu.cis2370.RUNTIME.ValueObject;

public class arryayCheck extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("TextArea Experiment 1");
		ValueObject vo = new ValueObject();
		ArrayList<String> s1 = vo.getFlightTable();
		TextArea textArea = new TextArea();
		String [] hold = vo.arrayListToString(s1);
		int count = 0;
		
		for(int x = 0; x< vo.flightList(); x++){
			textArea.appendText(hold[x] + "\n");
		}
	

			
			
			VBox vbox = new VBox(textArea);

			Scene scene = new Scene(vbox, 200, 100);
			primaryStage.setScene(scene);
			primaryStage.show();

		}
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		/*
		ValueObject vo = new ValueObject();
		ArrayList<String> s1 = vo.getFlightTable();

		String [] hold = vo.arrayListToString(s1);
		int count = 0;
		//for(int x = 0; x< hold[0].length(); x++){
		for(int x = 0; x< vo.flightList(); x++){
			System.out.println(hold[x]);
		}
		System.out.println("End");
		System.exit(0);
		
		*/
		Application.launch(args);
		}

	
}
