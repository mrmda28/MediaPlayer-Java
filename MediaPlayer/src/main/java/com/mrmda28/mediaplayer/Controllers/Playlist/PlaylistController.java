package com.mrmda28.mediaplayer.Controllers.Playlist;

import com.mrmda28.mediaplayer.Player.IPlayer;
import com.mrmda28.mediaplayer.Player.Player;
import com.mrmda28.mediaplayer.Models.MediaModel;

import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.util.*;

public class PlaylistController implements IPlaylistDelegate {

    @FXML
    private TableView<MediaModel> playlistView;

    @FXML
    public TableColumn<MediaModel, String> titleColumn;

    @FXML
    public TableColumn<MediaModel, String> durationColumn;

    @FXML
    public Button openMediaButton;

    @FXML
    protected void onOpenMediaButtonClick() {
        List<File> mediaList = fileChooser.showOpenMultipleDialog(null);
        if (mediaList != null) {
            mediaModels.addAll(mediaList.stream().map(file ->
                    new MediaModel(file.getPath(), file.getName(), "--:--")
            ).toList());
            mediaPlayer.setFiles(mediaList);
        }
    }

    private final FileChooser fileChooser = new FileChooser();
    private final ObservableList<MediaModel> mediaModels = FXCollections.observableArrayList();

    private final IPlayer mediaPlayer = Player.shared;

    @FXML
    public void initialize() {
        mediaPlayer.setPlaylistDelegate(this);
        configureFileChooser();
        configureTableView();
    }

    private void configureFileChooser() {
        fileChooser.setTitle("Select one or more media files");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", ".m4a"));
    }

    private void configureTableView() {
        playlistView.setRowFactory( tv -> {
            TableRow<MediaModel> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!row.isEmpty())) {
                    MediaModel rowData = row.getItem();
                    int index = mediaModels.indexOf(rowData);
                    mediaPlayer.play(index);
                }
            });
            return row ;
        });
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("Duration"));
        playlistView.setItems(mediaModels);
    }

    public void selectCell(int index) {
        playlistView.getSelectionModel().select(index);
    }
}
