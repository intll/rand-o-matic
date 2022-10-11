package main;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuScene {
	public static Scene getScene(Stage primaryStage)
	{
		//Background
		Image img = new Image(MainApp.assetPath);
		BackgroundSize backgroundSize = new BackgroundSize(1, 1, true, true, false, false);
		
		//Scenes and Layouts
		VBox startLayout = new VBox(15);
		startLayout.setBackground(new Background(new BackgroundImage(img, null, null, BackgroundPosition.CENTER, backgroundSize)));
		startLayout.setAlignment(Pos.CENTER);
		Scene menuScene = new Scene(startLayout, 500, 500);
		menuScene.getStylesheets().add(MainApp.cssPath);
		
		//Buttons
		Button inputBtn = new Button("Input Name");
		inputBtn.setOnAction(e -> primaryStage.setScene(MainApp.inputMenu));
		Button randomizeBtn = new Button("Rand-o-Mize");
		randomizeBtn.setOnAction(e -> primaryStage.setScene(MainApp.randomizeMenu));
		Button backBtn = new Button("Back");
		backBtn.setOnAction(e -> primaryStage.setScene(MainApp.mainScene));

		startLayout.getChildren().addAll(inputBtn, randomizeBtn, backBtn);
		return menuScene;
	}
}
