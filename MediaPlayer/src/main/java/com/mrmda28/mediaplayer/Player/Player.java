package com.mrmda28.mediaplayer.Player;

import com.mrmda28.mediaplayer.Controllers.ControlButtons.IControlButtonsDelegate;
import com.mrmda28.mediaplayer.Controllers.Playlist.IPlaylistDelegate;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class Player implements IPlayer {

    // Properties
    private List<File> playlist;
    private int mediaIndex = 0;
    private boolean isPlaying = false;

    private Media media;
    private MediaPlayer mediaPlayer;

    private IControlButtonsDelegate controlDelegate;
    private IPlaylistDelegate playlistDelegate;

    // Singleton
    private static final Player instance = new Player();
    private Player() {}
    public static Player shared = instance;

    // IPlayer methods
    public void setControlDelegate(IControlButtonsDelegate delegate) {
        controlDelegate = delegate;
    }

    public void setPlaylistDelegate(IPlaylistDelegate delegate) {
        playlistDelegate = delegate;
    }

    private boolean isReady() {
        return playlist != null && mediaPlayer != null;
    }

    public void play() {
        if (isReady()) {
            mediaPlayer.play();
            isPlaying = true;
        }
    }

    public void play(int index) {
        if (isReady()) {
            pause();
            mediaIndex = index;
            media = new Media(playlist.get(mediaIndex).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setOnReady(this::play);
            controlDelegate.setPlayingStatus();
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
        if (isReady()) {
            mediaPlayer.stop();
            if (mediaIndex > 0) {
                mediaIndex -= 1;
                media = new Media(playlist.get(mediaIndex).toURI().toString());
                mediaPlayer = new MediaPlayer(media);
                playlistDelegate.selectCell(mediaIndex);
            }
            if (isPlaying) {
                play();
            }
        }
    }

    public void next() {
        if (isReady()) {
            mediaPlayer.stop();
            if (mediaIndex < (playlist.size() - 1)) {
                mediaIndex += 1;
                media = new Media(playlist.get(mediaIndex).toURI().toString());
                mediaPlayer = new MediaPlayer(media);
                playlistDelegate.selectCell(mediaIndex);
            }
            if (isPlaying) {
                play();
            }
        }
    }

    public void setFiles(List<File> files) {
        playlist = new ArrayList<>(files);
        media = new Media(playlist.get(mediaIndex).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setOnReady(() -> {
            controlDelegate.setDisable(false);
            playlistDelegate.selectCell(mediaIndex);
        });
    }

    public void setVolume(double value) {
        if (isReady()) {
            mediaPlayer.setVolume(value * 0.01);
        }
    }
}
