package com.mrmda28.mediaplayer.Models;

import javafx.beans.property.SimpleStringProperty;

public class MediaModel {
    private SimpleStringProperty path;
    private SimpleStringProperty name;
    private SimpleStringProperty duration;

    public MediaModel(String path, String name, String duration) {
        this.path = new SimpleStringProperty(path);
        this.name = new SimpleStringProperty(name);
        this.duration = new SimpleStringProperty(duration);
    }

    public String getPath() {
        return path.get();
    }

    public void setPath(String path) {
        this.path = new SimpleStringProperty(path);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public String getDuration() {
        return duration.get();
    }

    public void setDuration(String duration) {
        this.duration = new SimpleStringProperty(duration);
    }
}
