package main;

import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
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

public class MainApp extends Application {
	
	//Properties
	static String cssPath = new File("./style.css").toURI().toString();
	static String assetPath = new File("./assets/GUI-1.png").toURI().toString();
	static Scene mainScene;
    static Scene startMenu;
    static Scene inputMenu;
    static Scene randomizeMenu;
    static Stage mainStage;
    
	ArrayList<String> names = new ArrayList<>();
	public static void main(String[] args) {
		launch(args);
	}
	
	//Fill name array with pre-generated names and sets default application .css
	//to a user defined one.
	private void initialize()
	{
		names.add("Glory");
		names.add("Jaysie");
		names.add("Mario");
		names.add("Joshua");
		names.add("Erin");
		names.add("Jason");
		startMenu = MenuScene.getScene(mainStage);
		inputMenu = InputScene.getScene(names, mainStage);
		randomizeMenu = RandomizeScene.getScene(names, mainStage);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		mainStage = primaryStage;
		
		//Background
		Image img = new Image(assetPath);
		BackgroundSize backgroundSize = new BackgroundSize(1, 1, true, true, false, false);
		
		//Layouts and Scenes
		VBox root = new VBox(15);
		root.setAlignment(Pos.CENTER);
		root.setBackground(new Background(new BackgroundImage(img, null, null, BackgroundPosition.CENTER, backgroundSize)));
		mainScene = new Scene(root, 500, 500);
		mainScene.getStylesheets().add(cssPath);
		
		//Root Scene < ------------------------------------->
		//Title
		Label mainTitle = new Label("Rand-o-Matic");
		mainTitle.getStyleClass().add("big-text");
		
		//Buttons
		Button startBtn = new Button("Start");
		startBtn.setOnAction(e -> primaryStage.setScene(startMenu));
		Button exitBtn = new Button("Exit");
		exitBtn.setOnAction(e -> primaryStage.close());
	
		root.getChildren().addAll(mainTitle, startBtn, exitBtn);
		//Root Scene < ------------------------------------->
		
		initialize();
		mainStage.setTitle("Rand-o-Matic 1.0b");
		mainStage.setResizable(false);
		mainStage.setScene(mainScene);
		mainStage.show();
	}
}
