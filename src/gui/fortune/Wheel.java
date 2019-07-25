package gui.fortune;

import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

class Wheel extends Group {

    private static final double
            RADIUS = 300,
            POINTER_RADIUS = 5,
            X0 = RADIUS,
            Y0 = RADIUS + 3 * POINTER_RADIUS;
    private Timeline anim;

    Wheel() {

        Circle pointer = new Circle(X0, POINTER_RADIUS, POINTER_RADIUS, Color.RED);
        pointer.setStroke(Color.BLACK);
        pointer.setStrokeWidth(1.5);
        Circle circle = new Circle(X0, Y0, RADIUS, Color.LIGHTBLUE);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(3);
        getChildren().addAll(pointer, circle);

        Line line = new Line(X0, Y0, X0, Y0 - RADIUS);
        Text text2 = new Text(X0, Y0 - RADIUS * 0.75, "100");
        text2.setRotate(90);
        getChildren().addAll(text2, line);

    }

    int roll() {
        anim.play();
        anim.pause();
        return 100;
    }

}
