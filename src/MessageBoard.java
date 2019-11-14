//I worked on the homework assignment alone, using only course materials.

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This is MessageBoard class in HW15 for CS1331.
 * @author Qifan Yang
 * @version 1.0
 */
public class MessageBoard extends Application {
    /**
     * This is a message board that users can leave their messages in this program.
     * @param stage primary stage in which the message board exists
     */
    @Override
    public void start(Stage stage) {
        VBox layout = new VBox();
        HBox postArea = new HBox();
        TextField nameField = new TextField();
        TextField messageField = new TextField();
        Button postBtn = new Button("Post Message");
        ObservableList<String> messages = FXCollections.observableArrayList();
        ListView<String> listView = new ListView<>(messages);

        postArea.getChildren().add(nameField);
        postArea.getChildren().add(messageField);
        postArea.getChildren().add(postBtn);
        layout.getChildren().add(listView);
        layout.getChildren().add(postArea);

        Scene scene = new Scene(layout);

        postBtn.requestFocus();
        nameField.setPromptText("name");
        messageField.setPromptText("message");
        listView.setMinHeight(500);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("CS 1331 Message Board");
        stage.show();

        postBtn.setOnAction(e -> {
                if (!nameField.getText().isEmpty() && !messageField.getText().isEmpty()) {
                    messages.add(String.format("%s: %s", nameField.getText(), messageField.getText()));
                    nameField.clear();
                    messageField.clear();
                }
            });
    }
}
