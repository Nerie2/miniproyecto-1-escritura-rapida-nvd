package com.example.ventana.model;

/**
 * The {@code IGameState} interface defines the contract for managing
 * the current state of the game. Implementations of this interface
 * are responsible for storing and updating the level, time per level,
 * and the current word.
 *
 * <p>Main responsibilities include:</p>
 * <ul>
 *   <li>Providing access to the current level, time per level, and word.</li>
 *   <li>Allowing updates to the game state values.</li>
 *   <li>Resetting the game to its initial state.</li>
 * </ul>
 *
 * <p>This interface separates the state management from the game logic,
 * enabling cleaner architecture and easier maintenance.</p>
 *
 * @author Nerie
 */
public interface IGameState {
    /**
     * Returns the current level of the game.
     *
     * @return the current level as an {@code int}.
     */
    int getLevel();

    /**
     * Returns the time allowed per level in seconds.
     *
     * @return the time per level as an {@code int}.
     */
    int getTimePerLevel();

    /**
     * Returns the current word stored in the game state.
     *
     * @return the current word as a {@code String}.
     */
    String getCurrentWord();

    /**
     * Updates the current level of the game.
     *
     * @param level the new level value.
     */
    void setLevel(int level);

    /**
     * Updates the time allowed per level.
     *
     * @param time the new time per level in seconds.
     */
    void setTimePerLevel(int time);

    /**
     * Updates the current word stored in the game state.
     *
     * @param word the new word as a {@code String}.
     */
    void setCurrentWord(String word);

    /**
     * Resets the game state to its initial values.
     * <p>The level is set to 1, the time per level is reset to 20 seconds,
     * and the current word is cleared.</p>
     */
    void resetGame();
}