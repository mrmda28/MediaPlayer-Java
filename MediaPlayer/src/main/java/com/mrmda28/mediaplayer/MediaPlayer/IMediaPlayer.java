package com.mrmda28.mediaplayer.MediaPlayer;

public interface IMediaPlayer {
    void play();
    void pause();
    void stop();
    void seek(int time);
    void previous();
    void next();
}
