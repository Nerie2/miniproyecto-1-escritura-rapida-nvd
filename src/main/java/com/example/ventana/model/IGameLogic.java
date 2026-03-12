package com.example.ventana.model;

public interface IGameLogic {
        boolean validateWord(String input);
        void nextLevel();
        int getLevel();
        int getTimePerLevel();
        void resetGame();

        String getCurrentWord();

}
