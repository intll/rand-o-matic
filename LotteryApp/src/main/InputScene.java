package main;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InputScene {
	
	public static Scene getScene(ArrayList<String> names, Stage primaryStage)
	{
		
		//Background
	    Image img = new Image(MainApp.assetPath);
		BackgroundSize backgroundSize = new BackgroundSize(1, 1, true, true, false, false);
		
		//Scenes and Layouts
		VBox inputLayout = new VBox(15);
		inputLayout.setBackground(new Background(new BackgroundImage(img, null, null, BackgroundPosition.CENTER, backgroundSize)));
		inputLayout.setAlignment(Pos.CENTER);
		Scene inputScene = new Scene(inputLayout, 500, 500);
		inputScene.getStylesheets().add(MainApp.cssPath);
		
		//Label
		Label mainTitle = new Label("Input Name");
		Label successInfo = new Label("");
		successInfo.setId("info-text");
		mainTitle.getStyleClass().add("big-text");
		
		//Textfield
		TextField inputText = new TextField();
		
		//Buttons
		Button inputBtn = new Button("Submit");
		inputBtn.setOnAction(e -> {
			if (!inputText.getText().isEmpty())
			{
				names.add(inputText.getText());
				successInfo.setText(names.get(names.size()-1) + " added successfully.");
			}
			inputText.setText("");
		});
		
		Button backBtn = new Button("Done");
		backBtn.setOnAction(e -> {
			successInfo.setText("");
			primaryStage.setScene(MainApp.startMenu);
		});
		
		inputLayout.getChildren().addAll(mainTitle, inputText, inputBtn, backBtn, successInfo);
		
		return inputScene;
	}
}
