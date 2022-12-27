package com.mrmda28.mediaplayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {
    String TITLE = "Media Player";
    String CSS = Objects.requireNonNull(this.getClass().getResource("styles.css")).toExternalForm();

    double STANDARD_WIDTH = 800;
    double STANDARD_HEIGHT = 500;
    double MIN_WIDTH = 600;
    double MIN_HEIGHT = 400;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), STANDARD_WIDTH, STANDARD_HEIGHT);
        scene.getStylesheets().add(CSS);

        stage.setTitle(TITLE);
        stage.setMinWidth(MIN_WIDTH);
        stage.setMinHeight(MIN_HEIGHT);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
