package com.mrmda28.mediaplayer;

public interface IMediaPlayer {
    void play();
    void pause();
    void stop();
    void seek(int time);
    void previous();
    void next();
}
