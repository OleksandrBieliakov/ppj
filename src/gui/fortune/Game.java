package gui.fortune;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javax.swing.*;

class Game extends BorderPane {

    private int score = 0;
    private int lives = 3;

    Game(Main main, String draw) {

        PhraseGrid grid = new PhraseGrid(draw);
        Wheel wheel = new Wheel();
        HBox buttonsAndStats = new HBox();

        Button settingsB = new Button("Settings");
        Button playB = new Button("Play");
        Label showLives = new Label("Opportunities: " + lives);
        Label showScore = new Label("Score: " + score);

        EventHandler<ActionEvent> openSettings = event -> main.openSettings();
        settingsB.setOnAction(openSettings);
        EventHandler<ActionEvent> play = event -> {
            int prise = wheel.roll();
            if (!grid.tryGuess()) {
                showLives.setText("Opportunities: " + --lives);
                if (lives <= 0) {
                    JOptionPane.showMessageDialog(null, "GAME OVER! YOUR SCORE: " + score);
                    playB.setDisable(true);
                }
            } else {
                score += prise;
                showScore.setText("Score: " + score);
                if (grid.hasWon()) {
                    JOptionPane.showMessageDialog(null, "YOU WON! YOUR SCORE: " + score);
                    playB.setDisable(true);
                }
            }
        };
        playB.setOnAction(play);

        buttonsAndStats.getChildren().addAll(settingsB, showLives, showScore, playB);
        buttonsAndStats.setPadding(new Insets(10));
        buttonsAndStats.setSpacing(10);
        buttonsAndStats.setAlignment(Pos.CENTER);

        setTop(grid);
        setBottom(buttonsAndStats);

    }

}
