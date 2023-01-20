module com.mrmda28.mediaplayer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.mrmda28.mediaplayer to javafx.fxml;
    exports com.mrmda28.mediaplayer;
    exports com.mrmda28.mediaplayer.Controllers.ControlButtons;
    opens com.mrmda28.mediaplayer.Controllers.ControlButtons to javafx.fxml;
}