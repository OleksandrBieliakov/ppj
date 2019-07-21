package gui.werner.e12;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

class Lover extends VBox {

    private static String dialog = "";

    private String name;
    private Lover partner;
    private TextArea history = new TextArea();
    private BorderPane inputPane = new BorderPane();
    private TextField message = new TextField();
    private Button sendB = new Button("Send");
    private EventHandler<ActionEvent> sending;


    Lover(String name) {
        this.name = name;
        history.setPrefRowCount(25);
        history.setPrefColumnCount(30);

        message.setText(name + ": ");
        message.setPrefColumnCount(30);

        sending = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog = dialog + "\n" + message.getText();
                message.setText(name + ": ");
                history.setText(dialog);
                partner.recieveMessage();
            }
        };

        message.setOnAction(sending);
        sendB.setOnAction(sending);

        inputPane.setLeft(message);
        inputPane.setRight(sendB);

        getChildren().addAll(history, inputPane);
    }

    void setPartner(Lover partner) {
        this.partner = partner;
    }

    void recieveMessage() {
        history.setText(dialog);
    }



}
