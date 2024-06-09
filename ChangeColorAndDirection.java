import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChangeColorAndDirection extends Application {

    private TextPane textPane = new TextPane();

    @Override
    public void start(Stage primaryStage) {

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(10, 10, 10, 10));

        Button leftButton = new Button("Left");
        Button rightButton = new Button("Right");

        hBox.getChildren().addAll(leftButton, rightButton);

        VBox vbox = new VBox(20);
        vbox.setPadding(new Insets(5, 5, 5, 5));

        RadioButton redRadioButton = new RadioButton("Red");
        RadioButton greenRadioButton = new RadioButton("Green");

        vbox.getChildren().addAll(redRadioButton, greenRadioButton);

        BorderPane borderPane = new BorderPane();

        borderPane.setCenter(textPane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);
        borderPane.setLeft(vbox);
        BorderPane.setAlignment(vbox, Pos.CENTER);

        Text txt = new Text("JavaFX");

        borderPane.setTop(txt);
        BorderPane.setAlignment(txt, Pos.CENTER);
        leftButton.setOnAction(e -> textPane.left());
        rightButton.setOnAction(e -> textPane.right());

        ToggleGroup colorGroup = new ToggleGroup();
        redRadioButton.setToggleGroup(colorGroup);
        greenRadioButton.setToggleGroup(colorGroup);
        redRadioButton.setOnAction(e -> {
            if (redRadioButton.isSelected()) {
                textPane.redColor();
            }
        });

        greenRadioButton.setOnAction(e -> {
            if (greenRadioButton.isSelected()) {
                textPane.GreenColor();
            }
        });
        Scene scene = new Scene(borderPane, 400, 200);
        primaryStage.setTitle("Programming 2");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class RightHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            textPane.right();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class TextPane extends Pane {

    private Text text = new Text(40, 40, "Final Lab is fun");

    public TextPane() {
        getChildren().add(text);
        text.setFill(Color.BLACK);
        text.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.ITALIC, 30));

    }

    public void right() {
        text.setX(text.getX() + 10);

    }

    public void left() {
        text.setX(text.getX() - 10);
    }

    public void redColor() {

        text.setFill(Color.RED);
    }

    public void GreenColor() {
        text.setFill(Color.GREEN);
    }
}
