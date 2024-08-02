package br.com.project.demo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Program extends javafx.application.Application {

    private double xOffset = 0;
    private double yOffset = 0;
    
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("gui-view.fxml"));
        VBox root = fxmlLoader.load();

        // Criando uma forma retangular com cantos arredondados
        Rectangle clip = new Rectangle(400, 420);
        clip.setArcWidth(30);  // Arredondamento horizontal dos cantos
        clip.setArcHeight(30); // Arredondamento vertical dos cantos
        root.setClip(clip);    // Aplicando o clip ao layout raiz

        Scene scene = new Scene(root, 400, 420);

        // Aplicando o CSS
        scene.getStylesheets().add(Program.class.getResource("styles.css").toExternalForm());

        // Configurando a janela com estilo TRANSPARENT
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setWidth(400);
        stage.setHeight(420);

        // Configurando a cor de fundo da cena como transparente
        scene.setFill(Color.TRANSPARENT);

        // Adicionando funcionalidade de arrastar
        root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });

        stage.setTitle("Login Form");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}