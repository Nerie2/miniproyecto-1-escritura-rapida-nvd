package com.example.ventana.model;

/**
 * The {@code GameState} class implements the {@link IGameState} interface
 * and is responsible for storing the current state of the game.
 *
 * <p>Main responsibilities include:</p>
 * <ul>
 *   <li>Tracking the current level.</li>
 *   <li>Managing the time allowed per level.</li>
 *   <li>Storing the current word.</li>
 *   <li>Resetting the game state to its initial values.</li>
 * </ul>
 *
 * <p>This class acts as a simple data container, separating state management
 * from the game logic. It allows the {@link GameLogic} class to manipulate
 * the game state without directly handling its internal details.</p>
 *
 * @author Nerie
 */
public class GameState implements IGameState {
    /** Current level of the game. */
    private int level;

    /** Time allowed per level in seconds. */
    private int timePerLevel;

    /** The current word stored in the game state. */
    private String currentWord;

    /**
     * Constructs a new {@code GameState} instance.
     * <p>Initial values are set by calling {@link #resetGame()}.</p>
     */
    public GameState() {
        resetGame();
    }

    /**
     * Returns the current level of the game.
     *
     * @return the current level as an {@code int}.
     */
    @Override
    public int getLevel() {
        return level;
    }

    /**
     * Returns the time allowed per level in seconds.
     *
     * @return the time per level as an {@code int}.
     */
    @Override
    public int getTimePerLevel() {
        return timePerLevel;
    }

    /**
     * Returns the current word stored in the game state.
     *
     * @return the current word as a {@code String}.
     */
    @Override
    public String getCurrentWord() {
        return currentWord;
    }

    /**
     * Updates the current level of the game.
     *
     * @param level the new level value.
     */
    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Updates the time allowed per level.
     *
     * @param time the new time per level in seconds.
     */
    @Override
    public void setTimePerLevel(int time) {
        this.timePerLevel = time;
    }

    /**
     * Updates the current word stored in the game state.
     *
     * @param word the new word as a {@code String}.
     */
    @Override
    public void setCurrentWord(String word) {
        this.currentWord = word;
    }

    /**
     * Resets the game state to its initial values.
     * <p>The level is set to 1, the time per level is reset to 20 seconds,
     * and the current word is cleared.</p>
     */
    @Override
    public void resetGame() {
        this.level = 1;
        this.timePerLevel = 20;
        this.currentWord = "";
    }
}