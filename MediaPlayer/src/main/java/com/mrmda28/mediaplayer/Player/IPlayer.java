package com.mrmda28.mediaplayer.Player;

import com.mrmda28.mediaplayer.Controllers.ControlButtons.IControlButtonsDelegate;
import com.mrmda28.mediaplayer.Controllers.Playlist.IPlaylistDelegate;

import java.io.File;
import java.util.List;

public interface IPlayer {
    void setControlDelegate(IControlButtonsDelegate delegate);
    void setPlaylistDelegate(IPlaylistDelegate delegate);
    void play();
    void play(int index);
    void pause();
    void stop();
    void seek(double time);
    void previous();
    void next();
    void setFiles(List<File> files);
    void setVolume(double value);
}
