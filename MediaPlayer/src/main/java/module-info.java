module com.mrmda28.mediaplayer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.mrmda28.mediaplayer to javafx.fxml;
    exports com.mrmda28.mediaplayer;
}