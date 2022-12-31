package com.mrmda28.mediaplayer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

import com.mrmda28.mediaplayer.IMediaPlayer;
import com.mrmda28.mediaplayer.MediaPlayer;

import com.mrmda28.mediaplayer.IVolumeManager;
import com.mrmda28.mediaplayer.VolumeManager;

import static com.mrmda28.mediaplayer.Defaults.*;
import static com.mrmda28.mediaplayer.Helper.getFormattedTime;

public class ControlButtonsController {
    @FXML
    private Button previousButton;
    @FXML
    private Button controlButton;
    @FXML
    private Button nextButton;
    @FXML
    private Button stopButton;
    @FXML
    private Label currentTimeLabel;
    @FXML
    private Slider trackSlider;
    @FXML
    private Label durationTimeLabel;
    @FXML
    private ImageView minVolumeImageView;
    @FXML
    private Slider volumeSlider;
    @FXML
    private ImageView maxVolumeImageView;

    @FXML
    protected void onPreviousButtonClick() {
        mediaPlayer.previous();
    }

    @FXML
    protected void onControlButtonClick() {
        changeButtonState();
    }

    @FXML
    protected void onNextButtonClick() {
        mediaPlayer.next();
    }

    @FXML
    protected void onStopButtonClick() {
        mediaPlayer.stop();
        mediaPlayer.seek(0);
        trackSlider.setValue(0);
        controlButtonState = ControlButtonState.PAUSE;
        setImage(ControlButtonState.PLAY);
    }

    @FXML
    protected void onTrackSliderChanged() {
        int sliderValue = (int) (trackSlider.getValue() * 1000.0); // ms
        mediaPlayer.seek(sliderValue);
    }

    @FXML
    protected void onVolumeSliderChanged() {
        double sliderValue = volumeSlider.getValue();
        volumeManager.setValue(sliderValue);
    }

    @FXML
    private void initialize() {
        previousButton.setText(PREVIOUS_IMAGE);
        controlButton.setText(PLAY_IMAGE);
        nextButton.setText(NEXT_IMAGE);
        stopButton.setText(STOP_IMAGE);

        currentTimeLabel.setText(getFormattedTime(CURRENT_TIME));
        durationTimeLabel.setText(getFormattedTime(DURATION_TIME));

        minVolumeImageView.setFitWidth(IMAGE_SIDE);
        minVolumeImageView.setFitHeight(IMAGE_SIDE);

        volumeSlider.setMin(MIN_VOLUME);
        volumeSlider.setMax(MAX_VOLUME);

        maxVolumeImageView.setFitWidth(IMAGE_SIDE);
        maxVolumeImageView.setFitHeight(IMAGE_SIDE);
    }

    private final IMediaPlayer mediaPlayer = new MediaPlayer();
    private final IVolumeManager volumeManager = new VolumeManager();
    private ControlButtonState controlButtonState = ControlButtonState.PAUSE;

    private enum ControlButtonState {
        PLAY, PAUSE;

        String getImage() {
            String image = "";
            switch (this) {
                case PLAY -> image = PLAY_IMAGE;
                case PAUSE -> image = PAUSE_IMAGE;
            }
            return image;
        }
    }

    private void changeButtonState() {
        switch (controlButtonState) {
            case PLAY -> {
                mediaPlayer.pause();
                setImage(ControlButtonState.PLAY);
                controlButtonState = ControlButtonState.PAUSE;
            }
            case PAUSE -> {
                mediaPlayer.play();
                setImage(ControlButtonState.PAUSE);
                controlButtonState = ControlButtonState.PLAY;
            }
        }
    }
    private void setImage(ControlButtonState state) {
        controlButton.setText(state.getImage());
    }
}
