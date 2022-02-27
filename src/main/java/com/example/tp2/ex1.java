package com.example.tp2;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;

public class ex1 extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        GridPane root = new GridPane();
        root.setPadding(new Insets(10,10,10,10));
        root.setAlignment(Pos.CENTER);
        root.setHgap(5);
        root.setVgap(5);

        Label text = new Label("Temperature °C <====> °F");
        text.setFont(Font.font("System", FontWeight.BOLD,20));
        text.setTextFill(Color.RED);
        GridPane.setHalignment(text, HPos.CENTER);
        GridPane.setConstraints(text,0,0,4,1);

        Label textc = new Label("Temperature °C :");
        GridPane.setConstraints(textc,0,1);

        TextField inputC = new TextField();
        GridPane.setConstraints(inputC,1,1,2,1);

        Button btnc = new Button("°C ====> °F");
        GridPane.setConstraints(btnc,1,3);

        Button btnf = new Button("°F ====> °C");
        GridPane.setConstraints(btnf,2,3);

        Label textf = new Label("Temperature °F :");
        GridPane.setConstraints(textf,0,4);

        TextField inputF = new TextField();
        GridPane.setConstraints(inputF,1,4,2,1);



        btnf.setOnAction(event->{
            double toNum = Double.parseDouble(inputF.getText());

                double celsiusResult = (toNum-32)*5/9;
            inputC.setText( new DecimalFormat("##.##").format(celsiusResult));


        });

        btnc.setOnAction(event->{
            double toNum = Double.parseDouble(inputC.getText());

                double fahrenheitResult = toNum*1.8+32;
                inputF.setText( new DecimalFormat("##.##").format(fahrenheitResult));

        });

        root.getChildren().addAll(textf,textc,btnc,btnf,text,inputC,inputF);


        primaryStage.setTitle("Converter");
        Scene scene = new Scene(root, 320, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}