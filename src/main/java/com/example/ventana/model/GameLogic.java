package com.example.ventana.model;

import javafx.application.Application;
import javafx.stage.Stage;

public class GameLogic implements IGameLogic{
    private int level;
    private int timePerLevel;
    private final IWord wordManager;

    public void resetGame(){
        level=1;
        timePerLevel=20;
    }

    public GameLogic(IWord wordManager) {
        this.level = 1;
        this.timePerLevel = 20; // segundos iniciales
        this.wordManager = wordManager;
        wordManager.generateWord();
    }

    @Override
    public boolean validateWord(String input) {
        return input.equalsIgnoreCase(wordManager.getCurrentWord());
    }

    @Override
    public void nextLevel() {
        level++;
        if (level % 5 == 0 && timePerLevel > 2) {
            timePerLevel -= 2; // cada 5 niveles reduce el tiempo
        }
        wordManager.generateWord();
    }
    @Override
    public int getLevel() { return level; }

    @Override
    public int getTimePerLevel() { return timePerLevel; }

    @Override
    public String getCurrentWord() { return wordManager.getCurrentWord(); }

}
