package main;

import java.util.ArrayList;
import java.util.Random;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RandomizeScene {
	
	static int index=-1;
	static Random rand = new Random();
	
	public static Scene getScene(ArrayList<String> names, Stage primaryStage)
	{
		//Background
		Image img = new Image(MainApp.assetPath);
		BackgroundSize backgroundSize = new BackgroundSize(1, 1, true, true, false, false);
				
		//Scenes and Layouts
		VBox randomizeLayout = new VBox(15);
		randomizeLayout.setBackground(new Background(new BackgroundImage(img, null, null, BackgroundPosition.CENTER, backgroundSize)));
		randomizeLayout.setAlignment(Pos.CENTER);
		Scene randomizeScene = new Scene(randomizeLayout, 500, 500);
		randomizeScene.getStylesheets().add(MainApp.cssPath);
		
		//Label
		Label mainTitle = new Label("Rand-o-Mize");
		Label gachaResults = new Label("");
		Label successInfo = new Label("");
		successInfo.setId("info-text");
		gachaResults.setId("result-text");
		mainTitle.getStyleClass().add("big-text");
		
		//Buttons
		Button deleteBtn = new Button("Remove name from list");
		deleteBtn.setDisable(true);
		deleteBtn.setOnAction(e -> {
			if (index!=-1)
			{
				successInfo.setText(names.get(index) + " removed from the list.");
				names.remove(index);
				gachaResults.setText("");
				deleteBtn.setDisable(true);
			}
		});
		
		Button randomizeBtn = new Button("Randomize a name");
		randomizeBtn.setOnAction(e -> {
			if (names.isEmpty())
			{
				successInfo.setStyle("-fx-text-fill: red");
				successInfo.setText("List is empty! Add a new name first.");
				randomizeBtn.setDisable(true);
				deleteBtn.setDisable(true);
			}
			else
			{
				index = rand.nextInt(names.size());
				gachaResults.setText(names.get(index));
				deleteBtn.setDisable(false);
			}
		});
		
		
		Button backBtn = new Button("Back");
		backBtn.setOnAction(e -> {
			successInfo.setText("");
			gachaResults.setText("");
			index=-1;
			randomizeBtn.setDisable(false);
			primaryStage.setScene(MainApp.startMenu);
		});
		
		randomizeLayout.getChildren().addAll(mainTitle, gachaResults, randomizeBtn, deleteBtn, backBtn, successInfo);
		return randomizeScene;
	}
}
