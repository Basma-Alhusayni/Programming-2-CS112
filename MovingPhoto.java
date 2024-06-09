// this program lets you move a photo where ever you want using the keyboard 
package movingphoto;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.DOWN;
import static javafx.scene.input.KeyCode.LEFT;
import static javafx.scene.input.KeyCode.RIGHT;
import static javafx.scene.input.KeyCode.UP;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MovingPhoto extends Application {
@Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Image image = new Image("https://i.guim.co.uk/img/media/26392d05302e02f7bf4eb143bb84c8097d09144b/446_167_3683_2210/master/3683.jpg?width=1200&quality=85&auto=format&fit=max&s=a52bbe202f57ac0f5ff7f47166906403");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(500);
        imageView.setFitHeight(300);
        pane.getChildren().add(imageView);
        

        imageView.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case DOWN:
                    imageView.setY(imageView.getY() + 10);
                    break;
                case UP:
                    imageView.setY(imageView.getY() - 10);
                    break;
                case LEFT:
                    imageView.setX(imageView.getX() - 10);
                    break;
                case RIGHT:
                    imageView.setX(imageView.getX() + 10);
                    break;
                default:
                    
                    break;
            }
        });

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Moving a Photo");
        primaryStage.setScene(scene);
        primaryStage.show();
        imageView.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}