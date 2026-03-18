package com.example.ventana.model;

import java.util.Random;

import static javafx.application.Application.launch;

/**
 * The {@code Word} class implements the {@link IWord} interface and is responsible
 * for generating random words from a predefined list.
 * <p>
 * This class also contains a {@code main} method to launch a JavaFX application,
 * although its primary purpose is word generation logic.
 * </p>
 */
public class Word implements IWord {

    /**
     * Stores the currently generated word.
     */
    private String currentWord;

    /**
     * Generates a random word selected from a predefined set of words.
     * <p>
     * The set includes common words as well as programming-related terms
     * and general concepts.
     * </p>
     *
     * @return
     */
    @Override
    public String generateWord() {
        String[] words = {"Perro", "Casa", "Chuspa", "Caracol", "Cocodrilo", "algoritmo",
                "booleano", "compilador", "depuracion", "encapsulado", "framework", "herencia", "instancia",
                "jerarquia", "kilobyte", "libreria", "metadatos", "parametro", "recursividad", "sintaxis",
                "variable", "asincrono", "repositorio", "interfaz", "polimorfismo", "ventana", "guitarra",
                "elefante", "cuaderno", "planeta", "camino", "silencio", "aventura", "brujula", "espejo", "zapato",
                "bosque", "alegria", "destino", "pintura", "cascada", "puente", "universo", "tiempo",
                "historia","cielo", "montaña", "río", "bosque", "sol", "luna", "estrella", "mar", "arena", "flor",
                "viento", "trueno", "lluvia", "nube", "fuego", "tierra", "roca", "hierba", "hoja", "fruta",
                "camino", "puente", "ciudad", "casa", "puerta", "ventana", "mesa", "silla", "libro", "voz"};
        Random rand = new Random();
        currentWord = words[rand.nextInt(words.length)];
        return currentWord;
    }

    /**
     * Returns the currently generated word.
     *
     * @return the current word as a {@code String}.
     */
    @Override
    public String getCurrentWord() {
        return currentWord;
    }

    /**
     * The entry point of the application. Launches the JavaFX runtime.
     *
     * @param args command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        launch(args);
    }
}

