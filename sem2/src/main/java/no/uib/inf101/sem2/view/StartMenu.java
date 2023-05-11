package no.uib.inf101.sem2.view;

import no.uib.inf101.sem2.controller.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class StartMenu extends JFrame implements ActionListener {

    private BufferedImage backgroundImage;
    private final JButton playButton1Player;
    private final JButton playButton2Player;

    /**
     * Creates a new StartMenu with buttons for selecting the game mode.
     */

    public StartMenu() {
        // Set the title and default close operation
        setTitle("Start Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Load background image
        try {
            backgroundImage = ImageIO.read(getClass().getResource("/background.PNG"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(new GridLayout(2, 1));
        //1-player mode play button to the panel
        playButton1Player = new JButton("1-Player Mode");
        backgroundPanel.add(playButton1Player);
        //2-player mode play button to the panel
        playButton2Player = new JButton("2-Player Mode");
        backgroundPanel.add(playButton2Player);
        // Add action listeners to the play buttons
        playButton1Player.addActionListener(this);
        playButton2Player.addActionListener(this);
        // Add the custom panel to the frame
        getContentPane().add(backgroundPanel);
        // Set the size and make the frame visible
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Handles button events, starting the game with the selected gamemode.
     * @param e ActionEvent containing information about the button event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton1Player || e.getSource() == playButton2Player) {
            this.dispose();
            Game game = new Game(e.getSource() == playButton1Player ? 1 : 2);
            game.initialize();
        }
    }

    /**
     * Custom JPanel that displays the background image.
     */
    class BackgroundPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        }
    }
}
