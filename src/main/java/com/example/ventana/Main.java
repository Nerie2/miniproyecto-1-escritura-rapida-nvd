package com.example.ventana;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The {@code Main} class serves as the entry point of the JavaFX application.
 * <p>
 * It loads the FXML layout, initializes the primary stage, and displays
 * the main game window to the user.
 * </p>
 *
 * <p>Responsibilities include:</p>
 * <ul>
 *   <li>Loading the {@code Game.fxml} file.</li>
 *   <li>Creating and setting the main scene.</li>
 *   <li>Configuring and showing the primary stage.</li>
 * </ul>
 *
 * @author Nerie
 * @version 1.0
 */
public class Main extends Application {

    /**
     * Starts the JavaFX application by setting up the primary stage.
     *
     * @param primaryStage the main window of the application.
     * @throws Exception if the FXML file cannot be loaded.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Game.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Prueba Escritura Rápida");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The entry point of the application.
     * <p>
     * This method launches the JavaFX runtime and initializes the
     * application window defined in {@link #start(Stage)}.
     * </p>
     *
     * @param args command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        launch(args);
    }
}