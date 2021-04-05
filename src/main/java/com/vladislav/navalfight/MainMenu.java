package com.vladislav.navalfight;
import com.vladislav.navalfight.controllers.RmiController;
import com.vladislav.navalfight.controllers.SceneController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class MainMenu extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Морской бой");

        SceneController.setAppStage(stage);
        try {
            RmiController.initRmiConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
