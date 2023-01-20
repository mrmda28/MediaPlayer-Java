package com.mrmda28.mediaplayer.Player;

import com.mrmda28.mediaplayer.Controllers.ControlButtons.IControlButtonsDelegate;

public interface IPlayer {
    void setControlDelegate(IControlButtonsDelegate delegate);
    void play();
    void pause();
    void stop();
    void seek(double time);
    void previous();
    void next();
    void setVolume(double value);
}
