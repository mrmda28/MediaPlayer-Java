package com.mrmda28.mediaplayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
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
    double IMAGE_SIDE = 20.0;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), STANDARD_WIDTH, STANDARD_HEIGHT);
        scene.getStylesheets().add(CSS);

        stage.setTitle(TITLE);
        stage.setMinWidth(MIN_WIDTH);
        stage.setMinHeight(MIN_HEIGHT);

        configureUI(scene);

        stage.setScene(scene);
        stage.show();
    }

    void configureUI(Scene scene) {
        Button previousButton = (Button) scene.lookup("#previousButton");
        Button controlButton = (Button) scene.lookup("#controlButton");
        Button nextButton = (Button) scene.lookup("#nextButton");
        Button stopButton = (Button) scene.lookup("#stopButton");
        Label currentTimeLabel = (Label) scene.lookup("#currentTimeLabel");
        Label durationTimeLabel = (Label) scene.lookup("#durationTimeLabel");
        ImageView minVolumeImageView = (ImageView) scene.lookup("#minVolumeImageView");
        ImageView maxVolumeImageView = (ImageView) scene.lookup("#maxVolumeImageView");

        previousButton.setText("<<");
        controlButton.setText(">");
        nextButton.setText(">>");
        stopButton.setText("□");

        currentTimeLabel.setText("00:00");
        durationTimeLabel.setText("00:00");

        minVolumeImageView.setFitWidth(IMAGE_SIDE);
        minVolumeImageView.setFitHeight(IMAGE_SIDE);

        maxVolumeImageView.setFitWidth(IMAGE_SIDE);
        maxVolumeImageView.setFitHeight(IMAGE_SIDE);
    }

    public static void main(String[] args) {
        launch();
    }
}
