package com.example.ventana.model;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Random;

import static javafx.application.Application.launch;

public class Word implements IWord {
    private String currentWord;
    @Override
    public void generateWord() {
        String[] words = {"Perro", "Casa", "Chuspa", "Caracol", "Cocodrilo", "algoritmo",
                "booleano", "compilador", "depuracion", "encapsulado", "framework", "herencia", "instancia",
                "jerarquia", "kilobyte", "libreria", "metadatos", "parámetro", "recursividad", "sintaxis",
                "variable", "asíncrono", "repositorio", "interfaz", "polimorfismo", "ventana", "guitarra",
                "elefante", "cuaderno", "planeta", "camino", "silencio", "aventura", "brujula", "espejo", "zapato",
                "bosque", "alegria", "destino", "pintura", "cascada", "puente", "universo", "tiempo", "historia"};
        Random rand = new Random();
        currentWord = words[rand.nextInt(words.length)];
    }
    @Override
    public String getCurrentWord(){
        return currentWord;
    }
    public static void main(String[] args) {
        launch(args);
    }

}
