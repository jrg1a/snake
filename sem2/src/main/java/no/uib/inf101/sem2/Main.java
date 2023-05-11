package no.uib.inf101.sem2;


import no.uib.inf101.sem2.view.StartMenu;

import javax.swing.*;

public class Main {
  public static void main(String[] args) {

    /*
    SwingUtilities.invokeLater(() -> {
      Game game = new Game();
      game.initialize();
    });
     */
    SwingUtilities.invokeLater(() -> new StartMenu());
  }
}
