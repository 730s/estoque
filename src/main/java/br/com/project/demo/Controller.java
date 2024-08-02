package br.com.project.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private Button closeButton;

    @FXML
    private ImageView closeImageView;

    @FXML
    public void initialize() {
        // Carregar a imagem no ImageView
        Image closeImage = new Image(getClass().getResourceAsStream("/br/com/project/demo/close-icon.png"));
        closeImageView.setImage(closeImage);
    }

    @FXML
    private void handleClose() {
        // Obtém o stage atual a partir do botão
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close(); // Fecha a janela
    }
}

