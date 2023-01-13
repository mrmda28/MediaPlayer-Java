package com.mrmda28.mediaplayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static com.mrmda28.mediaplayer.Helpers.Defaults.*;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), STANDARD_WIDTH, STANDARD_HEIGHT);
        scene.getStylesheets().add(Objects.requireNonNull(this.getClass().getResource("styles.css")).toExternalForm());

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
