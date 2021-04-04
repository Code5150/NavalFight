package com.vladislav.navalfight;
import com.vladislav.navalfight.controllers.MainMenuController;
import com.vladislav.navalfight.controllers.SceneController;
import com.vladislav.navalfight.rmi.FightCalculations;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainMenu extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Морской бой");

        SceneController.setAppStage(stage);
        SceneController.toMainMenu();

        stage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });

        System.out.println(stage);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        Platform.exit();
        System.exit(0);
    }
}
