package tictactoe;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Ellipse;

public class TicTacToe extends Application {

    private char whoseTurn = 'X';
    private Cell[][] cell = new Cell[3][3];
    private Label lblStatus = new Label("X's turn to play");

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pane.add(cell[i][j] = new Cell(), j, i);
            }
        }
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(lblStatus);
        Scene scene = new Scene(borderPane, 400, 400);
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public boolean isFull() {
        for (Cell[] row : cell) {
            for (Cell c : row) {
                if (c.getToken() == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWon(char token) {
        for (int i = 0; i < 3; i++) {
            if (cell[i][0].getToken() == token
                    && cell[i][1].getToken() == token
                    && cell[i][2].getToken() == token) {
                return true;
            }
            if (cell[0][i].getToken() == token
                    && cell[1][i].getToken() == token
                    && cell[2][i].getToken() == token) {
                return true;
            }
        }
        if (cell[0][0].getToken() == token
                && cell[1][1].getToken() == token
                && cell[2][2].getToken() == token) {
            return true;
        }
        if (cell[0][2].getToken() == token
                && cell[1][1].getToken() == token
                && cell[2][0].getToken() == token) {
            return true;
        }
        return false;
    }

    public class Cell extends Pane {

        private char token = ' ';

        public Cell() {
            setStyle("-fx-border-color: black");
            setPrefSize(2000, 2000);
            setOnMouseClicked(e -> handleMouseClick());
        }

        public char getToken() {
            return token;
        }

        public void setToken(char c) {
            token = c;
            if (token == 'X') {
                Line line1 = new Line(10, 10, getWidth() - 10, getHeight() - 10);
                line1.endXProperty().bind(widthProperty().subtract(10));
                line1.endYProperty().bind(heightProperty().subtract(10));
                Line line2 = new Line(10, getHeight() - 10, getWidth() - 10, 10);
                line2.startYProperty().bind(heightProperty().subtract(10));
                line2.endXProperty().bind(widthProperty().subtract(10));
                getChildren().addAll(line1, line2);
            } else if (token == 'O') {
                Ellipse ellipse = new Ellipse(getWidth() / 2, getHeight() / 2, getWidth() / 2 - 10, getHeight() / 2 - 10);
                ellipse.centerXProperty().bind(widthProperty().divide(2));
                ellipse.centerYProperty().bind(heightProperty().divide(2));
                ellipse.radiusXProperty().bind(widthProperty().divide(2).subtract(10));
                ellipse.radiusYProperty().bind(heightProperty().divide(2).subtract(10));
                ellipse.setStroke(Color.BLACK);
                ellipse.setFill(Color.WHITE);
                getChildren().add(ellipse);
            }
        }

        private void handleMouseClick() {
            if (token == ' ' && whoseTurn != ' ') {
                setToken(whoseTurn);
                if (isWon(whoseTurn)) {
                    lblStatus.setText(whoseTurn + " won! The game is over");
                    whoseTurn = ' ';
                } else if (isFull()) {
                    lblStatus.setText("Draw! The game is over");
                    whoseTurn = ' ';
                } else {
                    whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
                    lblStatus.setText(whoseTurn + "'s turn");
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
