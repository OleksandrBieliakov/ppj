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
    private PhraseGrid grid;
    private Button playB;
    private Label showLives;
    private Label showScore;

    Game(Main main, String draw) {

        grid = new PhraseGrid(draw);
        Wheel wheel = new Wheel(this);
        HBox buttonsAndStats = new HBox();

        Button settingsB = new Button("Settings");
        playB = new Button("Play");
        showLives = new Label("Opportunities: " + lives);
        showScore = new Label("Score: " + score);

        EventHandler<ActionEvent> openSettings = event -> main.openSettings();
        settingsB.setOnAction(openSettings);

        EventHandler<ActionEvent> play = event -> {
            wheel.roll();
        };
        playB.setOnAction(play);

        buttonsAndStats.getChildren().addAll(settingsB, showLives, showScore, playB);
        buttonsAndStats.setSpacing(10);
        buttonsAndStats.setAlignment(Pos.CENTER);

        setPadding(new Insets(10));
        setMargin(wheel, new Insets(20));
        setTop(grid);
        setCenter(wheel);
        setBottom(buttonsAndStats);

    }

    void newGuess(int prise) {
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
    }

}
