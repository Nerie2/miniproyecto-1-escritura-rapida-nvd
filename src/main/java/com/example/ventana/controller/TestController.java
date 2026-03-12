package com.example.ventana.controller;

import com.example.ventana.model.GameLogic;
import com.example.ventana.model.IGameLogic;
import com.example.ventana.model.IWord;
import com.example.ventana.model.Word;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class TestController {
    @FXML private Label lblWord;
    @FXML private Label lblMessage;
    @FXML private Label lblLevel;
    @FXML private Button btnValidate;
    @FXML private TextField txtInput;
    @FXML private ProgressBar progressBar;

    private GameLogic gameLogic;
    private IWord wordGenerator = new Word();
    private Timeline timeline;
    private double progress = 0.0;

    @FXML
    private void initialize() {
        IWord wordManager = new Word();
        gameLogic = new GameLogic(wordManager);

        lblWord.setText(gameLogic.getCurrentWord());
        lblLevel.setText("Nivel: " + gameLogic.getLevel());

        txtInput.setOnAction(event -> validateInput());
        btnValidate.setOnAction(event -> validateInput());

        initializeTime();
    }

    private void initializeTime() {
        progress = 0.0;
        progressBar.setProgress(progress);
        int time = gameLogic.getTimePerLevel(); // segundos según nivel

        timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.1), e -> {
                    progress += 0.1 / time; // avanza proporcional al tiempo
                    progressBar.setProgress(progress);

                    if (progress >= 1.0) {
                        timeline.stop();
                        lblMessage.setText("Tiempo agotado. " + gameLogic.getCurrentWord());
                        updateUI();
                        //initializeTime();
                        gameLogic.resetGame();
                    }
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }
    @FXML
    private void validateInput() {
        String entrada = txtInput.getText().trim();

        if (gameLogic.validateWord(entrada)) {
            lblMessage.setText("Correcto");
            timeline.stop();
            gameLogic.nextLevel();
            updateUI();
            initializeTime();
        } else {
            lblMessage.setText("Incorrecto");
        }

        txtInput.clear();
    }

    @FXML
    private void handleExit() {
        javafx.application.Platform.exit();
        System.out.println("Saliendo..");
    }

    private void updateUI() {
        lblWord.setText(gameLogic.getCurrentWord());
        lblLevel.setText("Nivel: " + gameLogic.getLevel());
    }

}
