package com.example.ventana.model;

/**
 * The {@code IWord} interface defines the contract for word management
 * within the game. Implementations of this interface are responsible
 * for generating new words and providing access to the currently
 * generated word.
 *
 * <p>Main responsibilities include:</p>
 * <ul>
 *   <li>Generating a new word when requested.</li>
 *   <li>Returning the current word stored in memory.</li>
 * </ul>
 *
 * <p>This interface allows the game logic to remain independent of
 * the specific word generation strategy, enabling flexibility and
 * extensibility.</p>
 *
 * @author Nerie
 */
public interface IWord {
    /**
     * Generates a new word.
     * <p>Implementations should define how the word is selected,
     * for example from a predefined list, a database, or dynamically
     * based on the current game level.</p>
     *
     * @return the newly generated word as a {@code String}.
     */
    String generateWord();

    /**
     * Returns the currently generated word.
     *
     * @return the current word as a {@code String}.
     */
    String getCurrentWord();
}
