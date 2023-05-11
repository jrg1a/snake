package no.uib.inf101.sem2.view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.prefs.Preferences;

public class HighScore {
    private int highScore;
    private static final String HIGH_SCORE_KEY = "high_score";
    private Preferences prefs;
    private PropertyChangeSupport support;

    /**
     * Constructor for HighScire class.
     *  retrieves the stored high score.
     */
    public HighScore() {
        prefs = Preferences.userNodeForPackage(HighScore.class);
        highScore = prefs.getInt(HIGH_SCORE_KEY, 0);
        support = new PropertyChangeSupport(this);
    }

    /**
     * Adds a new score and updates the high score if the new score is higher.
     * @param score The new score to be added.
     */

    public void addScore(int score) {
        if (score > highScore) {
            highScore = score;
            prefs.putInt(HIGH_SCORE_KEY, highScore);
        }
    }

    /**
     * Gets the current high score.
     * @return The current high score.
     */
    public int getHighScore() {
        return highScore;
    }

    /**
     * Adds a PropertyChangeListener to the high score.
     * @param listener The listener to be added.
     */

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Removes a PropertyChangeListener from the high score.
     * @param listener The listener to be removed.
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    /**
     * Sets a new high score and fires a property change event.
     * @param newHighScore The new high score value. NOT IN USE :D
     */
    public void setHighScore(int newHighScore) {
        int oldHighScore = this.highScore;
        this.highScore = newHighScore;
        support.firePropertyChange("highScore", oldHighScore, newHighScore);
    }
}

