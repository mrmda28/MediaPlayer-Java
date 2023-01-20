package com.mrmda28.mediaplayer.Player;

public interface IPlayer {
    void play();
    void pause();
    void stop();
    void seek(double time);
    void previous();
    void next();
    void setVolume(double value);
}
