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

    /** Label that displays the word to guess. */
    @FXML private Label lblWord;

    /** Label that shows feedback messages (correct/incorrect/time out). */
    @FXML private Label lblMessage;

    /** Label that displays the current level. */
    @FXML private Label lblLevel;

    /** Button used to validate user input. */
    @FXML private Button btnValidate;

    /** Text field where the user types their guess. */
    @FXML private TextField txtInput;

    /** Progress bar representing the countdown timer. */
    @FXML private ProgressBar progressBar;

    /** Image shown when the answer is correct. */
    @FXML private ImageView imagCorrect;

    /** Image shown when the answer is incorrect. */
    @FXML private ImageView imagIncorrect;

    /** Core game logic handler. */
    private IGameLogic gameLogic;

    /** Timeline object used to control the countdown timer. */
    private Timeline timeline;

    /** Current progress value for the countdown timer. */
    private double progress = 0.0;

    /**
     * Initializes the controller after the FXML components are loaded.
     * <p>
     * Sets up the initial state of the UI, creates the game logic instance,
     * and binds event handlers for user input and validation.
     * </p>
     */
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

    /**
     * Resets the progress bar and stops the active timeline if running.
     * <p>
     * This method ensures the countdown timer is cleared before restarting.
     * </p>
     */
    private void resetProgressBar() {
        if (timeline != null) {
            timeline.stop();
        }
        progress = 0.0;
        progressBar.setProgress(progress);
    }

    /**
     * Initializes and starts the countdown timer.
     * <p>
     * The timer updates the progress bar every 0.1 seconds. When time runs out,
     * the game state is reset and the UI is updated accordingly.
     * </p>
     */
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
                        imagCorrect.setVisible(false);
                        updateUI();
                        gameLogic.resetGame();
                        lblLevel.setText("Nivel: " + gameLogic.getLevel());
                        resetProgressBar();
                    }
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    /**
     * Validates the user input against the current word.
     * <p>
     * If correct, advances to the next level and updates the UI.
     * If incorrect, resets the game state and shows feedback.
     * </p>
     */
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
            gameLogic.resetGame();
            lblLevel.setText("Nivel:" + gameLogic.getLevel());
            resetProgressBar();
        }

        txtInput.clear();
    }

    /**
     * Handles the exit action from the UI.
     * <p>
     * Terminates the JavaFX application and prints a message to the console.
     * </p>
     */
    @FXML
    private void handleExit() {
        javafx.application.Platform.exit();
        System.out.println("Saliendo..");
    }

    /**
     * Updates the UI labels with the current word and level.
     */
    private void updateUI() {
        lblWord.setText(gameLogic.getCurrentWord());
        lblLevel.setText("Nivel: " + gameLogic.getLevel());
    }
}