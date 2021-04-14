package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;

import javafx.geometry.Orientation;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label lbl = new Label();
        TextField textField = new TextField();
        textField.setPrefColumnCount(20);
        Button btn = new Button("Click");
        ObservableList<String> langs = FXCollections.observableArrayList("first element");
        ComboBox<String> langsComboBox = new ComboBox<>(langs);
        langsComboBox.setValue("first element");

        btn.setOnAction(event -> {
            if (langs.contains(textField.getText())) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Error");
                alert.setContentText("This item already exists");
                alert.showAndWait();
            } else {
                langs.add(textField.getText());
                langsComboBox.setValue(textField.getText());
            }
        });

        TextField textField1 = new TextField();
        textField1.setPrefColumnCount(20);
        Button btn1 = new Button("Button1");
        Button btn2 = new Button("Button2");
        btn1.setOnAction(event -> btn2.setText(textField1.getText()));
        btn2.setOnAction(event ->{
            String text;
            text = btn2.getText();
            btn2.setText(btn1.getText());
            btn1.setText(text);
        });

        RadioButton radio1 = new RadioButton("First");
        RadioButton radio2 = new RadioButton("Second");
        RadioButton radio3 = new RadioButton("Third");
        ToggleGroup group = new ToggleGroup();
        radio1.setToggleGroup(group);
        radio2.setToggleGroup(group);
        radio3.setToggleGroup(group);
        Button btn31 = new Button("Button");
        TextField textField31 = new TextField();
        btn31.setOnAction(event ->{
            if (textField31.getText().equals(radio1.getText())) {
                radio1.setSelected(true);
            } else if (textField31.getText().equals(radio2.getText())) {
                radio2.setSelected(true);
            } else if (textField31.getText().equals(radio3.getText())){
                radio3.setSelected(true);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Error");
                alert.setContentText("This item doesn't exist");
                alert.showAndWait();
            }
        });

        TextField textField41 = new TextField();
        CheckBox check1 = new CheckBox("First");
        CheckBox check2 = new CheckBox("Second");
        CheckBox check3 = new CheckBox("Third");
        Button btn41 = new Button("Button");
        btn41.setOnAction(event ->{
            if (textField41.getText().equals(check1.getText())) {
                if (check1.isSelected()) {
                    check1.setSelected(false);
                } else {
                    check1.setSelected(true);
                }
            } else if (textField41.getText().equals(check2.getText())){
                if (check2.isSelected()) {
                    check2.setSelected(false);
                } else {
                    check2.setSelected(true);
                }
            } else if (textField41.getText().equals(check3.getText())){
                if (check3.isSelected()) {
                    check3.setSelected(false);
                } else {
                    check3.setSelected(true);
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Error");
                alert.setContentText("This item doesn't exist");
                alert.showAndWait();
            }
        });

        TableView<String> table = new TableView<>();
        table.setPrefWidth(180);
        table.setPrefHeight(180);
        TableColumn<String, String> Column1 = new TableColumn<>();
        table.getColumns().add(Column1);
        TableColumn<String, String> Column2 = new TableColumn<>();
        table.getColumns().add(Column2);
        TextField textField51 = new TextField();
        Button btn51 = new Button("Button1");
        Button btn52 = new Button("Button2");
        Button btn53 = new Button("Button3");
        btn51.setOnAction(event->Column1.setText(textField51.getText()));
        btn52.setOnAction(event->{
            Column2.setText(textField51.getText());
            Column1.setText("");
        });
        btn53.setOnAction(event->{
            Column1.setText(textField51.getText());
            Column2.setText("");
        });

        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10, textField, btn, langsComboBox, lbl, textField1, btn1, btn2, textField31, radio1, radio2, radio3, btn31,textField41, check1, check2, check3, btn41, textField51, btn51, btn52, btn53, table);
        Scene scene = new Scene(root, 500, 750);
        stage.setScene(scene);
        stage.setTitle("text field in JavaFX");
        stage.show();
    }
}
