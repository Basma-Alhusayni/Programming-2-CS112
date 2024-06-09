// this program lets you change the style of a text and the color of a rectangle

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FontsAndColors extends Application {

    private RectanglePane rectanglePane = new RectanglePane();

    private CheckBox chbold;
    private CheckBox chitalic;
    private Text text;

    @Override
    public void start(Stage primaryStage) {

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(10, 10, 10, 10));

        Button btred = new Button("Red");
        Button btgreen = new Button("Green");

        hBox.getChildren().addAll(btred, btgreen);

        VBox vbox = new VBox(20);
        vbox.setPadding(new Insets(5, 5, 5, 5));

        chbold = new CheckBox("Bold");
        chitalic = new CheckBox("Italic");

        vbox.getChildren().addAll(chbold, chitalic);

        Font fontBoldItalic = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20);
        Font fontBold = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20);
        Font fontItalic = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.ITALIC, 20);
        Font fontNormal = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 20);

        text = new Text("JavaFX");
        text.setFont(fontNormal);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(20, 20, 20, 20));

        grid.add(vbox, 0, 0);
        grid.add(text, 1, 0);
        grid.add(rectanglePane, 2, 0);
        grid.add(hBox, 2, 1);

        btred.setOnAction(e -> {
            rectanglePane.RedColor();
        });

        btgreen.setOnAction(e -> {
            rectanglePane.greenColor();
        });

        chbold.setOnAction(e -> {
            updateFont();
        });

        chitalic.setOnAction(e -> {
            updateFont();
        });

        Scene scene = new Scene(grid, 500, 300);
        primaryStage.setTitle("FontsAndColors");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateFont() {
        Font font;
        if (chbold.isSelected() && chitalic.isSelected()) {
            font = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20);
        } else if (chbold.isSelected()) {
            font = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20);
        } else if (chitalic.isSelected()) {
            font = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.ITALIC, 20);
        } else {
            font = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 20);
        }
        text.setFont(font);
    }

    class RectanglePane extends StackPane {

        private Rectangle rectangle = new Rectangle(100, 50);

        public RectanglePane() {
            rectangle.setStroke(Color.BLACK);
            rectangle.setFill(Color.WHITE);
            getChildren().add(rectangle);
        }

        public void RedColor() {
            rectangle.setFill(Color.RED);
        }

        public void greenColor() {
            rectangle.setFill(Color.GREEN);
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
