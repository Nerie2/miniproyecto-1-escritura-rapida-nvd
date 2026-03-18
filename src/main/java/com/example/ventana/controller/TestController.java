package com.example.ventana.controller;

import com.example.ventana.model.GameLogic;
import com.example.ventana.model.GameState;
import com.example.ventana.model.IGameLogic;
import com.example.ventana.model.IGameState;
import com.example.ventana.model.IWord;
import com.example.ventana.model.Word;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * Main controller for the test game view.
 * <p>
 * This class manages the interaction between the JavaFX UI (FXML)
 * and the {@link GameLogic} class. Responsibilities include:
 * <ul>
 *   <li>Displaying the current word to guess.</li>
 *   <li>Validating user input.</li>
 *   <li>Controlling the countdown timer with a progress bar.</li>
 *   <li>Updating messages and level information on the UI.</li>
 * </ul>
 * </p>
 *
 * @author Nerie
 * @version 2.0
 */
public class TestController {
    @FXML private Label lblWord;
    @FXML private Label lblMessage;
    @FXML private Label lblLevel;
    @FXML private Button btnValidate;
    @FXML private TextField txtInput;
    @FXML private ProgressBar progressBar;
    @FXML private ImageView imagCorrect;
    @FXML private ImageView imagIncorrect;

    /** Core game logic handler. */
    private IGameLogic gameLogic;

    /** Timeline object used to control the countdown timer. */
    private Timeline timeline;

    /** Current progress value for the countdown timer. */
    private double progress = 0.0;

    @FXML
    private void initialize() {
        imagCorrect.setVisible(false);
        imagIncorrect.setVisible(false);

        IWord wordManager = new Word();
        IGameState gameState = new GameState();
        gameLogic = new GameLogic(wordManager, gameState);

        lblWord.setText(gameLogic.getCurrentWord());
        lblLevel.setText("Nivel: " + gameLogic.getLevel());

        txtInput.setOnAction(event -> validateInput());
        btnValidate.setOnAction(event -> validateInput());

        initializeTime();
    }

    private void resetProgressBar() {
        if (timeline != null) {
            timeline.stop();
        }
        progress = 0.0;
        progressBar.setProgress(progress);
    }

    private void initializeTime() {
        progress = 0.0;
        progressBar.setProgress(progress);
        int time = gameLogic.getTimePerLevel();

        timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.1), e -> {
                    progress += 0.1 / time;
                    progressBar.setProgress(progress);

                    if (progress >= 1.0) {
                        timeline.stop();
                        lblMessage.setText("Tiempo agotado. Perdiste :( ");
                        imagIncorrect.setVisible(true);
                        updateUI();
                        gameLogic.resetGame();   // ahora limpio
                        lblLevel.setText("Nivel: " + gameLogic.getLevel());
                        resetProgressBar();
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
            imagCorrect.setVisible(true);
            imagIncorrect.setVisible(false);
            lblMessage.setText("Correcto");
            timeline.stop();
            gameLogic.nextLevel();
            updateUI();
            initializeTime();
        } else {
            imagCorrect.setVisible(false);
            imagIncorrect.setVisible(true);
            lblMessage.setText("Incorrecto");
            gameLogic.resetGame();   // delega en GameLogic
            lblLevel.setText("Nivel:" + gameLogic.getLevel());
            resetProgressBar();
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