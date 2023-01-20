package com.mrmda28.mediaplayer.Player;

import com.mrmda28.mediaplayer.Controllers.ControlButtons.IControlButtonsDelegate;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public final class Player implements IPlayer {

    // Properties
    private boolean isPlaying = false;

    private Media media;
    private MediaPlayer mediaPlayer;

    private IControlButtonsDelegate controlDelegate;

    // Singleton
    private static final Player instance = new Player();
    private Player() { }
    public static Player shared = instance;

    private boolean isReady() {
        return mediaPlayer != null;
    }

    // IPlayer methods
    public void setControlDelegate(IControlButtonsDelegate delegate) {
        controlDelegate = delegate;
    }

    public void play() {
        if (isReady()) {
            mediaPlayer.play();
            isPlaying = true;
        }
    }

    public void pause() {
        if (isReady()) {
            mediaPlayer.pause();
            isPlaying = false;
        }
    }

    public void stop() {
        if (isReady()) {
            mediaPlayer.stop();
            isPlaying = false;
        }
    }

    public void seek(double time) {
        if (isReady()) {
            mediaPlayer.seek(Duration.millis(time));
        }
    }

    public void previous() {

    }

    public void next() {

    }

    public void setVolume(double value) {
        if (isReady()) {
            mediaPlayer.setVolume(value * 0.01);
        }
    }
}
